
package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class fncCatalogo {
     // Se instancia una conexion de la clase conecta
    conexion con = new conexion();
    // se asigna la conexion a la base de datos con la variable cn
    Connection cn = con.conectar();
    
   public Boolean existe(String busca){
       //iniciamos
       Boolean existencia=false; 
       try {
            String sql = "SELECT * FROM calzado WHERE articulo='"+busca+"';";
            Statement busqueda;
            busqueda = cn.createStatement();
            ResultSet rs = busqueda.executeQuery(sql);
            while (rs.next()) {
                existencia=true;

            }

        } catch (SQLException ex) {
            System.out.println("no se encuentra el articulo");
        }
       return existencia;
   } 
}
