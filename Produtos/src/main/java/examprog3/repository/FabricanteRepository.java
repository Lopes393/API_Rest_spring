package examprog3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import examprog3.models.Fabricante;


public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

	Fabricante findById(long id);

}
