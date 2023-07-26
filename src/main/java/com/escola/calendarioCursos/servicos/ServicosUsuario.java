package com.escola.calendarioCursos.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.escola.calendarioCursos.entidades.Usuario;
import com.escola.calendarioCursos.repositorios.RepositorioUsuario;
import com.escola.calendarioCursos.servicos.excecoes.DatabaseException;
import com.escola.calendarioCursos.servicos.excecoes.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicosUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			//throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario update(Long id, Usuario obj) {
		try {
			Usuario entity = repositorio.getReferenceById(id);
			updateData(entity, obj);
			return repositorio.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setnomeCompleto(obj.getnomeCompleto());
		entity.setEmail(obj.getEmail());
	}
}
