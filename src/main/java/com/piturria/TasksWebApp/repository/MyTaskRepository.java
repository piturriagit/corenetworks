package com.piturria.TasksWebApp.repository;

import com.piturria.TasksWebApp.model.MyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyTaskRepository extends JpaRepository<MyTask, Integer> {
}
