/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;

/**
 *
 * @author RLCR
 */
public class Gestionbd {
    public String ingresar(String nombre, int precio, 
            String categoria, String plataforma, String compania){
    
        
        Connection conexion=null;
        Statement sentencia=null;
        String BD="viernes04";
        String url="jdbc:postgresql://localhost:5432/"+BD;
        String usuario="postgres";
        String pass="root";
        
        try{
        Class.forName("org.postgresql.Driver");
        conexion=DriverManager.getConnection(url,usuario,pass);
        sentencia=conexion.createStatement();
        String sql="insert into juegos(nombre,precio,categoria,plataforma,compania)"+
                "values('"+nombre+"','"+precio+"','"+categoria+"','"+plataforma+"','"+compania+"')";
        sentencia.executeUpdate(sql);
        sentencia.close();
        conexion.close();
        return "Datos ingresados con exito";
        }catch(ClassNotFoundException | SQLException e){
        return "Error: "+e.getMessage();
        }
        
    }
}
