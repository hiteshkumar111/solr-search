package com.apple.mongodb.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apple.mongodb.entity.User;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {

}
