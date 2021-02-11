package com.webpacs.api.demo.report;

import com.webpacs.api.demo.models.Report;
import com.webpacs.api.demo.repositories.ReportRepository;
import com.webpacs.api.demo.services.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReportServiceTests {
  @Autowired
  private ReportRepository reportRepository;

  @Test
  void getAllReports() {
    Report reportSample = new Report("Teste de criação de laudo médico");
    reportRepository.save(reportSample);
    ReportService reportService = new ReportService(reportRepository);
    List<Report> reportList = reportService.findAllReports();

    Report lastResult = reportList.get(reportList.size() - 1);

    assertEquals(reportSample.getContent(), lastResult.getContent());
    assertEquals(reportSample.getId(), lastResult.getId());
  }
}
