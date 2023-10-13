package com.dda.crbc.reepository;

import com.dda.crbc.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Applicant} entity.
 */
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}