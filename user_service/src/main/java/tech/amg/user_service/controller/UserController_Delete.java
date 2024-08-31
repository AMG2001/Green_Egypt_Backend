package tech.amg.user_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.amg.user_service.service.UserService;

@RestController
@RequestMapping("users")
public class UserController_Delete {

    private UserService userService;

    @Autowired
    public UserController_Delete(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<?> deleteUser(@PathVariable String uuid) {
        try {
            userService.deleteUser(uuid);
            return ResponseEntity.ok("User Deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
