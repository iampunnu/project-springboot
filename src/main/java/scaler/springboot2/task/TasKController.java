package scaler.springboot2.task;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TasKController {

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
        /*for (Task task:tasks){
            if(task.getId().equals(id)){
                return task;
            }
        }*/
        Task foundlist=tasks.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
        return foundlist;
    }

}
