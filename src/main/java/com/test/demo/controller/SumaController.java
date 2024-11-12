package com.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumaController {
	
	@GetMapping("/calculador")
	public String mostrarForm() {
	    return "index";
	}
	
	@PostMapping("/resultado")
	public String sumar(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
	    int resultado = num1 + num2;
	    System.out.println("Resultado calculado: " + resultado);
	    model.addAttribute("resultado", resultado);
	    model.addAttribute("numero1", num1);
	    model.addAttribute("numero2", num2);
	    return "resultado";
	}
}
