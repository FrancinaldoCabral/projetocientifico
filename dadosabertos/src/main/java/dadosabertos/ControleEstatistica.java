package dadosabertos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControleEstatistica {
	
	private ManipuladorXLSX planilhas;
	
	@RequestMapping("/dados")
	public EstatisticasCriminais getEstatistica(@RequestParam(value="crime")String crime){
			
		planilhas = new ManipuladorXLSX(crime);
		return planilhas.getEstatisticasCriminais();
		
	}
	
	
}
