package com.arno.service;

import com.arno.domain.Call;
import com.arno.repository.CallR;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CallServiceImpl implements CallService {
    private final CallR callR;


    @Override
    public Call insert(Call call) {
        return callR.save(call);
    }

    @Override
    public List<Call> getAll() {
        return callR.findAll();
    }

    @Override
    public Call getById(int id) {
        return callR.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        callR.deleteById(id);
    }
}
