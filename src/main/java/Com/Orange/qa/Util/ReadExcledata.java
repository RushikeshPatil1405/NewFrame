package Com.Orange.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcledata {
	
	@DataProvider(name="testData")
	public String[][] getexcle(String ExcleSheetname ) throws EncryptedDocumentException, IOException {
		
	File file=new File(System.getProperty("user.dir")+"//Testdata//Data.xlsx");
	
	FileInputStream files=new FileInputStream(file);
	
	Workbook WB=WorkbookFactory.create(files);
	
	Sheet Sheetname=WB.getSheet(ExcleSheetname);
	
	int TotalRows=Sheetname.getLastRowNum();
	System.out.println(TotalRows);
	
	Row rowcells=Sheetname.getRow(0);
	
	int TotalCell=rowcells.getLastCellNum();
	System.out.println(TotalCell);
	DataFormatter format=new DataFormatter();
	
	String testData[][]=new String[TotalRows][TotalCell];
	for(int i=1;i<=TotalRows;i++) {
		
		for(int j=0;j<TotalCell;j++) {
			
			testData[i-1][j]=format.formatCellValue(Sheetname.getRow(j).getCell(j));
			System.out.println(testData[i-1][j]);
			
		}
	}
	
	
	return testData;
	
	
	}

	public static String getProperty(String string) {
		
		return null;
	}

}
