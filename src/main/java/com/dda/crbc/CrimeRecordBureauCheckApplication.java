package com.dda.crbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.dda.crbc"})
@EnableTransactionManagement
@EnableWebSecurity
@EnableAutoConfiguration
public class CrimeRecordBureauCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrimeRecordBureauCheckApplication.class, args);
    }

}
