package br.edu.univas.main;

import java.util.Scanner;

import vo.ListaDupla;
import vo.No;

public class StartApp {
	
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		ListaDupla lista = new ListaDupla();
		int come�ar = 0;
		lista.todasPecas();
		lista.PecasPlayer();
		lista.PecasComputador();
		do {
			if(lista.whoStart() == 0 && come�ar == 0) {
				System.out.println("Escolha uma pe�a para retirar");
				System.out.println(lista.ListaPecasPlayer());
				int select = leitura.nextInt();
				leitura.nextLine();
				lista.sendPiecePlayer(select);
				come�ar++;
			}else if(lista.whoStart() == 1 && come�ar == 0) {
				lista.firstPlay();
				System.out.println(lista.listPiece()+"\n");
				come�ar++;
			}
			else {
				System.out.println("Escolha uma pe�a para retirar");
				System.out.println(lista.ListaPecasPlayer());
				int select = leitura.nextInt();
				leitura.nextLine();
				lista.sendPiecePlayer(select);
				System.out.println("\n"+lista.listPiece()+"\n");
				lista.sendPieceComputer();
				System.out.println("\n"+lista.listPiece()+"\n");
				if(lista.verifyPlayer() == 9 || lista.verifyComputer() == 9) {
					break;
				}
			}
		}while(true);
		if(lista.verifyPlayer() == 0) {
			System.out.println("Parabens voc� ganhou!");
		}else if(lista.verifyComputer() == 0) {
			System.out.println("N�o foi dessa vez!");
		}
	}
}