package gerePet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gerePet.entities.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

}
