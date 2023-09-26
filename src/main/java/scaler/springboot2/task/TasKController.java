package scaler.springboot2.task;

import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scaler.springboot2.dtos.CreateTaskDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasKController {
/*
    List<Task> tasks=new ArrayList<>();
    private int taskId=1;

    @GetMapping("")
    public List<Task> getAllTask(){
        return tasks;
    }
    @PostMapping("")
    Task createTask(@RequestBody Task task){
        task.setId(taskId++);
        tasks.add(task);
        return task;
    }
    @PostMapping("/{id}")
    Task getTaskById(@PathVariable("id") Integer id){
        *//*for (Task task:tasks){
            if(task.getId().equals(id)){
                return task;
            }
        }*//*
        Task foundlist=tasks.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
        return foundlist;
    }*/
private final TasksService tasksService;
    public TasKController(TasksService tasksService) {
        this.tasksService = tasksService;
    }
    @GetMapping("")
    ResponseEntity<List<Task>> getAllTasks() {
        var tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
//    @PostMapping("")
//    ResponseEntity<Task> createTask(@RequestBody Task task) {
//        var createdTask = tasksService.createTask(task);
//        return ResponseEntity.ok(createdTask);
//    }

    @PostMapping("")
    ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO createTaskDTO) {
        var createdTask = tasksService.createTask(createTaskDTO.getName(), createTaskDTO.getDueDate());
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id) {
        var task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    //Todo 1: implement Update Task - PATCh
    // Todo 2: implement Delete Task - DELETE
    // Todo5: create a ResponseBodyDTO - only return name, dueDate, completed

    // Todo3 - handle expection for IllegalArgumentException ( due date, name)
    // Todo4 - in error responses, also send the error message in the response body
    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    ResponseEntity<String> handleTaskNotFoundException(TasksService.TaskNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

}
