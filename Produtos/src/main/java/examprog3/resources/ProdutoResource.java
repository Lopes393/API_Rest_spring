package examprog3.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import examprog3.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import examprog3.models.Produto;

@RestController
@RequestMapping(value="/api")
@Api(value="Produtos API Rest")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Detalhar de produto")
	public Produto getProdutoById(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("produto")
	@ApiOperation(value="Salva produtos")
	public Produto storeProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto/{id}")
	@ApiOperation(value="Deleta um produto pelo id")
	public String deleteAlunoById(@PathVariable(value="id") long id) {
		produtoRepository.deleteById(id);
		return "Fabricante n° " + id + " deletado com sucesso!";
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza os dados do produto")
	public Produto updateProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
