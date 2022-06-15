package dao;
import Model.Eleitor;
import dao.ExecuteSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EleitorDao extends ExecuteSQL{
    public EleitorDao(Connection con){
        super(con);
    }
    
    public String salvar(Eleitor eleitor){
        String sql = "INSERT INTO ELEITOR VALUES(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, eleitor.getTf8());
             ps.setString(2, eleitor.getTf7());
            if(ps.executeUpdate() > 0){
                return "voto concluido";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}