package tech.amg.user_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.amg.user_service.domain.dto.TipDto;
import tech.amg.user_service.domain.entity.User;
import tech.amg.user_service.exceptions.UserAlreadyExistException;
import tech.amg.user_service.feign.TipsServiceInterface;
import tech.amg.user_service.service.UserService;
import tech.amg.user_service.service.feignServices.TipsFeignService;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController_Get {

    private TipsFeignService tipsFeignService;
    private UserService userService;

    @Autowired
    public UserController_Get(UserService userService) {
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

    @GetMapping("email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
       try {
           User user = userService.findUserByEmail(email);
           if( user !=null) return ResponseEntity.ok(user);
           throw new Exception("User Not Exist !!");
         }catch (Exception e){
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
    }

    @GetMapping("uuid/{uuid}")
    public ResponseEntity<?> getUserByUuid(@PathVariable String uuid){
        try {
            User user = userService.findUserByUuid(uuid);
            if( user !=null) return ResponseEntity.ok(user);
            throw new Exception("User Not Exist !!");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("tips")
    public ResponseEntity<List<TipDto>> getAllTipsFromUserService(){
        return ResponseEntity.ok(tipsFeignService.getAllTips());
    }

    @Autowired
    public void setTipsFeignService(TipsFeignService tipsFeignService) {this.tipsFeignService = tipsFeignService;}

}
