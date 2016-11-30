/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import Interfaces.IContacto;
import Model.ContactoVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PC54
 */
public class Contacto extends Conexion implements IContacto {

    @Override
    public List<ContactoVo> Consultar() {
        conectar();
        List<ContactoVo> lista = new Vector<>();
        try {
            PreparedStatement sentencia = cnn.prepareStatement("{CALL ConsultarContacto()}");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                ContactoVo modelo = new ContactoVo();
                modelo.setIdContacto(resultado.getInt(1));
                modelo.setNombre(resultado.getString(2));
                modelo.setApellido(resultado.getString(3));
                modelo.setEmail(resultado.getString(4));
                modelo.setFechaNacimiento(resultado.getDate(5));
                modelo.setTelefono(resultado.getString(6));
                modelo.setCelular(resultado.getString(7));
                modelo.setFoto(resultado.getString(8));

                lista.add(modelo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
        return lista;
    }

    @Override
    public void Guardar(ContactoVo modelo) {
        conectar();
        try {
            PreparedStatement sentencia = cnn.prepareStatement("{CALL AgregarContacto(?,?,?,?,?,?,?)}");
            sentencia.setString(1, modelo.getNombre());
            sentencia.setString(2, modelo.getApellido());
            sentencia.setString(3, modelo.getCelular());
            sentencia.setDate(4, modelo.getFechaNacimiento());
            sentencia.setString(5, modelo.getTelefono());
            sentencia.setString(6, modelo.getCelular());
            sentencia.setString(7, modelo.getFoto());
            int resultado = sentencia.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(new JFrame(), "Persona Guardada");
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Persona NO Guardada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    @Override
    public void Modificar(ContactoVo modelo) {
        conectar();
        try {
            PreparedStatement sentencia = cnn.prepareStatement("{CALL ModificarContacto(?,?,?,?,?,?,?,?)}");
            sentencia.setInt(1, modelo.getIdContacto());
            sentencia.setString(2, modelo.getNombre());
            sentencia.setString(3, modelo.getApellido());
            sentencia.setString(4, modelo.getCelular());
            sentencia.setDate(5, modelo.getFechaNacimiento());
            sentencia.setString(6, modelo.getTelefono());
            sentencia.setString(7, modelo.getCelular());
            sentencia.setString(8, modelo.getFoto());
            int resultado = sentencia.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(new JFrame(), "Persona Actualizada");
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Persona NO Actualizada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    @Override
    public void Eliminar(ContactoVo modelo) {
      conectar();
        try {
            PreparedStatement sentencia = cnn.prepareStatement("{CALL EliminarContacto(?)}");
            sentencia.setInt(1, modelo.getIdContacto());
           int resultado = sentencia.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(new JFrame(), "Persona Eliminada");
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Persona NO Eliminada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

}
