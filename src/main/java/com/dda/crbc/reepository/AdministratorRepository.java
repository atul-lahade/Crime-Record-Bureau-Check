package com.dda.crbc.reepository;

import com.dda.crbc.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Administrator} entity.
 */
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}