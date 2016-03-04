/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.mssouza00.agenda;

/**
 *
 * @author matheus.ssouza1
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agenda {

    private Connection obterConexao() throws SQLException, ClassNotFoundException {
        Connection conn;
        // Passo 1: Registrar driver JDBC.
        Class.forName("org.apache.derby.jdbc.ClientDataSource");

        // Passo 2: Abrir a conexÃƒÂ£o
        conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/agendadb;SecurityMechanism=3",
                "app", // usuario
                "app"); // senha
        return conn;
    }

    public void listarPessoas() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT NM_contato, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL FROM TB_contato";
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

            while (resultados.next()) {
                String nome = resultados.getString("NM_contato");
                Date dataNasc = resultados.getDate("DT_NASCIMENTO");
                String email = resultados.getString("VL_EMAIL");
                String telefone = resultados.getString("VL_TELEFONE");
                System.out.println( nome + ", " + formatadorData.format(dataNasc) + ", " + email + ", " + telefone);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void AddPessoa(Contato contato) {
        Connection conn = null;
        try {
            conn = obterConexao();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        String nome = contato.getNM_CONTATO();
        String dataNasc = contato.getDT_NASCIMENTO();
        String telefone = contato.getVL_TELEFONE();
        String email = contato.getVL_EMAIL();

        String sql = "INSERT INTO TB_CONTATO (NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO) VALUES (?,?,?,?,?);";

        try ( PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, dataNasc);
            ps.setString(3, telefone);
            ps.setString(4, email);
            ps.setString(5, "CURRENT_TIMESTAMP");
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int alterarContato(Contato contato) {
        Statement stmt = null;
        Connection conn = null;
        String nome = contato.getNM_CONTATO();
        String dataNasc = contato.getDT_NASCIMENTO();
        String telefone = contato.getVL_TELEFONE();
        String email = contato.getVL_EMAIL();
        try {
            conn.setAutoCommit(false);
            String sql = "UPDATE tb_contato SET nm_contato=?,dt_nascimento=?,vl_telefone=?,vl_email=? WHERE id_contato = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nome);
                ps.setString(2, dataNasc);
                ps.setString(3, telefone);
                ps.setString(4, email);
                ps.setLong(5, contato.getID_CONTATO());
                ps.execute();
                conn.commit();
            }

        } catch (Exception ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 1;
    }

    public int deletaContato(long id_contato) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn.setAutoCommit(false);
            String sql = "delete from tb_contato where ID_CONTATO = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, id_contato);
                ps.execute();
                conn.commit();
            }

        } catch (Exception ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 1;
    }

}
