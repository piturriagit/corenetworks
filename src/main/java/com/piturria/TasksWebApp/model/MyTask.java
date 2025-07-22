package com.piturria.TasksWebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
public class MyTask {

    @Id
    private int id;
    private String title;
    private String description;
    private LocalDateTime creationDate;

}
