package com.kranti.multidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public final static String MODEL_PACKAGE = "com.kranti.multidatasource.model";

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
