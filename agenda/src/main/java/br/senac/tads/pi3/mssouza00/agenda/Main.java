/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.mssouza00.agenda;

import java.util.Scanner;

/**
 *
 * @author joel
 */
public class Main {
    public static void main(String[] args) {
        Contato contato= new Contato();
        Agenda agenda = new Agenda();
        Scanner input = new Scanner(System.in);
        System.out.printf("1 - Cadastrar contato"
                + "\n2 - Consultar Contato"
                + "\n3 - Alterar Contato"
                + "\n4 - Excluir Contato\n");
        
        short itemMenu = input.nextShort();
        
        switch(itemMenu) {
            case 1:
                System.out.println("Informações de cadastro:");
                System.out.println("Nome:");
                contato.setNM_CONTATO(input.next());
                System.out.println("Data de Nascimento:");
                contato.setDT_NASCIMENTO(input.next());
                System.out.println("Telefone:");
                contato.setVL_TELEFONE(input.next());
                System.out.println("E-mail:");
                contato.setVL_EMAIL(input.nextLine());
                agenda.AddPessoa(contato);
                break;
            case 2:
                System.out.println("Consultar contato:");
                System.out.println("Nome:");
                contato.setNM_CONTATO(input.next());
                agenda.consultarContato(contato.getNM_CONTATO());
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
