package com.odazie.simpleblog.seed;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LiquibaseRunner implements ApplicationRunner {

    private final SpringLiquibase liquibase;

    @Autowired
    public LiquibaseRunner(SpringLiquibase liquibase) {
        this.liquibase = liquibase;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        liquibase.afterPropertiesSet();
    }
}
