package com.service.hotel.dto;

import lombok.Data;

import java.util.List;

@Data
public class HotelsDto {
    List<HotelDto> hotelDtos;
    int totalPages;
}
