package com.arno.rest.controller;

import com.arno.LibraryApp;
import com.arno.domain.User;
import com.arno.rest.dto.TokenDto;
import com.arno.rest.dto.UserDto;
import com.arno.service.TokenService;
import com.arno.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;
    private final TokenService tokenService;

    @PostMapping("/user")
    public UserDto getUserByLoginAndPassword(@RequestParam String login,
                                             @RequestParam String password){
        User user = userService.getByLoginAndPassword(login, password);
        return UserDto.toDto(user);
    }

    @PostMapping("/users")
    public List<UserDto> getAllUsers(@RequestBody TokenDto tokenDto){
        if (isTokenValid(tokenDto)){
            return userService
                    .getAll().stream().map(UserDto::toDto).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @PostMapping("/user/create")
    public String insertUser(@RequestBody UserDto userDto,
                             @RequestParam String hash){
        if(hash.equals(LibraryApp.password)){
            userService.insert(UserDto.toDomainObject(userDto));
            return "Successful";
        } else {
            return "Deny";
        }
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam int id, @RequestParam String hash ){
        if(hash.equals(LibraryApp.password)){
            tokenService.deleteById(userService.getById(id).getTokenId().getId());
            userService.deleteById(id);
            return "Successful";
        } else {
            return "Deny";
        }
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable int id, @RequestBody TokenDto tokenDto){
        if (isTokenValid(tokenDto)) {
            User user = userService.getById(id);
            return UserDto.toDto(user);
        }
        return new UserDto();
    }

    private boolean isTokenValid(TokenDto tokenDto){
        if(tokenDto == null){
            return false;
        }
        String value = tokenDto.getValue();
        return tokenService.getTokenByValue(value) != null;
    }
}
