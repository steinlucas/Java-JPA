/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	
    	Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/prova?useTimezone=true&serverTimezone=UTC", "root", "aluno");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Cliente c1 = new Cliente(1, "Lucas", "47992843101", "12987634951");
        Cliente c2 = new Cliente(2, "Stein", "47999999999", "15584653214");
        Cliente c3 = new Cliente(3, "IFSC" , "47988888888", "12345678901");
        
        System.out.println("Cadastrando clientes:");
        ClienteDAO dao = ClienteDAO.getInstance();
        dao.save(c1);
        dao.save(c2);
        dao.save(c3);

        System.out.println("Mostrando clientes cadastrados:");
        for (Cliente cliente : dao.getAll()) {
            System.out.println(cliente);
        }
        
        System.out.println("Removendo clientes:");
        //dao.remove(c1);
        //dao.remove(c2);
        //dao.remove(c3);
        
        System.out.println("Mostrando clientes cadastrados (vazio):");
        for (Cliente cliente : dao.getAll()) {
            //System.out.println(cliente);
        }

        //System.out.println("Mostrando clientes");
        //System.out.println("Mostrando clientes cadastrados");
        
        //for (Cliente cliente : dao.getAll()) {
        //    System.out.println(cliente);
        //}
    }

}
