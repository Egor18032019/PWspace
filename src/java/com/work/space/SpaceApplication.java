    package com.work.space;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

    //import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@SpringBootApplication
//@Import(WebSecurityConfig.class)
//@ComponentScan(basePackages ="com.work.space")
public class SpaceApplication {
    static final Logger log = LoggerFactory.getLogger(SpaceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpaceApplication.class, args);
        log.info("Starting my application with {} args.", args.length);

    }

}
