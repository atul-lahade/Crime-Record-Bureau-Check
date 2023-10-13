package com.dda.crbc.reepository;

import com.dda.crbc.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Feedback} entity.
 */
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}