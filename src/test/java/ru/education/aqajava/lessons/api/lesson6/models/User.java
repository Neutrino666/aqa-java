package ru.education.aqajava.lessons.api.lesson6.models;

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
