SET search_path TO ingame365;

CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    enabled    BOOLEAN   DEFAULT TRUE,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS tasks
(
    id              BIGSERIAL PRIMARY KEY,
    title           VARCHAR(255) NOT NULL,
    description     VARCHAR(255) DEFAULT NULL,
    status          VARCHAR(255) NOT NULL,
    expiration_date TIMESTAMP    DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS teams
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    logo       VARCHAR(255) DEFAULT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS training
(
    id           BIGSERIAL PRIMARY KEY,
    description  VARCHAR(255) NOT NULL,
    scheduled_at TIMESTAMP    NOT NULL
);


CREATE TABLE IF NOT EXISTS before_training
(
    id            BIGSERIAL PRIMARY KEY,
    training_id   BIGINT NOT NULL,
    CONSTRAINT fk_before_training_training
        FOREIGN KEY (training_id) REFERENCES training (id)
            ON DELETE CASCADE ON UPDATE NO ACTION,
    user_id       BIGINT NOT NULL,
    CONSTRAINT fk_before_training_users
        FOREIGN KEY (user_id) REFERENCES users (id)
            ON DELETE CASCADE ON UPDATE NO ACTION,
    front_right_hip SMALLINT,
    front_left_hip  SMALLINT,
    rear_right_hip  SMALLINT,
    rear_left_hip   SMALLINT,
    right_adductor SMALLINT,
    left_adductor  SMALLINT,
    right_groin    SMALLINT,
    left_groin     SMALLINT,
    right_calf     SMALLINT,
    left_calf      SMALLINT,
    fatigue       SMALLINT,
    dream_quality  SMALLINT,
    muscle_pain    SMALLINT,
    stress        SMALLINT,
    comments      VARCHAR(255) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS after_training
(
    id          BIGSERIAL PRIMARY KEY,
    training_id BIGINT NOT NULL,
    CONSTRAINT fk_after_training_training
        FOREIGN KEY (training_id) REFERENCES training (id)
            ON DELETE CASCADE ON UPDATE NO ACTION,
    user_id       BIGINT NOT NULL,
    CONSTRAINT fk_after_training_users
        FOREIGN KEY (user_id) REFERENCES users (id)
            ON DELETE CASCADE ON UPDATE NO ACTION,
    difficulty  SMALLINT,
    comments    VARCHAR(255) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS training_teams
(
    id          BIGSERIAL PRIMARY KEY,
    training_id BIGINT NOT NULL,
    team_id BIGINT NOT NULL,
    CONSTRAINT fk_training_teams_training FOREIGN KEY (training_id)
        REFERENCES training (id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT fk_training_teams_teams FOREIGN KEY (team_id)
        REFERENCES teams (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS users_tasks
(
    user_id BIGINT NOT NULL,
    task_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, task_id),
    CONSTRAINT fk_users_tasks_users FOREIGN KEY (user_id)
        REFERENCES users (id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT fk_users_tasks_tasks FOREIGN KEY (task_id)
        REFERENCES tasks (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS users_roles
(
    user_id BIGINT       NOT NULL,
    role    VARCHAR(255) NOT NULL,
    PRIMARY KEY (user_id, role),
    CONSTRAINT fk_users_roles_users FOREIGN KEY (user_id)
        REFERENCES users (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS users_teams
(
    user_id BIGINT NOT NULL,
    team_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, team_id),
    CONSTRAINT fk_users_teams_users FOREIGN KEY (user_id)
        REFERENCES users (id) ON DELETE CASCADE ON UPDATE NO ACTION
);