/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.mssouza00.agenda;

import br.senac.tads.pi3.mssouza00.agenda.dao.ContatoDAO;
import java.util.Scanner;

/**
 *
 * @author joel
 */
public class Main {

    public static void main(String[] args) {
        Contato contato = new Contato();
        Scanner input = new Scanner(System.in);
        int saida=0;
        do { 
        System.out.printf("1 - Cadastrar contato"
                + "\n2 - Listar contatos"
                + "\n3 - Alterar contato"
                + "\n4 - Excluir contato"
                + "\n5 - sair\n");

        
        short itemMenu=0;
                   
            
        
            itemMenu = input.nextShort();
            switch (itemMenu) {
                case 1:
                    System.out.println("Informações de cadastro:");
                    System.out.println("Nome:");
                    contato.setNM_CONTATO(util.leitor());
                    System.out.println("Data de Nascimento:");
                    contato.setDT_NASCIMENTO(util.leitor());
                    System.out.println("Telefone:");
                    contato.setVL_TELEFONE(util.leitor());
                    System.out.println("E-mail:");
                    contato.setVL_EMAIL(util.leitor());
                    ContatoDAO.cadastrarContato(contato);
                    break;
                case 2:
                    ContatoDAO.listarContato();
                    break;
                case 3:
                    ContatoDAO.listarContato();
                    System.out.println("Digite o ID do contato a alterar");
                    contato.setID_CONTATO(input.nextLong());
                    System.out.println("Nome:");
                    contato.setNM_CONTATO(util.leitor());
                    System.out.println("Data de Nascimento:");
                    contato.setDT_NASCIMENTO(util.leitor());
                    System.out.println("Telefone:");
                    contato.setVL_TELEFONE(util.leitor());
                    System.out.println("E-mail:");
                    contato.setVL_EMAIL(util.leitor());
                    ContatoDAO.alterarContato(contato);
                    break;
                case 4:
                    ContatoDAO.listarContato();
                    System.out.println("Digite o ID do contato a excluir");
                    contato.setID_CONTATO(input.nextLong());
                    ContatoDAO.removerContato(contato.getID_CONTATO());
                    break;
                case 5:
                    saida =5;
            }
        } while (saida !=5);
    }
}
