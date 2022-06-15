package dao;
import Model.Chapa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ChapaDao extends ExecuteSQL{
    public ChapaDao(Connection con){
        super(con);
    }
    
    public String salvar(Chapa chapa){
        String sql = "INSERT INTO CHAPA VALUES(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setInt(1, chapa.getTf1());
             ps.setString(2, chapa.getNome());
            if(ps.executeUpdate() > 0){
                return "chapa cadastrada";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}