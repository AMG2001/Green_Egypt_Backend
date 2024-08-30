package tech.green_egypt.repo;

import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import tech.green_egypt.domain.model.Tip;

public interface TipRepo extends MongoRepository<Tip,ObjectId> {
    
    public void deleteByUuid(UUID uuid);
}
