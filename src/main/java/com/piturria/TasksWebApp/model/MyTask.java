package com.piturria.TasksWebApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Generated;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@Table(name="tasks")
public class MyTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    private String description;
    private LocalDateTime creationDate;

}
