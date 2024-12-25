package com.example.calculator;


import com.example.calculator.CalculatorController;
import com.example.calculator.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
public class CalculatorControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
    public void testAdd() throws Exception {
        when(calculatorService.add(1, 2)).thenReturn(3.0);
        mockMvc.perform(get("/api/calculator/add?a=1&b=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    public void testSubtract() throws Exception {
        when(calculatorService.subtract(5, 3)).thenReturn(2.0);
        mockMvc.perform(get("/api/calculator/subtract?a=5&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    public void testMultiply() throws Exception {
        when(calculatorService.multiply(2, 3)).thenReturn(6.0);
        mockMvc.perform(get("/api/calculator/multiply?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.0"));
    }

    @Test
    public void testDivide() throws Exception {
        when(calculatorService.divide(6, 3)).thenReturn(2.0);
        mockMvc.perform(get("/api/calculator/divide?a=6&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

}

