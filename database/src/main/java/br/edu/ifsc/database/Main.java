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
        c2.setIdCliente(null);
        c2.setNome("IFSC");
        c2.setTelefone("47988888888");
        c2.setCpf("12345678901");
        
        System.out.println("Cadastrando clientes:");
        ClienteDAO cdao = ClienteDAO.getInstance();
        cdao.save(c1);
        cdao.save(c2);
        cdao.save(c3);

        System.out.println("Mostrando clientes cadastrados:");
        System.out.println("Código CPF          Nome");
        for (Cliente cliente : cdao.getAll()) {
        	System.out.print(cliente.getIdCliente());
        	System.out.print(StringUtils.rightPad(Long.toString(cliente.getIdCliente()), 7));
        	System.out.print(StringUtils.rightPad(cliente.getCpf(), 12));
        	System.out.print(StringUtils.rightPad(cliente.getNome(), 45));
        	System.out.println("");
        }
            	
        
        System.out.println("Removendo clientes:");
        cdao.remove(c1);
        cdao.remove(c2);
        cdao.remove(c3);
        
        System.out.println("Mostrando clientes cadastrados (vazio):");
        for (Cliente cliente : cdao.getAll()) {
        	System.out.print(StringUtils.rightPad(Long.toString(cliente.getIdCliente()), 7));
        	System.out.print(StringUtils.rightPad(cliente.getCpf(), 12));
        	System.out.print(StringUtils.rightPad(cliente.getNome(), 45));
        	System.out.println("");
        }
        
        Orcamento o1 = new Orcamento(null, 50, "01/10/2022");
        Orcamento o2 = new Orcamento(null, 21, "28/04/2001");
        Orcamento o3 = new Orcamento(null, 22, "28/04/2023");
        
        OrcamentoDAO odao = OrcamentoDAO.getInstance();
        odao.save(o1);
        odao.save(o2);
        odao.save(o3);
    }

}
