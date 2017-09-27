package com.heartBar.sharedDiary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.heartBar.sharedDiary.dao")
public class SharedDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharedDiaryApplication.class, args);
	}

}
