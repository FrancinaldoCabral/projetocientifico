package dadosabertos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControleEstatistica {
	
	private ManipuladorXLSX planilhas;
	
	@RequestMapping("/homicidio")
	public EstatisticasCriminais getHomicidio(){
		planilhas = new ManipuladorXLSX("homicidio");
		return planilhas.getEstatisticasCriminais();
	}
	
	@RequestMapping("/estupro")
	public EstatisticasCriminais getEstupro(){
		planilhas = new ManipuladorXLSX("estupro");
		return planilhas.getEstatisticasCriminais();
	}
	
	@RequestMapping("/rouboveiculo")
	public EstatisticasCriminais getRouboVeiculo(){
		planilhas = new ManipuladorXLSX("rouboveiculo");
		return planilhas.getEstatisticasCriminais();
	}
	
	@RequestMapping("/lesaocorporalseguidodemorte")
	public EstatisticasCriminais getLesaoCorporal(){
		planilhas = new ManipuladorXLSX("lesaocorporalseguidodemorte");
		return planilhas.getEstatisticasCriminais();
	}
	
	@RequestMapping("/latrocinio")
	public EstatisticasCriminais getLatrocinio(){
		planilhas = new ManipuladorXLSX("latrocinio");
		return planilhas.getEstatisticasCriminais();
	}
	
	@RequestMapping("/furtodeveiculo")
	public EstatisticasCriminais getFurtoVeiculo(){
		planilhas = new ManipuladorXLSX("furtodeveiculo");
		return planilhas.getEstatisticasCriminais();
	}
	

}
