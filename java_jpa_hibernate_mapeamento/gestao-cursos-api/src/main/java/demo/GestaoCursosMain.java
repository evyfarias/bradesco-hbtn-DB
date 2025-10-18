package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.util.*;

public class GestaoCursosMain {
    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        // Criando um professor
        Professor prof = new Professor();
        prof.setNomeCompleto("João Souza");
        prof.setEmail("joao.souza@example.com");
        prof.setMatricula("PROF001");

        // Criando um curso
        Curso curso = new Curso();
        curso.setNome("Java Avançado");
        curso.setSigla("JAVA-AV");
        curso.setProfessor(prof);

        // Criando material do curso
        MaterialCurso material = new MaterialCurso();
        material.setUrl("http://material.com/java-avancado");
        material.setCurso(curso);
        curso.setMaterial(material);

        // Criando um aluno
        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Maria Silva");
        aluno.setMatricula("MAT2023001");
        aluno.setEmail("maria@example.com");
        aluno.setNascimento(new Date());

        // Endereço
        Endereco end = new Endereco();
        end.setLogradouro("Av. Paulista");
        end.setNumero("123");
        end.setBairro("Bela Vista");
        end.setCidade("São Paulo");
        end.setEstado("SP");
        end.setCep(12345678);
        end.setAluno(aluno);

        // Telefone
        Telefone tel = new Telefone();
        tel.setDDD("11");
        tel.setNumero("999999999");
        tel.setAluno(aluno);

        aluno.setEnderecos(Arrays.asList(end));
        aluno.setTelefones(Arrays.asList(tel));

        // Relacionando aluno e curso
        curso.setAlunos(Arrays.asList(aluno));
        aluno.setCursos(Arrays.asList(curso));

        // Criando no banco
        alunoModel.create(aluno);
        cursoModel.create(curso);

        System.out.println("Dados inseridos com sucesso!");
    }
}
