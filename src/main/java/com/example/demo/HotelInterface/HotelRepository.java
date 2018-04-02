package com.example.demo.HotelInterface;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}
