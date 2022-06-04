package com.arno.rest.controller;


import com.arno.LibraryApp;
import com.arno.domain.Medications;
import com.arno.domain.Token;
import com.arno.rest.dto.MedicationsDto;
import com.arno.rest.dto.TokenDto;
import com.arno.service.MedicationsService;
import com.arno.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class MedicationsController {

    private final MedicationsService medicationsService;
    private final TokenService tokenService;

    @PostMapping("/medications")
    public List<MedicationsDto> getAllMedications(@RequestBody TokenDto tokenDto){
        if (isTokenValid(tokenDto)){
            return medicationsService
                    .getAll().stream().map(MedicationsDto::toDto).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @PostMapping("/medications/create")
    public String insertMedications(@RequestBody MedicationsDto medicationsDto, @RequestParam String hash){
        if(hash.equals(LibraryApp.password)){
            medicationsService.insert(MedicationsDto.toDomainObject(medicationsDto));
            return "Successful";
        } else {
            return "Deny";
        }
    }

    @PostMapping("/medications/delete")
    public String deleteMedications(@RequestParam int id, @RequestParam String hash ){
        if(hash.equals(LibraryApp.password)){
            medicationsService.deleteById(id);
            return "Successful";
        } else {
            return "Deny";
        }
    }

    @GetMapping("/medications/{id}")
    public MedicationsDto getMedicationsById(@PathVariable int id, @RequestBody TokenDto tokenDto){
        if (isTokenValid(tokenDto)) {
            Medications medications = medicationsService.getById(id);
            return MedicationsDto.toDto(medications);
        }
        return new MedicationsDto();
    }

    private boolean isTokenValid(TokenDto tokenDto){
        if(tokenDto == null){
            return false;
        }
        String value = tokenDto.getValue();
        return tokenService.getTokenByValue(value) != null;
    }
}
