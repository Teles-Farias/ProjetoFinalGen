package com.gen.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gen.projeto.model.Usuario;
import com.gen.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario cadastrarUsuario(Usuario usuario){

		if(usuarioRepository.existsByEmail(usuario.getEmail()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email já cadastrado.");
//			throw new Error("Email já cadastrado.");
			
		return usuarioRepository.save(usuario);
	}
	
	
	
	public void atualizarUsuario(Usuario usuario){
		
		if(usuarioRepository.findById(usuario.getId()).isPresent()) {
				
		usuarioRepository.save(usuario);
		}
	
	}
	
	public void delete(Long id) {		
		
		if(!usuarioRepository.existsById(id))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
		
		usuarioRepository.deleteById(id);
		
	}
	
	
	
}
