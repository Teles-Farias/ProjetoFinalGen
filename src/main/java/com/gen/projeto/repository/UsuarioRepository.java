package com.gen.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.projeto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//public Optional<Usuario> findByEmail(String email);
	boolean existsByEmail(String email);

}
