package com.service.hotel.services.impl;

import com.service.hotel.constants.HotelConstants;
import com.service.hotel.dao.HotelRepository;
import com.service.hotel.dto.HotelDto;
import com.service.hotel.dto.HotelsDto;
import com.service.hotel.entity.Hotel;
import com.service.hotel.exception.BadRequestException;
import com.service.hotel.mapper.CustomObjectMapper;
import com.service.hotel.services.IHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HotelService implements IHotel {

    /**
     * PersonRepository to interact with
     * database layer .
     */
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CustomObjectMapper customObjectMapper;

    /**
     * @param hotelDto .
     * @return PersonDto .
     */
    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = customObjectMapper.personDtoToPerson(hotelDto);
        hotel = hotelRepository.save(hotel);
        return customObjectMapper.personToPersonDto(hotel);
    }

    /**
     * @param hotelDto .
     * @return updated PersonDto object .
     */
    @Override
    public HotelDto updateHotel(HotelDto hotelDto) throws BadRequestException {
        if(Objects.isNull(hotelDto.getId())){
            throw new BadRequestException(HotelConstants.BAD_REQUEST_MESSAGE);
        }
        Optional<Hotel> personSaved = hotelRepository.findById(hotelDto.getId());
        Hotel hotel = null;
        if(personSaved.isPresent()){
            hotel = customObjectMapper.personDtoToPerson(hotelDto);
            hotel = hotelRepository.save(hotel);
        }else{
            throw new BadRequestException(HotelConstants.BAD_REQUEST_MESSAGE);
        }
        return Objects.nonNull(hotel)?customObjectMapper.personToPersonDto(hotel):null;
    }

    /**
     * @param id .
     * @return PersonDto .
     */
    @Override
    public HotelDto getById(String id) {
        Optional<Hotel> person = hotelRepository.findById(id);
        return person.isPresent()?customObjectMapper.personToPersonDto(person.get()):null;
    }

    /**
     * @return All Person Objects .
     * @param page
     */
    @Override
    public HotelsDto getAllHotels(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Hotel> personDB = hotelRepository.findAll(pageable);
        HotelsDto personsDto = new HotelsDto();
        List<Hotel> hotels = personDB.getContent();
        personsDto.setHotelDtos(customObjectMapper.hotelsTohotelDtos(hotels));
        personsDto.setTotalPages(personDB.getTotalPages());
        return personsDto;
    }
}
