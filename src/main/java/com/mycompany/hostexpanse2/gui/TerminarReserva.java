/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hostexpanse2.gui;

import com.mycompany.hostexpanse2.model.Reserva;

/**
 *
 * @author Drow
 */
public class TerminarReserva extends javax.swing.JFrame {

    Reserva res;
    public TerminarReserva(Reserva reserva) {
        initComponents();
        this.res = reserva;
        llenarDatos();
    }

    public void llenarDatos(){
        lblNomb.setText(res.getNombreHuesped() + " " + res.getApellidoHuesped());
        lblCed.setText(res.getCedulaHuesped());
        lblContact.setText(res.getNumeroTelefono());
        lblRoom.setText(res.getNumeroHabitacion());
        lblPreTo.setText(String.valueOf(res.getPrecioTotal()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblHabitacion = new javax.swing.JLabel();
        lblContacto = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        lblHabitacion1 = new javax.swing.JLabel();
        lblNomb = new javax.swing.JLabel();
        lblRoom = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        lblCed = new javax.swing.JLabel();
        lblPreTo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 250, 247));

        lblNombre.setBackground(new java.awt.Color(254, 250, 247));
        lblNombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblNombre.setText("*Nombre:");

        lblCedula.setBackground(new java.awt.Color(254, 250, 247));
        lblCedula.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblCedula.setText("*Cedúla:");

        lblHabitacion.setBackground(new java.awt.Color(254, 250, 247));
        lblHabitacion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblHabitacion.setText("*Habitación:");

        lblContacto.setBackground(new java.awt.Color(254, 250, 247));
        lblContacto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblContacto.setText("*Precio total:");

        lblApellido1.setBackground(new java.awt.Color(254, 250, 247));
        lblApellido1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblApellido1.setText("Terminar reserva");

        lblHabitacion1.setBackground(new java.awt.Color(254, 250, 247));
        lblHabitacion1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblHabitacion1.setText("*Contacto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(lblApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblHabitacion)
                    .addComponent(lblHabitacion1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContact, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPreTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblApellido1)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblCedula)
                    .addComponent(lblNomb)
                    .addComponent(lblCed))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHabitacion)
                    .addComponent(lblContacto)
                    .addComponent(lblRoom)
                    .addComponent(lblPreTo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHabitacion1)
                    .addComponent(lblContact))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblCed;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblContacto;
    private javax.swing.JLabel lblHabitacion;
    private javax.swing.JLabel lblHabitacion1;
    private javax.swing.JLabel lblNomb;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPreTo;
    private javax.swing.JLabel lblRoom;
    // End of variables declaration//GEN-END:variables
}
