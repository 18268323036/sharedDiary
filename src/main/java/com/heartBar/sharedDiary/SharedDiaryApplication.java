package com.heartBar.sharedDiary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Controller
@MapperScan("com.heartBar.sharedDiary.dao")
public class SharedDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharedDiaryApplication.class, args);
	}


}
