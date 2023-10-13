package com.dda.crbc.reepository;

import com.dda.crbc.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Document} entity.
 */
public interface DocumentRepository extends JpaRepository<Document, Long> {

}