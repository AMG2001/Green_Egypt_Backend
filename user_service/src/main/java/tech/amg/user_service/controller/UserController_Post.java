package tech.amg.user_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.amg.user_service.domain.entity.User;
import tech.amg.user_service.exceptions.UserAlreadyExistException;
import tech.amg.user_service.service.UserService;

@RestController
@RequestMapping("users")
public class UserController_Post {

    private UserService userService;

    @Autowired
    public UserController_Post(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addNewUser(@RequestBody User newUser){
        try{
            User newUserWithFullAttributes = userService.addNewUser(newUser);
            return ResponseEntity.ok(newUserWithFullAttributes);
        }catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
