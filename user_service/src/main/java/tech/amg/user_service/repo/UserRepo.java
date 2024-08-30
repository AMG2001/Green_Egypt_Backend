package tech.amg.user_service.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.amg.user_service.domain.entity.User;

import java.util.UUID;


@Repository
public interface UserRepo extends MongoRepository<User, UUID> {

    User findByEmail(String email);

    User findByUuid(String uuid);

    User findByPhoneNumber(String phoneNumber);

}
