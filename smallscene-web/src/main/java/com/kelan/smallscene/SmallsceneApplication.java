package com.kelan.smallscene;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
//@EnableJms
@MapperScan(value = "com.kelan.smallscene.dao")
public class SmallsceneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallsceneApplication.class, args);
	}

}

