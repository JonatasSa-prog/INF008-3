import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionMapasRGB {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/Mapa4";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        } 
    }

    public static void closeConnection(Connection con){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
        
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt){

        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException ex) {
            
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            
        }
    }
}
