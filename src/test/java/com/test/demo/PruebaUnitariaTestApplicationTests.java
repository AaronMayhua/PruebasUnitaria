package com.test.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.test.demo.controller.SumaController;


@WebMvcTest(SumaController.class)
class PruebaUnitariaTestApplicationTests {
	
	  @Autowired
	    private MockMvc mockMvc;

	  @DisplayName("unITestMostrarForm") 
	    @Test
	    public void mostrarFormTest() throws Exception {
	        mockMvc.perform(get("/calculador"))
	            .andExpect(status().isOk())
	            .andExpect(view().name("index"));
	    }

	
	  @DisplayName("unIResultadoDeLaSuma")
	   @Test
	    public void sumarTest() throws Exception {
	        int num1 = 5;
	        int num2 = 10;
	        int resultadoEsperado = 15;

	        mockMvc.perform(post("/resultado")
	                .param("num1", String.valueOf(num1))
	                .param("num2", String.valueOf(num2)))
	            .andExpect(status().isOk())
	            .andExpect(view().name("resultado"))
	            .andExpect(model().attribute("resultado", resultadoEsperado))
	            .andExpect(model().attribute("numero1", num1))
	            .andExpect(model().attribute("numero2", num2));
	    }

}
