package exemple;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelToTxt {
	private BufferedWriter out;
	
	public ExcelToTxt() throws IOException {
		out = new BufferedWriter(new FileWriter("c:/users/leeny/out.txt"));	// 변환된 파일이 쓰여질 장소
		readExcel("c:/users/leeny/team.xlsx");
		out.close();
	}
	
	public void readExcel(String file) {
		Row row;
		Cell cell;
		
		try {
			Workbook workbook = WorkbookFactory.create(new File(file));
			
			Sheet sheet = workbook.getSheetAt(0);		// 0번째 엑셀에서 첫번째 시트를 가져온다.
			
			int rows = sheet.getPhysicalNumberOfRows();
			// getPhysicalNumberOfRows() ==> 사용자가 엑셀을 입력한 Row의 수를 캐치하여 리턴해주는 부분
			// 하지만 이부분이 간혹 사용자가 입력한 Row가 아닌데도 읽어들여 입력한 Row이상의 수를 리턴하는 경우가 종종 발생
			// 이때 row = sheet.getRow(r); 이부분에서 row를 가져와도 row는 null로 나오므로 여기서 캐치하서 잘못 인식하지 않도록 처리해야한다.
			int cells = sheet.getRow(0).getPhysicalNumberOfCells();
			
			for (int r = 1; r < rows; r++) {
				row = sheet.getRow(r);	// 행 가져오기
				if (row != null) {
					for (int c = 0; c < cells; c++) {
						cell = row.getCell(c);
						if (cell != null) {
							String value = null;
							switch (cell.getCellType()) {	// 다양한 형태의 엑셀파일을 가져와서 집어 넣는다.
							case NUMERIC:
								value = cell.getNumericCellValue()+"";
								break;
								
							case STRING:
								value = cell.getStringCellValue()+"";
								break;
								
							case ERROR:
								value = cell.getErrorCellValue()+"";
								break;
							default:
							}
//							System.out.print(value + ",");	// Test Print 
							writeFile(value);
						} else {
							
						}
					}
					writeFile("\n");
//					System.out.println();// Test Print 
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeFile(String str) throws IOException {
		str = ","+str;
		out.write(str);	//파일을 쓰는부분
		
	}
	
	public static void main(String[] args) {
		
		try {
			new ExcelToTxt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
}























