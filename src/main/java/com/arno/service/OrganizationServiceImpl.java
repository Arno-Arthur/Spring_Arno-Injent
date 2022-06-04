package com.arno.service;

import com.arno.domain.Organization;
import com.arno.repository.OrganizationR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationR organizationR;


    @Override
    public Organization insert(String name, String address) {
        Organization organization = Organization.builder()
                .name(name)
                .address(address)
                .build();
        return organizationR.save(organization);
    }

    @Override
    public List<Organization> getAll() {
        return organizationR.findAll();
    }

    @Override
    public Organization getById(int id) {
        return organizationR.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        organizationR.deleteById(id);
    }
}
