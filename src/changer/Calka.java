package changer;

public class Calka {

	public double[] getPoCalkowo() {
		return poCalkowo;
	}

	private double przedCalkowo[];
	private double poCalkowo[];
	
	public Calka(double[] przedCalkowo) {
		super();
		this.przedCalkowo = przedCalkowo;
		this.poCalkowo = new double[przedCalkowo.length+1];
		calkuj();
	}

	private void calkuj() {
		
		for (int i = 0; i < przedCalkowo.length; i++) {
			poCalkowo[i+1] = przedCalkowo[i]/(i+1);
		}
	}
	
	
	
}
