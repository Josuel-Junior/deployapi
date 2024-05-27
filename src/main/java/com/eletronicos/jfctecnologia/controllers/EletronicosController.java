package com.eletronicos.jfctecnologia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eletronicos.jfctecnologia.eletronico.DadosCadastroEletronico;
import com.eletronicos.jfctecnologia.eletronico.Eletronico;
import com.eletronicos.jfctecnologia.eletronico.EletronicoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/eletronicos")
public class EletronicosController {
	
	@Autowired
	private EletronicoRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroEletronico dados) {
		
		
		repository.save(new Eletronico(dados));
	}

}
