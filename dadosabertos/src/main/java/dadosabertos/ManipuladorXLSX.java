package dadosabertos;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ManipuladorXLSX {
	
	private ImportandoXLSX importador;
	private XSSFSheet planilha;
	private Iterator<Row> iteratorRow;
	private EstatisticasCriminais estatisticasCriminais;
	private EstatisticaEstado estatisticaEstado;
	private String nomeCrime;
	
	public ManipuladorXLSX(String nomeCrime){
		
		estatisticasCriminais = new EstatisticasCriminais(nomeCrime.toUpperCase());
		this.nomeCrime = nomeCrime.toLowerCase();
		this.nomeCrime = this.nomeCrime.replaceAll(" ", "");
		
		try{
			String url = "files/"+this.nomeCrime.toLowerCase()+".xlsx";
			this.importador = new ImportandoXLSX(url, 0);
			this.planilha = importador.getPlanilha(0);
			this.iteratorRow = this.planilha.iterator();
			
		}catch(IOException erro){
			System.out.println(erro.getMessage());
		}
	}
	
	public EstatisticasCriminais getEstatisticasCriminais(){
		while(this.iteratorRow.hasNext()){
			Row row = this.iteratorRow.next();
			Iterator<Cell> cellIterator = row.iterator();
			String estado="";
			int ano=2009;
			int registroOcorrencias =0;
			double taxa =0;
			
				while(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					
					switch(cell.getColumnIndex()){
					case 0: 
						estado = cell.getStringCellValue();
						break;
					case 1:
						if(cell.getCellType() == Cell.CELL_TYPE_STRING){
							registroOcorrencias = 0;
							break;
						}else{
							registroOcorrencias = (int)cell.getNumericCellValue();
							break;
						}
					case 2: 
						if(cell.getCellType() == Cell.CELL_TYPE_STRING){
							taxa = 0;
							break;
						}else{
							taxa = (double)cell.getNumericCellValue();
							break;
						}
					case 3:
						this.estatisticaEstado = new EstatisticaEstado(estado);
						this.estatisticaEstado.addEstatisticaAno(new EstatisticaAno(ano, registroOcorrencias, taxa));
						ano++;
						if(cell.getCellType() == Cell.CELL_TYPE_STRING){
							registroOcorrencias = 0;
							break;
						}else{
							registroOcorrencias = (int)cell.getNumericCellValue();
							break;
						}
					case 4:
						if(cell.getCellType() == Cell.CELL_TYPE_STRING){
							taxa = 0;
							break;
						}else{
							taxa = (double)cell.getNumericCellValue();
							break;
						}
					case 5:
						this.estatisticaEstado.addEstatisticaAno(new EstatisticaAno(ano, registroOcorrencias, taxa));
						ano++;
						if(cell.getCellType() == Cell.CELL_TYPE_STRING){
							registroOcorrencias = 0;
							break;
						}else{
							registroOcorrencias = (int)cell.getNumericCellValue();
							break;
						}
					case 6:
						if(cell.getCellType() == Cell.CELL_TYPE_STRING){
							taxa = 0;
							break;
						}else{
							taxa = (double)cell.getNumericCellValue();
							break;
						}
					case 7:
						this.estatisticaEstado.addEstatisticaAno(new EstatisticaAno(ano, registroOcorrencias, taxa));
						ano++;
						if(cell.getCellType() == Cell.CELL_TYPE_STRING){
							registroOcorrencias = 0;
							break;
						}else{
							registroOcorrencias = (int)cell.getNumericCellValue();
							break;
						}
					case 8:
						if(cell.getCellType() == Cell.CELL_TYPE_STRING){
							taxa = 0;
							this.estatisticaEstado.addEstatisticaAno(new EstatisticaAno(ano, registroOcorrencias, taxa));
							break;
						}else{
							taxa = (double)cell.getNumericCellValue();
							this.estatisticaEstado.addEstatisticaAno(new EstatisticaAno(ano, registroOcorrencias, taxa));
							break;
						}
						
					}
					
				}
				
				this.estatisticasCriminais.addEstado(this.estatisticaEstado);
				ano=2009;
		}
		
		return this.estatisticasCriminais;
	}

}
