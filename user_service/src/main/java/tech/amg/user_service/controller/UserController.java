package tech.amg.user_service.controller;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.amg.user_service.domain.entity.User;
import tech.amg.user_service.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        try{
            return ResponseEntity.ok(userService.getAllUsers());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("{uuid}")
    public ResponseEntity<?> getUserByUuid(@PathVariable("uuid") String uuid){
        try {
            return ResponseEntity.ok(userService.findUserByUuid(uuid));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping
//    public ResponseEntity<?> addNewUser(@RequestBody User user){
//
//    }

}
