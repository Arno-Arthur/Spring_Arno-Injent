package com.arno.repository;

import com.arno.domain.Call;
import com.arno.domain.Medications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationsR extends JpaRepository<Medications,Integer> {
}
