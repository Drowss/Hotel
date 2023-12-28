/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hostexpanse2.gui;

import com.mycompany.hostexpanse2.model.Habitacion;
import com.mycompany.hostexpanse2.model.Reserva;
import com.mycompany.hostexpanse2.model.Usuario;
import com.mycompany.hostexpanse2.persistencia.ControladoraPersistencia;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Drow
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    private ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
    DefaultTableModel tableModel = new DefaultTableModel();
    DefaultTableModel tableMod = new DefaultTableModel();
    DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
    List<String> roomListNumero = new ArrayList<>();

   
    public MenuPrincipal(Usuario usuario) {
        initComponents();
        btnEditarHabitacion.setEnabled(false);
        btnRecuperarPerfil.setEnabled(false);
        panelReservas.setVisible(true);
        panelAdmin.setVisible(false);
        panelEstados.setVisible(false);
        panelEstadoReservas.setVisible(false);
        if (usuario.getPermisos() == 0){
            btnAdmin.setEnabled(false);
            panelAdmin.setVisible(false);
        }
        construirTabla();
        llenarDatos();
        comboHabitaciones.setModel(comboModel);
        comboHabitaciones();
        
        
        inicializarTablaPersonas();
        llenarDatosReservas();
    }
    
    public void inicializarTablaPersonas(){
        tableMod.addColumn("Cédula");
        tableMod.addColumn("Nombre");
        tableMod.addColumn("Habitación");
        tableMod.addColumn("Teléfono");
        tableMod.addColumn("Fecha de entrada");
        tableMod.addColumn("Fecha de salida");
        this.tblReservasPersonas.setModel(tableMod);
    }
    
    public void comboHabitaciones(){
        comboModel.removeAllElements();
        roomListNumero.clear();
        for (Habitacion habitacion : listHabitacionesNumero()){
            if (habitacion.getEstadoHabitacion().equals("Desocupado")){
                roomListNumero.add(habitacion.getNumeroPiso());
            }
        }
        
        comboModel.addAll(roomListNumero);
        comboHabitaciones.repaint();
    }
    
    public void construirTabla(){
        tableModel.addColumn("Número de habitación");
        tableModel.addColumn("Cantidad de camas");
        tableModel.addColumn("Disponibilidad");
        this.tblRooms.setModel(tableModel);
    }
    
    public void llenarDatos(){
        List<Habitacion> habitaciones = controladoraPersistencia.encontrarHabitaciones();
        String dispo = "";
        for (Habitacion habitacion : habitaciones){
            if (habitacion.getEstadoHabitacion().equals("Desocupado")){
                dispo = "Desocupado";
            } else if (habitacion.getEstadoHabitacion().equals("Ocupado")){
                dispo = "Ocupado";
            } else if (habitacion.getEstadoHabitacion().equals("Aseo")){
                dispo = "Aseo";
            }
//            String dispo = habitacion.getEstadoHabitacion().equals("Desocupado") ? "Desocupado" : "Ocupado";
            TableColumn tableColumn = tblRooms.getColumn("Disponibilidad");
            tableColumn.setCellRenderer(new DisponibilidadCellRenderer());
            Object[] rowData = {habitacion.getNumeroPiso(), habitacion.getCantidadCamas(), dispo};
            tableModel.addRow(rowData);
        }
    }
    
//        public void inicializarTablaPersonas(){
//        tableMod.addColumn("Cédula");
//        tableMod.addColumn("Nombre");
//        tableMod.addColumn("Habitación");
//        tableMod.addColumn("Teléfono");
//        tableMod.addColumn("Fecha de entrada");
//        tableMod.addColumn("Fecha de salida");
//        this.tblReservasPersonas.setModel(tableMod);
//    }
    
    public void llenarDatosReservas(){
        List<Reserva> reservas = controladoraPersistencia.encontrarReservas();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter fFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();
        
        
        for (Reserva reserva : reservas){
            LocalDate resDate = reserva.getFechaReservaSalida().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            String dispo = formatoFecha.format(reserva.getFechaReservaSalida()).equals(fFecha.format(fechaActual)) ? "Termina hoy" : formatoFecha.format(reserva.getFechaReservaSalida());
            if (fechaActual.isAfter(resDate)){
                dispo = "Expiró";
            }
            TableColumn tableColumn = tblReservasPersonas.getColumn("Fecha de salida");
            tableColumn.setCellRenderer(new DisponibilidadCellRenderer());
            Object[] rowData = {reserva.getCedulaHuesped(), reserva.getNombreHuesped() + " " + reserva.getApellidoHuesped(), reserva.getNumeroHabitacion(), reserva.getNumeroTelefono(),
                formatoFecha.format(reserva.getFechaReservaEntrada()), dispo};
            tableMod.addRow(rowData);
        }
    }
    
    
    public List<Habitacion> listHabitacionesNumero(){
        List<Habitacion> list = new ArrayList<>();
        for (Habitacion habitacion : controladoraPersistencia.encontrarHabitaciones()){
            list.add(habitacion);
        }
        return list;
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
        btnReservas = new javax.swing.JButton();
        btnEstadoHabitaciones = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnEstadoReservas = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panelAdmin = new javax.swing.JPanel();
        lblHabitaciones = new javax.swing.JLabel();
        btnCrearHabitacion = new javax.swing.JButton();
        btnEditarHabitacion = new javax.swing.JButton();
        btnBorrarHabitacion = new javax.swing.JButton();
        lblPerfiles = new javax.swing.JLabel();
        btnRecuperarPerfil = new javax.swing.JButton();
        btnEditarPerfil = new javax.swing.JButton();
        btnBorrarPerfil = new javax.swing.JButton();
        panelEstados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRooms = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        panelEstadoReservas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReservasPersonas = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelReservas = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        lblHabitacion = new javax.swing.JLabel();
        lblPrecioNoche = new javax.swing.JLabel();
        lblNumeroPersonas = new javax.swing.JLabel();
        txtNumeroPersonas = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        lblContacto = new javax.swing.JLabel();
        comboHabitaciones = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtPrecioNoche = new javax.swing.JTextField();
        lblHabitacion1 = new javax.swing.JLabel();
        jdcEntrada = new com.toedter.calendar.JDateChooser();
        lblHabitacion2 = new javax.swing.JLabel();
        jdcSalida = new com.toedter.calendar.JDateChooser();
        lblHabitacion3 = new javax.swing.JLabel();
        lblPrecioTotal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(181, 221, 212));

        jLabel1.setBackground(new java.awt.Color(51, 153, 0));

        btnReservas.setBackground(new java.awt.Color(254, 250, 247));
        btnReservas.setText("Reservas");
        btnReservas.setBorder(null);
        btnReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasActionPerformed(evt);
            }
        });

        btnEstadoHabitaciones.setBackground(new java.awt.Color(254, 250, 247));
        btnEstadoHabitaciones.setText("Estado de las habitaciones");
        btnEstadoHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoHabitacionesActionPerformed(evt);
            }
        });

        btnAdmin.setBackground(new java.awt.Color(254, 250, 247));
        btnAdmin.setText("Panel de administrador");
        btnAdmin.setBorder(null);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnEstadoReservas.setBackground(new java.awt.Color(254, 250, 247));
        btnEstadoReservas.setText("Estado de las reservas");
        btnEstadoReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoReservasActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar sesión");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEstadoReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstadoHabitaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEstadoReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEstadoHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 570));

        jPanel2.setBackground(new java.awt.Color(254, 250, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAdmin.setBackground(new java.awt.Color(254, 250, 247));

        lblHabitaciones.setText("Gestionar habitaciones");

        btnCrearHabitacion.setText("Crear habitación");
        btnCrearHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearHabitacionActionPerformed(evt);
            }
        });

        btnEditarHabitacion.setText("Modificar habitación");
        btnEditarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarHabitacionActionPerformed(evt);
            }
        });

        btnBorrarHabitacion.setText("Eliminar habitación");
        btnBorrarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarHabitacionActionPerformed(evt);
            }
        });

        lblPerfiles.setText("Gestionar perfiles");

        btnRecuperarPerfil.setText("Recuperar perfil");

        btnEditarPerfil.setText("Modificar perfil");
        btnEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPerfilActionPerformed(evt);
            }
        });

        btnBorrarPerfil.setText("Eliminar perfil");
        btnBorrarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCrearHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrarHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRecuperarPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                        .addComponent(lblPerfiles)
                        .addGap(25, 25, 25)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addComponent(lblHabitaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrarHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addComponent(lblPerfiles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRecuperarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 173, 173))
        );

        jPanel2.add(panelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 630, 530));

        panelEstados.setBackground(new java.awt.Color(254, 250, 247));

        tblRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRooms);

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setText("Cambiar aseo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEstadosLayout = new javax.swing.GroupLayout(panelEstados);
        panelEstados.setLayout(panelEstadosLayout);
        panelEstadosLayout.setHorizontalGroup(
            panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadosLayout.createSequentialGroup()
                .addGroup(panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelEstadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEstadosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelEstadosLayout.setVerticalGroup(
            panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.add(panelEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 630, 530));

        panelEstadoReservas.setBackground(new java.awt.Color(254, 250, 247));

        tblReservasPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblReservasPersonas);

        jButton5.setText("Actualizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Modificar reserva");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("Terminar reserva");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEstadoReservasLayout = new javax.swing.GroupLayout(panelEstadoReservas);
        panelEstadoReservas.setLayout(panelEstadoReservasLayout);
        panelEstadoReservasLayout.setHorizontalGroup(
            panelEstadoReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadoReservasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelEstadoReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelEstadoReservasLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelEstadoReservasLayout.setVerticalGroup(
            panelEstadoReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadoReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelEstadoReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.add(panelEstadoReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 620, 510));

        panelReservas.setBackground(new java.awt.Color(254, 250, 247));

        lblNombre.setBackground(new java.awt.Color(254, 250, 247));
        lblNombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblNombre.setText("*Nombre:");

        txtNombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setActionCommand("<Not Set>");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCedula.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblCedula.setBackground(new java.awt.Color(254, 250, 247));
        lblCedula.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblCedula.setText("*Cedúla:");

        lblHabitacion.setBackground(new java.awt.Color(254, 250, 247));
        lblHabitacion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblHabitacion.setText("*Habitación:");

        lblPrecioNoche.setBackground(new java.awt.Color(254, 250, 247));
        lblPrecioNoche.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblPrecioNoche.setText("*Precio cada noche:");

        lblNumeroPersonas.setBackground(new java.awt.Color(254, 250, 247));
        lblNumeroPersonas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblNumeroPersonas.setText("*Numero de personas:");

        txtNumeroPersonas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtNumeroPersonas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtApellido.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblApellido.setBackground(new java.awt.Color(254, 250, 247));
        lblApellido.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblApellido.setText("*Apellido:");

        lblContacto.setBackground(new java.awt.Color(254, 250, 247));
        lblContacto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblContacto.setText("*Contacto:");

        jButton1.setText("Reservar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(254, 250, 247));
        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Reserva de habitaciones");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        lblHabitacion1.setBackground(new java.awt.Color(254, 250, 247));
        lblHabitacion1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblHabitacion1.setText("*Fecha de entrada:");

        lblHabitacion2.setBackground(new java.awt.Color(254, 250, 247));
        lblHabitacion2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblHabitacion2.setText("*Fecha de salida:");

        lblHabitacion3.setBackground(new java.awt.Color(254, 250, 247));
        lblHabitacion3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblHabitacion3.setText("*Precio estimado:");

        jButton2.setText("Calcular precio estimado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelReservasLayout = new javax.swing.GroupLayout(panelReservas);
        panelReservas.setLayout(panelReservasLayout);
        panelReservasLayout.setHorizontalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelReservasLayout.createSequentialGroup()
                                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReservasLayout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReservasLayout.createSequentialGroup()
                                        .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReservasLayout.createSequentialGroup()
                                        .addComponent(lblHabitacion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelReservasLayout.createSequentialGroup()
                                        .addComponent(lblHabitacion1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                        .addComponent(jdcEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(panelReservasLayout.createSequentialGroup()
                                .addComponent(lblPrecioNoche)
                                .addGap(7, 7, 7)
                                .addComponent(txtPrecioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido)
                            .addComponent(lblNumeroPersonas)
                            .addComponent(lblHabitacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContacto)
                            .addComponent(lblHabitacion3)))
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellido)
                    .addComponent(txtNumeroPersonas)
                    .addComponent(jdcSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono)
                    .addComponent(lblPrecioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 39, Short.MAX_VALUE))
        );
        panelReservasLayout.setVerticalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(71, 71, 71)
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula)
                            .addComponent(lblNumeroPersonas)
                            .addComponent(txtNumeroPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHabitacion)
                            .addComponent(lblContacto)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHabitacion2)
                            .addComponent(jdcSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(lblHabitacion1)))
                .addGap(18, 18, 18)
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioNoche)
                    .addComponent(lblHabitacion3)
                    .addComponent(lblPrecioTotal))
                .addGap(5, 5, 5)
                .addComponent(jButton2)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jPanel2.add(panelReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 630, 530));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 670, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasActionPerformed
        panelReservas.setVisible(true);
        panelAdmin.setVisible(false);
        panelEstados.setVisible(false);
        panelEstadoReservas.setVisible(false);
    }//GEN-LAST:event_btnReservasActionPerformed

    private void btnEstadoHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoHabitacionesActionPerformed

        panelReservas.setVisible(false);
        panelAdmin.setVisible(false);
        panelEstados.setVisible(true);
        panelEstadoReservas.setVisible(false);
    }//GEN-LAST:event_btnEstadoHabitacionesActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed

        panelReservas.setVisible(false);
        panelAdmin.setVisible(true);
        panelEstados.setVisible(false);
        panelEstadoReservas.setVisible(false);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPerfilActionPerformed
        EditarUsuario editarUsuario = new EditarUsuario();
        editarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editarUsuario.setVisible(true);
        editarUsuario.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEditarPerfilActionPerformed

    private void btnBorrarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPerfilActionPerformed
        BorrarUsuario borrarUsuario = new BorrarUsuario();
        borrarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        borrarUsuario.setVisible(true);
        borrarUsuario.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBorrarPerfilActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCrearHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearHabitacionActionPerformed
        CrearHabitacion crearHabitacion = new CrearHabitacion();
        crearHabitacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        crearHabitacion.setVisible(true);
        crearHabitacion.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCrearHabitacionActionPerformed

    private void btnBorrarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarHabitacionActionPerformed
        BorrarUsuario borrarUsuario = new BorrarUsuario("Eliminar habitacion", "Numero de la habitacion");
        borrarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        borrarUsuario.setVisible(true);
        borrarUsuario.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBorrarHabitacionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int op = JOptionPane.showConfirmDialog(this, "¿Estás seguro de guardar reserva?", "Confirmación", JOptionPane.YES_NO_OPTION);
        
        
        if (op == JOptionPane.YES_OPTION){
            Reserva reserva = new Reserva();
            LocalDate a = jdcEntrada.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            LocalDate b = jdcSalida.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            Habitacion habitacion;

            if ((int) ChronoUnit.DAYS.between(a, b) <= -1){
                JOptionPane.showMessageDialog(null, "Fecha de hospedaje inválida");
                return;
            }
            try {
                reserva.setNombreHuesped(txtNombre.getText());
                reserva.setApellidoHuesped(txtApellido.getText());
                reserva.setCedulaHuesped(txtCedula.getText());
                reserva.setNumeroPersonas(Integer.parseInt(txtNumeroPersonas.getText()));
                reserva.setNumeroHabitacion((String) comboHabitaciones.getSelectedItem());
                String num = (String)comboHabitaciones.getSelectedItem();
                reserva.setNoches((int)ChronoUnit.DAYS.between(a, b));
                reserva.setNumeroTelefono(txtTelefono.getText());
                reserva.setNochePrecio(Integer.parseInt(txtPrecioNoche.getText()));
                reserva.setFechaReservaEntrada(jdcEntrada.getDate());
                reserva.setFechaReservaSalida(jdcSalida.getDate());
                reserva.calcularReserva();
                reserva.calcularTotal();
                habitacion = controladoraPersistencia.findHabitacion(controladoraPersistencia.encontrarIdByNumeroPiso(num));
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Por favor verifique los datos correctamente, recuerde\nno usar carácteres especiales.");
                return;
            }
            txtNombre.setText("");
            txtApellido.setText("");
            txtCedula.setText("");
            txtNumeroPersonas.setText("");
            comboHabitaciones.setSelectedIndex(0);
            txtTelefono.setText("");
            txtPrecioNoche.setText("");
            controladoraPersistencia.agregarReserva(reserva);
            habitacion.hacerOcupado();
            try {
                controladoraPersistencia.editarHabitacion(habitacion);
            } catch (Exception ex) {

            }
            tableModel = (DefaultTableModel) tblRooms.getModel();
            tableModel.setRowCount(0);
            llenarDatos();
            comboHabitaciones();
            
            tableMod = (DefaultTableModel) tblReservasPersonas.getModel();
            tableMod.setRowCount(0);
            llenarDatosReservas();

            JOptionPane.showMessageDialog(null, "Reserva guardada correctamente.");
        } else {
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Reserva reserva = new Reserva();
        LocalDate a = jdcEntrada.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate b = jdcSalida.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        reserva.setNoches((int)ChronoUnit.DAYS.between(a, b));
        reserva.setNochePrecio(Integer.parseInt(txtPrecioNoche.getText()));
        reserva.setNumeroPersonas(Integer.parseInt(txtNumeroPersonas.getText()));
        reserva.calcularReserva();
        reserva.calcularTotal();
        lblPrecioTotal.setText(String.valueOf(reserva.getPrecioTotal()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tableModel = (DefaultTableModel) tblRooms.getModel();
        tableModel.setRowCount(0);
        llenarDatos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnEstadoReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoReservasActionPerformed
        panelReservas.setVisible(false);
        panelAdmin.setVisible(false);
        panelEstados.setVisible(false);
        panelEstadoReservas.setVisible(true);
    }//GEN-LAST:event_btnEstadoReservasActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        tableMod = (DefaultTableModel) tblReservasPersonas.getModel();
        tableMod.setRowCount(0);
        llenarDatosReservas();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int selectedRow = tblReservasPersonas.getSelectedRow();
        
        if (selectedRow != -1){
            Integer idReserva = controladoraPersistencia.encontrarReservaByCedula((String) tblReservasPersonas.getValueAt(selectedRow, 0));
                try {
                    ModificarReserva modificarReserva = new ModificarReserva(controladoraPersistencia.encontrarReservaById(idReserva));
                    modificarReserva.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    modificarReserva.setVisible(true);
                    modificarReserva.setLocationRelativeTo(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se encontró la reserva");
                }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una reserva");
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = tblReservasPersonas.getSelectedRow();
        if (selectedRow != -1){
            Integer idReserva = controladoraPersistencia.encontrarReservaByCedula((String) tblReservasPersonas.getValueAt(selectedRow, 0));
            try {
                Reserva res = controladoraPersistencia.encontrarReservaById(idReserva);
                int op = JOptionPane.showConfirmDialog(this, "¿Estás seguro de terminar la reserva de\n" + res.getNombreHuesped() + " " + res.getApellidoHuesped(), "Confirmación", JOptionPane.YES_NO_OPTION);
                if (op == JOptionPane.YES_OPTION){
                    controladoraPersistencia.eliminarReserva(idReserva);
                    TerminarReserva terminarReserva = new TerminarReserva(res);
                    terminarReserva.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    terminarReserva.setVisible(true);
                    terminarReserva.setLocationRelativeTo(null);
                    Habitacion hb = controladoraPersistencia.findHabitacion(controladoraPersistencia.encontrarIdByNumeroPiso(res.getNumeroHabitacion()));
                    hb.hacerAseo();
                    controladoraPersistencia.editarHabitacion(hb);
                    jButton5ActionPerformed(evt);
                    jButton4ActionPerformed(evt);
                    comboHabitaciones();
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Selecciona una reserva");
            }
                
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int selectedRow = tblRooms.getSelectedRow();
        System.out.println(selectedRow);
        if (selectedRow != -1){
            Habitacion hb = controladoraPersistencia.findHabitacion(controladoraPersistencia.encontrarIdByNumeroPiso((String) tblRooms.getValueAt(selectedRow, 0)));
            System.out.println(hb.getNumeroPiso());
            if (hb.getEstadoHabitacion().equals("Aseo")){
                List<Reserva> resList = controladoraPersistencia.encontrarReservas();
                for (Reserva res : resList){
                    if (res.getNumeroHabitacion().equals(hb.getNumeroPiso())){
                        hb.setEstadoHabitacion("Ocupado");
                        System.out.println(hb.getNumeroPiso());
                        try {
                            controladoraPersistencia.editarHabitacion(hb);
                            jButton4ActionPerformed(evt);
                            return;
                        } catch (Exception ex) {
                        }
                    }
                }
                hb.setEstadoHabitacion("Desocupado");
                try {
                    controladoraPersistencia.editarHabitacion(hb);
                    jButton4ActionPerformed(evt);
                } catch (Exception ex) {
                    
                }
            } else if (hb.getEstadoHabitacion().equals("Ocupado") || hb.getEstadoHabitacion().equals("Desocupado")) {
                hb.setEstadoHabitacion("Aseo");
                System.out.println(hb.getNumeroPiso());
                try {
                    controladoraPersistencia.editarHabitacion(hb);
                    jButton4ActionPerformed(evt);
                } catch (Exception ex) {
                }
            }
        }
        comboHabitaciones();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnEditarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarHabitacionActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Login login = new Login();
        dispose();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCerrarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnBorrarHabitacion;
    private javax.swing.JButton btnBorrarPerfil;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearHabitacion;
    private javax.swing.JButton btnEditarHabitacion;
    private javax.swing.JButton btnEditarPerfil;
    private javax.swing.JButton btnEstadoHabitaciones;
    private javax.swing.JButton btnEstadoReservas;
    private javax.swing.JButton btnRecuperarPerfil;
    private javax.swing.JButton btnReservas;
    private javax.swing.JComboBox<String> comboHabitaciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcEntrada;
    private com.toedter.calendar.JDateChooser jdcSalida;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContacto;
    private javax.swing.JLabel lblHabitacion;
    private javax.swing.JLabel lblHabitacion1;
    private javax.swing.JLabel lblHabitacion2;
    private javax.swing.JLabel lblHabitacion3;
    private javax.swing.JLabel lblHabitaciones;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroPersonas;
    private javax.swing.JLabel lblPerfiles;
    private javax.swing.JLabel lblPrecioNoche;
    private javax.swing.JLabel lblPrecioTotal;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelEstadoReservas;
    private javax.swing.JPanel panelEstados;
    private javax.swing.JPanel panelReservas;
    private javax.swing.JTable tblReservasPersonas;
    private javax.swing.JTable tblRooms;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroPersonas;
    private javax.swing.JTextField txtPrecioNoche;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    class DisponibilidadCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            // Llamada al método padre para realizar inicializaciones
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Obtener el valor de la celda en la columna "disponible"
            String disponibilidad = (String) value;
            
            LocalDate fa = LocalDate.now();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            

            // Establecer el color de fondo según la disponibilidad
            if ("Desocupado".equals(disponibilidad)) {
                setBackground(Color.GREEN);
            } else if ("Termina hoy".equals(disponibilidad)) {
                setBackground(Color.RED);
            } else if ("Aseo".equals(disponibilidad)){
                setBackground(Color.CYAN);
            } else if ("Expiró".equals(disponibilidad)){
                setBackground(Color.GRAY);
            }
            
            else {
                setBackground(Color.ORANGE);
            }

            // Devolver el componente renderizado
            return this;
        }
    }
}
