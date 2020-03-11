package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return entityManager.merge(user);
    }

    @Transactional
    public List<UserEntity> getUsers() {
        return entityManager.createQuery(
                "SELECT u FROM UserEntity u", UserEntity.class).getResultList();
    }

    @Transactional
    public List<UserEntity> getUserSurname(String surName) {
        return entityManager.createQuery(
                "SELECT u FROM UserEntity u WHERE u.lastName = :surName", UserEntity.class)
                .setParameter("surName", surName)
                .getResultList();
    }

    @Transactional
    public List<UserEntity> getUserByLetter(String word) {
        return entityManager.createQuery(
                "SELECT u FROM UserEntity u " +
                        "WHERE u.firstName LIKE CONCAT('%', :word, '%') " +
                        "OR u.lastName LIKE CONCAT('%', :word, '%')",
                UserEntity.class)
                .setParameter("word", word)
                .getResultList();

    }
}
