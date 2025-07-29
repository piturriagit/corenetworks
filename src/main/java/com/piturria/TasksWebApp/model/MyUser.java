package com.piturria.TasksWebApp.model;

import jakarta.persistence.*;

/*
CREATE TABLE `securitydb`.`users` (
  `id` INT NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);
INSERT INTO users (id, username, password)  VALUES
  (1,"ana","$2a$12$Mb5D8LBPRG.vU45sujldm.NHHCmLZEUaADEkMi5Ej.38JpynXQnei")
, (2,"bea","$2a$12$0blOmOf3pGxiHHehZXRj3OddDW2pH.4PP0eTA5s2NU4mKc0qrNqC.")
, (3, "carlos", "$2a$12$qME8Ux5SKINLwS5Lfit4KeTMCvzhZzqUsG.JPwHc.CLcUQT49qHum")
;
-- BCrypt(12,a@123) = $2a$12$Mb5D8LBPRG.vU45sujldm.NHHCmLZEUaADEkMi5Ej.38JpynXQnei
-- https://bcrypt-generator.com
SELECT * FROM users;
 */

@Entity
@Table(name="users")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}