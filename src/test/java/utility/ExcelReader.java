package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	
	XSSFWorkbook wb;
	
	public ExcelReader() throws Exception
	{
		System.out.println("===Excel file is loading====");
		
		String location =System.getProperty("user.dir");
		
		File src=new File(location+"\\TestData\\AppData.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		wb=new XSSFWorkbook(fis);
		
		System.out.println("===Excel file is loaded===");
		
		System.out.println("Fine");
	}
	
	
	public String readStringData(String sheetName, int rowIndex, int columnIndex)
	{
		String data=wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();
		return data;
	}
	
	public int readNumericData(String sheetName, int rowIndex,int columnIndex)
	{
		int data =(int)wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
		return data ;
	}
	
	
	public int getRows(String sheetName)
	{
		int row=wb.getSheet(sheetName).getPhysicalNumberOfRows();
		return row;
	}

}
