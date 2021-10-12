package com.playground.service.impl;

import com.playground.dto.UserDto;
import com.playground.entity.Address;
import com.playground.entity.User;
import com.playground.repositories.AddressRepository;
import com.playground.repositories.UserRepository;
import com.playground.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());

        final User userDb = userRepository.save(user);

        List<Address> liste = new ArrayList<>();
        userDto.getAddressList().forEach(item -> {
            Address address = new Address();
            address.setAddressDetail(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setUser(userDb);
            liste.add(address);
        });
        addressRepository.saveAll(liste);
        userDto.setId(userDb.getId());

        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(it -> {
            UserDto userDto = new UserDto();
            userDto.setId(it.getId());
            userDto.setName(it.getName());
            userDto.setSurname(it.getSurname());
            userDto.setAddressList(it.getAddresses().stream().map(Address::getAddressDetail)
                    .collect(Collectors.toList()));
            userDtos.add(userDto);
        });

        return userDtos;
    }


    @Override
    public Page<UserDto> getAll(Pageable pegeable) {
        return null;
    }
}
