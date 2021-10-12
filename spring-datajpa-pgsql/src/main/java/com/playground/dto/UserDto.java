package com.playground.dto;

import com.playground.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;

    private String name;

    private String surname;

    private List<String> addressList;
}
