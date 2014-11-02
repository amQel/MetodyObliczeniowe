package changer;
/**
 * FunctionChanger to funkcja s³u¿¹ca do
 * przekrzta³cania funkcji w formie kanonicznej 
 * do funkcji w formie ogólnej
 * Wszystkie Prawa Zastrze¿one
 * tylko do u¿ytku w³asnego
 * @author azdybel
 * @serial v0.1
 */
public class FunctionChanger {
	
	private double[] fOdx;
	private double[] war;
	
	private double[] wynik;
	private double[] funkcja;
	

	/**
	 * zwraca tablice w formie normalnej
	 * @param tablicaMnoznikow
	 * @param tablicaWartosci
	 * @return Tablica w formie normalnej
	 */
	public double[] normalForm(double[] tablicaMnoznikow, double[] tablicaWartosci)
	{
		
		setfOdx(tablicaMnoznikow);
		setWar(tablicaWartosci);
		double aktualnyX;
		double[] wyrazWolny = new double[funkcja.length];
		
		funkcja[0] = war[0]*(-1);
		funkcja[1] = 1;
		
		wynik[0] = fOdx[0];

		for (int czynnik=1;czynnik<war.length;czynnik++) {
			
			aktualnyX=war[czynnik];
			
			for (int i = 0; i < wynik.length; i++) {
				wynik[i] += funkcja[i]*fOdx[czynnik];
			}
			
			for (int i = 0; i < wyrazWolny.length; i++) {
				wyrazWolny[i] = funkcja[i]*aktualnyX*(-1);
			}
			
			for(int miejsce=funkcja.length-2;miejsce>=0;miejsce--) {
				funkcja[miejsce+1]=funkcja[miejsce]; 
			}
			funkcja[0] = 0;
			
			
			
			
			for (int i = 0; i < funkcja.length; i++) {
				funkcja[i] += wyrazWolny[i];
			}
			
			
			
		}
		
		for (int i = 0; i < wynik.length; i++) {
			wynik[i] += funkcja[i]*fOdx[fOdx.length-1];
		}
		
		return wynik;
	}


	private void setfOdx(double[] fOdx) {
		this.fOdx = fOdx;
	}


	private void setWar(double[] war) {
		this.war = war;
		this.funkcja = new double[war.length+1];
		this.wynik = new double[war.length+1];
	}


	
	

}
