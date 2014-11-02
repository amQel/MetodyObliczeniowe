package changer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;


/**
 * Rysyje funkcje zgodna z tablica
 * i wyswietla rownanie w wersji LaTeX
 * @author azdybel
 * @serial v1.0
 */
public class Rysownik extends JFrame {


	
	private double[] funkcja;
	private String wzor;
	private JPanel drawingArea;
	private int gestosc;
	private double probkowanie;
	
	public void setWzor(String wzor) {
		this.wzor = wzor;
	}


	public void setFunkcja(double[] funkcja) {
		this.funkcja = funkcja;
	}

/**
 * 
 * @param funkcja : w postaci tablicowej, gdzie f[i] = f[i]*x^i
 * @param wzor : wzor do wyswietlenia w formie LaTeX
 * @param Gestosc ilosc prob na zadanej przestrzeni liczba prob =  (this.gestosc = Gestosc*200)
 */
	public Rysownik(double[] funkcja,String wzor,int Gestosc) {
		this.setTitle("Graf");
		this.setSize(1000,1000);
		Container content = this.getContentPane();
		content.add(this.drawingArea = new JPanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setFunkcja(funkcja);
		setWzor(wzor);
		setGestosc(Gestosc);
		setProbkowanie(75);
	}
	

	public void paint(Graphics g){
		 
		g.setColor(Color.BLACK);
		g.drawLine(0, 500, 1000, 500);
		g.drawLine(200, 0, 200, 1000);
		g.setColor(Color.RED);
		
		double x,y;
		
		for (int i = 200*gestosc; i <1000*gestosc ; i++) {
			x=(double)i;
			x=x/gestosc;
			y=wynik((x/200)-1);
			y=((-1)*y*probkowanie)+500;
			g.drawLine((int)x, (int)y, (int)x, (int)y);
		}
		
		render();
		
	}
	
	private void render() {
		TeXFormula formula = new TeXFormula("P(x) = " + wzor);
		TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);
		
		 
		icon.setInsets(new Insets(5, 5, 5, 5));

		
		BufferedImage image = new BufferedImage(icon.getIconWidth(),
				icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2 = image.createGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
		JLabel jl = new JLabel();
		jl.setForeground(new Color(0, 0, 0));
		icon.paintIcon(jl, g2, 0, 0);
		
		
		Graphics g = this.drawingArea.getGraphics();
		g.drawImage(image,0,0,null);
		
		
		
		
	}


	private double wynik(double i) {
		double wynik = funkcja[0];
		double mnoznik=i;
		for (int j = 1; j < funkcja.length; j++) {
			wynik += mnoznik * funkcja[j];
			mnoznik *= i;
		}
		return wynik;
	}


	public void setGestosc(int gestosc) {
		this.gestosc = gestosc;
	}

	public void setProbkowanie(double d) {
		this.probkowanie = d;
	}

}
