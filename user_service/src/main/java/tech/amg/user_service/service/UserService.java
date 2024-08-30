package tech.amg.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.amg.user_service.domain.entity.User;
import tech.amg.user_service.repo.UserRepo;

import java.util.List;
import java.util.UUID;


@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User findUserByUuid(String uuid){
       return userRepo.findByUuid(uuid);
    }

}
