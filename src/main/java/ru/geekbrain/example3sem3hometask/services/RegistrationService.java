package ru.geekbrain.example3sem3hometask.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;

@Service
@Data
@AllArgsConstructor
public class RegistrationService {

    private UserService userService;
    private NotificationService notificationService;
    private DataProcessingService dataProcessingService;


    public void processRegistration(String name, int age, String email) {
        userService.createUser(name, age, email);
        notificationService.sendNotification("User named : " + name + " eMail:" + email + "has been created ");

    }
}