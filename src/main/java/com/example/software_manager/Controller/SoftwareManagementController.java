package com.example.software_manager.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class SoftwareManagementController {
    public SoftwareManagementController(){}

    //Método para testar conexão
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello world";
    }
    @PostMapping("/cadastrar")
    public String cadastrar(RequestBody userDTO){
        return null;
    }
}
