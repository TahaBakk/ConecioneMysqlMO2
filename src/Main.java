import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException, IOException {

            Tablas tbl = new Tablas();
            SelectsBBDD sbbdd= new SelectsBBDD();
            ConsultasBBDD cBBDD = new ConsultasBBDD();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Creamos un conexion a la BBDD pasandole la ruta/schema, usuario y password
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://172.31.73.167:3306/World?verifyServerCertificate=false&useSSL=true","root", "taha");
            // Preparamos la consulta
            Statement stmt = conexion.createStatement();

                int num=1;
                while(num != 9){
                    System.out.println("\n");
                    System.out.println("------------------------------------------------");
                    System.out.println("Seleccione una de la opciones siguientes");
                    System.out.println("------------------------------------------------");
                    System.out.println("1.Crear la tabla y hacer los inserts");
                    System.out.println("2.Ver el contenido de la tabla");
                    System.out.println("3.Ver descripcion de la tabla city");
                    System.out.println("4.Añadir una nueva columna \"Population\" en la tabla city");


                    Scanner sc = new Scanner(System.in);
                    num = sc.nextInt();


                    switch (num) {
                        case  1: tbl.afegirTablasInserts(stmt);//Llamamos al metodo para crear la tabla y los inserts
                            break;
                        case  2: sbbdd.selectTabla(conexion);
                            break;
                        case  3: cBBDD.descripcionTabla(conexion);
                            break;
                        case  4: cBBDD.modificarTabla(conexion);
                            break;
                        /*case  5: selects.selectPeliculasID(5);
                            break;
                        case  6: selects.selectRelacionID(5);
                            break;
                        case  7: creates.crearTablas();
                            break;
                        case  8: consultasApi.mainLlamadas();
                            break;*/
                        default:
                            break;
                    }
                }

            // Cerramos la conexion a la base de datos.
            conexion.close();


    }
}
