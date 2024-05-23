package com.eletronicos.jfctecnologia.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eletronicos.jfctecnologia.eletronico.DadosCadastroEletronico;

@RestController
@RequestMapping("/eletronicos")
public class EletronicosController {
	
	
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroEletronico dados) {
		System.out.println(dados);
	}

}
