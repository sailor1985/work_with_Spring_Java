package com.example.restapp.services;

import com.example.restapp.domain.User;
import com.example.restapp.repository.RepositoryH2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    private final RepositoryH2 repositoryH2;

    //Constructor
    public DataProcessingService(RepositoryH2 repositoryH2) {
        this.repositoryH2 = repositoryH2;
    }

    //Repository Getter
    public RepositoryH2 getRepositoryH2() {
        return repositoryH2;
    }

    /**
     * Sorting users by age
     *
     * @param users A list of users
     * @return A list of sorted users
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Filtering users by age
     *
     * @param users A list of users
     * @param age   Filtering criterion
     * @return A list of filtered users
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Calculating the average age of users
     *
     * @param users A list of users
     * @return Average age
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Adding a user to the repository
     *
     * @param user New user
     */
    public void addUserToRepo(User user) {
        repositoryH2.save(user);
    }

}
