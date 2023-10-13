package com.dda.crbc.reepository;

import com.dda.crbc.entity.CRBCheckAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link CRBCheckAssignment} entity.
 */
public interface CRBCheckAssignmentRepository extends JpaRepository<CRBCheckAssignment, Long> {


}