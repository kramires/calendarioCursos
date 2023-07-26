package com.escola.calendarioCursos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.calendarioCursos.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

}
