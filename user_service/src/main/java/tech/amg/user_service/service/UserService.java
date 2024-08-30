package tech.amg.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.amg.user_service.domain.entity.User;
import tech.amg.user_service.repo.UserRepo;
import tech.amg.user_service.service.util.UuidUtil;

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

    /**
     * Note that the coming user data is missing a couple of attributes like :
     * UUID , image byte[] , totalNumberOfPlastic,cans,etc as it will be assigned from server side
     */
    public User addNewUser(User newUser){
        // the object that will contain the full version of attributes
        User newUserWithFullAttributes = new User();
        // assign the whole fields that will not assigned from client side .
        newUserWithFullAttributes.setUuid(UuidUtil.generateUuid());
        newUserWithFullAttributes.setTotalNumberOfCans(0);
        newUserWithFullAttributes.setTotalNumberOfPlastic(0);
        newUserWithFullAttributes.setTotalNumberOfPoints(0);
        newUserWithFullAttributes.setImage(new byte[]{});
        // assign the whole fields that will be assigned from Client side :
        newUserWithFullAttributes.setFirstName(newUser.getFirstName());
        newUserWithFullAttributes.setLastName(newUser.getLastName());
        newUserWithFullAttributes.setEmail(newUser.getEmail());
        newUserWithFullAttributes.setPassword(newUser.getPassword());
        newUserWithFullAttributes.setCredintial(newUser.getCredintial());
        newUserWithFullAttributes.setPhoneNumber(newUser.getPhoneNumber());
        // store the full version object on Mongo :
        userRepo.save(newUserWithFullAttributes);
        return newUserWithFullAttributes;
    }

}
