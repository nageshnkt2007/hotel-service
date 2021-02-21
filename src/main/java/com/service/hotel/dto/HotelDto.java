package com.service.hotel.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class HotelDto {

    private String id;

    @NotBlank(message="name cannot be blank")
    private String name;

    @NotBlank(message="description cannot be blank")
    private String description;

    @NotBlank(message="city cannot be blank")
    private String city;

    @Range(message = "Rating should be in range of 1 to 5")
    @Min(0)
    @Max(5)
    private Integer rating;
}
