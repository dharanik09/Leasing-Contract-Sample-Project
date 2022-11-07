package com.allane.mobility.group.amg.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.allane.mobility.group.amg.security.controller.CustomerController;
import com.allane.mobility.group.amg.servies.CustomerService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CustomerController.class,  excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class CustomerControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private CustomerService customerservice;

    @Test
    void indexTest() throws Exception {
        RequestBuilder request = get("/api/test");
        MvcResult result = mvc.perform(request).andReturn();
        //System.out.println(result.getResponse().getContentAsString());
        assertEquals("Test Customer", result.getResponse().getContentAsString());
    }

 

}
