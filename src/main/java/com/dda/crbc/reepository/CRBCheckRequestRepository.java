package com.dda.crbc.reepository;

import com.dda.crbc.entity.CrbCheckRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link CrbCheckRequest} entity.
 */
public interface CRBCheckRequestRepository extends JpaRepository<CrbCheckRequest, Long> {

}