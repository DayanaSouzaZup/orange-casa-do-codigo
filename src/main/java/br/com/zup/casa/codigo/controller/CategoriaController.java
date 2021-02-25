package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.dto.CategoriaDto;
import br.com.zup.casa.codigo.entity.Categoria;

@RestController
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/categorias")
	@Transactional
	public String cadastrarCategoria (@RequestBody @Valid CategoriaDto categoriaDto) {
		
		Categoria categoria = categoriaDto.toModel();
		manager.persist(categoria);
		return categoria.toString();
	}
}

