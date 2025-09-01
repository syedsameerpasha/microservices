package com.hotelratingsystem.UserService.mongo;

import com.hotelratingsystem.UserService.dto.UserDto;
import com.hotelratingsystem.UserService.entity.UserEntity;
import com.hotelratingsystem.UserService.exceptions.DatabaseError;
import com.hotelratingsystem.UserService.exceptions.DuplicatedIdException;
import com.hotelratingsystem.UserService.exceptions.FailedToGetDetails;
import com.hotelratingsystem.UserService.exceptions.FailedToUpdateDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserImpl {
    private MongoTemplate mongoTemplate;

    @Autowired
    public UserImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public UserEntity createUser(UserEntity userEntity) {
        try {
            Criteria criteria = Criteria.where("id").is(userEntity.getId());
            Query query = new Query(criteria);
            if (mongoTemplate.exists(query, UserEntity.class)) {
                throw new DuplicatedIdException("Id alreday exists,plz pass unqiue id");
            }
            return mongoTemplate.save(userEntity);

        } catch (DuplicatedIdException e) {
            throw e;
        } catch (Exception e) {
            throw new DatabaseError();
        }
    }

    public UserEntity getUser(String id) {
        if (id == null || id.isEmpty() || id.equalsIgnoreCase("null")) {
            throw new FailedToGetDetails("Id is mandatory to get the data");
        }
        try {
            UserEntity user = mongoTemplate.findById(id, UserEntity.class);

            return user;
        } catch (Exception e) {
            throw new DatabaseError("Database operation failed");

        }

    }

    public UserEntity updateUser(String id, UserDto userDto) {
        if (id == null || id.isEmpty() || id.equalsIgnoreCase("null")) {
            throw new FailedToUpdateDetails("id is must to update details");
        }
        UserEntity user;
        try {
             user = mongoTemplate.findById(id, UserEntity.class);

        } catch (Exception e) {
            throw new DatabaseError("DB Server error");
        }
        if (user == null) {
            throw new FailedToGetDetails("user doesnt exists");
        }
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setDob(userDto.getDob());
        user.setHotelId(userDto.getHotelId());
        try {
            return mongoTemplate.save(user);
        }catch (Exception e){
            throw new DatabaseError("DB Server error while saving user");
        }

    }
}


//Missing @RequestParam(required = false)
//
//If you don't set required = false, and id is not passed at all, Spring throws its own 400 Bad Request before your method is even called.





