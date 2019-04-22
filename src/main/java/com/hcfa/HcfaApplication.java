package com.hcfa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.hcfa.material.dao.**")
public class HcfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcfaApplication.class, args);
	}

}
