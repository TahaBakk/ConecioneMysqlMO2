import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by x3727349s on 02/02/17.
 */
public class Tablas {

    public void afegirTablasInserts(Statement statement) throws IOException, SQLException {

        Statement stmt = statement;

        String s;
        StringBuffer sb = new StringBuffer();//usamos StringBuffer para que nos lo vaya añadiendo Strings, usando el append se añade  sin tener que usar =+
        FileReader f1 = new FileReader(new File("world.sql"));//Ponemos la ruta del fitxero a leer
        BufferedReader br = new BufferedReader(f1);//Creamos un objeto bufferedReader para poder leer el fitxero
        System.out.println(br.readLine());
        while((s = br.readLine()) != null){//hacemos que el string se igual a la linia leida y si no es null la añadimos al Stringbuffered
            sb.append(s);
        }
        br.close();//Cerramos la coneccion a BufferedReader

        String[] inst = sb.toString().split(";");
        for(int i = 0; i<inst.length; i++) {
            //Nos asseguramos que no haya alguna linia en blanco y las ejecutamos con el statment
            if(!inst[i].trim().equals("")){
                stmt.executeUpdate(inst[i]+";");
            }
        }

    }









































    /*public static void crearTablas() {

        Connection c = null;
        Statement stmt = null;


        try {

            Class.forName("org.mysql.Driver");
            c = DriverManager.getConnection("jdbc:mysql://172.31.73.167:3306/prueba","taha", "taha");

            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE PELICULAS " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " TITLE           CHAR(50)    NOT NULL, " +
                    " DATA_ESTRENA            TEXT     NOT NULL) ";

            String sql2 = "CREATE TABLE RELACION " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " ID_ACTOR           INT   NOT NULL, " +
                    " PERSONAJE       CHAR(100)   NOT NULL, " +
                    " ID_PELICULA        INT   NOT NULL) ";

            String sql3 = "CREATE TABLE ACTORES " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           CHAR(50)    NOT NULL, " +
                    " DATE_OF_BIRTHDAY          TEXT     NOT NULL) ";

            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }*/



}
