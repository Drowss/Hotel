[33mcommit 6ae51d8793d4c35f5f0f615080203e1bc952aa68[m[33m ([m[1;36mHEAD -> [m[1;32mhpp[m[33m, [m[1;31morigin/hpp[m[33m)[m
Author: Drow <esneiderhel@gmail.com>
Date:   Thu Nov 30 17:51:49 2023 -0500

    prefinal-commit

[1mdiff --git a/src/main/java/com/mycompany/hostexpanse2/gui/MenuPrincipal.form b/src/main/java/com/mycompany/hostexpanse2/gui/MenuPrincipal.form[m
[1mindex d0e32d9..2e969df 100644[m
[1m--- a/src/main/java/com/mycompany/hostexpanse2/gui/MenuPrincipal.form[m
[1m+++ b/src/main/java/com/mycompany/hostexpanse2/gui/MenuPrincipal.form[m
[36m@@ -146,6 +146,93 @@[m
         <Property name="useNullLayout" type="boolean" value="false"/>[m
       </Layout>[m
       <SubComponents>[m
[32m+[m[32m        <Container class="javax.swing.JPanel" name="panelEstados">[m
[32m+[m[32m          <Properties>[m
[32m+[m[32m            <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">[m
[32m+[m[32m              <Color blue="f7" green="fa" red="fe" type="rgb"/>[m
[32m+[m[32m            </Property>[m
[32m+[m[32m          </Properties>[m
[32m+[m[32m          <Constraints>[m
[32m+[m[32m            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout" value="org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout$AbsoluteConstraintsDescription">[m
[32m+[m[32m              <AbsoluteConstraints x="20" y="20" width="630" height="530"/>[m
[32m+[m[32m            </Constraint>[m
[32m+[m[32m          </Constraints>[m
[32m+[m
[32m+[m[32m          <Layout>[m
[32m+[m[32m            <DimensionLayout dim="0">[m
[32m+[m[32m              <Group type="103" groupAlignment="0" attributes="0">[m
[32m+[m[32m                  <Group type="102" alignment="0" attributes="0">[m
[32m+[m[32m                      <Group type="103" groupAlignment="1" attributes="0">[m
[32m+[m[32m                          <Group type="102" alignment="1" attributes="0">[m
[32m+[m[32m                              <EmptySpace max="-2" attributes="0"/>[m
[32m+[m[32m                              <Component id="jButton7" min="-2" pref="133" max="-2" attributes="0"/>[m
[32m+[m[32m                              <EmptySpace type="separate" max="-2" attributes="0"/>[m
[32m+[m[32m                              <Component id="jButton4" min="-2" pref="133" max="-2" attributes="0"/>[m
[32m+[m[32m                          </Group>[m
[32m+[m[32m                          <Group type="102" alignment="0" attributes="0">[m
[32m+[m[32m                              <EmptySpace min="-2" pref="23" max="-2" attributes="0"/>[m
[32m+[m[32m                              <Component id="jScrollPane1" min="-2" pref="566" max="-2" attributes="0"/>[m
[32m+[m[32m                          </Group>[m
[32m+[m[32m                      </Group>[m
[32m+[m[32m                      <EmptySpace pref="41" max="32767" attributes="0"/>[m
[32m+[m[32m                  </Group>[m
[32m+[m[32m              </Group>[m
[32m+[m[32m            </DimensionLayout>[m
[32m+[m[32m            <DimensionLayout dim="1">[m
[32m+[m[32m              <Group type="103" groupAlignment="0" attributes="0">[m
[32m+[m[32m                  <Group type="102" alignment="0" attributes="0">[m
[32m+[m[32m                      <EmptySpace min="-2" pref="20" max="-2" attributes="0"/>[m
[32m+[m[32m                      <Component id="jScrollPane1" min="-2" max="-2" attributes="0"/>[m
[32m+[m[32m                      <EmptySpace type="unrelated" max="-2" attributes="0"/>[m
[32m+[m[32m                      <Group type="103" groupAlignment="3" attributes="0">[m
[32m+[m[32m                          <Component id="jButton4" alignment="3" min="-2" pref="51" max="-2" attributes="0"/>[m
[32m+[m[32m                          <Component id="jButton7" alignment="3" min="-2" pref="51" max="-2" attributes="0"/>[m
[32m+[m[32m                      </Group>[m
[32m+[m[32m                      <EmptySpace pref="20" max="32767" attributes="0"/>[m
[32m+[m[32m                  </Group>[m
[32m+[m[32m              </Group>[m
[32m+[m[32m            </DimensionLayout>[m
[32m+[m[32m          </Layout>[m
[32m+[m[32m          <SubComponents>[m
[32m+[m[32m            <Container class="javax.swing.JScrollPane" name="jScrollPane1">[m
[32m+[m[32m              <AuxValues>[m
[32m+[m[32m                <AuxValue name="autoScrollPane" type="java.lang.Boolean" value="true"/>[m
[32m+[m[32m              </AuxValues>[m
[32m+[m
[32m+[m[32m              <Layout class="org.netbeans.modules.form.compat2.layouts.support.JScrollPaneSupportLayout"/>[m
[32m+[m[32m              <SubComponents>[m
[32m+[m[32m                <Component class="javax.swing.JTable" name="tblRooms">[m
[32m+[m[32m                  <Properties>[m
[32m+[m[32m                    <Property name="model" type="javax.swing.table.TableModel" editor="org.netbeans.modules.form.editors2.TableModelEditor">[m
[32m+[m[32m                      <Table columnCount="4" rowCount="4">[m
[32m+[m[32m                        <Column editable="true" title="Title 1" type="java.lang.Object"/>[m
[32m+[m[32m                        <Column editable="true" title="Title 2" type="java.lang.Object"/>[m
[32m+[m[32m                        <Column editable="true" title="Title 3" type="java.lang.Object"/>[m
[32m+[m[32m                        <Column editable="true" title="Title 4" type="java.lang.Object"/>[m
[32m+[m[32m                      </Table>[m
[32m+[m[32m                    </Property>[m
[32m+[m[32m                  </Properties>[m
[32m+[m[32m                </Component>[m
[32m+[m[32m              </SubComponents>[m
[32m+[m[32m            </Container>[m
[32m+[m[32m            <Component class="javax.swing.JButton" name="jButton4">[m
[32m+[m[32m              <Properties>[m
[32m+[m[32m                <Property name="text" type="java.lang.String" value="Actualizar"/>[m
[32m+[m[32m              </Properties>[m
[32m+[m[32m              <Events>[m
[32m+[m[32m                <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="jButton4ActionPerformed"/>[m
[32m+[m[32m              </Events>[m
[32m+[m[32m            </Component>[m
[32m+[m[32m            <Component class="javax.swing.JButton" name="jButton7">[m
[32m+[m[32m              <Properties>[m
[32m+[m[32m                <Property name="text" type="java.lang.String" value="Cambiar aseo"/>[m
[32m+[m[32m              </Properties>[m
[32m+[m[32m              <Events>[m
[32m+[m[32m                <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="jButton7ActionPerformed"/>[m
[32m+[m[32m              </Events>[m
[32m+[m[32m            </Component>[m
[32m+[m[32m          </SubComponents>[m
[32m+[m[32m        </Container>[m
         <Container class="javax.swing.JPanel" name="panelEstadoReservas">[m
           <Properties>[m
             <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">[m
[36m@@ -576,80 +663,6 @@[m
             </Component>[m
           </SubComponents>[m
         </Container>[m
[31m-        <Container class="javax.swing.JPanel" name="panelEstados">[m
[31m-          <Properties>[m
[31m-            <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">[m
[31m-              <Color blue="f7" green="fa" red="fe" type="rgb"/>[m
[31m-            </Property>[m
[31m-          </Properties>[m
[31m-          <Constraints>[m
[31m-            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout" value="org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout$AbsoluteConstraintsDescription">[m
[31m-              <AbsoluteConstraints x="20" y="20" width="630" height="530"/>[m
[31m-            </Constraint>[m
[31m-          </Constraints>[m
[31m-[m
[31m-          <Layout>[m
[31m-            <DimensionLayout dim="0">[m
[31m-              <Group type="103" groupAlignment="0" attributes="0">[m
[31m-                  <Group type="102" alignment="0" attributes="0">[m
[31m-                      <Group type="103" groupAlignment="1" attributes="0">[m
[31m-                          <Group type="102" alignment="1" attributes="0">[m
[31m-                              <EmptySpace max="-2" attributes="0"/>[m
[31m-                              <Component id="jButton4" min="-2" pref="133" max="-2" attributes="0"/>[m
[31m-                          </Group>[m
[31m-                          <Group type="102" alignment="0" attributes="0">[m
[31m-                              <EmptySpace min="-2" pref="23" max="-2" attributes="0"/>[m
[31m-                              <Component id="jScrollPane1" min="-2" pref="566" max="-2" attributes="0"/>[m
[31m-                          </Group>[m
[31m-                      </Group>[m
[31m-                      <EmptySpace pref="41" max="32767" attributes="0"/>[m
[31m-                  </Group>[m
[31m-              </Group>[m
[31m-            </DimensionLayout>[m
[31m-            <DimensionLayout dim="1">[m
[31m-              <Group type="103" groupAlignment="0" attributes="0">[m
[31m-                  <Group type="102" alignment="0" attributes="0">[m
[31m-                      <EmptySpace min="-2" pref="20" max="-2" attributes="0"/>[m
[31m-                      <Component id="jScrollPane1" min="-2" max="-2" attributes="0"/>[m
[31m-                      <EmptySpace type="unrelated" max="-2" attributes="0"/>[m
[31m-                      <Component id="jButton4" min="-2" pref="51" max="-2" attributes="0"/>[m
[31m-                      <EmptySpace pref="20" max="32767" attributes="0"/>[m
[31m-                  </Group>[m
[31m-              </Group>[m
[31m-            </DimensionLayout>[m
[31m-          </Layout>[m
[31m-          <SubComponents>[m
[31m-            <Container class="javax.swing.JScrollPane" name="jScrollPane1">[m
[31m-              <AuxValues>[m
[31m-                <AuxValue name="autoScrollPane" type="java.lang.Boolean" value="true"/>[m
[31m-              </AuxValues>[m
[31m-[m
[31m-              <Layout class="org.netbeans.modules.form.compat2.layouts.support.JScrollPaneSupportLayout"/>[m
[31m-              <SubComponents>[m
[31m-                <Component class="javax.swing.JTable" name="tblRooms">[m
[31m-                  <Properties>[m
[31m-                    <Property name="model" type="javax.swing.table.TableModel" editor="org.netbeans.modules.form.editors2.TableModelEditor">[m
[31m-                      <Table columnCount="4" rowCount="4">[m
[31m-                        <Column editable="true" title="Title 1" type="java.lang.Object"/>[m
[31m-                        <Column editable="true" title="Title 2" type="java.lang.Object"/>[m
[31m-                        <Column editable="true" title="Title 3" type="java.lang.Object"/>[m
[31m-                        <Column editable="true" title="Title 4" type="java.lang.Object"/>[m
[31m-                      </Table>[m
[31m-                    </Property>[m
[31m-                  </Properties>[m
[31m-                </Component>[m
[31m-              </SubComponents>[m
[31m-            </Container>[m
[31m-            <Component class="javax.swing.JButton" name="jButton4">[m
[31m-              <Properties>[m
[31m-                <Property name="text" type="java.lang.String" value="Actualizar"/>[m
[31m-              </Properties>[m
[31m-              <Events>[m
[31m-                <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="jButton4ActionPerformed"/>[m
[31m-              </Events>[m
[31m-            </Component>[m
[31m-          </SubComponents>[m
[31m-        </Container>[m
         <Container class="javax.swing.JPanel" name="panelAdmin">[m
           <Properties>[m
             <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">[m
[1mdiff --git a/src/main/java/com/mycompany/hostexpanse2/gui/MenuPrincipal.java b/src/main/java/com/mycompany/hostexpanse2/gui/MenuPrincipal.java[m
[1mindex d67e117..efa0917 100644[m
[1m--- a/src/main/java/com/mycompany/hostexpanse2/gui/MenuPrincipal.java[m
[1m+++ b/src/main/java/com/mycompany/hostexpanse2/gui/MenuPrincipal.java[m
[36m@@ -91,9 +91,16 @@[m [mpublic class MenuPrincipal extends javax.swing.JFrame {[m
     [m
     public void llenarDatos(){[m
         List<Habitacion> habitaciones = controladoraPersistencia.encontrarHabitaciones();[m
[31m-        [m
[32m+[m[32m        String dispo = "";[m
         for (Habitacion habitacion : habitaciones){[m
[31m-            String dispo = habitacion.getEstadoHabitacion().equals("Desocupado") ? "Desocupado" : "Ocupado";[m
[32m+[m[32m            if (habitacion.getEstadoHabitacion().equals("Desocupado")){[m
[32m+[m[32m                dispo = "Desocupado";[m
[32m+[m[32m            } else if (habitacion.getEstadoHabitacion().equals("Ocupado")){[m
[32m+[m[32m                dispo = "Ocupado";[m
[32m+[m[32m            } else if (habitacion.getEstadoHabitacion().equals("Aseo")){[m
[32m+[m[32m                dispo = "Aseo";[m
[32m+[m[32m            }[m
[32m+[m[32m//            String dispo = habitacion.getEstadoHabitacion().equals("Desocupado") ? "Desocupado" : "Ocupado";[m
             TableColumn tableColumn = tblRooms.getColumn("Disponibilidad");[m
             tableColumn.setCellRenderer(new DisponibilidadCellRenderer());[m
             Object[] rowData = {habitacion.getNumeroPiso(), habitacion.getCantidadCamas(), dispo};[m
[36m@@ -153,6 +160,11 @@[m [mpublic class MenuPrincipal extends javax.swing.JFrame {[m
         btnAdmin = new javax.swing.JButton();[m
         btnEstadoReservas = new javax.swing.JButton();[m
         jPanel2 = new javax.swing.JPanel();[m
[32m+[m[32m        panelEstados = new javax.swing.JPanel();[m
[32m+[m[32m        jScrollPane1 = new javax.swing.JScrollPane();[m
[32m+[m[32m        tblRooms = new javax.swing.JTable();[m
[32m+[m[32m        jButton4 = new javax.swing.JButton();[m
[32m+[m[32m        jButton7 = new javax.swing.JButton();[m
         panelEstadoReservas = new javax.swing.JPanel();[m
         jScrollPane2 = new javax.swing.JScrollPane();[m
         tblReservasPersonas = new javax.swing.JTable();[m
[36m@@ -183,10 +195,6 @@[m [mpublic class MenuPrincipal extends javax.swing.JFrame {[m
         lblHabitacion3 = new javax.swing.JLabel();[m
         lblPrecioTotal = new javax.swing.JLabel();[m
         jButton2 = new javax.swing.JButton();[m
[31m-        panelEstados = new javax.swing.JPanel();[m
[31m-        jScrollPane1 = new javax.swing.JScrollPane();[m
[31m-        tblRooms = new javax.swing.JTable();[m
[31m-        jButton4 = new javax.swing.JButton();[m
         panelAdmin = new javax.swing.JPanel();[m
         lblHabitaciones = new javax.swing.JLabel();[m
         btnCrearHabitacion = new javax.swing.JButton();[m
[36m@@ -272,6 +280,65 @@[m [mpublic class MenuPrincipal extends javax.swing.JFrame {[m
         jPanel2.setBackground(new java.awt.Color(254, 250, 247));[m
         jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());[m
 [m
[32m+[m[32m        panelEstados.setBackground(new java.awt.Color(254, 250, 247));[m
[32m+[m
[32m+[m[32m        tblRooms.setModel(new javax.swing.table.DefaultTableModel([m
[32m+[m[32m            new Object [][] {[m
[32m+[m[32m                {null, null, null, null},[m
[32m+[m[32m                {null, null, null, null},[m
[32m+[m[32m                {null, null, null, null},[m
[32m+[m[32m                {null, null, null, null}[m
[32m+[m[32m            },[m
[32m+[m[32m            new String [] {[m
[32m+[m[32m                "Title 1", "Title 2", "Title 3", "Title 4"[m
[32m+[m[32m            }[m
[32m+[m[32m        ));[m
[32m+[m[32m        jScrollPane1.setViewportView(tblRooms);[m
[32m+[m
[32m+[m[32m        jButton4.setText("Actualizar");[m
[32m+[m[32m        jButton4.addActionListener(new java.awt.event.ActionListener() {[m
[32m+[m[32m            public void actionPerformed(java.awt.event.ActionEvent evt) {[m
[32m+[m[32m                jButton4ActionPerformed(evt);[m
[32m+[m[32m            }[m
[32m+[m[32m        });[m
[32m+[m
[32m+[m[32m        jButton7.setText("Cambiar aseo");[m
[32m+[m[32m        jButton7.addActionListener(new java.awt.event.ActionListener() {[m
[32m+[m[32m            public void actionPerformed(java.awt.event.ActionEvent evt) {[m
[32m+[m[32m                jButton7ActionPerformed(evt);[m
[32m+[m[32m            }[m
[32m+[m[32m        });[m
[32m+[m
[32m+[m[32m        javax.swing.GroupLayout panelEstadosLayout = new javax.swing.GroupLayout(panelEstados);[m
[32m+[m[32m        panelEstados.setLayout(panelEstadosLayout);[m
[32m+[m[32m        panelEstadosLayout.setHorizontalGroup([m
[32m+[m[32m            panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)[m
[32m+[m[32m            .addGroup(panelEstadosLayout.createSequentialGroup()[m
[32m+[m[32m                .addGroup(panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)[m
[32m+[m[32m                    .addGroup(panelEstadosLayout.createSequentialGroup()[m
[32m+[m[32m                        .addContainerGap()[m
[32m+[m[32m                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)[m
[32m+[m[32m                        .addGap(18, 18, 18)[m
[32m+[m[32m                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))[m
[32m+[m[32m                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEstadosLayout.createSequentialGroup()[m
[32m+[m[32m                        .addGap(23, 23, 23)[m
[32m+[m[32m                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))[m
[32m+[m[32m                .addContainerGap(41, Short.MAX_VALUE))[m
[32m+[m[32m        );[m
[32m+[m[32m        panelEstadosLayout.setVerticalGroup([m
[32m+[m[32m            panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)[m
[32m+[m[32m            .addGroup(panelEstadosLayout.createSequentialGroup()[m
[32m+[m[32m                .addGap(20, 20, 20)[m
[32m+[m[32m                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)[m
[32m+[m[32m                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)[m
[32m+[m[32m                .addGroup(panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)[m
[32m+[m[32m                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)[m
[32m+[m[32m                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))[m
[32m+[m[32m                .addContainerGap(20, Short.MAX_VALUE))[m
[32m+[m[32m        );[m
[32m+[m
[32m+[m[32m        jPanel2.add(panelEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 630, 530));[m
[32m+[m
         panelEstadoReservas.setBackground(new java.awt.Color(254, 250, 247));[m
 [m
         tblReservasPersonas.setModel(new javax.swing.table.DefaultTableModel([m
[36m@@ -525,54 +592,6 @@[m [mpublic class MenuPrincipal extends javax.swing.JFrame {[m
 [m
         jPanel2.add(panelReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 630, 530));[m
 [m
[31m-        panelEstados.setBackground(new java.awt.Color(254, 250, 247));[m
[31m-[m
[31m-        tblRooms.setModel(new javax.swing.table.DefaultTableModel([m
[31m-            new Object [][] {[m
[31m-                {null, null, null, null},[m
[31m-                {null, null, null, null},[m
[31m-                {null, null, null, null},[m
[31m-                {null, null, null, null}[m
[31m-            },[m
[31m-            new String [] {[m
[31m-                "Title 1", "Title 2", "Title 3", "Title 4"[m
[31m-            }[m
[31m-        ));[m
[31m-        jScrollPane1.setViewportView(tblRooms);[m
[31m-[m
[31m-        jButton4.setText("Actualizar");[m
[31m-        jButton4.addActionListener(new java.awt.event.ActionListener() {[m
[31m-            public void actionPerformed(java.awt.event.ActionEvent evt) {[m
[31m-                jButton4ActionPerformed(evt);[m
[31m-            }[m
[31m-        });[m
[31m-[m
[31m-        javax.swing.GroupLayout panelEstadosLayout = new javax.swing.GroupLayout(panelEstados);[m
[31m-        panelEstados.setLayout(panelEstadosLayout);[m
[31m-        panelEstadosLayout.setHorizontalGroup([m
[31m-            panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)[m
[31m-            .addGroup(panelEstadosLayout.createSequentialGroup()[m
[31m-                .addGroup(panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)[m
[31m-                    .addGroup(panelEstadosLayout.createSequentialGroup()[m
[31m-                        .addContainerGap()[m
[31m-                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))[m
[31m-                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEstadosLayout.createSequentialGroup()[m
[31m-                        .addGap(23, 23, 23)[m
[31m-                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))[m
[31m-                .addContainerGap(41, Short.MAX_VALUE))[m
[31m-        );[m
[31m-        panelEstadosLayout.setVerticalGroup([m
[31m-            panelEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)[m
[31m-            .addGroup(panelEstadosLayout.createSequentialGroup()[m
[31m-                .addGap(20, 20, 20)[m
[31m-                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)[m
[31m-                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)[m
[31m-                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)[m
[31m-                .addContainerGap(20, Short.MAX_VALUE))[m
[31m-        );[m
[31m-[m
[31m-        jPanel2.add(panelEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 630, 530));[m
[31m-[m
         panelAdmin.setBackground(new java.awt.Color(254, 250, 247));[m
 [m
         lblHabitaciones.setText("Gestionar habitaciones");[m
[36m@@ -862,7 +881,7 @@[m [mpublic class MenuPrincipal extends javax.swing.JFrame {[m
                     terminarReserva.setVisible(true);[m
                     terminarReserva.setLocationRelativeTo(null);[m
                     Habitacion hb = controladoraPersistencia.findHabitacion(controladoraPersistencia.encontrarIdByNumeroPiso(res.getNumeroHabitacion()));[m
[31m-                    hb.hacerDesocupado();[m
[32m+[m[32m                    hb.hacerAseo();[m
                     controladoraPersistencia.editarHabitacion(hb);[m
                     jButton5ActionPerformed(evt);[m
                     jButton4ActionPerformed(evt);[m
[36m@@ -874,6 +893,45 @@[m [mpublic class MenuPrincipal extends javax.swing.JFrame {[m
         }[m
     }//GEN-LAST:event_jButton3ActionPerformed[m
 [m
[32m+[m[32m    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed[m
[32m+[m[32m        int selectedRow = tblRooms.getSelectedRow();[m
[32m+[m[32m        System.out.println(selectedRow);[m
[32m+[m[32m        if (selectedRow != -1){[m
[32m+[m[32m            Habitacion hb = controladoraPersistencia.findHabitacion(controladoraPersistencia.encontrarIdByNumeroPiso((String) tblRooms.getValueAt(selectedRow, 0)));[m
[32m+[m[32m            System.out.println(hb.getNumeroPiso());[m
[32m+[m[32m            if (hb.getEstadoHabitacion().equals("Aseo")){[m
[32m+[m[32m                List<Reserva> resList = controladoraPersistencia.encontrarReservas();[m
[32m+[m[32m                for (Reserva res : resList){[m
[32m+[m[32m                    if (res.getNumeroHabitacion().equals(hb.getNumeroPiso())){[m
[32m+[m[32m                        hb.setEstadoHabitacion("Ocupado");[m
[32m+[m[32m                        System.out.println(hb.getNumeroPiso());[m
[32m+[m[32m                        try {[m
[32m+[m[32m                            controladoraPersistencia.editarHabitacion(hb);[m
[32m+[m[32m                            jButton4ActionPerformed(evt);[m
[32m+[m[32m                            return;[m
[32m+[m[32m                        } catch (Exception ex) {[m
[32m+[m[32m                        }[m
[32m+[m[32m                    }[m
[32m+[m[32m                }[m
[32m+[m[32m                hb.setEstadoHabitacion("Desocupado");[m
[32m+[m[32m                try {[m
[32m+[m[32m                    controladoraPersistencia.editarHabitacion(hb);[m
[32m+[m[32m                    jButton4ActionPerformed(evt);[m
[32m+[m[32m                } catch (Exception ex) {[m
[32m+[m[41m                    [m
[32m+[m[32m                }[m
[32m+[m[32m            } else if (hb.getEstadoHabitacion().equals("Ocupado") || hb.getEstadoHabitacion().equals("Desocupado")) {[m
[32m+[m[32m                hb.setEstadoHabitacion("Aseo");[m
[32m+[m[32m                System.out.println(hb.getNumeroPiso());[m
[32m+[m[32m                try {[m
[32m+[m[32m                    controladoraPersistencia.editarHabitacion(hb);[m
[32m+[m[32m                    jButton4ActionPerformed(evt);[m
[32m+[m[32m                } catch (Exception ex) {[m
[32m+[m[32m                }[m
[32m+[m[32m            }[m
[32m+[m[32m        }[m
[32m+[m[32m    }//GEN-LAST:event_jButton7ActionPerformed[m
[32m+[m
     [m
 [m
     // Variables declaration - do not modify//GEN-BEGIN:variables[m
[36m@@ -894,6 +952,7 @@[m [mpublic class MenuPrincipal extends javax.swing.JFrame {[m
     private javax.swing.JButton jButton4;[m
     private javax.swing.JButton jButton5;[m
     private javax.swing.JButton jButton6;[m
[32m+[m[32m    private javax.swing.JButton jButton7;[m
     private javax.swing.JLabel jLabel1;[m
     private javax.swing.JLabel jLabel2;[m
     private javax.swing.JPanel jPanel1;[m
[36m@@ -949,6 +1008,8 @@[m [mpublic class MenuPrincipal extends javax.swing.JFrame {[m
                 setBackground(Color.GREEN);[m
             } else if ("Termina hoy".equals(disponibilidad)) {[m
                 setBackground(Color.RED);[m
[32m+[m[32m            } else if ("Aseo".equals(disponibilidad)){[m
[32m+[m[32m                setBackground(Color.CYAN);[m
             }[m
             [m
             else {[m
[1mdiff --git a/src/main/java/com/mycompany/hostexpanse2/model/Habitacion.java b/src/main/java/com/mycompany/hostexpanse2/model/Habitacion.java[m
[1mindex 3e70f21..125a97b 100644[m
[1m--- a/src/main/java/com/mycompany/hostexpanse2/model/Habitacion.java[m
[1m+++ b/src/main/java/com/mycompany/hostexpanse2/model/Habitacion.java[m
[36m@@ -29,4 +29,8 @@[m [mpublic class Habitacion implements Serializable {[m
         this.estadoHabitacion = "Desocupado";[m
     }[m
     [m
[32m+[m[32m    public void hacerAseo(){[m
[32m+[m[32m        this.estadoHabitacion = "Aseo";[m
[32m+[m[32m    }[m
[32m+[m[41m    [m
 }[m
[1mdiff --git a/target/classes/com/mycompany/hostexp