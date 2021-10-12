package com.playground.dto;

import com.playground.entity.Address;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@Api(value = "User object")
public class UserDto {
    @ApiModelProperty(value = "id field")
    private Long id;

    @ApiModelProperty(value = "name field")
    private String name;

    @ApiModelProperty(value = "surname field")
    private String surname;

    @ApiModelProperty(value = "addressList field")
    private List<String> addressList;
}
