package ru.education.aqajava.tests.lessons.lesson7.models;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

}
