package com.dda.crbc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 * Utils to Control Hibernate Sessions.
 */
@Component
public class JpaManager {

    @Autowired
    private EntityManager entityManager;
}
