package ru.geekbrain.example3sem3hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrain.example3sem3hometask.domain.User;
import ru.geekbrain.example3sem3hometask.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService().getRepository().findAll();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }
        registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());

        return "user added";
    }

    @PostMapping()
    public String userAddFromParam(
            @ModelAttribute("user") User user
    ) {
        registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());

        return "user added";
    }
}