package Exercicio01;

public class Quadrado extends Quadrilatero implements Diagonais {

	public Quadrado(String nome, double base, double altura) {
		super(nome, base, altura);
	
	}

	@Override
	public double area() {
		
		return getBase()*getAltura();
	}

	@Override
	public double calculoDiagonal() {
		
		return 0;
	}

}
