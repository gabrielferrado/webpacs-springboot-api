package com.webpacs.api.demo;

import com.webpacs.api.demo.models.Report;
import com.webpacs.api.demo.repositories.ReportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

//  @Bean
//  public CommandLineRunner setup(ReportRepository reportRepository) {
//    return (args) -> {
//      reportRepository.save(new Report("Add a new test case"));
//      reportRepository.save(new Report("Make it fail"));
//      reportRepository.save(new Report("Do changes to the code"));
//      reportRepository.save(new Report("Pass the test"));
//    };
//  }
}
