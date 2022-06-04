package com.arno.service;

import com.arno.domain.Organization;

import java.util.List;

public interface OrganizationService {

    Organization insert(
            String name,
            String address
    );

    List<Organization> getAll();

    Organization getById(int id);

    void deleteById(int id);
}
