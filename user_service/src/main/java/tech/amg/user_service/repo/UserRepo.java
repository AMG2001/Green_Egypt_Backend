package tech.amg.user_service.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.amg.user_service.domain.entity.User;

import java.util.UUID;


@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {

    public User findByEmail(String email);

    public User findByUuid(String uuid);

    public User findByPhoneNumber(String phoneNumber);

}
