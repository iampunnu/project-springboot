package scaler.springboot2;

import org.springframework.web.bind.annotation.*;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/hello")
public class RestController {
    @GetMapping("/world")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/you")
    public String You(@RequestParam(value = "name") String name,@RequestParam("age") String age){
        return "hello "+name+" "+age;
    }

}
