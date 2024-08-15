package tech.amg.user_service.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import tech.amg.user_service.domain.entity.User;

public interface UserRepo extends MongoRepository<User, ObjectId> {
}
