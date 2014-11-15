package dadosabertos;

import java.util.ArrayList;
import java.util.List;

public class EstatisticaEstado {
	
	private String nome;
	private List<EstatisticaAno> anos;
	
	public EstatisticaEstado(String nome, List<EstatisticaAno> anos){
		this.nome = nome;
		this.anos = anos;
		this.anos = new ArrayList<EstatisticaAno>();
		
	}
	
	public EstatisticaEstado(String nome){
		this.nome = nome;
		this.anos = new ArrayList<EstatisticaAno>();
	}
	
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setAnos(List<EstatisticaAno> anos){
		this.anos = anos;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public List<EstatisticaAno> getanos(){
		return this.anos;
	}
	
	public void addEstatisticaAno(EstatisticaAno estatisticaAno){
		this.anos.add(estatisticaAno);
	}

}
