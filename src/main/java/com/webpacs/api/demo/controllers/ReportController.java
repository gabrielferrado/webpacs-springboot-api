package com.webpacs.api.demo.controllers;

import com.webpacs.api.demo.models.Report;
import com.webpacs.api.demo.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {
  @Autowired
  private ReportService reportService;

  @GetMapping("/reports")
  ResponseEntity<List<Report>> getAllReports() {
    return new ResponseEntity<>(reportService.findAllReports(), HttpStatus.OK);
  }
}
