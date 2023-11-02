package com.dda.crbc.reepository;

import com.dda.crbc.entity.Applicant;
import com.dda.crbc.entity.CriminalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the {@link CriminalRecord} entity.
 */
public interface CriminalRecordRepository extends JpaRepository<CriminalRecord, Long> {

    Optional<CriminalRecord> findByApplicant(Applicant applicant);
}