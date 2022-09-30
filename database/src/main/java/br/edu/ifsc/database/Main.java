/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.database;
import org.apache.commons.lang3.StringUtils;
import java.sql.SQLException;

import br.edu.ifsc.database.entity.Cliente;
import br.edu.ifsc.database.entity.Orcamento;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	
    	
        Cliente c1 = new Cliente();
        c1.setIdCliente(null);
        c1.setNome("Lucas");
        c1.setTelefone("47992843101");
        c1.setCpf("12987634951");
        
        Cliente c2 = new Cliente();
        c2.setIdCliente(null);
        c2.setNome("Stein");
        c2.setTelefone("47999999999");
        c2.setCpf("15584653214");
        
        Cliente c3 = new Cliente();
        c3.setIdCliente(null);
        c3.setNome("IFSC");
        c3.setTelefone("47988888888");
        c3.setCpf("12345678901");
        
        System.out.println("Cadastrando clientes...");
        ClienteDAO cdao = ClienteDAO.getInstance();
        cdao.save(c1);
        cdao.save(c2);
        cdao.save(c3);

        System.out.println("Mostrando clientes cadastrados:");
        System.out.println("Código   CPF          Nome");
        for (Cliente cliente : cdao.getAll()) {
        	System.out.print(cliente.getIdCliente());
        	System.out.print(StringUtils.rightPad(Long.toString(cliente.getIdCliente()), 7));
        	System.out.print(StringUtils.rightPad(cliente.getCpf(), 12));
        	System.out.print(StringUtils.rightPad(cliente.getNome(), 45));
        	System.out.println("");
        }
        
        System.out.println("Removendo clientes...");
        System.out.println("");
        cdao.remove(c1);
        cdao.remove(c2);
        cdao.remove(c3);
        
        System.out.println("Mostrando clientes cadastrados (vazio):");
        for (Cliente cliente : cdao.getAll()) {
        	System.out.print(StringUtils.rightPad(Long.toString(cliente.getIdCliente()), 5));
        	System.out.print(StringUtils.rightPad(cliente.getCpf(), 12));
        	System.out.print(StringUtils.rightPad(cliente.getNome(), 45));
        	System.out.println("");
        }
        System.out.println("");
        
        Orcamento o1 = new Orcamento();
        o1.setIdOrcamento(null);
        o1.setValor(50);
        o1.setData("01/10/2022");
        
        Orcamento o2 = new Orcamento();
        o2.setIdOrcamento(null);
        o2.setValor(21);
        o2.setData("28/04/2001");
        
        Orcamento o3 = new Orcamento();
        o3.setIdOrcamento(null);
        o3.setValor(22);
        o3.setData("28/04/2023");
        
        System.out.println("Cadastrando orçamentos...");
        OrcamentoDAO odao = OrcamentoDAO.getInstance();
        odao.save(o1);
        odao.save(o2);
        odao.save(o3);
        
        System.out.println("Mostrando orçamentos cadastrados:");
        System.out.println("Código Data       Valor");
        for (Orcamento orcamento : odao.getAll()) {
        	System.out.print(orcamento.getIdOrcamento());
        	System.out.print(StringUtils.rightPad(Long.toString(orcamento.getIdOrcamento()), 5));
        	System.out.print(StringUtils.rightPad(orcamento.getData(), 11));
        	System.out.print(StringUtils.rightPad(Integer.toString(orcamento.getValor()), 10));
        	System.out.println("");
        }
        System.out.println("");
        
        System.out.println("Removendo orçamentos...");
        System.out.println("");
        odao.remove(o1);
        odao.remove(o2);
        odao.remove(o3);
        
        System.out.println("Mostrando orçamentos cadastrados (vazio):");
        System.out.println("Código Data       Valor");
        for (Orcamento orcamento : odao.getAll()) {
        	System.out.print(orcamento.getIdOrcamento());
        	System.out.print(StringUtils.rightPad(Long.toString(orcamento.getIdOrcamento()), 5));
        	System.out.print(StringUtils.rightPad(orcamento.getData(), 11));
        	System.out.print(StringUtils.rightPad(Integer.toString(orcamento.getValor()), 10));
        }
        System.out.println("");
    }

}
