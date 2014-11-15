package dadosabertos;

import java.util.ArrayList;
import java.util.List;

public class EstatisticasCriminais {
	
	private String crime; 
	private List<EstatisticaEstado> estados; 
	
	public EstatisticasCriminais(String crime, List<EstatisticaEstado> estados){
		this.crime = crime;
		this.estados = estados;
		this.estados = new ArrayList<EstatisticaEstado>();
	}
	
	public EstatisticasCriminais(String crime){
		this.crime = crime;
		this.estados = new ArrayList<EstatisticaEstado>();
	}
	
	public void setCrime(String crime){
		this.crime = crime;
	}
	
	public void setEstados(List<EstatisticaEstado> estados){
		this.estados = estados;
	}
	
	public String getCrime(){
		return this.crime;
	}
	
	public List<EstatisticaEstado> getEstados(){
		return this.estados;
	}
	
	public void addEstado(EstatisticaEstado estado){
		this.estados.add(estado);
	}

}
