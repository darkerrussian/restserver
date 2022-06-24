package com.cage.users.demo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String pass;
    private String name;
    private String phone;
    private String adress;
}
