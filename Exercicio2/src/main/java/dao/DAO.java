package dao;
import java.sql.*;


public class DAO {
protected Connection conexao;
private boolean status = false;

public DAO() {
	conexao=null;
}
public boolean conectar() {
	  String dbname = "teste";
	  String username = "postgres";
	  String password = "ti@cc";
	  
	  try {
		  Class.forName("org.postgresql.Driver");
		  conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname,username,password);
		  
		  if(conexao != null) {
			  status = true;
			  System.out.println("Connection: " + status);
		  }
		  else {
			  System.out.println("Connection Failed");
		  }
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  return status;
}

public boolean desconectar() {
    if (conexao != null) {
        try {
            conexao.close();
            status = false;
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    return status;
}
}
