package com.Flipkart.Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class XLUtility extends Configue {
public  static FileInputStream f;
	@DataProvider(name="login")
public Object[][] setData() throws EncryptedDocumentException, IOException, InvalidFormatException
{
	Object[][] loginData =getData("Sheet1");
	return loginData;
}


	public static  Object[][] getData(String shet) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		 f=new FileInputStream(xlpath);

			Workbook workbook = WorkbookFactory.create(f);
		org.apache.poi.ss.usermodel.Sheet sheet=	 workbook.getSheet(shet);
		int rows = sheet.getLastRowNum();
		   int cols = sheet.getRow(1).getLastCellNum();
		   
	
	
		System.out.println("row =" + rows);
		System.out.println("coloum =" + cols);
		Object [][]data=new Object[rows][cols];
		for(int i=0;i<rows;i++)
		{
			Row row = sheet.getRow(i+1);
			for(int j=0;j<cols;j++)
			{
				Cell cell = row.getCell(j);
				data[i][j]=cell.getStringCellValue();
				
				
			}
		}
		return data;
		
		
		
			}

}
