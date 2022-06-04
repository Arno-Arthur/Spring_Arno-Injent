package com.arno.service;


import com.arno.domain.*;
import com.arno.repository.CallR;
import com.arno.repository.MedicationsR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MisDemoService {

    private final CallService callService;
    private final MedicationsService medicationsService;
    private final TokenService tokenService;
    private final UserService userService;
    private final OrganizationService organizationService;

    public void medicationsDemo(){

        List<Medications> medications = medicationsService.getAll();
        System.out.println("======");
        for(Medications medication: medications){
            System.out.println(medication);
        }
        System.out.println("=====");
    }


    public void callDemo(){

        List<Call> calls = callService.getAll();
        System.out.println("======");
        for(Call call: calls){
            System.out.println(call);
        }
        System.out.println("=====");
        callService.deleteById(2);
    }

    public void organizationDemo(){
        List<Organization> organizations = organizationService.getAll();
        System.out.println("======");
        for (Organization organization: organizations){
            System.out.println(organization);
        }
        System.out.println("======");
        organizationService.insert("Ar","no");
        organizationService.deleteById(3);
    }

    public void tokenDemo(){
        List<Token> tokens = tokenService.getAll();
        System.out.println("======");
        for (Token token: tokens){
            System.out.println(token);
        }
        System.out.println("======");
    }

    public void userDemo(){
        List<User> users = userService.getAll();
        System.out.println("=====");
        for (User user: users){
            System.out.println(users);
        }
        System.out.println("=====");
    }
}
