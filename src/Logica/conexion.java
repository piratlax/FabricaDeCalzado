
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class conexion {
    public String db="san_felipe";
    public String url="jdbc:mysql://localhost/"+db+"?zeroDateTimeBehavior=convertToNull";
    public String user="root";
    public String pass="toor";

    public conexion() {
    }
    
    public Connection conectar(){
        Connection link=null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Sin poderse conectar a la base de datos\n"+e);
        }
        return link;
    } 
    
}
