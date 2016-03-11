/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.mssouza00.agenda.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joel
 */
public class DerbyDB {
    
    public static Connection getConnection() {
        String conn = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String passwd = "app";
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(conn,user,passwd);
        } catch (SQLException ex) {
            Logger.getLogger(DerbyDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return conexao;
    }
    
}
