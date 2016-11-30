/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Contacto;
import Model.ContactoVo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC54
 */
public class Formulario extends javax.swing.JFrame {

    DefaultTableModel tbmodel;
    Contacto ejecutar = new Contacto();

    public Formulario() {
        initComponents();
        Inicializar();
    }

    private void Inicializar() {
        String Columnas[] = {"IdContacto", "Nombre", "Apellido", "Email", "Nacimiento", "Telefono", "Celular", "Foto"};
        tbmodel = new DefaultTableModel(null, Columnas);
        List<ContactoVo> lista = ejecutar.Consultar();
        for (int i = 0; i < lista.size(); i++) {
            ContactoVo modelo = lista.get(i);
            tbmodel.addRow(Columnas);
            tbmodel.setValueAt(modelo.getIdContacto(), i, 0);
            tbmodel.setValueAt(modelo.getNombre(), i, 1);
            tbmodel.setValueAt(modelo.getApellido(), i, 2);
            tbmodel.setValueAt(modelo.getEmail(), i, 3);
            tbmodel.setValueAt(modelo.getFechaNacimiento(), i, 4);
            tbmodel.setValueAt(modelo.getTelefono(), i, 5);
            tbmodel.setValueAt(modelo.getCelular(), i, 6);
            tbmodel.setValueAt(modelo.getFoto(), i, 7);
        }
        tbcontacto.setModel(tbmodel);
    }

    private void CargarFoto() {
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Abrir Imagen");
        FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Imagenes", "jpg", "png");
        selector.setFileFilter(filtro2);

        int opcion = selector.showOpenDialog(null);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            try {
                File imagenSeleccionada = selector.getSelectedFile();
                BufferedImage original = ImageIO.read(new File(imagenSeleccionada.getAbsolutePath()));
                lbfoto.setIcon(new ImageIcon(original));
                File fotoGuardada = new File("C:\\Archivos\\" + imagenSeleccionada.getName());
                if (!fotoGuardada.exists()) {
                    ImageIO.write(original, "jpg", fotoGuardada);
                }
                txtfoto.setText(fotoGuardada.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void Guardar() {
        ContactoVo modelo = new ContactoVo();
        modelo.setNombre(txtnombre.getText());
        modelo.setApellido(txtapellido.getText());
        modelo.setEmail(txtemail.getText());
        modelo.setFechaNacimiento(Date.valueOf(txtnacimiento.getText()));
        modelo.setTelefono(txttelefono.getText());
        modelo.setCelular(txtcelular.getText());
        modelo.setFoto(txtfoto.getText());
        ejecutar.Guardar(modelo);
    }

    private void Modificar() {
        ContactoVo modelo = new ContactoVo();
        modelo.setIdContacto(Integer.parseInt(txtid.getText()));
        modelo.setNombre(txtnombre.getText());
        modelo.setApellido(txtapellido.getText());
        modelo.setEmail(txtemail.getText());
        modelo.setFechaNacimiento(Date.valueOf(txtnacimiento.getText()));
        modelo.setTelefono(txttelefono.getText());
        modelo.setCelular(txtcelular.getText());
        modelo.setFoto(txtfoto.getText());
        ejecutar.Modificar(modelo);
    }

    private void Eliminar() {
        ContactoVo modelo = new ContactoVo();
        modelo.setIdContacto(Integer.parseInt(txtid.getText()));
        ejecutar.Eliminar(modelo);
    }

    private void Asignar() {
        ContactoVo modelo = new ContactoVo();
        modelo.setIdContacto(Integer.parseInt(tbcontacto.getValueAt(tbcontacto.getSelectedRow(), 0).toString()));
        modelo.setNombre(tbcontacto.getValueAt(tbcontacto.getSelectedRow(), 1).toString());
        modelo.setApellido(tbcontacto.getValueAt(tbcontacto.getSelectedRow(), 2).toString());
        modelo.setEmail(tbcontacto.getValueAt(tbcontacto.getSelectedRow(), 3).toString());
        modelo.setFechaNacimiento(Date.valueOf(tbcontacto.getValueAt(tbcontacto.getSelectedRow(), 4).toString()));
        modelo.setTelefono(tbcontacto.getValueAt(tbcontacto.getSelectedRow(), 5).toString());
        modelo.setCelular(tbcontacto.getValueAt(tbcontacto.getSelectedRow(), 6).toString());
        modelo.setFoto(tbcontacto.getValueAt(tbcontacto.getSelectedRow(), 7).toString());

        txtnombre.setText(modelo.getNombre());
        txtapellido.setText(modelo.getApellido());
        txtemail.setText(modelo.getEmail());
        txtnacimiento.setText(modelo.getFechaNacimiento().toString());
        txttelefono.setText(modelo.getTelefono());
        txtcelular.setText(modelo.getCelular());
        txtfoto.setText(modelo.getFoto());
        txtid.setText(String.valueOf(modelo.getIdContacto()));

        lbfoto.setIcon(new ImageIcon(txtfoto.getText()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnombre = new javax.swing.JTextField();
        lbfoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnacimiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        txtfoto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btncargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcontacto = new javax.swing.JTable();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre :");

        jLabel2.setText("Apellido :");

        jLabel3.setText("Email :");

        jLabel4.setText("Nacimiento :");

        jLabel5.setText("Telefono :");

        jLabel6.setText("Celular :");

        jLabel7.setText("Foto :");

        btncargar.setText("Cargar Foto");
        btncargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarActionPerformed(evt);
            }
        });

        tbcontacto.setModel(new javax.swing.table.DefaultTableModel(
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
        tbcontacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbcontactoMouseClicked(evt);
            }
        });
        tbcontacto.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbcontactoPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tbcontacto);

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtapellido)
                                    .addComponent(txtemail)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnacimiento)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtfoto)
                                    .addComponent(txttelefono)
                                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnguardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnmodificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btneliminar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btncargar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncargar)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar)
                    .addComponent(btnmodificar)
                    .addComponent(btneliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        Guardar();
        Inicializar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarActionPerformed
        CargarFoto();
    }//GEN-LAST:event_btncargarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        Modificar();
        Inicializar();
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        Eliminar();
        Inicializar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tbcontactoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbcontactoPropertyChange

    }//GEN-LAST:event_tbcontactoPropertyChange

    private void tbcontactoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbcontactoMouseClicked
        Asignar();
        this.repaint();
    }//GEN-LAST:event_tbcontactoMouseClicked

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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncargar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbfoto;
    private javax.swing.JTable tbcontacto;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfoto;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnacimiento;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
