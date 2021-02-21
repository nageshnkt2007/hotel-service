package com.service.hotel.resource;

import com.service.hotel.dto.HotelDto;
import com.service.hotel.dto.HotelsDto;
import com.service.hotel.exception.BadRequestException;
import com.service.hotel.services.IHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;


@RestController
@Validated
@RequestMapping("/hotels")
public class HotelResource {

    @Autowired
    private IHotel hotelService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPerson(@PathVariable("id") String id) {
        HotelDto hotelDto = hotelService.getById(id);
        if(Objects.isNull(hotelDto)){
            ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpStatus.NO_CONTENT.getReasonPhrase());
        }
        return ResponseEntity.status(HttpStatus.OK).body(hotelDto);
    }

    @PostMapping("/")
    public ResponseEntity<?> createHotel(@Valid @RequestBody HotelDto hotelDto) {
        HotelDto hotelDtoSaved = hotelService.createHotel(hotelDto);
        return ResponseEntity.status(HttpStatus.OK).body(hotelDtoSaved);
    }

    @PutMapping("/")
    public ResponseEntity<?> updatePerson(@Valid @RequestBody HotelDto hotelDto) throws BadRequestException {
        HotelDto hotelDtoSaved = hotelService.updateHotel(hotelDto);
        return ResponseEntity.status(HttpStatus.OK).body(hotelDtoSaved);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllPersons(@RequestParam(required = false) Integer page
    ,@RequestParam(required = false) Integer size) {
        HotelsDto hotelsDto = hotelService.getAllHotels(page,size);
        if(Objects.isNull(hotelsDto.getHotelDtos()) || hotelsDto.getHotelDtos().isEmpty()){
            ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpStatus.NO_CONTENT.getReasonPhrase());
        }
        return ResponseEntity.status(HttpStatus.OK).body(hotelsDto);
    }
}
