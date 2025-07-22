package com.piturria.TasksWebApp.service;

import com.piturria.TasksWebApp.model.MyTask;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyTaskService {

    private List<MyTask> fakeTasks = new ArrayList<>(Arrays.asList(
            new MyTask(101, "Task1", "Description1", LocalDateTime.now()),
            new MyTask(102, "Task2", "Description2", LocalDateTime.now()),
            new MyTask(103, "Task3", "Description3", LocalDateTime.now())
    ));

    public List<MyTask> getAllTasks() {
        return fakeTasks;
    }

    public MyTask getTaskById(int id) {
        for (MyTask fakeTask : fakeTasks)
            if (fakeTask.getId() == id)
                return fakeTask;
        return null;
    }

    public MyTask addTask(MyTask task) {
        fakeTasks.add(task);
        return fakeTasks.getLast();
    }

    public MyTask updateTask(int id, MyTask updatedTask) {
        MyTask task = getTaskById(id);
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCreationDate(updatedTask.getCreationDate());
        return task;
    }

    public boolean deleteTaskById(int id) {
        for (int i = 0 ; i < fakeTasks.size() ; i++)
            if (fakeTasks.get(i).getId() == id) {
                fakeTasks.remove(i);
                return true;
            }
        return false;
    }

    public void deleteAllTasks() {
        fakeTasks.clear();
    }
}