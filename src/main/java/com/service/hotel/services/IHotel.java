package com.service.hotel.services;

import com.service.hotel.dto.HotelDto;
import com.service.hotel.dto.HotelsDto;
import com.service.hotel.exception.BadRequestException;

public interface IHotel {
    /**
     * @param hotelDto .
     * @return PersonDto .
     */
    HotelDto createHotel(HotelDto hotelDto);

    /**
     * @param id .
     * @return PersonDto .
     */
    HotelDto getById(String id);

    /**
     * @return All Person Objects .
     * @param page
     */
    HotelsDto getAllHotels(Integer page, Integer size);


    /**
     * @param hotelDto .
     * @return updated PersonDto object .
     */
    HotelDto updateHotel(HotelDto hotelDto) throws BadRequestException;

}
