/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.mssouza00.agenda;

/**
 *
 * @author WEB
 */
public class Contato {
    
    private long ID_CONTATO;
    private String NM_CONTATO;
    private String DT_NASCIMENTO;
    private String VL_TELEFONE;
    private String VL_EMAIL;
    private String DT_CADASTRO;

    /**
     * @return the ID_CONTATO
     */
    protected long getID_CONTATO() {
        return ID_CONTATO;
    }

    /**
     * @param ID_CONTATO the ID_CONTATO to set
     */
    protected void setID_CONTATO(long ID_CONTATO) {
        this.ID_CONTATO = ID_CONTATO;
    }

    /**
     * @return the NM_CONTATO
     */
    protected String getNM_CONTATO() {
        return NM_CONTATO;
    }

    /**
     * @param NM_CONTATO the NM_CONTATO to set
     */
    protected void setNM_CONTATO(String NM_CONTATO) {
        this.NM_CONTATO = NM_CONTATO;
    }

    /**
     * @return the DT_NASCIMENTO
     */
    protected String getDT_NASCIMENTO() {
        return DT_NASCIMENTO;
    }

    /**
     * @param DT_NASCIMENTO the DT_NASCIMENTO to set
     */
    protected void setDT_NASCIMENTO(String DT_NASCIMENTO) {
        this.DT_NASCIMENTO = DT_NASCIMENTO;
    }

    /**
     * @return the VL_TELEFONE
     */
    protected String getVL_TELEFONE() {
        return VL_TELEFONE;
    }

    /**
     * @param VL_TELEFONE the VL_TELEFONE to set
     */
    protected void setVL_TELEFONE(String VL_TELEFONE) {
        this.VL_TELEFONE = VL_TELEFONE;
    }

    /**
     * @return the VL_EMAIL
     */
    protected String getVL_EMAIL() {
        return VL_EMAIL;
    }

    /**
     * @param VL_EMAIL the VL_EMAIL to set
     */
    protected void setVL_EMAIL(String VL_EMAIL) {
        this.VL_EMAIL = VL_EMAIL;
    }

    /**
     * @return the DT_CADASTRO
     */
    protected String getDT_CADASTRO() {
        return DT_CADASTRO;
    }

    /**
     * @param DT_CADASTRO the DT_CADASTRO to set
     */
    protected void setDT_CADASTRO(String DT_CADASTRO) {
        this.DT_CADASTRO = DT_CADASTRO;
    }
    
    
}
