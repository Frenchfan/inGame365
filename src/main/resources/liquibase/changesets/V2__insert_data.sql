SET search_path TO ingame365;

INSERT INTO users (first_name, last_name, username, password, created_at)
VALUES ('John', 'Doe', 'johndoe@gmail.com',
        '$2a$10$Xl0yhvzLIaJCDdKBS0Lld.ksK7c2Zytg/ZKFdtIYYQUv8rUfvCR4W', '2024-01-01 00:00:00'),
       ('Mike', 'Smith', 'mikesmith@yahoo.com',
        '$2a$10$fFLij9aYgaNCFPTL9WcA/uoCRukxnwf.vOQ8nrEEOskrCNmGsxY7m', '2024-01-01 00:00:00'),
       ('Jane', 'Dowson', 'janed@gmail.com',
        '$2a$10$Xl0yhvzLIaJCDdKBS0Lld.ksK7c2Zytg/ZKFdtIYYQUv8rUfvCR4W', '2024-01-01 00:00:00'),
       ('Tom', 'Hanks', 'tomh@gmail.com',
        '$2a$10$Xl0yhvzLIaJCDdKBS0Lld.ksK7c2Zytg/ZKFdtIYYQUv8rUfvCR4W', '2024-01-01 00:00:00'),
       ('Demi', 'Moore', 'demim@gmail.com',
        '$2a$10$Xl0yhvzLIaJCDdKBS0Lld.ksK7c2Zytg/ZKFdtIYYQUv8rUfvCR4W', '2024-01-01 00:00:00'),
       ('Ivan', 'Great', 'ivang@gmail.com',
        '$2a$10$Xl0yhvzLIaJCDdKBS0Lld.ksK7c2Zytg/ZKFdtIYYQUv8rUfvCR4W', '2024-01-01 00:00:00');

INSERT INTO tasks (title, description, status, expiration_date)
VALUES ('Buy cheese', NULL, 'TODO', '2024-01-29 12:00:00'),
       ('Do homework', 'Math, Physics, Literature',
        'IN_PROGRESS', '2024-01-31 00:00:00'),
       ('Clean rooms', NULL, 'DONE', NULL),
       ('Call Mike', 'Ask about meeting', 'TODO',
        '2023-02-01 00:00:00');

INSERT INTO users_tasks (task_id, user_id)
VALUES (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);

INSERT INTO users_roles (user_id, role)
VALUES (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER'),
       (3, 'ROLE_PLAYER'),
       (4, 'ROLE_PARENT'),
       (5, 'ROLE_COACH'),
       (6, 'ROLE_DOCTOR');

INSERT INTO teams (name, created_at)
VALUES ('Спартак', '2022-01-29 12:00:00'),
       ('Локомотив', '2022-01-29 12:00:00'),
       ('Зенит', '2022-01-29 12:00:00');

INSERT INTO users_teams (user_id, team_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 1),
       (4, 1),
       (5, 3),
       (6, 1);

INSERT INTO training (description, scheduled_at)
VALUES ('Running', '2022-01-29 12:00:00'),
       ('Football', '2022-01-31 12:00:00'),
       ('Swimming', '2022-02-15 12:00:00'),
       ('Cycling', '2022-02-20 12:00:00'),
       ('Walking', '2022-02-25 12:00:00');

INSERT INTO training_teams (training_id, team_id)
VALUES (1, 1),
       (2, 3),
       (3, 2);

INSERT INTO before_training (training_id, user_id, front_right_hip, front_left_hip, rear_right_hip, rear_left_hip,
                             right_adductor, left_adductor, right_groin, left_groin, right_calf, left_calf, fatigue,
                             dream_quality, muscle_pain, stress, comments)
VALUES (1, 1, 0, 2, 3, 5, 0, 2, 3, 5, 0, 0, 2, 1, 3, 2, 'super'),
       (2, 1, 0, 3, 0, 0, 1, 3, 2, 0, 0, 0, 2, 1, 3, 2, 'super'),
       (3, 1, 0, 3, 0, 0, 4, 0, 2, 0, 0, 0, 2, 1, 3, 2, 'exhausted'),
       (2, 2, 0, 5, 0, 4, 5, 2, 1, 5, 3, 1, 2, 1, 3, 2, 'super'),
       (3, 2, 0, 3, 0, 5, 0, 1, 0, 6, 0, 0, 2, 1, 3, 2, 'super'),
       (1, 3, 0, 5, 0, 4, 5, 2, 1, 5, 3, 1, 2, 1, 3, 2, 'super'),
       (4, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 3, 2, 'super'),
       (1, 5, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 3, 2, 'not bad'),
       (3, 5, 0, 5, 0, 4, 5, 2, 1, 5, 3, 1, 2, 1, 3, 2, 'super'),
       (2, 6, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 3, 2, 'super'),
       (5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 3, 2, 'super');

INSERT INTO after_training (training_id, user_id, difficulty, comments)
VALUES (1, 1, 2, 'Good'),
       (2, 1, 2, 'Good'),
       (3, 1, 0, 'Good'),
       (2, 2, 0, 'Good'),
       (3, 2, 1, 'Good'),
       (1, 3, 2, 'Good'),
       (4, 3, 2, 'Good'),
       (1, 5, 4, 'Good'),
       (3, 5, 0, 'Good'),
       (2, 6, 0, 'Good'),
       (5, 6, 0, 'Superb');
;