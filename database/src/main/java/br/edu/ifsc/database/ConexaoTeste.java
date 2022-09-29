
package br.edu.ifsc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import org.hsqldb.jdbc.JDBCDataSource;

public class ConexaoTeste {

    public static void main(String[] args) {
        try {
            //opcao 1
            //Class.forName("org.hsqldb.jdbc.JDBCDriver");

            //Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/aulaifsc", "SA", "");
            //if (con != null) {
            //    System.out.println("Conexão criada com sucesso");
            //    con.close();
            //}

        	Connection con = DriverManager.getConnection("mysql:hsqldb:hsql://localhost/aulaifsc", "SA", "");
            //opção 2
            JDBCDataSource ds = new JDBCDataSource();
            ds.setDatabase("localhost");
            ds.setDatabase("aulaifsc");
            ds.setUser("aluno");
            con = ds.getConnection();
            if (con != null) {
                System.out.println("Conexão com DataSource criada com sucesso");
                con.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
