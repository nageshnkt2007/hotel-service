package com.service.hotel.mapper;

import com.service.hotel.dto.HotelDto;
import com.service.hotel.entity.Hotel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * The interface Custom object mapper.
 */
@Component
@Mapper(componentModel = "spring")
public interface CustomObjectMapper {

    HotelDto personToPersonDto(Hotel hotel);

    Hotel personDtoToPerson(HotelDto hotelDto);

    List<HotelDto> hotelsTohotelDtos(List<Hotel> hotelList);

    List<Hotel> hotelDtosToHotels(List<HotelDto> hotelList);
}
