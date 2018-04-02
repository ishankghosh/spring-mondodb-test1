package com.example.demo.Controller;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.HotelInterface.HotelRepository;
import com.example.demo.hotlservice.HotelService;
import com.example.demo.model.Hotel;

@RestController
public class HotelController {
	
	static final Logger logger = LoggerFactory.getLogger(HotelController.class);
	@Autowired
	HotelService hotelService;
	
	@RequestMapping("/hotels")
	public Hotel sayHi()
	{
		logger.info("logger info");
		logger.debug("logger debug");
		logger.error("error message");
		logger.trace("Hello World!");
		logger.debug("How are you today?");
		logger.info("I am fine.");
		logger.warn("I love programming.");
		logger.error("I am programming.");
		return new Hotel();
	}
	/*@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addInfo(@RequestBody Hotel hotel){
		hotelService.addInfo(hotel);
	}*/
	@GetMapping("/all")
	@Produces(MediaType.APPLICATION_XML_VALUE)
	//@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public List<Hotel> getAll(){
		return hotelService.getAll();
	}
	@PutMapping
	public void addInfo(@RequestBody Hotel hotel){
		System.out.println(hotelService.addInfo(hotel));
	}
	@PostMapping
	public void update(@RequestBody Hotel hotel){
		hotelService.saveInfo(hotel);
	}
	@DeleteMapping("/{id}")
	public void deleteData(@PathVariable("id") String id){
		hotelService.deletedata(id);
	}
}
