package SauceDemo.Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRead {
	XSSFSheet sheet;
	XSSFWorkbook wb;
	public  ExcelDataRead(String path) throws FileNotFoundException {
		File f=new File(path);
		FileInputStream FIS=new FileInputStream(f);
		try {
			 wb=new XSSFWorkbook(FIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String getData(int sheetNumber,int row,int col) {
		XSSFSheet sheet=wb.getSheetAt(sheetNumber);
		String data=sheet.getRow(row).getCell(col).getStringCellValue();
		
		System.out.println(data);
		return data;
		
	}
	
	public int getRowcount(int Sheetindex)
	{
		int row=wb.getSheetAt(Sheetindex).getLastRowNum();   //it ill return 4 rows.if we have 5 rows in ececxcel
		row=row+1;    //return excat rows count in excel
		
		return row;
	}
	public static void main(String[] args) throws FileNotFoundException {
		ExcelDataRead Filepath=new ExcelDataRead(".//TestData//LoginDataSauceDemo.xlsx");
		Filepath.getData(0, 1, 0);
		Filepath.getData(0, 1, 1);
		System.out.println(Filepath.getRowcount(0));
		
	}

}
