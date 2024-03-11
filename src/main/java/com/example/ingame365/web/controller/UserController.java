package com.example.ingame365.web.controller;

import com.example.ingame365.domain.entities.task.Task;
import com.example.ingame365.domain.entities.team.Team;
import com.example.ingame365.domain.entities.user.User;
import com.example.ingame365.web.dto.user.UserDto2;
import com.example.ingame365.service.TaskService;
import com.example.ingame365.service.TeamService;
import com.example.ingame365.service.UserService;
import com.example.ingame365.web.dto.task.TaskDto;
import com.example.ingame365.web.dto.team.TeamDto;
import com.example.ingame365.web.dto.user.UserDto;
import com.example.ingame365.web.dto.validation.OnCreate;
import com.example.ingame365.web.dto.validation.OnUpdate;
import com.example.ingame365.web.mappers.TaskMapper;
import com.example.ingame365.web.mappers.TeamMapper;
import com.example.ingame365.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller", description = "User API")
@Slf4j
public class UserController {

    private final UserService userService;
    private final TaskService taskService;
    private final TeamService teamService;


    private final UserMapper userMapper;
    private final TaskMapper taskMapper;
    private final TeamMapper teamMapper;

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserDto> getAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(defaultValue = "id,asc") String sort) {
        log.info("Finding all users with pagination and sorting, page = " + page + ", " +
                "size = " + size + ", sort = " + sort);
        List<User> users = userService.getAll(page, size, sort);
        return userMapper.toDto(users);
    }

    @GetMapping("/{teamId}/team")
    @Operation(summary = "Get all users by team id")
    public List<UserDto> getAllByTeam(@PathVariable Long teamId,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id,asc") String sort) {
        List<User> users = userService.getAllByTeam(teamId, page, size, sort);
        return userMapper.toDto(users);
    }

    @PutMapping
    @Operation(summary = "Update user")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#dto.id)")
    public UserDto update(@Validated(OnUpdate.class)
                              @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        updatedUser.setLastName(dto.getLastName());
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @GetMapping("/info/{id}")
    @Operation(summary = "Get user full info by id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public User getFullInfo(@PathVariable Long id) {
        User myUser = userService.getById(id);
        log.info("User: " + myUser);
        return myUser;
    }

    @GetMapping("/short/{id}")
    @Operation(summary = "Get user short info by id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public UserDto2 getShortInfo(@PathVariable Long id) {
        User user = userService.getById(id);
        return new UserDto2(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    @Operation(summary = "Get tasks by user id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id) {
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    @Operation(summary = "Create task")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public TaskDto createTask(@PathVariable Long id,
                              @Validated(OnCreate.class)
                              @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }

    @PostMapping("/{user_id}/teams/{team_id}")
    @Operation(summary = "Assign user to team")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#dto.id)")
    public TeamDto assignTeam(@PathVariable Long user_id,
                              @PathVariable Long team_id) {
        Team updatedTeam = teamService.assignToUser(team_id, user_id);
        return teamMapper.toDto(updatedTeam);
    }
}

