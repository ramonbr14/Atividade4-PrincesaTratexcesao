package br.edu.aranoua.ramonsantos.princesas.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.edu.aranoua.ramonsantos.princesas.entity.Princesas;
import br.edu.aranoua.ramonsantos.princesas.modelo.PrincesasModel;
import br.edu.aranoua.ramonsantos.princesas.recursos.PrincesasController;

@Component
public class PrincesasModelAssembler extends RepresentationModelAssemblerSupport<Princesas, PrincesasModel> {

	public PrincesasModelAssembler( ) {
		super(PrincesasController.class, PrincesasModel.class);
	}
	
	@Override
	public PrincesasModel toModel(Princesas princesa) {
		PrincesasModel princesaModel = instantiateModel(princesa);
		
		princesaModel.add(linkTo(
				methodOn(PrincesasController.class)
				.getPrincesa(princesa.getId())
				).withSelfRel());

		princesaModel.add(linkTo(
				methodOn(PrincesasController.class)
				.getPrincesas()).withRel("principalmain"));
		
		princesaModel.setId(princesa.getId());
		princesaModel.setNome(princesa.getNome());
		princesaModel.setReino(princesa.getReino());
		princesaModel.setIdade(princesa.getIdade());
		
		return princesaModel;
	}

	@Override
	public CollectionModel<PrincesasModel> toCollectionModel(Iterable<? extends Princesas> princesa) {
		
		CollectionModel<PrincesasModel> princesaModels = super.toCollectionModel(princesa);
		
		princesaModels.add(linkTo(
				methodOn(PrincesasController.class)
				.getPrincesas())
				.withSelfRel());
		
		return princesaModels;
	}
}
