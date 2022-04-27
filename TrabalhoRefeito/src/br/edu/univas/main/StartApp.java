package br.edu.univas.main;

import java.util.Scanner;

import vo.ListaDupla;
import vo.No;

public class StartApp {
	
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		ListaDupla lista = new ListaDupla();
		int começar = 0;
		lista.todasPecas();
		lista.PecasPlayer();
		lista.PecasComputador();
		do {
			if(lista.whoStart() == 0 && começar == 0) {
				System.out.println("Escolha uma peça para retirar");
				System.out.println(lista.ListaPecasPlayer());
				int select = leitura.nextInt();
				leitura.nextLine();
				lista.sendPiecePlayer(select);
				começar++;
			}else if(lista.whoStart() == 1 && começar == 0) {
				lista.firstPlay();
				System.out.println(lista.listPiece()+"\n");
				começar++;
			}
			else {
				System.out.println("Escolha uma peça para retirar");
				System.out.println(lista.ListaPecasPlayer());
				int select = leitura.nextInt();
				leitura.nextLine();
				lista.sendPiecePlayer(select);
				System.out.println("\n"+lista.listPiece()+"\n");
				lista.sendPieceComputer();
				System.out.println("\n"+lista.listPiece()+"\n");
				if(lista.verifyPlayer() == 0 || lista.verifyComputer() == 0) {
					break;
				}
			}
		}while(true);
		if(lista.verifyPlayer() == 0) {
			System.out.println("Parabens você ganhou!");
		}else {
			System.out.println("Não foi dessa vez!");
		}
	}
}
