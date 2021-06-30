package examprog3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import examprog3.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findById(long id);
}
