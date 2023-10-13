package com.dda.crbc.reepository;

import com.dda.crbc.entity.CriminalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link CriminalRecord} entity.
 */
public interface CriminalRecordRepository extends JpaRepository<CriminalRecord, Long> {

}