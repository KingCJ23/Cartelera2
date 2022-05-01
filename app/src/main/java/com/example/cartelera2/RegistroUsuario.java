package com.example.cartelera2;

import android.os.AsyncTask;

import java.sql.Statement;

public class RegistroUsuario extends AsyncTask<Usuario, Void, String> {
    @Override
    protected String doInBackground(Usuario... datos) {
        String respuesta;
        try{
            Conexion.conexion = Conexion.conectar();
            String sql = "insert into moviles.usuario(nickname, password, nombre, apellido, dpi, correo, genero, estado, foto) values('"+datos[0].getNickname()+"','"+datos[0].getPassword()+"','"+datos[0].getNombre()+"','"+datos[0].getApellido()+"','"+datos[0].getDpi()+"','"+datos[0].getCorreo()+"','"+datos[0].getGenero()+"',"+datos[0].getIdEstado()+", '"+datos[0].getFoto()+"')";
            Statement st = Conexion.conexion.createStatement();
            int rs = st.executeUpdate(sql);
            if(rs == 1){
                respuesta = "exito";
            } else{
                respuesta = "error";
            }
        } catch(Exception ex){
            ex.printStackTrace();
            respuesta = "error";
        }
        return respuesta;
    }

}
