package com.webpacs.api.demo.services;

import com.webpacs.api.demo.models.Report;
import com.webpacs.api.demo.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
  @Autowired
  ReportRepository reportRepository;

  public ReportService(ReportRepository reportRepository) {
    this.reportRepository = reportRepository;
  }

  public List<Report> findAllReports() {
    return reportRepository.findAll();
  }
}
