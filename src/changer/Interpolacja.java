package changer;

import java.util.Scanner;


public class Interpolacja {


	public static void main(String[] args) {
		FunctionChanger changer = new FunctionChanger();

		double[] fOdx = {3,1,0,0,-0.25};
		double[] war = {0,0,1,2};
		
		double[] po = changer.normalForm(fOdx,war);
		Calka calka = new Calka(po);
		
		
		String wzor = wypiszWynik(po, false);
		wypiszWynik(calka.getPoCalkowo(),true);
		System.out.println("wyswietlic plot ?");
		Scanner in = new Scanner(System.in);
		String c;
		c=in.nextLine();
		int i = in.nextInt();
		if(c.toLowerCase().contains("t")) new Rysownik(po,wzor,i);
		
	}

	
	
public static String wypiszWynik(double[] tablicaWFormieNormalnej, boolean cons) {
				
		String postacOgolna = "";
		
		for (int i=tablicaWFormieNormalnej.length-1;i>1;i--){
			
			if(tablicaWFormieNormalnej[i]!=1.0) postacOgolna += tablicaWFormieNormalnej[i];
			if(tablicaWFormieNormalnej[i-1]<0)
				postacOgolna +=  "x^{" + i + "} ";
			else
				postacOgolna +=  "x^{" + i +  "} + " ;
			
		}
		if(tablicaWFormieNormalnej[1]!=1.0) postacOgolna += tablicaWFormieNormalnej[1];
		postacOgolna +=  "x";
		if(tablicaWFormieNormalnej[0]!=0.0) postacOgolna += " + " + tablicaWFormieNormalnej[0];
		if(cons) postacOgolna += " + Const";
		postacOgolna += "\n";
		System.out.print(postacOgolna);
		return postacOgolna;
	}
}
