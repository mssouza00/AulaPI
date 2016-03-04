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
                + "\n2 - Listar contatos"
                + "\n3 - Alterar contato"
                + "\n4 - Excluir contato\n");
        
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
                break;
            case 2:
                agenda.listarPessoas();
                break;
            case 3:
                agenda.listarPessoas();
                System.out.println("Digite o ID do contato a alterar");
                contato.setID_CONTATO(input.nextLong());
                contato.setNM_CONTATO(null);
                contato.setVL_TELEFONE(null);
                contato.setVL_EMAIL(null);
                contato.setDT_NASCIMENTO(null);
                int concluir=0;
                while (concluir == 0) {
                    System.out.printf("1 - Alterar nome"
                + "\n2 - Alterar telefone"
                + "\n3 - Alterar e-mail"
                + "\n4 - Alterar data nascimento"
                            + "\n5- Concluir\n");
                    itemMenu = input.nextShort();
                    switch(itemMenu) {
                        case 1:
                            contato.setNM_CONTATO(input.nextLine());
                            break;
                        case 2:
                            contato.setVL_TELEFONE(input.nextLine());
                            break;
                        case 3:
                            contato.setVL_EMAIL(input.nextLine());
                            break;
                        case 4:
                            contato.setDT_NASCIMENTO(input.nextLine());
                            break;
                        case 5:
                            agenda.alterarContato(contato);
                            concluir=1;
                            break;
                    }
                }
                break;
            case 4:
                agenda.listarPessoas();
                System.out.println("Digite o ID do contato a excluir");
                contato.setID_CONTATO(input.nextLong());
                agenda.deletaContato(contato.getID_CONTATO());
                break;
        }
    }
}
