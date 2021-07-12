import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class CorRGBDAO {

    ArrayList<CorRGB> cores = new ArrayList<CorRGB> ();
    CorCMYK cor = new CorCMYK();
    ConversorCMYKtoRGB c = new ConversorCMYKtoRGB();
    public ArrayList<CorRGB> read(String descricao){
        
        Connection con = ConnectionMapasRGB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT TIPO_COR,RED,GREEN,BLUE,CYAN,MAGENTA,YELLOW,KEY FROM MAPA WHERE DESCRICAO = ? ");
            stmt.setString(1, descricao);
            rs = stmt.executeQuery();

            while(rs.next()){

                if(rs.getInt("TIPO_COR") == 1){
                    cor = new CorCMYK(rs.getInt("TIPO_COR"),rs.getInt("CYAN"),rs.getInt("MAGENTA"),rs.getInt("YELLOW"),rs.getInt("KEY"));
                    cores.add((CorRGB) c.converter(cor));
                }else
                    cores.add(new CorRGB(rs.getInt("TIPO_COR"),rs.getInt("RED"), rs.getInt("GREEN"), rs.getInt("BLUE")));
            }

            
        
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionMapasRGB.closeConnection(con, stmt, rs);
        }
        
        
        return cores;
    }
}
