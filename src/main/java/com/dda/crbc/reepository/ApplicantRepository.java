package com.dda.crbc.reepository;

import com.dda.crbc.entity.Applicant;
import com.dda.crbc.entity.CrbUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Applicant} entity.
 */
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {


    Applicant findByCrbUser(CrbUser crbUser);
}