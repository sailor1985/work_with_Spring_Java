package com.example.restapp.repository;

import com.example.restapp.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryH2 extends CrudRepository<User, Integer> {

}
