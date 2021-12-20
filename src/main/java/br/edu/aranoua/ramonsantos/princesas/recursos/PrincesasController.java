package br.edu.aranoua.ramonsantos.princesas.recursos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.aranoua.ramonsantos.princesas.assembler.PrincesasModelAssembler;
import br.edu.aranoua.ramonsantos.princesas.entity.Princesas;
import br.edu.aranoua.ramonsantos.princesas.modelo.PrincesasModel;
import br.edu.aranoua.ramonsantos.princesas.servicos.PrincesasServices;



@RestController
@RequestMapping(value="princesa")
public class PrincesasController {

	@Autowired
	PrincesasServices princesaServices;
	
	@Autowired
	PrincesasModelAssembler princesasModelAssembler; 
	
	@GetMapping
	public ResponseEntity<CollectionModel<PrincesasModel>> getPrincesas() {
		List<Princesas> princesas = princesaServices.obterPrincesas();
		CollectionModel<PrincesasModel> princesasModel =
				princesasModelAssembler.toCollectionModel(princesas);
		return ResponseEntity.ok(princesasModel);
	}
	@GetMapping("/procura")
	public ResponseEntity<CollectionModel<PrincesasModel>> getPrincesaByNome(@RequestParam String nome) {
		List<Princesas> princesas = princesaServices.obterPrincesas(nome);
		CollectionModel<PrincesasModel> princesasModel =
				princesasModelAssembler.toCollectionModel(princesas);
		return ResponseEntity.ok(princesasModel);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PrincesasModel> getPrincesa(@PathVariable("id") long id){
		Optional<Princesas> optionalPrincesas = princesaServices.obterPrincesas(id);
		if(optionalPrincesas.isPresent()) {
			Princesas princesas = optionalPrincesas.get();
			PrincesasModel princesasModel = princesasModelAssembler.toModel(princesas);
			return ResponseEntity.ok(princesasModel);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Princesas> postPrincesas(@RequestBody Princesas princesa){
		Princesas princes = princesaServices.criarPrincesas(princesa);
		return ResponseEntity.status(HttpStatus.CREATED).body(princes);
	}
	@PutMapping
	@RequestMapping(value="/{id}")
	public ResponseEntity<Princesas> putPrincesa(@RequestBody Princesas princesas,
			@PathVariable("id") int id){
		return ResponseEntity.ok(princesaServices.atualizarPrincesa(id, princesas));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletePrincesa(@PathVariable("id") int id){
		princesaServices.excluirPrincesa(id);
		return ResponseEntity.noContent().build();
	}
}
