package com.pk.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.demo.service.CustomUrlService;
import com.pk.demo.service.UrlService;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrlService urlService;

    @MockBean
    private CustomUrlService customUrlService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_redirect_Successful_302() throws Exception {
        Mockito.when(urlService.getActualUrl("i4ty7sw")).thenReturn("http://www.google.com");
        mockMvc.perform(get("/i4ty7sw"))
                .andExpect(status().isFound());
    }

    @Test
    public void test_redirect_UnSuccessful_404() throws Exception {
        Mockito.when(urlService.getActualUrl("i4ty7sw")).thenReturn("");
        mockMvc.perform(get("/i4ty7sw"))
                .andExpect(status().isNotFound());
    }
}
