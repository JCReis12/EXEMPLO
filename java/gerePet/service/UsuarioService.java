package gerePet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gerePet.repository.UsuarioRepository;
import gerePet.entities.Usuario;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService (UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getAllUsuario(){
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuarioById (Long id) {
		Optional <Usuario> Usuario = usuarioRepository.findById(id);
		return Usuario.orElse(null);
	}
	
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario alterarUsuario (Long id, Usuario alterarU) {
		Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
		if(existeUsuario.isPresent()) {
			alterarU.setId(id);
			return usuarioRepository.save(alterarU);
		}
		return null;
	}
	
	public boolean deleteUsuario(Long id) {
		Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
		if(existeUsuario.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
