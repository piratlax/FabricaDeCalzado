
package Calzado;

import Logica.conexion;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class rptEspecificacion extends javax.swing.JFrame {

     // Se instancia una conexion de la clase conecta
    conexion con = new conexion();
    // se asigna la conexion a la base de datos con la variable cn
    Connection cn = con.conectar();
    // asignamos la primera tabla
    DefaultTableModel manipulacion;
    public rptEspecificacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTablaManipulacion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblManipulacion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(465, 660));

        tblManipulacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Material", "Uni/par", "Cons/par", "Precio", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblManipulacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(351, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(rptEspecificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rptEspecificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rptEspecificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rptEspecificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rptEspecificacion().setVisible(true);
            }
        });
    }
    
    //Iniciamos mis procesos
    private void mostrarTablaManipulacion(){
        
        String sql = "SELECT * FROM especificacion where proceso='manipulacion' AND articulo='121'";
        String[] cabecera = {"Cod", "Pieza", "Nombre", "Md", "Cons", "Precio", "total"};
        // se definen los registros que llevara la tabla
        String[] registros = new String[7];
        // se hace el llamado sql de todos los usuarios

        System.out.println(sql);
        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {40, 100, 180, 35, 40, 40, 35};
        manipulacion = new DefaultTableModel(null, cabecera);
        
        try {

            Statement tablaManipulacion;
            tablaManipulacion = cn.createStatement();
            ResultSet rs = tablaManipulacion.executeQuery(sql);
            while (rs.next()) {

                registros[0] = rs.getString("codigo");
                registros[1] = rs.getString("pieza");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("medida");
                registros[4] = rs.getString("consumo");
                registros[5] = rs.getString("precio");
                registros[6] = rs.getString("resultado");

                manipulacion.addRow(registros);
                
            }
            tblManipulacion.setModel(manipulacion);
            for (int i = 0; i < cabecera.length; i++) {
                tblManipulacion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tblManipulacion.setFont(new java.awt.Font("Tahoma", 0, 9));
                tblManipulacion.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 9));
                
            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblManipulacion;
    // End of variables declaration//GEN-END:variables
}