package com.tyss.bank.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author abhijith s
 * It is used to read data from Excel File
 */

public class ExcelUtility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param colNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getDataFromExcelFileInString(String sheetName,int rowNumber,int colNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/testscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(colNumber).getStringCellValue();	
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param colNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getDataFromExcelFileInNumber(String sheetName,int rowNumber,int colNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/testscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return (int)workbook.getSheet(sheetName).getRow(rowNumber).getCell(colNumber).getNumericCellValue();	
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param colNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public boolean getDataFromExcelFileInBoolean(String sheetName,int rowNumber,int colNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/testscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(colNumber).getBooleanCellValue();	
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param colNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public LocalDateTime getDataFromExcelFileInDateFormat(String sheetName,int rowNumber,int colNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/testscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(colNumber).getLocalDateTimeCellValue();	
	}
}
