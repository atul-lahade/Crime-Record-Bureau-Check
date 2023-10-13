package com.dda.crbc.reepository;

import com.dda.crbc.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Employer} entity.
 */
public interface EmployerRepository extends JpaRepository<Employer, Long> {

}