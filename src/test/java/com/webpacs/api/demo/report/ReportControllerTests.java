package com.webpacs.api.demo.report;

import com.webpacs.api.demo.DemoApplication;
import com.webpacs.api.demo.controllers.ReportController;
import com.webpacs.api.demo.models.Report;
import com.webpacs.api.demo.services.ReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DemoApplication.class)
@WebMvcTest(ReportController.class)
public class ReportControllerTests {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private ReportService reportService;

  @Test
  void getAllReports() throws Exception {
    List<Report> reportsList = new ArrayList<Report>();
    reportsList.add(new Report("Tomografia computadorizada do crânio."));
    reportsList.add(new Report("Ressonância magnética de Fulano de Tal."));

    when(reportService.findAllReports()).thenReturn(reportsList);

    mockMvc.perform(MockMvcRequestBuilders.get("/reports")
            .contentType(MediaType.APPLICATION_JSON)
    ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
  }

}
