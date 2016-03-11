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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author joel
 */
public class ContatoDAO {
    
    Connection conn = DerbyDB.getConnection();
    
    public static void cadastrarContato(Contato contato) {
        Connection conn = DerbyDB.getConnection();
        String sql = "INSERT INTO TB_CONTATO (NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO) VALUES (?,?,?,?,CURRENT_TIMESTAMP)";
       
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, contato.getNM_CONTATO()); // Nome
            ps.setString(2, contato.getDT_NASCIMENTO()); // Data de nascimento
            ps.setString(3, contato.getVL_TELEFONE()); // Telefone
            ps.setString(4, contato.getVL_EMAIL()); // E-mail
            ps.execute();
            System.out.println("Cadastrado com sucesso!!");
        } catch (SQLException er) {
            System.out.println(er.getMessage() + " Erro ao cadastrar");
        }
    }
    
    public static void removerContato(long id) {
        Connection conn = DerbyDB.getConnection();
        String sql = "Delete FROM TB_CONTATO WHERE ID_CONTATO = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.execute();
            System.out.println("Dados removidos com sucesso");
        } catch (SQLException er) {
            System.out.println(er.getMessage() + " Erro ao remover");
        }
        
    }
    
    public static void listarContato () {
        Connection conn = DerbyDB.getConnection();
        String sql = "SELECT * FROM TB_CONTATO";
        try(Statement stmt = conn.createStatement()){
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while(rs.next()) {
                    System.out.println("\nID " + rs.getLong("ID_CONTATO"));
                    System.out.println("NOME " + rs.getString("NM_CONTATO"));
                    System.out.println("NASCIMENTO " + rs.getString("DT_NASCIMENTO"));
                    System.out.println("TELEFONE " + rs.getString("VL_TELEFONE"));
                    System.out.println("E-MAIL " + rs.getString("VL_EMAIL"));
                    System.out.println("CADASTRO " + rs.getString("DT_CADASTRO"));
                }
            }
            stmt.close();
            conn.close();
        } catch (SQLException er) {
            System.out.println(er.getMessage() + " Erro ao listar");
        }
    }
    
    public static void alterarContato(Contato contato) {
        Connection conn = DerbyDB.getConnection();
        String sql = "UPDATE tb_contato SET nm_contato=?,dt_nascimento=?,vl_telefone=?,vl_email=? WHERE id_contato = ?";
        Long Id = contato.getID_CONTATO();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, contato.getNM_CONTATO());
            ps.setString(2, contato.getDT_NASCIMENTO());
            ps.setString(3, contato.getVL_TELEFONE());
            ps.setString(4, contato.getVL_EMAIL());
            ps.setLong(5, Id);
            ps.execute();
            System.out.println("dados alterados com sucesso.");
        } catch (SQLException er) {
            System.out.println(er.getMessage() + " Erro ao alterar");
        }
    }
}
