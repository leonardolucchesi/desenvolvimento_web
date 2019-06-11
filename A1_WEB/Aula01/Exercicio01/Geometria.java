package Exercicio01;

import java.util.ArrayList;

public class Geometria {

	public static void main(String[] args) {
		    ArrayList <Figura> figs = new ArrayList <> ();
		    figs.add(new Quadrado("Quadrado",1000, 12));
		    figs.add(new Circulo("Circulo", 2));
		    figs.add(new Triangulo("Triangulo", 5000, 3000));
		    figs.add(new Retangulo("Retangulo", 200, 20));
		    figs.add(new Losango("Losango", 12, 20));

		    
		    for (Figura f : figs) {
		    	System.out.println(f.area());
		    }
		    
		   
	}
	  
	

}


