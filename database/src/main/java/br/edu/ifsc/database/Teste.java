/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.database;

import br.edu.ifsc.database.entity.Aluno;
import br.edu.ifsc.database.entity.Endereco;
import br.edu.ifsc.database.entity.TipoAluno;

/**
 *
 * @author renato
 */
public class Teste {

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Renato1", TipoAluno.POS);
        Aluno a2 = new Aluno("Amanda2", TipoAluno.TECNICO);
        Aluno a3 = new Aluno("Nathalia3", TipoAluno.GRADUACAO);
        Endereco e1 = new Endereco("Rua Florianopolis", "10", "Blumenau");
        Endereco e2 = new Endereco("Rua Jardim", "20", "Gaspar");

        a1.setEndereco(e1);
        a2.setEndereco(e1);
        a3.setEndereco(e2);

        AlunoDAO dao = AlunoDAO.getInstance();
        dao.save(a1);
        dao.save(a2);
        dao.save(a3);

        System.out.println("Mostrando alunos cadastrados");
        for (Aluno aluno : dao.getAll()) {
            System.out.println(aluno);
        }

        System.out.println("Alterando a cidade de todos os alunos");
        for (Aluno aluno : dao.getAll()) {
            aluno.getEndereco().setCidade("São Paulo");
            dao.save(aluno);
        }

        System.out.println("Mostrando alunos");
        System.out.println("Mostrando alunos cadastrados");
        for (Aluno aluno : dao.getAll()) {
            System.out.println(aluno);
        }
    }

}
