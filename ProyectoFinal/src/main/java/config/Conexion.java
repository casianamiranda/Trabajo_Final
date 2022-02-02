
package config;

import java.sql.*;

public class Conexion {
    public Connection getConection(){
        Connection c = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/comision2160",
                    "casiana.miranda", "Casimael9807");
        }catch(ClassNotFoundException | SQLException error){
            System.out.println(error.toString());
        }
        return c;
    }
    public static void main(String[] argumentos) throws SQLException{
        Connection conexion = null;
        Conexion con = new Conexion();
        conexion = con.getConection();
        
        PreparedStatement ps;
        ResultSet rs;
        ps = conexion.prepareStatement("SELECT * FROM Participantes");
        rs = ps.executeQuery();
        while(rs.next()){
            int id = rs.getInt("id");
            String nombre =  rs.getString("nombres");
            String apellido =  rs.getString("apellido");
            String email =  rs.getString("email");
            int telefono =  rs.getInt("telefono");
            System.out.println("Id: "+ id + "\n Nombre: "+ nombre +
                    "\n Apellido: "+ "\n Email: "+ email + "\n Telefono: "
                    +telefono);



        }
        
        
        
    }
}
