package com.dda.crbc.reepository;

import com.dda.crbc.entity.CrbUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the {@link CrbUser} entity.
 */
public interface CrbUserRepository extends JpaRepository<CrbUser, Long> {

    Optional<CrbUser> findByEmail(String email);

}
