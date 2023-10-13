package com.dda.crbc.reepository;

import com.dda.crbc.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link ActivityLog} entity.
 */
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

}