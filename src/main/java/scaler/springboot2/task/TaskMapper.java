package scaler.springboot2.task;

import scaler.springboot2.dtos.CreateTaskDTO;

import java.util.Date;

public class TaskMapper {
    public CreateTaskDTO createTaskDTO(String name, Date dueDate){
        CreateTaskDTO createTaskDTO = new CreateTaskDTO();
        createTaskDTO.setName(name);
        createTaskDTO.setDueDate(dueDate);
        return createTaskDTO;
    }
}
