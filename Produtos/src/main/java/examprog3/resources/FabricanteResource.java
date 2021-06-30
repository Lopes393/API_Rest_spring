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

import examprog3.models.Fabricante;
import examprog3.repository.FabricanteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="Fabricantes API Rest")
@CrossOrigin(origins="*")
public class FabricanteResource {
	

	@Autowired
	FabricanteRepository fabricanteRepository;
	
	@GetMapping("/fabricantes")
	@ApiOperation(value="Retorna uma lista de fabricantes")
	public List<Fabricante> getFabricantes(){
		return fabricanteRepository.findAll();
	}
	
	@GetMapping("/fabricante/{id}")
	@ApiOperation(value="Detalhar de fabricante")
	public Fabricante getFabricanteById(@PathVariable(value="id") long id){
		return fabricanteRepository.findById(id);
	}
	
	@PostMapping("fabricante")
	@ApiOperation(value="Salva fabricantes")
	public Fabricante storeFabricante(@RequestBody Fabricante fabricante) {
		return fabricanteRepository.save(fabricante);
	}
	
	@DeleteMapping("/fabricante/{id}")
	@ApiOperation(value="Deleta um fabricante pelo id")
	public String deleteAlunoById(@PathVariable(value="id") long id) {
		fabricanteRepository.deleteById(id);
		return "Fabricante n° " + id + " deletado com sucesso!";
	}
	
	@PutMapping("/fabricante")
	@ApiOperation(value="Atualiza os dados do fabricante")
	public Fabricante updateFabricante(@RequestBody Fabricante fabricante) {
		return fabricanteRepository.save(fabricante);
	}
}
