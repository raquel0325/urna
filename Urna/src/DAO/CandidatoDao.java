package dao;
import Model.Candidato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * @author Raquel Nunes
 */
public class CandidatoDao extends ExecuteSQL{
    public CandidatoDao(Connection con){
        super(con);
    }
    
    public String salvar(Candidato candidato){
        String sql = "INSERT INTO CANDIDATO VALUES(?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setInt(1, candidato.getTf3());
             ps.setString(2, candidato.getTf4());
             ps.setString(3, candidato.getTf5());
            if(ps.executeUpdate() > 0){
                return "candidato cadastrado";
            }else{
                return "Erro ao cadastrar";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}