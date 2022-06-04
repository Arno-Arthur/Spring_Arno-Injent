package com.arno.repository;

import com.arno.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationR extends JpaRepository<Organization,Integer> {
}
