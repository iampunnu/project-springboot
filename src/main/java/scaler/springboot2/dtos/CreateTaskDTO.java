package scaler.springboot2.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskDTO {
    String name;
    Date dueDate;
}
