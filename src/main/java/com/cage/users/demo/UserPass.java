package com.cage.users.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserPass {

    @Id
    private Long id;
    private Long pass;

}
