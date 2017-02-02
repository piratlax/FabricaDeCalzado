package Calzado;

import Logica.conexion;
import Logica.imagenes;
import Logica.fncCatalogo;
import com.mxrck.autocompleter.TextAutoCompleter;
import inventarios.frmInventario;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class catalogo extends javax.swing.JFrame {

    // Se instancia una conexion de la clase conecta
    conexion con = new conexion();
    // se asigna la conexion a la base de datos con la variable cn
    Connection cn = con.conectar();
    // asignamos la primera tabla
    DefaultTableModel manipulacion;
    DefaultTableModel costura;
    DefaultTableModel inyeccion;

    public catalogo() {
        initComponents();
        this.setLocationRelativeTo(null);
        asignarAutocompletado();
        asignarAutocompletadoMaquila();
        asignarAutocompletado1();
        asignarAutocompletadoMaquila1();
        asignarAutocompletado2();
        asignarAutocompletadoMaquila2();
        asignarAutocompletadoArticulo();
        btnIntegrar.setEnabled(false);
        btnIntegrarCostura.setEnabled(false);
        btnIntegrarInyeccion.setEnabled(false);
        btnImagen.setEnabled(false);

        //desactivamos los campos que no se podran tocar
        /*
        txtSubManipulacion.setEnabled(false);
        txtSubManipulacion1.setEnabled(false);
        txtSubManipulacion2.setEnabled(false);
        txtTotalMan.setEnabled(false);
        txtTotalCos.setEnabled(false);
        txtTotalIny.setEnabled(false);
        txtSubTotal.setEnabled(false);
        txtCostoFabricacion.setEnabled(false);
        txtUtilidad.setEnabled(false);
        */
        btnGuardar.setEnabled(false);

    }

    // iniciamos autocompletado de los 3 campos dobles
    public void asignarAutocompletado() {
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtPredecible);
        textAutoCompleter.setMode(0); // infijo
        textAutoCompleter.setCaseSensitive(false); //No sensible a mayúsculas

        //iniciamos
        try {
            String sql = "SELECT * FROM inventario";
            Statement completar;
            completar = cn.createStatement();
            ResultSet rs = completar.executeQuery(sql);
            while (rs.next()) {
                textAutoCompleter.addItem(rs.getString("nombre"));

            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla1");
        }

    }

    public void asignarAutocompletadoMaquila() {
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtMaquila);
        textAutoCompleter.setMode(0); // infijo
        textAutoCompleter.setCaseSensitive(false); //No sensible a mayúsculas

        //iniciamos
        try {
            String sql = "SELECT * FROM maquila";
            Statement completar;
            completar = cn.createStatement();
            ResultSet rs = completar.executeQuery(sql);
            while (rs.next()) {
                textAutoCompleter.addItem(rs.getString("nombre"));

            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla2");
        }

    }

    public void asignarAutocompletado1() {
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtPredecible1);
        textAutoCompleter.setMode(0); // infijo
        textAutoCompleter.setCaseSensitive(false); //No sensible a mayúsculas

        //iniciamos
        try {
            String sql = "SELECT * FROM inventario";
            Statement completar;
            completar = cn.createStatement();
            ResultSet rs = completar.executeQuery(sql);
            while (rs.next()) {
                textAutoCompleter.addItem(rs.getString("nombre"));

            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla1");
        }

    }

    public void asignarAutocompletado2() {
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtPredecible2);
        textAutoCompleter.setMode(0); // infijo
        textAutoCompleter.setCaseSensitive(false); //No sensible a mayúsculas

        //iniciamos
        try {
            String sql = "SELECT * FROM inventario";
            Statement completar;
            completar = cn.createStatement();
            ResultSet rs = completar.executeQuery(sql);
            while (rs.next()) {
                textAutoCompleter.addItem(rs.getString("nombre"));

            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla1");
        }

    }

    public void asignarAutocompletadoMaquila1() {
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtMaquila1);
        textAutoCompleter.setMode(0); // infijo
        textAutoCompleter.setCaseSensitive(false); //No sensible a mayúsculas

        //iniciamos
        try {
            String sql = "SELECT * FROM maquila";
            Statement completar;
            completar = cn.createStatement();
            ResultSet rs = completar.executeQuery(sql);
            while (rs.next()) {
                textAutoCompleter.addItem(rs.getString("nombre"));

            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla2");
        }

    }

    public void asignarAutocompletadoMaquila2() {
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtMaquila2);
        textAutoCompleter.setMode(0); // infijo
        textAutoCompleter.setCaseSensitive(false); //No sensible a mayúsculas

        //iniciamos
        try {
            String sql = "SELECT * FROM maquila";
            Statement completar;
            completar = cn.createStatement();
            ResultSet rs = completar.executeQuery(sql);
            while (rs.next()) {
                textAutoCompleter.addItem(rs.getString("nombre"));

            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla2");
        }

    }
    

    public void asignarAutocompletadoArticulo() {
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtArticulo);
        textAutoCompleter.setMode(0); // infijo
        textAutoCompleter.setCaseSensitive(false); //No sensible a mayúsculas

        //iniciamos
        try {
            String sql = "SELECT * FROM calzado";
            Statement completar;
            completar = cn.createStatement();
            ResultSet rs = completar.executeQuery(sql);
            while (rs.next()) {
                textAutoCompleter.addItem(rs.getString("articulo"));

            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla2");
        }

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
        jLabel1 = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtArticulo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        panel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPredecible = new javax.swing.JTextField();
        btnIntegrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMan = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaquila = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPrecio1 = new javax.swing.JTextField();
        btnActMaquila = new javax.swing.JButton();
        btnNuevaMaquila = new javax.swing.JButton();
        btnActInventario = new javax.swing.JButton();
        txtSubManipulacion = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtPredecible1 = new javax.swing.JTextField();
        btnIntegrarCostura = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCos = new javax.swing.JTable();
        btnBorrar1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtParCost = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPrecioCost = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaquila1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPrecioMaqCost = new javax.swing.JTextField();
        btnActMaquila1 = new javax.swing.JButton();
        btnNuevaMaquila1 = new javax.swing.JButton();
        btnActInventario1 = new javax.swing.JButton();
        txtSubManipulacion1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtPredecible2 = new javax.swing.JTextField();
        btnIntegrarInyeccion = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaIny = new javax.swing.JTable();
        btnBorrar2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtParIny = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtPrecioIny = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtMaquila2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtMaqIny = new javax.swing.JTextField();
        btnActMaquila2 = new javax.swing.JButton();
        btnNuevaMaquila2 = new javax.swing.JButton();
        btnActInventario2 = new javax.swing.JButton();
        txtSubManipulacion2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnBorrar3 = new javax.swing.JButton();
        btnActualizar3 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtSubManipulacion3 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtSalariosInyeccion = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtGastosInd = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtMerma = new javax.swing.JTextField();
        txtTotalMan = new javax.swing.JLabel();
        txtTotalCos = new javax.swing.JLabel();
        txtTotalIny = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JLabel();
        txtCostoFabricacion = new javax.swing.JLabel();
        txtUtilidad = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        txtPrueba = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        imgCalzado = new javax.swing.JLabel();
        btnImagen = new javax.swing.JButton();
        chkActivo = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Creacion de Calzado");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Catalogo"));

        jLabel1.setText("Linea");

        jLabel2.setText("Modelo");

        jLabel3.setText("Articulo");

        jLabel4.setText("Combinacion");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/nuevo.png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(btnCrear))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Especificacion");

        btnIntegrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/grabar.png"))); // NOI18N
        btnIntegrar.setText("Integrar");
        btnIntegrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrarActionPerformed(evt);
            }
        });

        tablaMan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Material", "Unidad", "Consumo", "Precio", "Total"
            }
        ));
        jScrollPane1.setViewportView(tablaMan);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Consumo por par");

        jLabel7.setText("Precio");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel10.setText("SubTotal");

        jLabel11.setText("Maquila");

        jLabel13.setText("Costo");

        txtPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio1ActionPerformed(evt);
            }
        });

        btnActMaquila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/actmaquila.png"))); // NOI18N
        btnActMaquila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActMaquilaActionPerformed(evt);
            }
        });

        btnNuevaMaquila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/maquila.png"))); // NOI18N
        btnNuevaMaquila.setText("Nuevo");
        btnNuevaMaquila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaMaquilaActionPerformed(evt);
            }
        });

        btnActInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/actmaquila.png"))); // NOI18N
        btnActInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActInventarioActionPerformed(evt);
            }
        });

        txtSubManipulacion.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPredecible, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtMaquila))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActMaquila, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnActInventario)
                                .addGap(0, 1, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNuevaMaquila))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIntegrar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBorrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(79, 79, 79)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSubManipulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIntegrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtPredecible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnActInventario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtMaquila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnActMaquila)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtPar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaMaquila)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(jLabel10)
                    .addComponent(txtSubManipulacion))
                .addContainerGap())
        );

        panel.addTab("Manipulacion", jPanel2);

        jLabel8.setText("Especificacion");

        btnIntegrarCostura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/grabar.png"))); // NOI18N
        btnIntegrarCostura.setText("Integrar");
        btnIntegrarCostura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrarCosturaActionPerformed(evt);
            }
        });

        tablaCos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Material", "Unidad", "Consumo", "Precio", "Total"
            }
        ));
        jScrollPane2.setViewportView(tablaCos);

        btnBorrar1.setText("Borrar");
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Consumo por par");

        jLabel12.setText("Precio");

        txtPrecioCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCostActionPerformed(evt);
            }
        });

        jLabel14.setText("SubTotal");

        jLabel15.setText("Maquila");

        jLabel16.setText("Costo");

        txtPrecioMaqCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioMaqCostActionPerformed(evt);
            }
        });

        btnActMaquila1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/actmaquila.png"))); // NOI18N
        btnActMaquila1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActMaquila1ActionPerformed(evt);
            }
        });

        btnNuevaMaquila1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/maquila.png"))); // NOI18N
        btnNuevaMaquila1.setText("Nuevo");
        btnNuevaMaquila1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaMaquila1ActionPerformed(evt);
            }
        });

        btnActInventario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/actmaquila.png"))); // NOI18N
        btnActInventario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActInventario1ActionPerformed(evt);
            }
        });

        txtSubManipulacion1.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPredecible1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtMaquila1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActMaquila1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnActInventario1)
                                .addGap(0, 1, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtParCost, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNuevaMaquila1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioMaqCost, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioCost, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIntegrarCostura))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnBorrar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(97, 97, 97)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSubManipulacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIntegrarCostura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtPredecible1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnActInventario1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtMaquila1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnActMaquila1)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtPrecioCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtPrecioMaqCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtParCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaMaquila1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar1)
                    .addComponent(jLabel14)
                    .addComponent(txtSubManipulacion1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel.addTab("Costura-Pespunte", jPanel3);

        jLabel17.setText("Especificacion");

        btnIntegrarInyeccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/grabar.png"))); // NOI18N
        btnIntegrarInyeccion.setText("Integrar");
        btnIntegrarInyeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrarInyeccionActionPerformed(evt);
            }
        });

        tablaIny.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Material", "Unidad", "Consumo", "Precio", "Total"
            }
        ));
        jScrollPane3.setViewportView(tablaIny);

        btnBorrar2.setText("Borrar");
        btnBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar2ActionPerformed(evt);
            }
        });

        jLabel18.setText("Consumo por par");

        jLabel19.setText("Precio");

        txtPrecioIny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioInyActionPerformed(evt);
            }
        });

        jLabel20.setText("SubTotal");

        jLabel21.setText("Maquila");

        jLabel22.setText("Costo");

        txtMaqIny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaqInyActionPerformed(evt);
            }
        });

        btnActMaquila2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/actmaquila.png"))); // NOI18N
        btnActMaquila2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActMaquila2ActionPerformed(evt);
            }
        });

        btnNuevaMaquila2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/maquila.png"))); // NOI18N
        btnNuevaMaquila2.setText("Nuevo");
        btnNuevaMaquila2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaMaquila2ActionPerformed(evt);
            }
        });

        btnActInventario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/actmaquila.png"))); // NOI18N
        btnActInventario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActInventario2ActionPerformed(evt);
            }
        });

        txtSubManipulacion2.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btnBorrar2)
                                .addGap(581, 581, 581)
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(txtSubManipulacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPredecible2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtMaquila2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActMaquila2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btnActInventario2)
                                .addGap(0, 1, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtParIny, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNuevaMaquila2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaqIny, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioIny, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIntegrarInyeccion)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIntegrarInyeccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(txtPredecible2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnActInventario2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtMaquila2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnActMaquila2)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtPrecioIny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtMaqIny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtParIny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaMaquila2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar2)
                    .addComponent(jLabel20)
                    .addComponent(txtSubManipulacion2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel.addTab("Inyeccion y Terminacion", jPanel4);

        btnBorrar3.setText("Borrar");

        btnActualizar3.setText("Actualizar");

        jLabel26.setText("SubTotal");

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jLabel23.setText("Salarios para Inyeccion");

        jLabel24.setText("Total de Manipulacion");

        jLabel25.setText("Total de Costura y Pespunte");

        jLabel27.setText("Total de Inyeccion y Terminacion");

        txtSalariosInyeccion.setText("0.00");

        jLabel28.setText("SubTotal");

        jLabel29.setText("Gastos Indirectos");

        txtGastosInd.setText("0.00");

        jLabel30.setText("Total Costo de fabricacion");

        jLabel31.setText("Utilidad");

        txtPorcentaje.setText("20");

        jLabel32.setText("%");

        jLabel33.setText("Merma");

        txtMerma.setText("0.00");

        txtTotalMan.setText("0.00");

        txtTotalCos.setText("0.00");

        txtTotalIny.setText("0.00");

        txtSubTotal.setText("0.00");

        txtCostoFabricacion.setText("0.00");

        txtUtilidad.setText("0.00");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel27)
                    .addComponent(jLabel23)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32))
                    .addComponent(jLabel33))
                .addGap(100, 100, 100)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSalariosInyeccion, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(txtGastosInd)
                    .addComponent(txtMerma)
                    .addComponent(txtTotalMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotalCos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotalIny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCostoFabricacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUtilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtTotalMan))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtTotalCos))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtTotalIny))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtSalariosInyeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtSubTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtGastosInd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtCostoFabricacion))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txtUtilidad))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtMerma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jLabel34.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("TOTAL");

        txtTotal.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotal.setText("0.00");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btnGuardar.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnActualizar3)
                        .addGap(39, 39, 39)
                        .addComponent(btnBorrar3)
                        .addGap(435, 435, 435)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(txtSubManipulacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(131, 131, 131)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnCalcular)
                                .addGap(4, 4, 4)
                                .addComponent(txtPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrueba, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnCalcular)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar3)
                    .addComponent(btnActualizar3)
                    .addComponent(jLabel26)
                    .addComponent(txtSubManipulacion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        panel.addTab("Total", jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen"));

        imgCalzado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(imgCalzado, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgCalzado, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/imagen.png"))); // NOI18N
        btnImagen.setText("Actualizar Imagen");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        chkActivo.setSelected(true);
        chkActivo.setText("Activo");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/cabeceraCalzado.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkActivo)
                            .addComponent(btnImagen))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnImagen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chkActivo))
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void integraTabla(String proceso) {

    }
    private void btnIntegrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrarActionPerformed

        // preparamos la funcion de integracion a "manipulacion"        
        //verificamos si es maquila o inventario a integrar el modelo
        //checamos que no tengan ambos campos con texto
        if (txtPredecible.getText().length() > 1 && txtMaquila.getText().length() > 1) {
            JOptionPane.showMessageDialog(this, "Solo integra un elemento a la vez");
        } // vericamos que ambos no esten vacios
        else if (txtPredecible.getText().length() == 0 && txtMaquila.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Agrega un material o una maquila");
        } else if (txtPredecible.getText().length() > 1) {
            //aqui integramos un material del inventario

            //primero verificamos que si este en la base de datos de inventario
            int contador = 0;
            try {
                String checar = "SELECT * FROM inventario WHERE nombre='" + txtPredecible.getText() + "'";
                Statement repetido;
                repetido = cn.createStatement();
                ResultSet buscar = repetido.executeQuery(checar);
                while (buscar.next()) {
                    contador = 1;

                }
            } catch (SQLException ex) {
                Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (contador == 1) {
                //revisamos que no este repetido el material en el especificacion

                int material = 0;
                try {
                    String checar = "SELECT * FROM especificacion WHERE nombre='" + txtPredecible.getText() + "' and modelo='"
                            + txtModelo.getText() + "' and articulo='" + txtArticulo.getText() + "'";
                    Statement repetido;
                    repetido = cn.createStatement();
                    ResultSet buscar = repetido.executeQuery(checar);
                    while (buscar.next()) {
                        material++;
                        JOptionPane.showMessageDialog(this, "El material ya esta en la hoja de especificacion");
                        txtPredecible.setText("");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (material == 0) {
                    // como si existe el material en la bd de datos de inventario, procedemos a integrarlo a Calzado
                    if (txtPar.getText().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Falta agregar el costo");
                    } else if (txtPrecio.getText().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Falta agregar el Precio");
                    } else {
                        //Asignamos variables a la especificacion
                        String Linea = txtLinea.getText().toUpperCase();
                        String Modelo = txtModelo.getText().toUpperCase();
                        String Articulo = txtArticulo.getText().toUpperCase();
                        String Color = txtColor.getText().toUpperCase();
                        String Nombre = txtPredecible.getText();
                        String Consumo = txtPar.getText();
                        String Precio = txtPrecio.getText();
                        String Codigo = null;
                        String Pieza = null;
                        String Medida = null;
                        String Activo = "1";
                        //calculamos el costo
                        String txtResultado = redondeo();
                        // verificamos si esta seleccionado
                        if (!chkActivo.isSelected()) {
                            Activo = "0";
                        }
                        String sql = "SELECT * FROM inventario WHERE nombre='" + txtPredecible.getText() + "'";

                        //buscamos en la base de datos Inventario las especificaciones faltantes
                        try {
                            Statement completar;
                            completar = cn.createStatement();
                            ResultSet rs = completar.executeQuery(sql);
                            while (rs.next()) {
                                Codigo = rs.getString("codigo");
                                Pieza = rs.getString("pieza");
                                Medida = rs.getString("medida");
                            }
                        } catch (SQLException ex) {
                            System.out.println("Sin poder ejecutar el query para asignar valores");
                        }

                        //ya teniendo todos los valores integramos la especificacion a la BD especificacion
                        try {
                            Statement stmt = cn.createStatement();
                            String grabar = "INSERT INTO especificacion (modelo,codigo,linea,articulo,color,pieza,nombre,medida,consumo,precio,resultado,estado,proceso) "
                                    + "VALUES ('"
                                    + Modelo + "','"
                                    + Codigo + "','"
                                    + Linea + "','"
                                    + Articulo + "','"
                                    + Color + "','"
                                    + Pieza + "','"
                                    + Nombre + "','"
                                    + Medida + "','"
                                    + Consumo + "','"
                                    + Precio + "','"
                                    + txtResultado + "','"
                                    + Activo + "','manipulacion');";
                            stmt.executeUpdate(grabar);

                            stmt.close();
                            txtSubManipulacion.setText("0.00");
                            mostrarTabla();
                        } catch (SQLException ex) {
                            Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }
            if (contador == 0) {
                JOptionPane.showMessageDialog(this, "No modifiques la ventana de materiales");
                txtPredecible.setText("");
                txtPar.setText("");
                txtPrecio.setText("");
            }
        } else if (txtMaquila.getText().length() > 0) {
            // ********** Inicia Captura de Maquila

            //primero verificamos que si este en la base de datos de maquila
            int contador = 0;
            try {
                String checar = "SELECT * FROM maquila WHERE nombre='" + txtMaquila.getText() + "'";
                Statement repetido;
                repetido = cn.createStatement();
                ResultSet buscar = repetido.executeQuery(checar);
                while (buscar.next()) {
                    contador = 1;

                }
            } catch (SQLException ex) {
                Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (contador == 1) {
                //revisamos que no este repetido la maquila en el especificacion

                int maquila = 0;
                try {
                    String checar = "SELECT * FROM especificacion WHERE nombre='" + txtMaquila.getText() + "' and modelo='"
                            + txtModelo.getText() + "' and articulo='" + txtArticulo.getText() + "'";
                    Statement repetido;
                    repetido = cn.createStatement();
                    ResultSet buscar = repetido.executeQuery(checar);
                    while (buscar.next()) {
                        maquila++;
                        JOptionPane.showMessageDialog(this, "La maquila ya esta en la hoja de especificacion");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (maquila == 0) {
                    // como si existe el material en la bd de datos de inventario, procedemos a integrarlo a Calzado
                    if (txtPrecio1.getText().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Falta agregar el Precio de la maquila");
                    } else {
                        //Asignamos variables a la especificacion
                        String Linea = txtLinea.getText().toUpperCase();
                        String Modelo = txtModelo.getText().toUpperCase();
                        String Articulo = txtArticulo.getText().toUpperCase();
                        String Color = txtColor.getText().toUpperCase();
                        String Nombre = txtMaquila.getText();
                        String Precio = txtPrecio1.getText();
                        String Codigo = null;
                        String Pieza = null;
                        String Activo = "1";
                        //Asignamos el precio como resultado
                        String txtResultado = Precio;
                        // verificamos si esta seleccionado
                        if (!chkActivo.isSelected()) {
                            Activo = "0";
                        }
                        String sql = "SELECT * FROM maquila WHERE nombre='" + txtMaquila.getText() + "'";

                        //buscamos en la base de datos Maquila las especificaciones faltantes
                        try {
                            Statement completar;
                            completar = cn.createStatement();
                            ResultSet rs = completar.executeQuery(sql);
                            while (rs.next()) {
                                Codigo = rs.getString("codigo");
                                Pieza = rs.getString("pieza");
                            }
                        } catch (SQLException ex) {
                            System.out.println("Sin poder ejecutar el query para asignar valores de maquila");
                        }

                        //ya teniendo todos los valores integramos la especificacion a la BD especificacion
                        try {
                            Statement stmt = cn.createStatement();
                            String grabar = "INSERT INTO especificacion (modelo,codigo,linea,articulo,color,pieza,nombre,precio,resultado,estado,proceso) "
                                    + "VALUES ('"
                                    + Modelo + "','"
                                    + Codigo + "','"
                                    + Linea + "','"
                                    + Articulo + "','"
                                    + Color + "','"
                                    + Pieza + "','"
                                    + Nombre + "','"
                                    + Precio + "','"
                                    + txtResultado + "','"
                                    + Activo + "','manipulacion');";
                            stmt.executeUpdate(grabar);

                            stmt.close();
                            txtSubManipulacion.setText("0.00");
                            txtPrecio1.setText("");
                            txtMaquila.setText("");
                            mostrarTabla();
                        } catch (SQLException ex) {
                            Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }
            if (contador == 0) {
                JOptionPane.showMessageDialog(this, "No modifiques la ventana de maquila");
                txtPredecible.setText("");
                txtPar.setText("");
                txtPrecio.setText("");
            }

            // ********** Termina captura de maquila
        }


    }//GEN-LAST:event_btnIntegrarActionPerformed

    public void mostrarTabla() {
        String sql = "SELECT * FROM especificacion where modelo='" + txtModelo.getText() + "' AND proceso='manipulacion' AND articulo='"
                + txtArticulo.getText() + "'";
        String[] cabecera = {"Codigo", "Pieza", "Nombre", "Medida", "Consumo", "Precio", "total"};
        // se definen los registros que llevara la tabla
        String[] registros = new String[7];
        // se hace el llamado sql de todos los usuarios

        System.out.println(sql);
        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {80, 250, 700, 80, 80, 80, 80};
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
                // calculamos el subtotal de Manipulacion
                Double subtotal = Double.parseDouble(txtSubManipulacion.getText());
                Double agregar = Double.parseDouble(rs.getString("resultado"));
                Double resultado = subtotal + agregar;
                BigDecimal SubTotal = BigDecimal.valueOf(resultado);
                SubTotal = SubTotal.setScale(2, RoundingMode.HALF_UP);
                txtSubManipulacion.setText(String.valueOf(SubTotal));
                //asignamos el valor en el total
                txtTotalMan.setText(String.valueOf(SubTotal));
                calculoTotal();
            }
            tablaMan.setModel(manipulacion);
            for (int i = 0; i < cabecera.length; i++) {
                tablaMan.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tablaMan.setFont(new java.awt.Font("Tahoma", 0, 12));
                txtPredecible.setText("");
                txtPar.setText("");
                txtPrecio.setText("");
            }

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla");
        }

    }
    
    public void mostrarTotales(){
        //iniciamos
        try {
            String sql = "SELECT * FROM calzado WHERE articulo='"+txtArticulo.getText()+"'";
            Statement completar;
            completar = cn.createStatement();
            ResultSet rs = completar.executeQuery(sql);
            while (rs.next()) {
               txtSalariosInyeccion.setText(rs.getString("salarioInyeccion"));
               txtGastosInd.setText(rs.getString("gastosIndirectos"));
               txtPorcentaje.setText(rs.getString("porcentaje"));
               txtGastosInd.setText(rs.getString("gastosIndirectos"));
               txtMerma.setText(rs.getString("merma"));
               
            }
    }catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla");
        }
    }
    /// Calculamos el valor total del especificacion
    public void calculoTotal() {
        //asignamos variables
        Double totalManipulacion = 0.00;
        Double totalCostura = 0.00;
        Double totalInyeccion = 0.00;
        Double salariosInyeccion = 0.00;
        Double total = 0.00;
        Double subTotal = 0.00;
        Double costosFabricacion = 0.00;
        Double gastosIndirectos = 0.00;
        Double porcentaje = 0.00;
        Double utilidad = 0.00;
        Double merma = 0.00;

        //convertimos strings a doubles
        totalManipulacion = Double.valueOf(txtTotalMan.getText());
        totalCostura = Double.valueOf(txtTotalCos.getText());
        totalInyeccion = Double.valueOf(txtTotalIny.getText());
        salariosInyeccion = Double.valueOf(txtSalariosInyeccion.getText());
        gastosIndirectos = Double.valueOf(txtGastosInd.getText());
        porcentaje = Double.valueOf(txtPorcentaje.getText());
        merma = Double.valueOf(txtMerma.getText());

        //hacemos los calculos
        subTotal = totalManipulacion + totalCostura + totalInyeccion + salariosInyeccion;

        costosFabricacion = subTotal + gastosIndirectos;
        utilidad = costosFabricacion * porcentaje / 100;
        total = costosFabricacion + utilidad + merma;
        // redondeamos subtotal
        BigDecimal subtotal = BigDecimal.valueOf(subTotal);
        subtotal = subtotal.setScale(2, RoundingMode.HALF_UP);

        // redondeamos costosFabricacion
        BigDecimal costosfabricacion = BigDecimal.valueOf(costosFabricacion);
        costosfabricacion = costosfabricacion.setScale(2, RoundingMode.HALF_UP);

        // redondeamos utilidad
        BigDecimal Utilidad = BigDecimal.valueOf(utilidad);
        Utilidad = Utilidad.setScale(2, RoundingMode.HALF_UP);

        // redondeamos total
        BigDecimal Total = BigDecimal.valueOf(total);
        Total = Total.setScale(2, RoundingMode.HALF_UP);

        //colocamos los valores
        txtSubTotal.setText(String.valueOf(subtotal));
        txtCostoFabricacion.setText(String.valueOf(costosfabricacion));
        txtUtilidad.setText(String.valueOf(Utilidad));
        txtTotal.setText(String.valueOf(Total));
    }

    public void mostrarTablaCost() {
        String sql = "SELECT * FROM especificacion where modelo='" + txtModelo.getText() + "' AND proceso='costura' AND articulo='"
                + txtArticulo.getText() + "'";
        String[] cabecera = {"Codigo", "Pieza", "Nombre", "Medida", "Consumo", "Precio", "total"};
        // se definen los registros que llevara la tabla
        String[] registros = new String[7];
        // se hace el llamado sql de todos los usuarios

        System.out.println(sql);
        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {80, 250, 700, 80, 80, 80, 80};
        costura = new DefaultTableModel(null, cabecera);

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

                costura.addRow(registros);
                // calculamos el subtotal de Manipulacion
                Double subtotal = Double.parseDouble(txtSubManipulacion1.getText());
                Double agregar = Double.parseDouble(rs.getString("resultado"));
                Double resultado = subtotal + agregar;
                BigDecimal SubTotal = BigDecimal.valueOf(resultado);
                SubTotal = SubTotal.setScale(2, RoundingMode.HALF_UP);
                txtSubManipulacion1.setText(String.valueOf(SubTotal));

                //asignamos el valor en el total
                txtTotalCos.setText(String.valueOf(SubTotal));
                calculoTotal();
            }
            tablaCos.setModel(costura);
            for (int i = 0; i < cabecera.length; i++) {
                tablaCos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tablaCos.setFont(new java.awt.Font("Tahoma", 0, 12));

            }
            txtPredecible1.setText("");
            txtParCost.setText("");
            txtPrecioCost.setText("");
            txtPrecioMaqCost.setText("");

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla");
        }

    }

    //tabla de inyeccion
    public void mostrarTablaIny() {
        String sql = "SELECT * FROM especificacion where modelo='" + txtModelo.getText() + "' AND proceso='inyeccion' AND articulo='"
                + txtArticulo.getText() + "'";
        String[] cabecera = {"Codigo", "Pieza", "Nombre", "Medida", "Consumo", "Precio", "total"};
        // se definen los registros que llevara la tabla
        String[] registros = new String[7];
        // se hace el llamado sql de todos los usuarios

        System.out.println(sql);
        //establecemos los anchos en pixeles de las columnas
        int[] anchos = {80, 250, 700, 80, 80, 80, 80};
        inyeccion = new DefaultTableModel(null, cabecera);

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

                inyeccion.addRow(registros);
                // calculamos el subtotal de Manipulacion
                Double subtotal = Double.parseDouble(txtSubManipulacion2.getText());
                Double agregar = Double.parseDouble(rs.getString("resultado"));
                Double resultado = subtotal + agregar;
                BigDecimal SubTotal = BigDecimal.valueOf(resultado);
                SubTotal = SubTotal.setScale(2, RoundingMode.HALF_UP);
                txtSubManipulacion2.setText(String.valueOf(SubTotal));

                //asignamos el valor en el total
                txtTotalIny.setText(String.valueOf(SubTotal));
                calculoTotal();
            }
            tablaIny.setModel(inyeccion);
            for (int i = 0; i < cabecera.length; i++) {
                tablaIny.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                tablaIny.setFont(new java.awt.Font("Tahoma", 0, 12));

            }
            txtPredecible2.setText("");
            txtParIny.setText("");
            txtPrecioIny.setText("");
            txtMaqIny.setText("");

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla");
        }

    }

    public String redondeo() {
        Double par = Double.parseDouble(txtPar.getText());
        Double precio = Double.parseDouble(txtPrecio.getText());
        Double Resultado = par * precio;
        BigDecimal resultado = BigDecimal.valueOf(Resultado);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        String txtResultado = resultado.toString();
        return txtResultado;
    }

    public String redondeoCost() {
        Double par = Double.parseDouble(txtParCost.getText());
        Double precio = Double.parseDouble(txtPrecioCost.getText());
        Double Resultado = par * precio;
        BigDecimal resultado = BigDecimal.valueOf(Resultado);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        String txtResultado = resultado.toString();
        return txtResultado;
    }

    public String redondeoIny() {
        Double par = Double.parseDouble(txtParIny.getText());
        Double precio = Double.parseDouble(txtPrecioIny.getText());
        Double Resultado = par * precio;
        BigDecimal resultado = BigDecimal.valueOf(Resultado);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        String txtResultado = resultado.toString();
        return txtResultado;
    }
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        // verificamos que no esten los campos vacios
        if (txtLinea.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Escribe la linea del calzado");
        } else if (txtModelo.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Escribe el modelo del calzado");
        } else if (txtArticulo.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Escribe el articulo del calzado");
        } else if (txtColor.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Escribe el color del calzado");
        } else {

            //verificamos que el modelo no exista previamente
            int repetido = 0;
            try {
                String checar = "SELECT * FROM especificacion WHERE articulo='" + txtArticulo.getText()
                        + "' and linea='" + txtLinea.getText() + "'";
                Statement verificar;
                verificar = cn.createStatement();
                ResultSet buscar = verificar.executeQuery(checar);
                while (buscar.next()) {
                    repetido++;
                    JOptionPane.showMessageDialog(null, "El articulo " + txtArticulo.getText()
                            + " ya existe\n en la linea " + txtLinea.getText(), "Alerta", 0);
                    
                }
            } catch (Exception e) {
            }
            if (repetido == 0) {
                txtLinea.setText(txtLinea.getText().toUpperCase());
                txtModelo.setText(txtModelo.getText().toUpperCase());
                txtColor.setText(txtColor.getText().toUpperCase());
                int respuesta = JOptionPane.showConfirmDialog(this, "se va a crear el siguiente calzado\nLinea:"
                        + txtLinea.getText() + "\nModelo: "
                        + txtModelo.getText() + "\nArticulo: "
                        + txtArticulo.getText() + "\n Color: "
                        + txtColor.getText(), "Confirmacion", 2);
                //verificamos que informacion se va a agregar y si lo acepta se integra a la BD
                if (respuesta == 0) {
                    //en caso que si, cancelamos los botones y activamos integrar
                    txtLinea.setEnabled(false);
                    txtModelo.setEnabled(false);
                    txtArticulo.setEnabled(false);
                    txtColor.setEnabled(false);
                    btnEditar.setEnabled(false);
                    btnCrear.setEnabled(false);
                    btnIntegrar.setEnabled(true);
                    btnIntegrarCostura.setEnabled(true);
                    btnIntegrarInyeccion.setEnabled(true);
                    btnImagen.setEnabled(true);
                    chkActivo.setEnabled(false);
                    txtSubManipulacion.setText("0.00");
                    btnGuardar.setEnabled(true);
                    btnGuardar.setText("GUARDAR");

                    // creamos la imagen de default del calzado
                    ImageIcon imagenCalzado = new ImageIcon(getClass().getResource("/Graficos/imgCalzado.png"));
                    imgCalzado.setIcon(imagenCalzado);

                } else {
                    //si se cancela la creacion de zapata dejamos limpio todo
                    txtLinea.setText("");
                    txtModelo.setText("");
                    txtArticulo.setText("");
                    txtColor.setText("");
                }
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio1ActionPerformed

    private void btnNuevaMaquilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaMaquilaActionPerformed
        maquila frm = new maquila();
        frm.setVisible(true);
        frm.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnNuevaMaquilaActionPerformed

    private void btnActMaquilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActMaquilaActionPerformed
        //actualizamos Autocompletar maquila
        asignarAutocompletadoMaquila();
    }//GEN-LAST:event_btnActMaquilaActionPerformed

    private void btnActInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActInventarioActionPerformed
        //actualizamos autocompletar inventario
        asignarAutocompletado();
    }//GEN-LAST:event_btnActInventarioActionPerformed

    private void btnIntegrarCosturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrarCosturaActionPerformed
        // preparamos la funcion de integracion a "Costura"

        //verificamos si es maquila o inventario a integrar el modelo
        //checamos que no tengan ambos campos con texto
        if (txtPredecible1.getText().length() > 1 && txtMaquila1.getText().length() > 1) {
            JOptionPane.showMessageDialog(this, "Solo integra un elemento a la vez");
        } // vericamos que ambos no esten vacios
        else if (txtPredecible1.getText().length() == 0 && txtMaquila1.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Agrega un material o una maquila");
        } else if (txtPredecible1.getText().length() > 1) {
            //aqui integramos un material del inventario

            //primero verificamos que si este en la base de datos de inventario
            int contador = 0;
            try {
                String checar = "SELECT * FROM inventario WHERE nombre='" + txtPredecible1.getText() + "'";
                Statement repetido;
                repetido = cn.createStatement();
                ResultSet buscar = repetido.executeQuery(checar);
                while (buscar.next()) {
                    contador = 1;

                }
            } catch (SQLException ex) {
                Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (contador == 1) {
                //revisamos que no este repetido el material en el calzado

                int material = 0;
                try {
                    String checar = "SELECT * FROM especificacion WHERE nombre='" + txtPredecible1.getText() + "' and modelo='"
                            + txtModelo.getText() + "' and articulo='" + txtArticulo.getText() + "'";
                    Statement repetido;
                    repetido = cn.createStatement();
                    ResultSet buscar = repetido.executeQuery(checar);
                    while (buscar.next()) {
                        material++;
                        JOptionPane.showMessageDialog(this, "El material ya esta en la hoja de especificacion");
                        txtPredecible1.setText("");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (material == 0) {
                    // como si existe el material en la bd de datos de inventario, procedemos a integrarlo a Calzado
                    if (txtParCost.getText().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Falta agregar el costo");
                    } else if (txtPrecioCost.getText().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Falta agregar el Precio");
                    } else {
                        //Asignamos variables a la especificacion
                        String Linea = txtLinea.getText().toUpperCase();
                        String Modelo = txtModelo.getText().toUpperCase();
                        String Articulo = txtArticulo.getText().toUpperCase();
                        String Color = txtColor.getText().toUpperCase();
                        String Nombre = txtPredecible1.getText();
                        String Consumo = txtParCost.getText();
                        String Precio = txtPrecioCost.getText();
                        String Codigo = null;
                        String Pieza = null;
                        String Medida = null;
                        String Activo = "1";
                        //calculamos el costo
                        String txtResultado = redondeoCost();
                        // verificamos si esta seleccionado
                        if (!chkActivo.isSelected()) {
                            Activo = "0";
                        }
                        String sql = "SELECT * FROM inventario WHERE nombre='" + txtPredecible1.getText() + "'";

                        //buscamos en la base de datos Inventario las especificaciones faltantes
                        try {
                            Statement completar;
                            completar = cn.createStatement();
                            ResultSet rs = completar.executeQuery(sql);
                            while (rs.next()) {
                                Codigo = rs.getString("codigo");
                                Pieza = rs.getString("pieza");
                                Medida = rs.getString("medida");
                            }
                        } catch (SQLException ex) {
                            System.out.println("Sin poder ejecutar el query para asignar valores");
                        }

                        //ya teniendo todos los valores integramos la especificacion a la BD calzado
                        try {
                            Statement stmt = cn.createStatement();
                            String grabar = "INSERT INTO especificacion (modelo,codigo,linea,articulo,color,pieza,nombre,medida,consumo,precio,resultado,estado,proceso) "
                                    + "VALUES ('"
                                    + Modelo + "','"
                                    + Codigo + "','"
                                    + Linea + "','"
                                    + Articulo + "','"
                                    + Color + "','"
                                    + Pieza + "','"
                                    + Nombre + "','"
                                    + Medida + "','"
                                    + Consumo + "','"
                                    + Precio + "','"
                                    + txtResultado + "','"
                                    + Activo + "','costura');";
                            stmt.executeUpdate(grabar);

                            stmt.close();
                            txtSubManipulacion1.setText("0.00");
                            mostrarTablaCost();
                        } catch (SQLException ex) {
                            Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }
            if (contador == 0) {
                JOptionPane.showMessageDialog(this, "No modifiques la ventana de materiales");
                txtPredecible1.setText("");
                txtParCost.setText("");
                txtPrecioCost.setText("");
            }
        } else if (txtMaquila1.getText().length() > 0) {
            // ********** Inicia Captura de Maquila

            //primero verificamos que si este en la base de datos de maquila
            int contador = 0;
            try {
                String checar = "SELECT * FROM maquila WHERE nombre='" + txtMaquila1.getText() + "'";
                Statement repetido;
                repetido = cn.createStatement();
                ResultSet buscar = repetido.executeQuery(checar);
                while (buscar.next()) {
                    contador = 1;

                }
            } catch (SQLException ex) {
                Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (contador == 1) {
                //revisamos que no este repetido la maquila en el calzado

                int maquila = 0;
                try {
                    String checar = "SELECT * FROM especificacion WHERE nombre='" + txtMaquila1.getText() + "' and modelo='"
                            + txtModelo.getText() + "' and articulo='" + txtArticulo.getText() + "'";
                    Statement repetido;
                    repetido = cn.createStatement();
                    ResultSet buscar = repetido.executeQuery(checar);
                    while (buscar.next()) {
                        maquila++;
                        JOptionPane.showMessageDialog(this, "La maquila ya esta en la hoja de especificacion");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (maquila == 0) {
                    // como si existe el material en la bd de datos de inventario, procedemos a integrarlo a Calzado
                    if (txtPrecioMaqCost.getText().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Falta agregar el Precio de la maquila");
                    } else {
                        //Asignamos variables a la especificacion
                        String Linea = txtLinea.getText().toUpperCase();
                        String Modelo = txtModelo.getText().toUpperCase();
                        String Articulo = txtArticulo.getText().toUpperCase();
                        String Color = txtColor.getText().toUpperCase();
                        String Nombre = txtMaquila1.getText();
                        String Precio = txtPrecioMaqCost.getText();
                        String Codigo = null;
                        String Pieza = null;
                        String Activo = "1";
                        //Asignamos el precio como resultado
                        String txtResultado = Precio;
                        // verificamos si esta seleccionado
                        if (!chkActivo.isSelected()) {
                            Activo = "0";
                        }
                        String sql = "SELECT * FROM maquila WHERE nombre='" + txtMaquila1.getText() + "'";

                        //buscamos en la base de datos Maquila las especificaciones faltantes
                        try {
                            Statement completar;
                            completar = cn.createStatement();
                            ResultSet rs = completar.executeQuery(sql);
                            while (rs.next()) {
                                Codigo = rs.getString("codigo");
                                Pieza = rs.getString("pieza");
                            }
                        } catch (SQLException ex) {
                            System.out.println("Sin poder ejecutar el query para asignar valores de maquila");
                        }

                        //ya teniendo todos los valores integramos la especificacion a la BD calzado
                        try {
                            Statement stmt = cn.createStatement();
                            String grabar = "INSERT INTO especificacion (modelo,codigo,linea,articulo,color,pieza,nombre,precio,resultado,estado,proceso) "
                                    + "VALUES ('"
                                    + Modelo + "','"
                                    + Codigo + "','"
                                    + Linea + "','"
                                    + Articulo + "','"
                                    + Color + "','"
                                    + Pieza + "','"
                                    + Nombre + "','"
                                    + Precio + "','"
                                    + txtResultado + "','"
                                    + Activo + "','costura');";
                            stmt.executeUpdate(grabar);

                            stmt.close();
                            txtSubManipulacion1.setText("0.00");
                            txtPrecioMaqCost.setText("");
                            txtMaquila1.setText("");
                            mostrarTablaCost();
                        } catch (SQLException ex) {
                            Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }
            if (contador == 0) {
                JOptionPane.showMessageDialog(this, "No modifiques la ventana de maquila");
                txtPredecible1.setText("");
                txtParCost.setText("");
                txtPrecioMaqCost.setText("");
            }

            // ********** Termina captura de maquila
        }
    }//GEN-LAST:event_btnIntegrarCosturaActionPerformed

    private void txtPrecioCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCostActionPerformed

    private void txtPrecioMaqCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioMaqCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioMaqCostActionPerformed

    private void btnActMaquila1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActMaquila1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActMaquila1ActionPerformed

    private void btnNuevaMaquila1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaMaquila1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaMaquila1ActionPerformed

    private void btnActInventario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActInventario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActInventario1ActionPerformed

    private void btnIntegrarInyeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrarInyeccionActionPerformed
        // preparamos la funcion de integracion a "Inyeccion"

        //verificamos si es maquila o inventario a integrar el modelo
        //checamos que no tengan ambos campos con texto
        if (txtPredecible2.getText().length() > 1 && txtMaquila2.getText().length() > 1) {
            JOptionPane.showMessageDialog(this, "Solo integra un elemento a la vez");
        } // vericamos que ambos no esten vacios
        else if (txtPredecible2.getText().length() == 0 && txtMaquila2.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Agrega un material o una maquila");
        } else if (txtPredecible2.getText().length() > 1) {
            //aqui integramos un material del inventario

            //primero verificamos que si este en la base de datos de inventario
            int contador = 0;
            try {
                String checar = "SELECT * FROM inventario WHERE nombre='" + txtPredecible2.getText() + "'";
                Statement repetido;
                repetido = cn.createStatement();
                ResultSet buscar = repetido.executeQuery(checar);
                while (buscar.next()) {
                    contador = 1;

                }
            } catch (SQLException ex) {
                Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (contador == 1) {
                //revisamos que no este repetido el material en el especificacion

                int material = 0;
                try {
                    String checar = "SELECT * FROM especificacion WHERE nombre='" + txtPredecible2.getText() + "' and modelo='"
                            + txtModelo.getText() + "' and articulo='" + txtArticulo.getText() + "'";
                    Statement repetido;
                    repetido = cn.createStatement();
                    ResultSet buscar = repetido.executeQuery(checar);
                    while (buscar.next()) {
                        material++;
                        JOptionPane.showMessageDialog(this, "El material ya esta en la hoja de especificacion");
                        txtPredecible2.setText("");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (material == 0) {
                    // como si existe el material en la bd de datos de inventario, procedemos a integrarlo a Calzado
                    if (txtParIny.getText().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Falta agregar el costo");
                    } else if (txtPrecioIny.getText().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Falta agregar el Precio");
                    } else {
                        //Asignamos variables a la especificacion
                        String Linea = txtLinea.getText().toUpperCase();
                        String Modelo = txtModelo.getText().toUpperCase();
                        String Articulo = txtArticulo.getText().toUpperCase();
                        String Color = txtColor.getText().toUpperCase();
                        String Nombre = txtPredecible2.getText();
                        String Consumo = txtParIny.getText();
                        String Precio = txtPrecioIny.getText();
                        String Codigo = null;
                        String Pieza = null;
                        String Medida = null;
                        String Activo = "1";
                        //calculamos el costo
                        String txtResultado = redondeoIny();
                        // verificamos si esta seleccionado
                        if (!chkActivo.isSelected()) {
                            Activo = "0";
                        }
                        String sql = "SELECT * FROM inventario WHERE nombre='" + txtPredecible2.getText() + "'";

                        //buscamos en la base de datos Inventario las especificaciones faltantes
                        try {
                            Statement completar;
                            completar = cn.createStatement();
                            ResultSet rs = completar.executeQuery(sql);
                            while (rs.next()) {
                                Codigo = rs.getString("codigo");
                                Pieza = rs.getString("pieza");
                                Medida = rs.getString("medida");
                            }
                        } catch (SQLException ex) {
                            System.out.println("Sin poder ejecutar el query para asignar valores");
                        }

                        //ya teniendo todos los valores integramos la especificacion a la BD calzado
                        try {
                            Statement stmt = cn.createStatement();
                            String grabar = "INSERT INTO especificacion (modelo,codigo,linea,articulo,color,pieza,nombre,medida,consumo,precio,resultado,estado,proceso) "
                                    + "VALUES ('"
                                    + Modelo + "','"
                                    + Codigo + "','"
                                    + Linea + "','"
                                    + Articulo + "','"
                                    + Color + "','"
                                    + Pieza + "','"
                                    + Nombre + "','"
                                    + Medida + "','"
                                    + Consumo + "','"
                                    + Precio + "','"
                                    + txtResultado + "','"
                                    + Activo + "','inyeccion');";
                            stmt.executeUpdate(grabar);

                            stmt.close();
                            txtSubManipulacion2.setText("0.00");
                            mostrarTablaIny();
                        } catch (SQLException ex) {
                            Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }
            if (contador == 0) {
                JOptionPane.showMessageDialog(this, "No modifiques la ventana de materiales");
                txtPredecible2.setText("");
                txtParIny.setText("");
                txtPrecioIny.setText("");
            }
        } else if (txtMaquila2.getText().length() > 0) {
            // ********** Inicia Captura de Maquila

            //primero verificamos que si este en la base de datos de maquila
            int contador = 0;
            try {
                String checar = "SELECT * FROM maquila WHERE nombre='" + txtMaquila2.getText() + "'";
                Statement repetido;
                repetido = cn.createStatement();
                ResultSet buscar = repetido.executeQuery(checar);
                while (buscar.next()) {
                    contador = 1;

                }
            } catch (SQLException ex) {
                Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (contador == 1) {
                //revisamos que no este repetido la maquila en el calzado

                int maquila = 0;
                try {
                    String checar = "SELECT * FROM especificacion WHERE nombre='" + txtMaquila2.getText() + "' and modelo='"
                            + txtModelo.getText() + "' and articulo='" + txtArticulo.getText() + "'";
                    Statement repetido;
                    repetido = cn.createStatement();
                    ResultSet buscar = repetido.executeQuery(checar);
                    while (buscar.next()) {
                        maquila++;
                        JOptionPane.showMessageDialog(this, "La maquila ya esta en la hoja de especificacion");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (maquila == 0) {
                    // como si existe el material en la bd de datos de inventario, procedemos a integrarlo a Calzado
                    if (txtMaqIny.getText().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Falta agregar el Precio de la maquila");
                    } else {
                        //Asignamos variables a la especificacion
                        String Linea = txtLinea.getText().toUpperCase();
                        String Modelo = txtModelo.getText().toUpperCase();
                        String Articulo = txtArticulo.getText().toUpperCase();
                        String Color = txtColor.getText().toUpperCase();
                        String Nombre = txtMaquila2.getText();
                        String Precio = txtMaqIny.getText();
                        String Codigo = null;
                        String Pieza = null;
                        String Activo = "1";
                        //Asignamos el precio como resultado
                        String txtResultado = Precio;
                        // verificamos si esta seleccionado
                        if (!chkActivo.isSelected()) {
                            Activo = "0";
                        }
                        String sql = "SELECT * FROM maquila WHERE nombre='" + txtMaquila2.getText() + "'";

                        //buscamos en la base de datos Maquila las especificaciones faltantes
                        try {
                            Statement completar;
                            completar = cn.createStatement();
                            ResultSet rs = completar.executeQuery(sql);
                            while (rs.next()) {
                                Codigo = rs.getString("codigo");
                                Pieza = rs.getString("pieza");
                            }
                        } catch (SQLException ex) {
                            System.out.println("Sin poder ejecutar el query para asignar valores de maquila");
                        }

                        //ya teniendo todos los valores integramos la especificacion a la BD especificacion
                        try {
                            Statement stmt = cn.createStatement();
                            String grabar = "INSERT INTO especificacion (modelo,codigo,linea,articulo,color,pieza,nombre,precio,resultado,estado,proceso) "
                                    + "VALUES ('"
                                    + Modelo + "','"
                                    + Codigo + "','"
                                    + Linea + "','"
                                    + Articulo + "','"
                                    + Color + "','"
                                    + Pieza + "','"
                                    + Nombre + "','"
                                    + Precio + "','"
                                    + txtResultado + "','"
                                    + Activo + "','inyeccion');";
                            stmt.executeUpdate(grabar);

                            stmt.close();
                            txtSubManipulacion2.setText("0.00");
                            txtMaqIny.setText("");
                            txtMaquila2.setText("");
                            mostrarTablaIny();
                        } catch (SQLException ex) {
                            Logger.getLogger(frmInventario.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }
            if (contador == 0) {
                JOptionPane.showMessageDialog(this, "No modifiques la ventana de maquila");
                txtPredecible2.setText("");
                txtParIny.setText("");
                txtMaqIny.setText("");
            }

            // ********** Termina captura de maquila
        }
    }//GEN-LAST:event_btnIntegrarInyeccionActionPerformed

    private void txtPrecioInyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioInyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioInyActionPerformed

    private void txtMaqInyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaqInyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaqInyActionPerformed

    private void btnActMaquila2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActMaquila2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActMaquila2ActionPerformed

    private void btnNuevaMaquila2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaMaquila2ActionPerformed
        maquila frm=new maquila();
        frm.setVisible(true);
    }//GEN-LAST:event_btnNuevaMaquila2ActionPerformed

    private void btnActInventario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActInventario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActInventario2ActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // recalculamos todo
        calculoTotal();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        // menu de introduccion de una Imagen
        //Creamos selector de apertura

        // iniciamos de nuevo
        JFileChooser seleccion = new JFileChooser();
        //Titulo que llevara la ventana
        seleccion.setDialogTitle("Selecciona la imagen del Calzado");
        seleccion.setAcceptAllFileFilterUsed(false);
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg", "*.PNG", "png");

        //Le indicamos el filtro
        seleccion.setFileFilter(filtro);
        int opcion = seleccion.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {

            File file = seleccion.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getPath());
            Image conversion = icon.getImage();
            Image escala = conversion.getScaledInstance(260, 165, Image.SCALE_SMOOTH);
            ImageIcon calzado = new ImageIcon(escala);
            imgCalzado.setIcon(calzado);
                 

        }


    }//GEN-LAST:event_btnImagenActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //recalculamos el zapato antes de que se grabe
        btnCalcular.doClick();
        
        //dependiendo el texto del boton hacemos las acciones
        if (btnGuardar.getText().equals("GUARDAR")){
       //iniciamos el proceso de guardar la creacion del Calzado
       
       // pasamos la imagen de icono de label a formato imagen
       imagenes img=new imagenes();
       Image imagenCalzado=img.iconToImage(imgCalzado.getIcon());
        BufferedImage bi = new BufferedImage(imagenCalzado.getWidth(null), imagenCalzado.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(imagenCalzado, 0, 0, null);
        g2d.dispose(); 
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, "jpg", baos );
        } catch (IOException ex) {
            Logger.getLogger(catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] imageInByte = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        
        //creamos las variables a integrar a la bd
        String linea=txtLinea.getText();
        String modelo=txtModelo.getText();
        String articulo=txtArticulo.getText();
        String color=txtColor.getText();
        int activo=1;
        if (!chkActivo.isSelected()){
            activo=0;
        }
        Double manipulacion=Double.parseDouble(txtTotalMan.getText());
        Double costura=Double.parseDouble(txtTotalCos.getText());
        Double inyeccion=Double.parseDouble(txtTotalIny.getText());
        Double salarioInyeccion=Double.parseDouble(txtSalariosInyeccion.getText());
        Double subTotal=Double.parseDouble(txtSubTotal.getText());
        Double gastosIndirectos=Double.parseDouble(txtGastosInd.getText());
        Double fabricacion=Double.parseDouble(txtCostoFabricacion.getText());
        Double porcentaje=Double.parseDouble(txtPorcentaje.getText());
        Double utilidad=Double.parseDouble(txtUtilidad.getText());
        Double merma=Double.parseDouble(txtMerma.getText());
        Double total=Double.parseDouble(txtTotal.getText());
        
        
        // pasamos toda la informacion a la base de datos calzado
        
        try {
            PreparedStatement ps;
            ps = cn.prepareStatement("insert into calzado(linea,modelo,articulo,color,activo,manipulacion,costura,inyeccion,salarioInyeccion,subTotal,gastosIndirectos,fabricacion,porcentaje,utilidad,merma,total,imagen) " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,linea);
            ps.setString(2,modelo);
            ps.setString(3,articulo);
            ps.setString(4,color);
            ps.setInt(5,activo);
            ps.setDouble(6,manipulacion);
            ps.setDouble(7,costura);
            ps.setDouble(8,inyeccion);
            ps.setDouble(9,salarioInyeccion);
            ps.setDouble(10,subTotal);
            ps.setDouble(11,gastosIndirectos);
            ps.setDouble(12,fabricacion);
            ps.setDouble(13,porcentaje);
            ps.setDouble(14,utilidad);
            ps.setDouble(15,merma);
            ps.setDouble(16,total);
            ps.setBlob(17, bais);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "El calzado se ha integrado correctamente a la base de datos");
            //ya que se grabo en la base de datos pasamos a dejar todo de nuevo para un nuevo calzado
            btnCrear.setEnabled(true);
            btnEditar.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnIntegrar.setEnabled(false);
            btnIntegrarCostura.setEnabled(false);
            btnIntegrarInyeccion.setEnabled(false);
            txtLinea.setText("");
            txtLinea.setEnabled(true);
            txtModelo.setText("");
            txtModelo.setEnabled(true);
            txtArticulo.setEnabled(true);
            txtArticulo.setText("");
            txtColor.setText("");
            txtColor.setEnabled(true);
            btnImagen.setEnabled(false);
            mostrarTabla();
            mostrarTablaCost();
            mostrarTablaIny();
            txtTotalMan.setText("0.00");
            txtTotalCos.setText("0.00");
            txtTotalIny.setText("0.00");
            txtSalariosInyeccion.setText("0.00");
            txtSubTotal.setText("0.00");
            txtGastosInd.setText("0.00");
            txtCostoFabricacion.setText("0.00");
            txtUtilidad.setText("20");
            txtMerma.setText("0.00");
            txtTotal.setText("0.00");
            txtSubManipulacion.setText("0.00");
            txtSubManipulacion1.setText("0.00");
            txtSubManipulacion2.setText("0.00");
            asignarAutocompletadoArticulo();
            
            // creamos la imagen de default del calzado
            ImageIcon imagenDefault = new ImageIcon(getClass().getResource("/Graficos/imgCalzado.png"));
            imgCalzado.setIcon(imagenDefault);
        } catch (SQLException ex) {
            Logger.getLogger(catalogo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hay un problema con la BD, Calzado no se ha grabado");
        }
        
         
        }else{
        //proceso si es que solo se va a actualizar
        // pasamos la imagen de icono de label a formato imagen
       imagenes img=new imagenes();
       Image imagenCalzado=img.iconToImage(imgCalzado.getIcon());
        BufferedImage bi = new BufferedImage(imagenCalzado.getWidth(null), imagenCalzado.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(imagenCalzado, 0, 0, null);
        g2d.dispose(); 
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, "jpg", baos );
        } catch (IOException ex) {
            Logger.getLogger(catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] imageInByte = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        
        //creamos las variables a integrar a la bd
        String linea=txtLinea.getText();
        String modelo=txtModelo.getText();
        String articulo=txtArticulo.getText();
        String color=txtColor.getText();
        int activo=1;
        if (!chkActivo.isSelected()){
            activo=0;
        }
        Double manipulacion=Double.parseDouble(txtTotalMan.getText());
        Double costura=Double.parseDouble(txtTotalCos.getText());
        Double inyeccion=Double.parseDouble(txtTotalIny.getText());
        Double salarioInyeccion=Double.parseDouble(txtSalariosInyeccion.getText());
        Double subTotal=Double.parseDouble(txtSubTotal.getText());
        Double gastosIndirectos=Double.parseDouble(txtGastosInd.getText());
        Double fabricacion=Double.parseDouble(txtCostoFabricacion.getText());
        Double porcentaje=Double.parseDouble(txtPorcentaje.getText());
        Double utilidad=Double.parseDouble(txtUtilidad.getText());
        Double merma=Double.parseDouble(txtMerma.getText());
        Double total=Double.parseDouble(txtTotal.getText());
        
        
        // pasamos toda la informacion a la base de datos calzado
        String actualizar="update calzado set activo=?,manipulacion=?,costura=?,inyeccion=?,salarioInyeccion=?,"
                    + "subTotal=?,gastosIndirectos=?,fabricacion=?,porcentaje=?,utilidad=?,merma=?,total=?,imagen=? WHERE articulo='"+txtArticulo.getText()+"'";
        
        try {
            PreparedStatement ps;
            ps = cn.prepareStatement(actualizar);
            
            ps.setInt(1,activo);
            ps.setDouble(2,manipulacion);
            ps.setDouble(3,costura);
            ps.setDouble(4,inyeccion);
            ps.setDouble(5,salarioInyeccion);
            ps.setDouble(6,subTotal);
            ps.setDouble(7,gastosIndirectos);
            ps.setDouble(8,fabricacion);
            ps.setDouble(9,porcentaje);
            ps.setDouble(10,utilidad);
            ps.setDouble(11,merma);
            ps.setDouble(12,total);
            ps.setBlob(13, bais);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "El calzado se ha actualizado correctamente a la base de datos");
            //ya que se grabo en la base de datos pasamos a dejar todo de nuevo para un nuevo calzado
            btnCrear.setEnabled(true);
            btnEditar.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnIntegrar.setEnabled(false);
            btnIntegrarCostura.setEnabled(false);
            btnIntegrarInyeccion.setEnabled(false);
            txtLinea.setText("");
            txtLinea.setEnabled(true);
            txtModelo.setText("");
            txtModelo.setEnabled(true);
            txtArticulo.setEnabled(true);
            txtArticulo.setText("");
            txtColor.setText("");
            txtColor.setEnabled(true);
            btnImagen.setEnabled(false);
            mostrarTabla();
            mostrarTablaCost();
            mostrarTablaIny();
            txtTotalMan.setText("0.00");
            txtTotalCos.setText("0.00");
            txtTotalIny.setText("0.00");
            txtSalariosInyeccion.setText("0.00");
            txtSubTotal.setText("0.00");
            txtGastosInd.setText("0.00");
            txtCostoFabricacion.setText("0.00");
            txtUtilidad.setText("20");
            txtMerma.setText("0.00");
            txtTotal.setText("0.00");
            txtSubManipulacion.setText("0.00");
            txtSubManipulacion1.setText("0.00");
            txtSubManipulacion2.setText("0.00");
            btnEditar.setText("Editar");
            txtSubManipulacion2.setText("0.00");
            asignarAutocompletadoArticulo();
            
            // creamos la imagen de default del calzado
            ImageIcon imagenDefault = new ImageIcon(getClass().getResource("/Graficos/imgCalzado.png"));
            imgCalzado.setIcon(imagenDefault);
        } catch (SQLException ex) {
            Logger.getLogger(catalogo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hay un problema con la BD, Calzado no se ha grabado");
        }
         
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // borrando un elemento de la tabla manipulacion
         int fila = tablaMan.getSelectedRow();
        String material;
       if (fila>=0){
           material=tablaMan.getValueAt(fila, 0).toString();
           
              
        try{
            String sql="DELETE FROM especificacion WHERE codigo='"+material+"' AND modelo='"+txtModelo.getText()+"' and articulo='"+txtArticulo.getText()+"'";
            System.out.println (sql);
            Statement st;
            st=cn.createStatement();
            st.executeUpdate(sql);
            st.close();
            JOptionPane.showMessageDialog(null,"Elemento Eliminado");
            txtSubManipulacion.setText("0.00");
            txtTotalMan.setText("0.00");
            mostrarTabla();
            btnCalcular.doClick();
        }
        catch (HeadlessException | SQLException ex){
          JOptionPane.showMessageDialog(null,"no se elimino el elemento");
          mostrarTabla();
        }
       }   
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
       //borrar elemento de costura
       // borrando un elemento de la tabla manipulacion
         int fila = tablaCos.getSelectedRow();
        String material;
       if (fila>=0){
           material=tablaCos.getValueAt(fila, 0).toString();
           
              
        try{
            String sql="DELETE FROM especificacion WHERE codigo='"+material+"' AND modelo='"+txtModelo.getText()+"' and articulo='"+txtArticulo.getText()+"'";
            System.out.println (sql);
            Statement st;
            st=cn.createStatement();
            st.executeUpdate(sql);
            st.close();
            JOptionPane.showMessageDialog(null,"Elemento Eliminado");
            txtSubManipulacion1.setText("0.00");
            txtTotalCos.setText("0.00");
            mostrarTablaCost();
            btnCalcular.doClick();
        }
        catch (HeadlessException | SQLException ex){
          JOptionPane.showMessageDialog(null,"no se elimino el elemento");
          mostrarTablaCost();
        }
       }   
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar2ActionPerformed
      //borrar elemento de costura
       // borrando un elemento de la tabla manipulacion
         int fila = tablaIny.getSelectedRow();
        String material;
       if (fila>=0){
           material=tablaIny.getValueAt(fila, 0).toString();
           
              
        try{
            String sql="DELETE FROM especificacion WHERE codigo='"+material+"' AND modelo='"+txtModelo.getText()+"' and articulo='"+txtArticulo.getText()+"'";
            System.out.println (sql);
            Statement st;
            st=cn.createStatement();
            st.executeUpdate(sql);
            st.close();
            JOptionPane.showMessageDialog(null,"Elemento Eliminado");
            txtSubManipulacion2.setText("0.00");
            txtTotalIny.setText("0.00");
            mostrarTablaIny();
            btnCalcular.doClick();
        }
        catch (HeadlessException | SQLException ex){
          JOptionPane.showMessageDialog(null,"no se elimino el elemento");
          mostrarTablaIny();
        }
       }   
    }//GEN-LAST:event_btnBorrar2ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //si el boton esta en modo "cancelar", reiniciamos
        if (btnEditar.getText().equals("Anular")){
            catalogo frm=new catalogo();
            frm.setVisible(true);
            this.dispose();
        }else{

        //asignamos valores
        String linea=null;
        String modelo=null;
        String articulo=null;
        String combinacion=null;
      
       
       // empezamos con la ventana de dialogo de informacion a editar
       String articuloBuscar=txtArticulo.getText();
       
       fncCatalogo metodo=new fncCatalogo();
       //verificamos si se puede editar
       if (metodo.existe(txtArticulo.getText())){
        
        //buscamos los datos del calzado
       //iniciamos
        try {
            String sql = "SELECT * FROM calzado WHERE articulo='"+articuloBuscar+"'";
            Statement completar;
            completar = cn.createStatement();
            ResultSet rs = completar.executeQuery(sql);
            while (rs.next()) {
               linea=rs.getString("linea");
               modelo=rs.getString("modelo");
               articulo=rs.getString("articulo");
               combinacion=rs.getString("color");
            }
               int respuesta=JOptionPane.showConfirmDialog(this, "se va a editar el siguiente calzado\n"
                       + "Linea: "+linea+"\n"
                       + "Modelo: "+modelo+"\n"
                       + "Articulo: "+articulo+"\n"
                       + "Combinacion: "+combinacion+"\n"
                       + "Continua?", "Atencion",0,1);
               if (respuesta==0){
                   //procedemos a la edicion del zapato
                    //Iniciamos el proceso de editar un calzado
       // activamos boton de imagen
       btnImagen.setEnabled(true);
       //y cargamos la imagen
       
            Statement st;
        try {
            st = cn.createStatement();
            String img = "select * from calzado where  articulo='"+txtArticulo.getText()+"'";
            System.out.println (sql);

            ResultSet rsImg = st.executeQuery(img);
            while (rsImg.next()) {
                Blob blob = rsImg.getBlob("imagen");

                int blobLength = (int) blob.length();

                byte[] blobAsBytes = blob.getBytes(1, blobLength);
                final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(blobAsBytes));

                imgCalzado.setIcon(new ImageIcon(bufferedImage));
            }
        } catch (SQLException ex) {
            Logger.getLogger(catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
                   //lo primero cambiamos el texto del boton guardar
                   // y inhabilitamos el boton de crear
                   btnGuardar.setEnabled(true);
                   btnGuardar.setText("Actualizar");
                   btnCrear.setEnabled(false);
                   
                   //activamos los botones de integrar
                   btnIntegrar.setEnabled(true);
                   btnIntegrarCostura.setEnabled(true);
                   btnIntegrarInyeccion.setEnabled(true);
                   
                   //cambiamos el boton de editar por el de cancelar
                   btnEditar.setText("Anular");
                   
                   //llenamos los datos del calzado y los inhabilitamos
                   txtLinea.setText(linea);
                   txtLinea.setEnabled(false);
                   txtModelo.setText(modelo);
                   txtModelo.setEnabled(false);
                   txtArticulo.setText(articulo);
                   txtArticulo.setEnabled(false);
                   txtColor.setText(combinacion);
                   txtColor.setEnabled(false);
                   
                   //y recuperamos los valores del total
                   mostrarTotales();
                   //ahora solo llenamos las tablas
                   mostrarTabla();
                   mostrarTablaCost();
                   mostrarTablaIny();
                   
                   
               }else{
                   //como no se decidio en editarlo borramos el texto
                   txtArticulo.setText("");
               }
        
            

        } catch (SQLException ex) {
            System.out.println("Sin poder ejecutar el query a la tabla1");
                }
        
        
       }else{
           // no hay nada que editar
           System.out.println ("No se encuentra");
       }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       CalzadoPrincipal frm=new CalzadoPrincipal();
       frm.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new catalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActInventario;
    private javax.swing.JButton btnActInventario1;
    private javax.swing.JButton btnActInventario2;
    private javax.swing.JButton btnActMaquila;
    private javax.swing.JButton btnActMaquila1;
    private javax.swing.JButton btnActMaquila2;
    private javax.swing.JButton btnActualizar3;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnBorrar2;
    private javax.swing.JButton btnBorrar3;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnIntegrar;
    private javax.swing.JButton btnIntegrarCostura;
    private javax.swing.JButton btnIntegrarInyeccion;
    private javax.swing.JButton btnNuevaMaquila;
    private javax.swing.JButton btnNuevaMaquila1;
    private javax.swing.JButton btnNuevaMaquila2;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JLabel imgCalzado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JTable tablaCos;
    private javax.swing.JTable tablaIny;
    private javax.swing.JTable tablaMan;
    private javax.swing.JTextField txtArticulo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JLabel txtCostoFabricacion;
    private javax.swing.JTextField txtGastosInd;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMaqIny;
    private javax.swing.JTextField txtMaquila;
    private javax.swing.JTextField txtMaquila1;
    private javax.swing.JTextField txtMaquila2;
    private javax.swing.JTextField txtMerma;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPar;
    private javax.swing.JTextField txtParCost;
    private javax.swing.JTextField txtParIny;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecio1;
    private javax.swing.JTextField txtPrecioCost;
    private javax.swing.JTextField txtPrecioIny;
    private javax.swing.JTextField txtPrecioMaqCost;
    private javax.swing.JTextField txtPredecible;
    private javax.swing.JTextField txtPredecible1;
    private javax.swing.JTextField txtPredecible2;
    private javax.swing.JLabel txtPrueba;
    private javax.swing.JTextField txtSalariosInyeccion;
    private javax.swing.JLabel txtSubManipulacion;
    private javax.swing.JLabel txtSubManipulacion1;
    private javax.swing.JLabel txtSubManipulacion2;
    private javax.swing.JTextField txtSubManipulacion3;
    private javax.swing.JLabel txtSubTotal;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JLabel txtTotalCos;
    private javax.swing.JLabel txtTotalIny;
    private javax.swing.JLabel txtTotalMan;
    private javax.swing.JLabel txtUtilidad;
    // End of variables declaration//GEN-END:variables
}
