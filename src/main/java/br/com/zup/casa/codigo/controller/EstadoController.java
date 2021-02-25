package br.com.zup.casa.codigo.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casa.codigo.dto.EstadoDto;
import br.com.zup.casa.codigo.entity.Estado;

@RestController
public class EstadoController {

	@Autowired
	private EntityManager manager;

	@PostMapping("/estados")
	@Transactional
	public String cadastraEstado(@RequestBody @Valid EstadoDto estadoDto) {

		Estado estadoCriado = estadoDto.toModel(manager);
		manager.persist(estadoCriado);

		return estadoCriado.toString();
	}

}
