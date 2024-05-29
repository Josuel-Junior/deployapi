package com.eletronicos.jfctecnologia.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eletronicos.jfctecnologia.eletronico.DadoListagemEletronicos;
import com.eletronicos.jfctecnologia.eletronico.DadosAtualizarEletronico;
import com.eletronicos.jfctecnologia.eletronico.DadosCadastroEletronico;
import com.eletronicos.jfctecnologia.eletronico.Eletronico;
import com.eletronicos.jfctecnologia.eletronico.EletronicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/eletronicos")
public class EletronicosController {
	
	@Autowired
	private EletronicoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroEletronico dados) {
		
		
		repository.save(new Eletronico(dados));
	}
	
	@GetMapping
	public List<DadoListagemEletronicos> listar (){
		
		return repository.findAllByAtivoTrue().stream().map(DadoListagemEletronicos::new).toList();
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarEletronico dados) {
		var eletronico = repository.getReferenceById(dados.id());
		
		eletronico.atualizarInformações(dados);
		
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@DeleteMapping("inativar/{id}")
	@Transactional
	public void inativar(@PathVariable Long id) {
		var eletronico = repository.getReferenceById(id);
		
		eletronico.inativar();
	}
	

}
