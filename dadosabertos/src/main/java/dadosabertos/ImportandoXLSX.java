package dadosabertos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportandoXLSX {
	
	private File arquivo;
	private FileInputStream streamArquivo;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private String enderecoArquivo;
	private int indicePlanilha;
	
	public ImportandoXLSX(String enderecoArquivo, int indicePlanilha) throws IOException{
		this.enderecoArquivo = enderecoArquivo;
		this.indicePlanilha = indicePlanilha;
		this.arquivo = new File(this.enderecoArquivo);
		this.streamArquivo = new FileInputStream(this.arquivo);
		this.workbook = new XSSFWorkbook(this.streamArquivo);
		this.sheet = workbook.getSheetAt(this.indicePlanilha);
		
	}
	
		
	public XSSFSheet getPlanilha(int indicePlanilha) throws IOException{
		return sheet = workbook.getSheetAt(indicePlanilha);
	}
	
	public XSSFWorkbook getWorkbook(){
		return this.workbook;
	}
	
	
	

}
