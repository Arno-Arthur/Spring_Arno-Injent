package com.arno.repository;

import com.arno.domain.Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallR extends JpaRepository<Call,Integer> {
}
