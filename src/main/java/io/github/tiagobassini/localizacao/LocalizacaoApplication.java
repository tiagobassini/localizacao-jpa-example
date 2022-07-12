package io.github.tiagobassini.localizacao;

import io.github.tiagobassini.localizacao.domain.entity.Cidade;
import io.github.tiagobassini.localizacao.domain.repository.CidadeRepository;
import io.github.tiagobassini.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService service;

	public void run(String... args) throws Exception{

		//var cidade = new Cidade(null, "Porto Alegre", null);
//		service.filtroDinamico(cidade).forEach(System.out::println);
		service.listarCidadesByNomeSpec();
	}





	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}


}
