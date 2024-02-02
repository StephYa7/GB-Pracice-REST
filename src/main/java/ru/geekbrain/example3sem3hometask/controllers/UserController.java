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
        registrationService.getDataProcessingService().getRepository().save(user);
        return "user added";
    }

    @PostMapping()
    public String userAddFromParam(@RequestParam("nm") String name,
                                   @RequestParam("ag") int age,
                                   @RequestParam("em") String email) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setAge(age);
        newUser.setEmail(email);

        registrationService.getDataProcessingService().getRepository().save(newUser);
        return "user added";
    }
}