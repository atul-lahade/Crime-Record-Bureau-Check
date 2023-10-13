package com.dda.crbc.reepository;

import com.dda.crbc.entity.CRBCheckRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link CRBCheckRequest} entity.
 */
public interface CRBCheckRequestRepository extends JpaRepository<CRBCheckRequest, Long> {

}