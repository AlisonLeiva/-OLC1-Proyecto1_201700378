package proyecto1;

import Recorridos.*;
import UFE.Componente;
import analizadores.*;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Point;
import java.awt.TextField;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * @author AlisonLeiva
 */
public class Frame extends javax.swing.JFrame {

    public static String nombre_proyecto;
    LinkedList<Ruta> rutas = new LinkedList<>();
    int i = 1, contadorTab = 1;
    int contador = 0;
    public Frame() {
        initComponents();
        txtEntrada.setLineWrap(true);
        txtSalida.setWrapStyleWord(true);
        txtEntrada.setLineWrap(true);
        txtSalida.setWrapStyleWord(true);
        nombre_proyecto = "UFEprojects\\" + txtname.getText();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        TabbedPane = new javax.swing.JTabbedPane();
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        txtname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        txtarchivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CrearArchivo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        Abrir = new javax.swing.JMenu();
        Guardar = new javax.swing.JMenu();
        GuardarComo = new javax.swing.JMenu();
        Reportes = new javax.swing.JMenu();
        Analizar = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar3.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setLocation(new java.awt.Point(150, 25));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/banner.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        txtEntrada.setColumns(20);
        txtEntrada.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        txtEntrada.setRows(5);
        txtEntrada.setText("\t\t\n\t\t\n\t\t\n         U S A C   F R O N T   E N D                  ");
        txtEntrada.setEnabled(false);
        jScrollPane1.setViewportView(txtEntrada);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Nuevo", panel);

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Crear Proyecto");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Archivo Nuevo");

        txtarchivo.setForeground(new java.awt.Color(102, 102, 102));
        txtarchivo.setText(".css / .ufe");
        txtarchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtarchivoActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Nombre Proyecto");

        CrearArchivo.setForeground(new java.awt.Color(153, 153, 153));
        CrearArchivo.setText("Crear Archivo");
        CrearArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearArchivoMouseClicked(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtSalida.setBackground(new java.awt.Color(153, 153, 153));
        txtSalida.setColumns(20);
        txtSalida.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtSalida.setForeground(new java.awt.Color(255, 255, 255));
        txtSalida.setLineWrap(true);
        txtSalida.setRows(5);
        jScrollPane2.setViewportView(txtSalida);

        jTabbedPane1.addTab("Consola", jScrollPane2);

        Abrir.setText("Abrir");
        Abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbrirMouseClicked(evt);
            }
        });
        jMenuBar1.add(Abrir);

        Guardar.setText("| Guardar");
        Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarMouseClicked(evt);
            }
        });
        jMenuBar1.add(Guardar);

        GuardarComo.setText("| Guardar Como");
        GuardarComo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarComoMouseClicked(evt);
            }
        });
        jMenuBar1.add(GuardarComo);

        Reportes.setText("|Reporte");
        jMenuBar1.add(Reportes);

        Analizar.setText("| Analizar");
        Analizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnalizarMouseClicked(evt);
            }
        });
        jMenuBar1.add(Analizar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtarchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(CrearArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtarchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrearArchivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Consola");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbrirMouseClicked
        AbrirArchivo();
    }//GEN-LAST:event_AbrirMouseClicked

    private void GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseClicked
        try {
            GuardarArchivo(null);
            JOptionPane.showMessageDialog(null, "Se guardaron los cambios exitosamente");
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GuardarMouseClicked

    private void GuardarComoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarComoMouseClicked
        GuardarArchivoComo();
        JOptionPane.showMessageDialog(null, "Se guardaron los cambios exitosamente");

    }//GEN-LAST:event_GuardarComoMouseClicked

    private void AnalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnalizarMouseClicked
        CSS.CSS.estilos.clear();
        HTML.HTML.listaId.clear();
        Componente.listaComponentes.clear();
        analizadores.parserHTML s;
        try {
            LexicoHTML lexico = new analizadores.LexicoHTML(new FileInputStream(nombre_proyecto + "\\public\\index.html"));
            s = new analizadores.parserHTML(lexico);
            s.parse();
        } catch (Exception ex) {
            System.out.println("NO ENTRO HTML");
        }

        Nodo raiz = null;
        PrimerRecorrido primer_rec = new PrimerRecorrido();
        SegundoRecorrido segundo_rec = new SegundoRecorrido();
        TercerRecorrido tercer_rec = new TercerRecorrido();
        Entorno global = new Entorno(null);

        try {
            LexicoUFE lexico = new LexicoUFE(new BufferedReader(new StringReader(getJTextArea().getText())));
            parserUFE sintactico = new parserUFE(lexico);
            sintactico.parse();
            raiz = sintactico.raiz;
           // graficar(raiz);
        } catch (Exception ex) {
            System.out.println("NO ENTRO UFE");
        }
        global = primer_rec.Ejecutar(raiz, global);
        global = segundo_rec.Ejecutar(raiz, global);
        tercer_rec.Ejecutar(raiz, global);
        txtSalida.setText(TercerRecorrido.ResultadoConsola);
        TercerRecorrido.ResultadoConsola = "";
        if (!Reporte.ReporteErrores.isEmpty()) {
            GenerarReporteErrores(Reporte.ReporteErrores);
            OpenFile("ReporteErrores.html");
            Reporte.ReporteErrores.clear();
        }


    }//GEN-LAST:event_AnalizarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        nombre_proyecto = "UFEprojects\\" + txtname.getText();
        CrearCarpeta("UFEprojects");
        CrearCarpeta(nombre_proyecto);
        CrearCarpeta(nombre_proyecto + "\\src");
        CrearCarpeta(nombre_proyecto + "\\public");
        try {
            CrearArchivo(nombre_proyecto + "\\public\\index.html", "BIENVENIDO!! 201700378");
            CrearArchivo(nombre_proyecto + "\\src\\App.css", "");
            CrearArchivo(nombre_proyecto + "\\src\\App.ufe", "");
            LeerArchivo(new File(nombre_proyecto + "\\public\\index.html"));
            LeerArchivo(new File(nombre_proyecto + "\\src\\App.css"));
            LeerArchivo(new File(nombre_proyecto + "\\src\\App.ufe"));
            JOptionPane.showMessageDialog(null, "Proyecto " + nombre_proyecto + " creado exitosamente!");

        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void CrearArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearArchivoMouseClicked
        File archivo = GuardarArchivoComo();
        AddTab(archivo, txtarchivo.getText());
    }//GEN-LAST:event_CrearArchivoMouseClicked

    private void txtarchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtarchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtarchivoActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // nombre_proyecto = txtname.getText();
    }//GEN-LAST:event_txtnameActionPerformed

    private void CrearCarpeta(String nombre) {
        File proyecto = new File(nombre);
        proyecto.mkdir();
    }

    private void CrearArchivo(String ruta, String contenido) throws IOException {
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (!archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(contenido);
            bw.close();
        }
    }

    private JTextArea getJTextArea() {
        return (JTextArea) TabbedPane.getComponent(TabbedPane.getSelectedIndex()).getComponentAt(10, 10).getComponentAt(10, 10).getComponentAt(10, 10);
    }

    public void OpenFile(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void GenerarReporteErrores(LinkedList<Reporte> errores) {
        FileOutputStream archivo;
        PrintStream p;
        String codigoHtml;
        codigoHtml = "<html>"
                + "<body>" + "<h1 align='center' bgcolor='#B6F4FB'> <FONT FACE='courier'>- - - - - -REPORTE- - - - - - </FONT></h1></br>"
                + "<table cellpadding='20' border = '0' align='center'>"
                + "<tr>"
                + "<td bgcolor= '#5DB1BC'><strong>No" + "</strong></td>"
                + "<td bgcolor= '#5DB1BC'><strong>Tipo" + "</strong></td>"
                + "<td bgcolor= '#5DB1BC'><strong>Error" + "</strong></td>"
                + "<td bgcolor= '#5DB1BC'><strong>Linea" + "</strong></td>"
                + "<td bgcolor= '#5DB1BC'><strong>Columna" + "</strong></td>";

        String Codigo = "", cadena = "";
        for (int i = 0; i < errores.size(); i++) {
            Codigo += "<tr>"
                    + "<td bgcolor='#5DB1BC'>" + (i + 1) + "</td>"
                    + "<td bgcolor='#D2EFF2'>" + errores.get(i).tipo + "</td>"
                    + "<td bgcolor='#D2EFF2'>" + errores.get(i).error + "</td>"
                    + "<td bgcolor='#D2EFF2'>" + errores.get(i).linea + "</td>"
                    + "<td bgcolor='#D2EFF2'>" + errores.get(i).columna + "</td>";

        }

        cadena = cadena + Codigo;
        codigoHtml = codigoHtml + cadena
                + "</table>"
                + "</body>"
                + "</html>";
        try {
            archivo = new FileOutputStream("ReporteErrores.html");
            p = new PrintStream(archivo);
            p.println(codigoHtml);
            p.close();
        } catch (FileNotFoundException e) {
        }
    }

    public void AbrirArchivo() {
        JFileChooser JFC = new JFileChooser();
        JFC.setFileFilter(new FileNameExtensionFilter("todos los archivos *.rep", "rep", "REP"));
        if (JFC.showDialog(this, "Abrir") == JFileChooser.APPROVE_OPTION) {
            LeerArchivo(JFC.getSelectedFile());
        }
    }

    private void LeerArchivo(File archivo) {
        String texto = new String();
        FileReader FR = null;
        BufferedReader BR = null;
        try {
            FR = new FileReader(archivo);
            BR = new BufferedReader(FR);
            while (BR.ready()) {
                texto += BR.readLine() + "\n";
            }
            AddTab(archivo, texto);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje", JOptionPane.ERROR);
        } finally {
            try {
                if (null != FR) {
                    FR.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void AddTab(File archivo, String texto) {
        txtEntrada = new JTextArea();
        txtEntrada.setLineWrap(true);
        txtEntrada.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(txtEntrada);
        txtEntrada.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        TabbedPane.addTab(archivo.getName(), scroll);
        TabbedPane.setName(archivo.getName());
        txtEntrada.setText(texto);
        rutas.add(new Ruta(archivo.getAbsolutePath(), (TabbedPane.getSelectedIndex() + contadorTab)));
        contadorTab++;
    }

    public File GuardarArchivo(String ruta) throws IOException {
        File archivo = null;
        boolean existe = false;
        for (Ruta r : rutas) {
            if (r.indice == TabbedPane.getSelectedIndex()) {
                existe = true;
                archivo = new File(r.ruta);
                break;
            }
        }
        if (!existe) {
            archivo = new File(ruta);
        }
        BufferedWriter BW;
        BW = new BufferedWriter(new FileWriter(archivo));
        BW.write(getJTextArea().getText());
        BW.close();
        return archivo;
    }

    public File GuardarArchivoComo() {
        JFileChooser JFC = new JFileChooser();
        try {
            if (JFC.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                return GuardarArchivo(JFC.getSelectedFile().getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void graficar(Nodo raiz) throws IOException {
        FileWriter archivo = null;
        PrintWriter pw;
        try {
            archivo = new FileWriter("arbol" + contador + ".txt");
            pw = new PrintWriter(archivo);

            pw.println("digraph G { node[shape=\"box\" , style=filled , color=\"#6495ED\"]");
            i = 0;
            pw.println(recorrer(raiz));
            pw.println("}");

        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } finally {
            try {
                if (null != archivo) {
                    archivo.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        Runtime rt = Runtime.getRuntime();
        rt.exec("dot -Tpng arbol" + contador + ".txt -o arbol" + contador + ".png");
        contador++;
    }

    private String recorrer(Nodo nodo) {
        String cadena = "";
        i = i + 1;
        String padre = "nodo" + i;
        cadena += padre + "[label = \"" + i + ") Etiqueta: \\\"" + nodo.estado + "\\\"  Valor: \\\"" + nodo.valor + "\\\"\"];\n";
        for (Nodo nodohijo : nodo.hijos) {
            cadena += padre + "->" + "nodo" + (i + 1) + "\n"; //El hijo va a estar en i + 1
            cadena += recorrer(nodohijo);
        }

        return cadena;
    }

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
            java.util.logging.Logger.getLogger(Frame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    /* private void AnalizarDatos() {
        Lexico lexico = new Lexico(new BufferedReader(new StringReader(getJTextArea().getText())));
        parser_datos sintactico = new parser_datos(lexico);
        try {
            sintactico.parse();
        } catch (Exception ex) {
            System.out.println("El archivo archivo_datos.txt, No existe\n");
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Abrir;
    private javax.swing.JMenu Analizar;
    private javax.swing.JButton CrearArchivo;
    private javax.swing.JMenu Guardar;
    private javax.swing.JMenu GuardarComo;
    private javax.swing.JMenu Reportes;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextArea txtSalida;
    private javax.swing.JTextField txtarchivo;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables

}
