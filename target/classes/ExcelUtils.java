package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	//Identify Testcases coloum by scanning the entire 1st row
	//once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
	//after you grab purchase testcase row = pull all the data of that row and feed into test

	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		//fileInputStream argument
		ArrayList<String> a=new ArrayList<String>();

		FileInputStream fis=new FileInputStream("C://Users//venkatesh.m//Framework//src//main//java//Resources//TestData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook(fis);

		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("SOXTestCases"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				//Identify Testcases coloum by scanning the entire 1st row

				Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
				Row firstrow= rows.next();
				Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
				int k=0;
				int coloumn = 0;
				while(ce.hasNext())
				{
					Cell value=ce.next();

					if(value.getStringCellValue().equalsIgnoreCase("TestStep"))
					{
						coloumn=k;

					}

					k++;
				}
				System.out.println(coloumn);

				////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
				while(rows.hasNext())
				{

					Row r=rows.next();

					if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName))
					{

						////after you grab purchase testcase row = pull all the data of that row and feed into test

						Iterator<Cell>  cv=r.cellIterator();
						while(cv.hasNext())
						{
							Cell c= cv.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{

								a.add(c.getStringCellValue());
							}
							else{

								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}
						}
					}


				}

			}
		}
		return a;

	}

	/*public static void main(String[] args) throws IOException {

	}*/

	//*********************//***************************//***********************

   //capture Dynamic value/Event ID in new sheet
	public void setData(String EventIdNumber) throws IOException
	{

		FileInputStream fis=new FileInputStream("C://Users//venkatesh.m//Framework//src//main//java//Resources//TestData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook(fis);

		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("CaptureData"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				//Identify Testcases coloum by scanning the entire 1st row

				Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
			//	Row firstrow= rows.next();
				//Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
				int k=0;
				int rownum = 0;
				while(rows.hasNext())
				{
					Row firstrow= rows.next();
					Iterator<Cell> ce=firstrow.cellIterator();
					Cell value=ce.next();

					if(value.getStringCellValue().equalsIgnoreCase("EventIdNumber"))
					{
						rownum=k;
						System.out.println("Entered into IF Loop");
						System.out.println("The Column id/name is " +rownum);
						sheet.getRow(rownum).createCell(1).setCellValue(EventIdNumber);
						FileOutputStream output = new FileOutputStream("C://Users//venkatesh.m//Framework//src//main//java//Resources//TestData.xlsx");
						workbook.write(output);
						System.out.println("The data is written into Excel");
						break;
					}

					k++;
				}

			}
		}

	}


	//***************************//*************************//*****************


	public ArrayList<String> getDynamicData(String DynamicData) throws IOException
	{
		//fileInputStream argument
		ArrayList<String> a=new ArrayList<String>();

		FileInputStream fis=new FileInputStream("C://Users//venkatesh.m//Framework//src//main//java//Resources//TestData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook(fis);

		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("CaptureData"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				//Identify Testcases coloum by scanning the entire 1st row

				Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
				Row firstrow= rows.next();
				Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
				int k=0;
				int coloumn = 0;
				while(ce.hasNext())
				{
					Cell value=ce.next();

					if(value.getStringCellValue().equalsIgnoreCase("EventId"))
					{
						coloumn=k;

					}

					k++;
				}
				System.out.println(coloumn);

				////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
				while(rows.hasNext())
				{

					Row r=rows.next();

					if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(DynamicData))
					{

						////after you grab purchase testcase row = pull all the data of that row and feed into test

						Iterator<Cell>  cv=r.cellIterator();
						while(cv.hasNext())
						{
							Cell c= cv.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{

								a.add(c.getStringCellValue());
							}
							else{

								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}
						}
					}


				}

			}
		}
		return a;

	}
}

//*********************//***************************//***********************