package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class O2_ExcelReader {

	static FileInputStream fis = null;

	public FileInputStream getFileInputStream() {
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.xlsx";
		// System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.xlsx"
		File srcFile = new File(filePath);

		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. treminating Process !! : Check file path of TestData");
			System.exit(0);
		}
		return fis;
	}

	// ------------------------------------------------------------------------------------------------

	public Object[][] getExcelData() throws IOException {
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int TotalNumberOfRows = (sheet.getLastRowNum() + 1);
		int TotalNumberOfCols = 4;

		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

		for (int i = 0; i < TotalNumberOfRows; i++) {
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}

		wb.close();
		return arrayExcelData;
	}

	// ------------------------------------------------------------------------------------------------

	/*
	 * static FileInputStream streamfile = null;
	 * 
	 * public GetDataFromExcel() throws IOException { super(); }
	 * 
	 * public static Object[][] ReadContactTestData(String SheetName) throws
	 * IOException {
	 * 
	 * // File file = new File("E:\\programs SetUp\\eclipse-workspace\\CRM //
	 * Sheet.xlsx");
	 * 
	 * File file = new File(System.getProperty("user.dir") +
	 * "/src/Data/CRM Sheet.xlsx"); streamfile = new FileInputStream(file);
	 * 
	 * // HSSFWorkbook for xls // XSSFWorkbook for xlsx XSSFWorkbook workbook = new
	 * XSSFWorkbook(streamfile); Sheet sheet = workbook.getSheet(SheetName);
	 * 
	 * // int rows = sheet.getPhysicalNumberOfRows(); // int
	 * columns=sheet.getRow(0).getPhysicalNumberOfCells();
	 * 
	 * int rows = sheet.getLastRowNum(); int columns =
	 * sheet.getRow(0).getFirstCellNum();
	 * 
	 * Object data[][] = new Object[rows - 1][columns];
	 * 
	 * for (int i = 0; i < rows; i++) { for (int j = 0; j < columns; j++) { data[i -
	 * 1][j] = sheet.getRow(i).getCell(j,
	 * Row.MissingCellPolicy.CREATE_NULL_AS_BLANK) .getStringCellValue(); } }
	 * workbook.close(); return data; }
	 */
}