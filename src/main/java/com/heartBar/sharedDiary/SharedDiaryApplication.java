package com.heartBar.sharedDiary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@SpringBootApplication
@Controller
@MapperScan("com.heartBar.sharedDiary.dao")
public class SharedDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharedDiaryApplication.class, args);
	}

	@RequestMapping(value = "testFreemarker")
	public String testFreemarker(Model model){
		Date date = new Date();
		model.addAttribute("time",date);
		model.addAttribute("message","在这里");
		return "web";
	}


}
