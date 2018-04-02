package com.example.demo.hotlservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.HotelInterface.HotelRepository;
import com.example.demo.model.Hotel;

@Service
public class HotelService {
	HotelRepository hotelRepo;
	
	public HotelService(HotelRepository hotelRepo) {
	
		this.hotelRepo = hotelRepo;
	}

	public ResponseEntity<String> addInfo(Hotel hotel)
	{
		Hotel hotels = hotelRepo.findOne("597d65aed02bdf1b50093257");
		if(hotels==null)
		{
			List<Hotel> hotelList = Arrays.asList(hotel);
			hotelRepo.insert(hotelList);
			return new ResponseEntity<>(hotel.toString(),HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>("Item already Exists"+hotel.toString(),HttpStatus.CONFLICT);

		}
		
	}
	public List<Hotel> getAll()
	{
		List<Hotel> hotelList = this.hotelRepo.findAll();
		return hotelList;
		
	}

	public void saveInfo(Hotel hotel) {
		List<Hotel> hotelList = Arrays.asList(hotel);
		hotelRepo.save(hotelList);
		
	}

	public void deletedata(String id) {

		hotelRepo.delete(id);
		
	}
}
