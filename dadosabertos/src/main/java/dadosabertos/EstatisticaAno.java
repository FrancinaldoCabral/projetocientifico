package dadosabertos;

public class EstatisticaAno {
	
	private int ano;
	private int qtdeOcorrencias;
	private double taxa;
	
	public EstatisticaAno(int ano, int qtdeOcorrencias, double taxa){
		this.ano = ano;
		this.qtdeOcorrencias = qtdeOcorrencias;
		this.taxa = taxa;
	}
	
	public void setAno(int ano){
		this.ano = ano;
	}
	
	public void setQtdeOcorrencias(int qtdeOcorrencias){
		this.qtdeOcorrencias = qtdeOcorrencias;
	}
	
	public void setTaxa(double taxa){
		this.taxa = taxa;
	}
	
	public int getAno(){
		return this.ano;
	}
	
	public int getRegistroOcorrencias(){
		return this.qtdeOcorrencias;
	}
	
	public double getTaxa(){
		return this.taxa;
	}

}
