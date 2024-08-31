package tech.amg.user_service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.amg.user_service.domain.entity.User;
import tech.amg.user_service.exceptions.UserAlreadyExistException;
import tech.amg.user_service.repo.UserRepo;
import tech.amg.user_service.service.util.UuidUtil;

import java.util.List;



@Slf4j
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

    public User findUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    /**
     * Note that the coming user data is missing a couple of attributes like :
     * UUID , image byte[] , totalNumberOfPlastic,cans,etc as it will be assigned from server side
     */
    public User addNewUser(User newUser) throws UserAlreadyExistException {
        if(checkIfEmailOrPhoneNumberExist(newUser)) throw new UserAlreadyExistException("User Already Exists !!");
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

    public void deleteUser(String uuid){
        userRepo.deleteById(uuid);
    }


    private boolean checkIfEmailOrPhoneNumberExist(User user){
        /**
         * Check in Mongo if there is any User with this email or phoneNumber as they are unique data .
         */
        return checkIfEmailExist(user) || checkIfPhoneNumberExist(user);
    }

    private boolean checkIfEmailExist(User user) {
        return userRepo.findByEmail(user.getEmail()) !=null ? true : false;
    }

    private boolean checkIfPhoneNumberExist(User user) {
        return userRepo.findByPhoneNumber(user.getPhoneNumber()) !=null ? true : false;
    }

}
