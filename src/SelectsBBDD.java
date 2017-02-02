import java.sql.*;

/**
 * Created by x3727349s on 02/02/17.
 */
public class SelectsBBDD {

    public void selectTabla(Connection conexion) throws SQLException, ClassNotFoundException {

        Connection c = conexion;
        Statement stmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM city;" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String  name = rs.getString("Name");
                String  countryCode = rs.getString("CountryCode");
                String  district = rs.getString("District");
                String  population = rs.getString("Population");
                System.out.println("-----------------------------------");
                System.out.println( "ID = " + id );
                System.out.println( "Name = " + name );
                System.out.println( "CountryCode = " + countryCode );
                System.out.println( "CountryCode = " + district );
                System.out.println( "CountryCode = " + population );
                System.out.println("-----------------------------------");
            }
            rs.close();
            stmt.close();
            c.close();

        System.out.println("Operation done successfully");
    }
}
