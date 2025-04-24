package gerePet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gerePet.entities.Usuario;
import gerePet.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long Id){
		Usuario usuario = usuarioService.getUsuarioById(Id);
		if(usuario != null) {
			return ResponseEntity.ok(usuario);
		}
		else {
			return ResponseEntity.ok().build();
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Usuario>> getAllUsuario(){
		List<Usuario> usuario = usuarioService.getAllUsuario();
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alteraUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuario){
		Usuario alteraUsuario = usuarioService.alterarUsuario(id, usuario);
		if(alteraUsuario != null) {
			return ResponseEntity.ok(usuario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Usuario> deleteUsuario(@PathVariable Long id){
		boolean apagar = usuarioService.deleteUsuario(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
