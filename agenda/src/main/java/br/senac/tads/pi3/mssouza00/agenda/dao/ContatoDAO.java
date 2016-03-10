/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.mssouza00.agenda.dao;

import br.senac.tads.pi3.mssouza00.agenda.Contato;
import br.senac.tads.pi3.mssouza00.agenda.jdbc.DerbyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author joel
 */
public class ContatoDAO {
    
    public static void cadastrarContato(Contato contato) {
        Connection conn = DerbyDB.getConnection();
        String sql = "INSERT INTO TB_CONTATO (NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO) VALUES (?,?,?,?,CURRENT_TIMESTAMP)";
       
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, contato.getNM_CONTATO()); // Nome
            ps.setString(2, contato.getDT_NASCIMENTO()); // Data de nascimento
            ps.setString(3, contato.getVL_TELEFONE()); // Telefone
            ps.setString(4, contato.getVL_EMAIL()); // E-mail
            ps.execute();
        } catch (SQLException er) {
            System.out.println(er.getMessage() + " Erro ao inserir dados");
        }
        
    }
    
}
