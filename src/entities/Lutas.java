package entities;

import java.util.Random;

public class Lutas {

	private Lutador desafiado;
	private Lutador desafiante;
	private int rounds;
	private boolean aprovada;

	public Lutas() {
	}

	public Lutas(Lutador desafiado, Lutador desafiante, int rounds, boolean aprovada) {
		this.desafiado = desafiado;
		this.desafiante = desafiante;
		this.rounds = rounds;
		this.aprovada = aprovada;
	}

	public Lutador getDesafiado() {
		return desafiado;
	}

	public void setDesafiado(Lutador desafiado) {
		this.desafiado = desafiado;
	}

	public Lutador getDesafiante() {
		return desafiante;
	}

	public void setDesafiante(Lutador desafiante) {
		this.desafiante = desafiante;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public boolean getAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}

	public void marcarLuta(Lutador l1, Lutador l2) {
		if (l1.getCategoria().equals(l2.getCategoria()) && l1 != l2) {
			this.aprovada = true;
			this.desafiado = l1;
			this.desafiante = l2;
		} else {
			this.aprovada = false;
			this.desafiado = null;
			this.desafiante = null;
		}
	}

	public void lutar() {
		if(this.aprovada) {
			System.out.println("####DESAFIADO###");
			this.desafiado.apresentar();
			System.out.println("----------");

			System.out.println("####DESAFIANTE###");
			this.desafiante.apresentar();
			System.out.println("----------");

			
			Random aleatorio = new Random();
			int vencedor= aleatorio.nextInt(3);

		switch(vencedor) {
			case 0:
		System.out.println("Empatou!");
		this.desafiado.empatarLuta();
		this.desafiante.empatarLuta();
		break;
			case 1:	
		System.out.println("Venceu: " + desafiado.getNome());
		this.desafiado.ganharLuta();
		this.desafiante.perderLuta();
		break;
			case 2:
		System.out.println("Venceu: " + desafiante.getNome());
		this.desafiante.ganharLuta();
		this.desafiado.perderLuta();
		break;
		}
		}else {
			System.out.println("A luta não pode acontecer");		
		}
	}
}
