package com.playground.controller;

import com.playground.dto.UserDto;
import com.playground.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(value = "User Api documentations")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation(value = "Add new user method", notes = "The method will be remove next release!")
    public ResponseEntity<UserDto> kaydet(@RequestBody @ApiParam(value = "user") UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping
    @ApiOperation(value = "Get all users method")
    public ResponseEntity<List<UserDto>> tumunuListele() {
        return ResponseEntity.ok(userService.getAll());
    }
}
