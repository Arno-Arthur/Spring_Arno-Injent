package com.arno.rest.controller;

import com.arno.LibraryApp;
import com.arno.domain.Call;
import com.arno.domain.Medications;
import com.arno.rest.dto.CallDto;
import com.arno.rest.dto.MedicationsDto;
import com.arno.rest.dto.TokenDto;
import com.arno.service.CallService;
import com.arno.service.MedicationsService;
import com.arno.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class CallController {
    private final CallService callService;
    private final TokenService tokenService;

    @PostMapping("/call")
    public List<CallDto> getAllCalls(@RequestBody TokenDto tokenDto){
        if (isTokenValid(tokenDto)){
            return callService
                    .getAll().stream().map(CallDto::toDto).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @PostMapping("/call/create")
    public String insertCall(@RequestBody CallDto callDto, @RequestParam String hash){
        if(hash.equals(LibraryApp.password)){
            callService.insert(CallDto.toDomainObject(callDto));
            return "Successful";
        } else {
            return "Deny";
        }
    }

    @PostMapping("/call/delete")
    public String deleteCall(@RequestParam int id, @RequestParam String hash ){
        if(hash.equals(LibraryApp.password)){
            callService.deleteById(id);
            return "Successful";
        } else {
            return "Deny";
        }
    }

    @GetMapping("/call/{id}")
    public CallDto getCallById(@PathVariable int id, @RequestBody TokenDto tokenDto){
        if (isTokenValid(tokenDto)) {
            Call call = callService.getById(id);
            return CallDto.toDto(call);
        }
        return new CallDto();
    }

    private boolean isTokenValid(TokenDto tokenDto){
        if(tokenDto == null){
            return false;
        }
        String value = tokenDto.getValue();
        return tokenService.getTokenByValue(value) != null;
    }
}
