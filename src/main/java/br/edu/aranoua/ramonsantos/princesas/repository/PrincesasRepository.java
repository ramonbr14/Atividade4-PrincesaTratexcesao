package br.edu.aranoua.ramonsantos.princesas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.aranoua.ramonsantos.princesas.entity.*;

public interface PrincesasRepository extends JpaRepository<Princesas, Long>{
	List<Princesas> findByReino(String reino);
}
