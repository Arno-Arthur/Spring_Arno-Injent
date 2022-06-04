package com.arno.service;

import com.arno.domain.Medications;

import java.util.List;

public interface MedicationsService {

    Medications insert(Medications medications);

    List<Medications> getAll();

    Medications getById(int id);

    void deleteById(int id);

}
