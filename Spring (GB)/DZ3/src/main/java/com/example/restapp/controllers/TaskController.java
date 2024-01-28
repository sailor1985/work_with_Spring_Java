package com.example.restapp.controllers;

import com.example.restapp.domain.User;
import com.example.restapp.services.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/tasks")//localhost:8080/tasks
public class TaskController {
    private DataProcessingService dataProcessingService;

    public TaskController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    /**
     * GET: Request a list of application tasks
     *
     * @return A list of tasks
     */
    @GetMapping
    public List<String> getAllTasks() {
        String[] tasksArray = {"sort", "filter", "calc"};
        return Arrays.stream(tasksArray).toList();
    }

    /**
     * Sorting task
     *
     * @return A list of sorted users
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge(
                (List<User>) dataProcessingService.getRepositoryH2().findAll()
        );
    }

    /**
     * Filtering task
     *
     * @return A list of filtered users
     */
    //метод filterUsersByAge
    @GetMapping("/filter/{age}")//localhost:8080/task/filter
    public List<User> filterUsersByAge(@PathVariable int age) {
        return ((List<User>) dataProcessingService.getRepositoryH2().findAll()).stream()
                .filter(user -> user.getAge() == age)
                .toList();
    }

    /**
     * Calculating task
     *
     * @return Average age
     */
    @GetMapping("/calc")//localhost:8080/task/calc
    public double calculateAverageAge() {
        OptionalDouble optional = ((List<User>) dataProcessingService.getRepositoryH2().findAll()).stream()
                .mapToInt(User::getAge)
                .average();
        return optional.isPresent() ? optional.getAsDouble() : 0;
    }
}
