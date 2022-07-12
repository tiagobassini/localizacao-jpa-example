package io.github.tiagobassini.localizacao.service;

import io.github.tiagobassini.localizacao.domain.entity.Cidade;
import io.github.tiagobassini.localizacao.domain.repository.CidadeRepository;
import io.github.tiagobassini.localizacao.domain.repository.specs.CidadeSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;
    }

    @Transactional
    public void salvarCidade(){
        var cidade =new Cidade(1L, "São Paulo",  999999L);
        repository.save(cidade);
    }

    public void listarCidade(){
        repository.findAll().forEach(System.out::println);
    }

    public void listarCidadePorNome(){
        System.out.println("Cidades por nome: ");
        repository.findByNome("Palmas").forEach(System.out::println);
    }

    public void listarCidadePorNomeSqlNativo(){
        System.out.println("Cidades por nome: ");
        repository.findByNomeSqlNativo("Palmas").forEach(System.out::println);
    }

    public void listarCidadePorNomeSqlNativoProjetction(){
        System.out.println("Cidades por nome: ");
        repository.findByNomeSqlNativoProjection("Palmas")
                        .stream()
                        .map(projection -> new Cidade(projection.getId(), projection.getNome(), null))
                        .forEach(System.out::println);
    }

    public void listarCidadePorHabitantes(){
        System.out.println("Cidades por Habitantes: ");
        repository.findByHabitantes(123456L).forEach(System.out::println);
    }

    public void listarCidadePorNomeLike(){
        System.out.println("Cidades por nome: ");
        repository.findByNomeLike("Palmas", Sort.by("habitantes", "nome")).forEach(System.out::println);
    }

    public void listarCidadePorNomePaginado(){
        System.out.println("Cidades por nome: ");
        Pageable pageable = PageRequest.of(0,10);

        repository.findByNomeLike("Palmas", Sort.by("habitantes", "nome")).forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                                    .withIncludeNullValues();

        Example<Cidade> example = Example.of(cidade);
        return repository.findAll(example);
    }

    public void listarCidadesByNomeSpec(){
        Specification<Cidade> spec = CidadeSpecs.nomeEqual("São Paulo")
                                        .or(CidadeSpecs.habitantesGreaterThan(1000));

        repository.findAll(spec).forEach(System.out::println);

    }

    public void listarCidadesSpecsFiltroDinamico(Cidade filtro){
        Specification<Cidade> specs = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction() );
    }

}
