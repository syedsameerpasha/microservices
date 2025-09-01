package com.example.HotelService.mongo;

import com.example.HotelService.document.HotelDocument;
import com.example.HotelService.exceptions.DatabaseError;
import com.example.HotelService.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public HotelDocument getHotelDetails(String hotelId) {

        try {
            Query query= new Query();
            query.addCriteria(Criteria.where("hotelId").is(hotelId));
            return Optional.ofNullable(
                    mongoTemplate.findOne(query, HotelDocument.class)

            ).orElseThrow(() -> new IdNotFoundException("hotel doesnt exist with this id"));


        } catch (DataAccessException e) {
            throw new DatabaseError("Databse server is down");
        }


    }
}
