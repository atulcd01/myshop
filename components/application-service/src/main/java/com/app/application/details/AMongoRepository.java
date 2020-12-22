package com.app.application.details;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AMongoRepository extends MongoRepository<AModel, String> {


}
