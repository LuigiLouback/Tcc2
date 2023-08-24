package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Comidas;
public class ComidasDAO extends DAO {

	public boolean insert(Comidas comidas) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO comidas (codigo, tipo, definiao) "
				       + "VALUES ("+comidas.getCodigo()+ ", '" + comidas.getTipo() + "', '"  
				        + comidas.getDefiniao() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean update(Comidas comidas) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE comidas SET tipo = '" + comidas.getTipo() + "', definiao = '"  
				       + comidas.getDefiniao() +  "'"
					   + " WHERE codigo = " + comidas.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	public boolean delete(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM comidas WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	public List<Comidas> listar() {
        List<Comidas> comidass = new ArrayList<>();
        try {
            Statement st = conexao.createStatement();
            String sql = "SELECT * FROM comidas;";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String tipo = rs.getString("tipo");
               String definiao = rs.getString("definiao");
                

                Comidas comidas = new Comidas(codigo, tipo, definiao);
                comidass.add(comidas);
            }

            rs.close();
            st.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return comidass;
}
	
}
