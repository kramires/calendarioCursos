package com.escola.calendarioCursos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.escola.calendarioCursos.entidades.Usuario;
import com.escola.calendarioCursos.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class Configuracao implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Maria Brown", "Maria" ,"maria@gmail.com", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "Green" ,"alex@gmail.com", "123456");
		
		repositorioUsuario.saveAll(Arrays.asList(u1,u2));
		
	}


}
