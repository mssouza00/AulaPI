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
        Agenda agenda = new Agenda();
        Scanner input = new Scanner(System.in);
        System.out.printf("1 - Cadastrar contato"
                + "\n2 - Consultar Contato"
                + "\n3 - Alterar Contato"
                + "\n4 - Excluir Contato\n");
        
        short itemMenu = input.nextShort();
        Object contato[] = new Object[6];
        switch(itemMenu) {
            case 1:
                System.out.println("Informações de cadastro:");
                System.out.println("Nome:");
                contato[2] = input.next();
                System.out.println("Data de Nascimento:");
                contato[3] = input.nextLine();
                System.out.println("Telefone:");
                contato[4] = input.nextLine();
                 System.out.println("E-mail:");
                contato[5] = input.nextLine();
                contato[6] = "02-03-2016";
                agenda.AddPessoa();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
