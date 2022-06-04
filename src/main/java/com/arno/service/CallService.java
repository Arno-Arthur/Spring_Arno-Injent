package com.arno.service;

import com.arno.domain.Call;

import java.util.List;

public interface CallService {

    Call insert( Call call);

    List<Call> getAll();

    Call getById(int id);

    void deleteById(int id);

}
