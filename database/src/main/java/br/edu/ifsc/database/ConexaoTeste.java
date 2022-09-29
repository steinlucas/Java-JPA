
package br.edu.ifsc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import org.hsqldb.jdbc.JDBCDataSource;

public class ConexaoTeste {

    public static void main(String[] args) {
        try {
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova?useTimezone=true&serverTimezone=UTC", "root", "aluno");

            JDBCDataSource ds = new JDBCDataSource();
            ds.setDatabase("localhost");
            ds.setDatabase("prova");
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
