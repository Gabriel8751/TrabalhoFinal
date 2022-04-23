package vo;

import java.util.Random;
import java.util.Scanner;

public class ListaDupla {
	No inicio;
	No fim;
	Player inicio1;
	Player fim1;
	Computador inicio2;
	Computador fim2;
	PecasJogadas inicio3;
	PecasJogadas fim3;
	int tamanho;
	int tamanhoP;
	int tamanhoC;
	int jogadas;
	
	static Scanner leitura = new Scanner(System.in);
	static Random random = new Random();
	
	public void inserirInicio(int lado1, int lado2) {
		No no = new No();
		no.lado1 = lado1;
		no.lado2 = lado2;
		no.anterior = null;
		no.proximo = inicio;
		
		if(inicio != null) {
			inicio.anterior = no;
		}
		
		inicio = no;
		if(tamanho == 0) {
			fim = inicio;
		}
		tamanho++;
	}
	
	public int retirarInicio() {
		if(inicio == null) {
			return 0;
		}
		int out = inicio.lado1;
		
		inicio = inicio.proximo;
		if(inicio != null) {
			inicio.anterior = null;
		}else {
			fim = null;
		}
		tamanho--;
		return out;
	}
	
	public void inserirFim(int lado1, int lado2) {
		No no = new No();
		no.lado1 = lado1;
		no.lado2 = lado2;
		no.proximo = null;
		no.anterior = fim;
		if(fim != null) {
			fim.proximo = no;
		}
		fim = no;
		if(tamanho == 0) {
			inicio = fim;
		}
		tamanho++;
	}
	
	public int retirarFim() {
		if (fim == null) {
			return 0;
		}
		int lado = fim.lado1;
		fim = fim.anterior;
		if(fim != null) {
			fim.proximo = null;
		}
		tamanho--;
		return lado;
	}
	
	public void inserirMeio(int indice, int lado1, int lado2) {
		if(indice <= 0) {
			inserirInicio(lado1, lado2);
		}else if(indice >= tamanho) {
			inserirFim(lado1, lado2);
		}else {
			No local = inicio;
			for(int i = 0; i < indice-1; i++) {
				local = local.proximo;
			}
			No no = new No();
			no.lado1 = lado1;
			no.lado2 = lado2;
			no.anterior = local;
			no.proximo = local.proximo;
			local.proximo = no;
			no.proximo.anterior = no;
			tamanho++;
		}
	}
	
	public int retirarMeio(int indice) {
		if(indice < 0
		|| indice >= tamanho
		|| inicio == null) {
			return 0;
		}else if(indice == 0) {
			return retirarInicio();
		}else if(indice == tamanho) {
			return retirarFim();
		}
		No local = inicio;
		for(int i = 0; i < indice; i++) {
			local = local.proximo;
		}
		if(local.anterior != null) {
			local.anterior.proximo = local.proximo;
		}
		if(local.proximo != null) {
			local.proximo.anterior = local.anterior;
		}
		tamanho--;
		return local.lado1;
	}
	
	public void inserirInicioPessoa(int lado1, int lado2) {
		Player no = new Player();
		no.lado1 = lado1;
		no.lado2 = lado2;
		no.anterior = null;
		no.proximo = inicio1;
		
		if(inicio1 != null) {
			inicio1.anterior = no;
		}
		
		inicio1 = no;
		if(tamanhoP == 0) {
			fim1 = inicio1;
		}
		tamanhoP++;
	}
	
	public int retirarInicioPessoa() {
		if(inicio1 == null) {
			return 0;
		}
		int out = inicio1.lado1;
		
		inicio1 = inicio1.proximo;
		if(inicio1 != null) {
			inicio1.anterior = null;
		}else {
			fim1 = null;
		}
		tamanhoP--;
		return out;
	}
	
	public void inserirFimPessoa(int lado1, int lado2) {
		Player no = new Player();
		no.lado1 = lado1;
		no.lado2 = lado2;
		no.proximo = null;
		no.anterior = fim1;
		if(fim1 != null) {
			fim1.proximo = no;
		}
		fim1 = no;
		if(tamanhoP == 0) {
			inicio1 = fim1;
		}
		tamanhoP++;
	}
	
	public int retirarFimPessoa() {
		if (fim1 == null) {
			return 0;
		}
		int lado = fim1.lado1;
		fim1 = fim1.anterior;
		if(fim1 != null) {
			fim1.proximo = null;
		}
		tamanhoP--;
		return lado;
	}
	
	public void inserirMeioPessoa(int indice, int lado1, int lado2) {
		if(indice <= 0) {
			inserirInicioPessoa(lado1, lado2);
		}else if(indice >= tamanhoP) {
			inserirFimPessoa(lado1, lado2);
		}else {
			Player local = inicio1;
			for(int i = 0; i < indice-1; i++) {
				local = local.proximo;
			}
			Player no = new Player();
			no.lado1 = lado1;
			no.lado2 = lado2;
			no.anterior = local;
			no.proximo = local.proximo;
			local.proximo = no;
			no.proximo.anterior = no;
			tamanhoP++;
		}
	}
	
	public int retirarMeioPessoa(int indice) {
		if(indice < 0
		|| indice >= tamanhoP
		|| inicio1 == null) {
			return 0;
		}else if(indice == 0) {
			return retirarInicioPessoa();
		}else if(indice == tamanhoP-1) {
			return retirarFimPessoa();
		}
		Player local = inicio1;
		for(int i = 0; i < indice; i++) {
			local = local.proximo;
		}
		if(local.anterior != null) {
			local.anterior.proximo = local.proximo;
		}
		if(local.proximo != null) {
			local.proximo.anterior = local.anterior;
		}
		tamanhoP--;
		return local.lado1;
	}
	
	public void inserirInicioComputador(int lado1, int lado2) {
		Computador no = new Computador();
		no.lado1 = lado1;
		no.lado2 = lado2;
		no.anterior = null;
		no.proximo = inicio2;
		
		if(inicio2 != null) {
			inicio2.anterior = no;
		}
		
		inicio2 = no;
		if(tamanhoC == 0) {
			fim2 = inicio2;
		}
		tamanhoC++;
	}
	
	public int retirarInicioComputador() {
		if(inicio2 == null) {
			return 0;
		}
		int out = inicio2.lado1;
		
		inicio2 = inicio2.proximo;
		if(inicio2 != null) {
			inicio2.anterior = null;
		}else {
			fim2 = null;
		}
		tamanhoC--;
		return out;
	}
	
	public void inserirFimComputador(int lado1, int lado2) {
		Computador no = new Computador();
		no.lado1 = lado1;
		no.lado2 = lado2;
		no.proximo = null;
		no.anterior = fim2;
		if(fim2 != null) {
			fim2.proximo = no;
		}
		fim2 = no;
		if(tamanhoC == 0) {
			inicio2 = fim2;
		}
		tamanhoC++;
	}
	
	public int retirarFimComputador() {
		if (fim2 == null) {
			return 0;
		}
		int lado = fim2.lado1;
		fim2 = fim2.anterior;
		if(fim2 != null) {
			fim2.proximo = null;
		}
		tamanhoC--;
		return lado;
	}
	
	public void inserirMeioComputador(int indice, int lado1, int lado2) {
		if(indice <= 0) {
			inserirInicioComputador(lado1, lado2);
		}else if(indice >= tamanhoC) {
			inserirFimComputador(lado1, lado2);
		}else {
			Computador local = inicio2;
			for(int i = 0; i < indice-1; i++) {
				local = local.proximo;
			}
			Computador no = new Computador();
			no.lado1 = lado1;
			no.lado2 = lado2;
			no.anterior = local;
			no.proximo = local.proximo;
			local.proximo = no;
			no.proximo.anterior = no;
			tamanhoC++;
		}
	}
	
	public int retirarMeioComputador(int indice) {
		if(indice < 0
		|| indice >= tamanhoC
		|| inicio2 == null) {
			return 0;
		}else if(indice == 0) {
			return retirarInicioComputador();
		}else if(indice == tamanhoC-1) {
			return retirarFimComputador();
		}
		Computador local = inicio2;
		for(int i = 0; i < indice; i++) {
			local = local.proximo;
		}
		if(local.anterior != null) {
			local.anterior.proximo = local.proximo;
		}
		if(local.proximo != null) {
			local.proximo.anterior = local.anterior;
		}
		tamanhoC--;
		return local.lado1;
	}
	
	public void PecasPlayer() {
		for(int i = 0; i < 14; i++) {
			No no = inicio;
			int a = random.nextInt(0, tamanho);
			inserirMeioPessoa(a,no.lado1, no.lado2);
			retirarMeio(0);
			no = no.proximo;
		}
	}
	
	public void PecasComputador() {
		for(int i = 0; i < 14; i++) {
			No no = inicio;
			int a = random.nextInt(0, tamanho);
			inserirMeioComputador(a,no.lado1, no.lado2);
			retirarMeio(0);
			no = no.proximo;
		}
	}
	
	
	public void todasPecas() {
		int contador = 0;
		int count = 1;
		for(int i = 6; i >= 0; i--) {
			for(int j = 0; j <= (6 - contador); j++) {
				if(i == 0 && j == 0) {
					inserirFim(i, j);
					}
				else if(i == 6 && j == 0) {
					inserirInicio(i, j);
				}else {
					inserirMeio(count, i, j);
				}	
				count++;
			}
			contador++;
		}
	}
	
	public String ListaPecasPlayer() {
		String str = "";
		Player no = inicio1;
		while(no != null) {
			str += "["+no.lado1 + ":" + no.lado2+"] ";
			no = no.proximo;
		}
		return str;
	}
	
	public String ListaPecasComputador() {
		String str = "";
		Computador no = inicio2;
		while(no != null) {
			str += "["+no.lado1 + ":" + no.lado2+"] ";
			no = no.proximo;
		}
		return str;
	}
	
	public String toString() {
		String str = "[" + tamanho + "]";
		No no = inicio;
		while(no != null) {
			str += "["+no.lado1 + ":" + no.lado2+"] ";
			no = no.proximo;
		}
		return str;
	}
	
	public int whoStart() {
		int a = random.nextInt(0,2);
		return a;
	}	
	
	public void inserirInicioJogada(int lado1, int lado2) {
		PecasJogadas no = new PecasJogadas();
		no.lado1 = lado1;
		no.lado2 = lado2;
		no.anterior = null;
		no.proximo = inicio3;
		
		if(inicio3 != null) {
			inicio3.anterior = no;
		}
		
		inicio3 = no;
		if(jogadas == 0) {
			fim3 = inicio3;
		}
		jogadas++;
	}
	
	public int retirarInicioJogada() {
		if(inicio3 == null) {
			return 0;
		}
		int out = inicio3.lado1;
		
		inicio3 = inicio3.proximo;
		if(inicio3 != null) {
			inicio3.anterior = null;
		}else {
			fim3 = null;
		}
		jogadas--;
		return out;
	}
	
	public void inserirFimJogada(int lado1, int lado2) {
		PecasJogadas no = new PecasJogadas();
		no.lado1 = lado1;
		no.lado2 = lado2;
		no.proximo = null;
		no.anterior = fim3;
		if(fim3 != null) {
			fim3.proximo = no;
		}
		fim3 = no;
		if(jogadas == 0) {
			inicio3 = fim3;
		}
		jogadas++;
	}
	
	public int retirarFimJogada() {
		if (fim3 == null) {
			return 0;
		}
		int lado = fim3.lado1;
		fim3 = fim3.anterior;
		if(fim3 != null) {
			fim3.proximo = null;
		}
		jogadas--;
		return lado;
	}
	
	public void inserirMeioJogada(int indice, int lado1, int lado2) {
		if(indice <= 0) {
			inserirInicioJogada(lado1, lado2);
		}else if(indice >= jogadas) {
			inserirFimJogada(lado1, lado2);
		}else {
			PecasJogadas local = inicio3;
			for(int i = 0; i < indice-1; i++) {
				local = local.proximo;
			}
			PecasJogadas no = new PecasJogadas();
			no.lado1 = lado1;
			no.lado2 = lado2;
			no.anterior = local;
			no.proximo = local.proximo;
			local.proximo = no;
			no.proximo.anterior = no;
			jogadas++;
		}
	}
	
	public int retirarMeioJogada(int indice) {
		if(indice < 0
		|| indice >= jogadas
		|| inicio3 == null) {
			return 0;
		}else if(indice == 0) {
			return retirarInicioJogada();
		}else if(indice == tamanhoP-1) {
			return retirarFimJogada();
		}
		PecasJogadas local = inicio3;
		for(int i = 0; i < indice; i++) {
			local = local.proximo;
		}
		if(local.anterior != null) {
			local.anterior.proximo = local.proximo;
		}
		if(local.proximo != null) {
			local.proximo.anterior = local.anterior;
		}
		jogadas--;
		return local.lado1;
	}
	
	public void sendPiecePlayer(int index) {
		PecasJogadas pecasInicio = inicio3;
		PecasJogadas pecasFim = fim3;
		Player no = inicio1;
		System.out.println("Deseja inserir no inicio ou no fim ? [l = left, r = right]");
		String position = leitura.nextLine();
		if(index <= tamanhoP && index >= 0) {
		for(int i = 1; i <= index; i++) {
			if(i == index && jogadas == 0) {
				if(position.equals("l")) {
					inserirInicioJogada(no.lado1, no.lado2);
					retirarMeioPessoa(index-1);
				}else if(position.equals("r")){
					inserirFimJogada(no.lado1, no.lado2);
					retirarMeioPessoa(index-1);
				}
			}
			else if(i == index) {
				if(position.equals("l")) {
					if(no.lado1 == pecasInicio.lado1) {
						inserirInicioJogada(no.lado2, no.lado1);
						retirarMeioPessoa(index-1);
					}else if(no.lado2 == pecasInicio.lado1) {
						inserirInicioJogada(no.lado1, no.lado2);
						retirarMeioPessoa(index-1);
					}else {
						System.out.println("Essa peça não é compativel");
					}
				}else if(position.equals("r")){
					if(no.lado1 == pecasFim.lado2) {
							inserirFimJogada(no.lado1, no.lado2);
							retirarMeioPessoa(index-1);
					}else if(no.lado2 == pecasFim.lado2) {
							inserirFimJogada(no.lado2, no.lado1);
							retirarMeioPessoa(index-1);
					}else {
							System.out.println("Essa peça não é compativel");
					}
				}
			}
			
		else {
			no = no.proximo;
		}
		}
	}else {
		System.out.println("Digite um numero entre 0 e " + tamanhoP);
	}
	}
	
	public void firstPlay() {
		Computador no = inicio2;
		int a = random.nextInt(0, 14);
		for(int i = 0; i < 14; i++) {
			if(i == a) {
				inserirInicioJogada(no.lado1, no.lado2);
			}else {
				no = no.proximo;
			}
		}
	}
	
	public void sendPieceComputer() {
		PecasJogadas pecasInicio = inicio3;
		PecasJogadas pecasFim = fim3;
		Computador no = inicio2;
		for(int i = 0; i < tamanhoC; i++) {
			if(no.lado1 == pecasInicio.lado1) {
				inserirInicioJogada(no.lado2, no.lado1);
				retirarMeioComputador(i);
				break;
			}else if(no.lado2 == pecasInicio.lado1){
				inserirInicioJogada(no.lado1, no.lado2);
				retirarMeioComputador(i);
				break;
			}else if(no.lado1 == pecasFim.lado2) {
				inserirFimJogada(no.lado1, no.lado2);
				retirarMeioComputador(i);
				break;
			}else if(no.lado2 == pecasFim.lado2) {
				inserirFimJogada(no.lado2, no.lado1);
				retirarMeioComputador(i);
				break;
			}else {
				no = no.proximo;
			}
		}
	}
	
	public int verifyPlayer() {
		return tamanhoP;
	}
	
	public int verifyComputer() {
		return tamanhoC;
	}
	
	public String listPiece() {
		String str = "Peças do tabuleiro\n";
		PecasJogadas no = inicio3;
		while(no != null) {
			str += "["+no.lado1 + ":" + no.lado2+"] ";
			no = no.proximo;
		}
		return str;
	}	
}