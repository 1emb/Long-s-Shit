package MyFirstPackage;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 


public class ExcelReader  
{  	
	
	public static int checkNegative(String input) {
		if (input.charAt(0) == '-') {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void output(String[][][] out) {
		String max = "";
		String min = "";
		String base = "";
		System.out.print("Max:" + max);
		System.out.print(" Min:" + min);
		System.out.print(" Base:" + base);
		try {
			FileWriter myWriter = new FileWriter("output.txt", true);

			System.out.print("first item when write to out: " + out[0][0][0] +"\n");
			int VN = 0;
			int HNX = 0;
			int UPCOM = 0;
			for (int j = 1; j<21; j++) {
				if (out[1][j][2].charAt(0) == '-') {
					UPCOM = 1;				
					System.out.print("Upcom negative " + out[1][j][2]);
				}
				if (out[0][j][2].charAt(0) == '-') {
					VN = 1;				
					System.out.print("Upcom negative " + out[1][j][2]);
				}
				if (out[2][j][2].charAt(0) == '-') {
					HNX = 1;				
					System.out.print("Upcom negative " + out[1][j][2]);
				}
			}
			//Style 5-3: 
			for (int j = 1; j<21; j++) {
			
				myWriter.write("Đóng cửa phiên giao dịch, chỉ số Vn-Index ");
				if (out[0][j][2].charAt(0) == '-') {
					myWriter.write("giảm ");		
					myWriter.write(out[0][j][2] + " điểm ");	
					myWriter.write("xuống " + out[0][j][1]);	
					
				} else {
					myWriter.write("tăng ");	
					myWriter.write(out[0][j][2] + " điểm ");	
					myWriter.write("lên " + out[0][j][1]);
				}
				myWriter.write(", ");
				int chk1 = 0;
				int chk2 = 0;
				if (out[1][j][2].charAt(0) == '-') {
					chk1 = 1;				
				}
				if (out[2][j][2].charAt(0) == '-') {
					chk2 = 1;
				}
				
				if (chk1 == chk2) {
					myWriter.write("trong khi HNX-Index và Upcom-Index đều ");
					if (chk1 == 0) {
						myWriter.write("giảm nhẹ.");
					} else {
						myWriter.write("tăng nhẹ.");	
					}
				} else {
					myWriter.write("HNX-Index ");
					if (chk2 == 0) {
						myWriter.write("giảm nhẹ ");
						myWriter.write("trong khi UPCOM-Index tăng nhẹ.");
					} else {
						myWriter.write("tăng nhẹ ");	
						myWriter.write("trong khi UPCOM-Index giảm nhẹ.");
					}
				}
				myWriter.write("\n");
			}
				
			//Style 5-7:
			for (int j = 1; j<21; j++) {
				int chk1 = 0;
				int chk2 = 0;
				myWriter.write("Tại thời điểm ngày " + out[0][j][0] + ", chỉ số Vn-Index ");
				if (checkNegative(out[0][j][2]) == 1) {
					myWriter.write("giảm nhẹ ");		
					myWriter.write(out[0][j][2] + " điểm ");	
					myWriter.write("xuống " + out[0][j][1]);	
					
				} else {
					myWriter.write("tăng ");	
					myWriter.write(out[0][j][2] + " điểm ");	
					myWriter.write("lên " + out[0][j][1]);
				}
				chk1 = 0;
				chk2 = 0;
				if (checkNegative(out[1][j][2]) == 1) {
					chk1 = 1;				
					System.out.print("Upcom negative " + out[1][j][2]);
				}
				if (checkNegative(out[2][j][2]) == 1) {
					chk2 = 1;
					System.out.print("HNX negative " + out[2][j][2]);
				}
				
				if (chk1 == chk2) {
					myWriter.write("trong khi HNX-Index và Upcom-Index đều ");
					if (chk1 == 0) {
						myWriter.write("giảm nhẹ.");
					} else {
						myWriter.write("tăng nhẹ.");	
					}
				} else {
					myWriter.write("HNX-Index ");
					if (chk2 == 0) {
						myWriter.write("giảm nhẹ ");
						myWriter.write("trong khi UPCOM-Index tăng nhẹ.");
					} else {
						myWriter.write("tăng nhẹ ");	
						myWriter.write("trong khi UPCOM-Index giảm nhẹ.");
					}
				}
				myWriter.write("\n");
			}
			
			//Style 5-12:
			for (int j = 1; j<21; j++) {
				int chk1 = 0;
				int chk2 = 0;
				myWriter.write("Tại thời điểm ngày " + out[0][j][0] + ", chỉ số Vn-Index ");
				if (checkNegative(out[0][j][2]) == 1) {
					myWriter.write("giảm ");		
					myWriter.write(out[0][j][2] + " điểm ");	
					myWriter.write("xuống " + out[0][j][1]);	
					
				} else {
					myWriter.write("tăng ");	
					myWriter.write(out[0][j][2] + " điểm ");	
					myWriter.write("lên " + out[0][j][1]);
				}
				myWriter.write(", ");
				chk1 = 0;
				chk2 = 0;
				if (checkNegative(out[1][j][2]) == 1) {
					chk1 = 1;				
					System.out.print("Upcom negative " + out[1][j][2]);
				}
				if (checkNegative(out[2][j][2]) == 1) {
					chk2 = 1;
					System.out.print("HNX negative " + out[2][j][2]);
				}
				
				if (chk1 == chk2) {
					myWriter.write("trong khi HNX-Index và Upcom-Index đều ");
					if (chk1 == 0) {
						myWriter.write("giảm nhẹ.");
					} else {
						myWriter.write("tăng nhẹ.");	
					}
				} else {
					myWriter.write("HNX-Index ");
					if (chk2 == 0) {
						myWriter.write("giảm nhẹ ");
						myWriter.write("trong khi UPCOM-Index tăng nhẹ.");
					} else {
						myWriter.write("tăng nhẹ ");	
						myWriter.write("trong khi UPCOM-Index giảm nhẹ.");
					}
				}
				myWriter.write("\n");
			}
				
			//Style 5-16:
			for (int j = 1; j<21; j++) {
				myWriter.write("Chỉ số VN-Index ");
				if (checkNegative(out[0][j][2]) == 1) {
					myWriter.write("mất ");
				} else {
					myWriter.write("được ");
				}
				myWriter.write(out[0][j][2] + ", ");
				myWriter.write("đóng cửa tại ngưỡng ");
				myWriter.write(out[0][j][1] + ", ");
				myWriter.write("và chỉ số HNX-Index ");
				if (checkNegative(out[2][j][2]) == 1) {
					myWriter.write("giảm ");
				} else {
					myWriter.write("tăng ");
				}
				myWriter.write(out[2][j][2] + ", ");
				myWriter.write("đóng cửa tại ngưỡng ");
				myWriter.write(out[2][j][1] + " điểm.");
				myWriter.write("\n");	
			}
			//Style 5-17:
			for (int j = 1; j<21; j++) {
				myWriter.write("Đóng cửa tuần giao dịch, VN-Index ");
				if (checkNegative(out[0][j][2]) == 1) {
					myWriter.write("giảm ");
				} else {
					myWriter.write("tăng ");
				}
				myWriter.write(out[0][j][2] + " ");
				myWriter.write("về mức ");
				myWriter.write(out[0][j][1] + " điểm, ");
				myWriter.write("còn chỉ số HNX-Index ");
				if (checkNegative(out[2][j][2]) == 1) {
					myWriter.write("giảm ");
				} else {
					myWriter.write("tăng ");
				}
				myWriter.write(out[2][j][2] + ", ");
				myWriter.write("về mức ");
				myWriter.write(out[2][j][1] + " điểm.");
				myWriter.write("\n");
			}
			
			
			//Style 5-18:
			for (int j = 1; j<21; j++) {
				myWriter.write("Đóng cửa, chỉ số VN-Index ");
				if (checkNegative(out[0][j][2]) == 1) {
					myWriter.write("giảm ");
				} else {
					myWriter.write("tăng ");
				}
				myWriter.write(out[0][j][2] + " ");
				myWriter.write("và tái chiếm lại mốc ");
				myWriter.write(out[0][j][1] + " điểm, ");
				myWriter.write("trong khi chỉ số HNX-Index ");
				if (checkNegative(out[2][j][2]) == 1) {
					myWriter.write("giảm ");
				} else {
					myWriter.write("tăng ");
				}
				myWriter.write(out[2][j][2] + ", ");
				myWriter.write("và đóng cửa tại ");
				myWriter.write(out[2][j][1] + " điểm.");
				myWriter.write("\n");
			}
			myWriter.write("\n");
			
			
			//Style 35-0:
			for (int j = 1; j<21; j++) {
				myWriter.write("Tại thời điểm ngày " + out[0][j][0]);
				myWriter.write(", chỉ số VN_Index ");
				if (checkNegative(out[0][j][2]) == 1) {
					myWriter.write("giảm ");
					myWriter.write(out[0][j][2]);
					myWriter.write("xuống ");
					myWriter.write(out[0][j][1]);
				} else {
					myWriter.write("tăng ");
					myWriter.write(out[0][j][2]);
					myWriter.write("lên ");
					myWriter.write(out[0][j][1]);
				}
				
				myWriter.write("; chỉ số Hnx_Index ");
				if (checkNegative(out[2][j][2]) == 1) {
					myWriter.write("giảm ");
					myWriter.write(out[2][j][2] + " ");
					myWriter.write("xuống ");
					myWriter.write(out[2][j][1] + " ");
				} else {
					myWriter.write("tăng ");
					myWriter.write(out[2][j][2] + " ");
					myWriter.write("lên ");
					myWriter.write(out[2][j][1] + " ");
				}
				
				myWriter.write("và Upcom_Index ");
				if (checkNegative(out[1][j][2]) == 1) {
					myWriter.write("giảm ");
					myWriter.write(out[1][j][2]);
					myWriter.write(" xuống ");
					myWriter.write(out[1][j][1]);
				} else {
					myWriter.write("tăng ");
					myWriter.write(out[1][j][2]);
					myWriter.write(" lên ");
					myWriter.write(out[1][j][1]);
				}
				myWriter.write(".\n");
			}
			
			//Style 35-1:
			for (int j = 1; j<21; j++) {
				myWriter.write("Tại thời điểm ngày " + out[0][j][0]);
				myWriter.write(", chỉ số VN_Index ");
				if (checkNegative(out[0][j][2]) == 1) {
					myWriter.write("giảm ");
					myWriter.write(out[0][j][2]);
					myWriter.write(" xuống ");
					myWriter.write(out[0][j][1]);
				} else {
					myWriter.write("tăng nhẹ");
					myWriter.write(out[0][j][2]);
					myWriter.write(" lên ");
					myWriter.write(out[0][j][1]);
				}
				
				myWriter.write("; trong khi chỉ số Hnx_Index ");
				if (checkNegative(out[2][j][2]) == 1) {
					myWriter.write("giảm ");
					myWriter.write(out[2][j][2] + " ");
					myWriter.write("xuống ");
					myWriter.write(out[2][j][1] + " ");
				} else {
					myWriter.write("tăng ");
					myWriter.write(out[2][j][2] + " ");
					myWriter.write("lên ");
					myWriter.write(out[2][j][1] + " ");
				}
				
				myWriter.write("và Upcom_Index ");
				if (checkNegative(out[1][j][2]) == 1) {
					myWriter.write("giảm ");
					myWriter.write(out[1][j][2]);
					myWriter.write(" xuống ");
					myWriter.write(out[1][j][1]);
				} else {
					myWriter.write("tăng ");
					myWriter.write(out[1][j][2]);
					myWriter.write(" lên ");
					myWriter.write(out[1][j][1]);
				}
				myWriter.write(".\n");	
			}
			
			//Style 35-15:
			for (int j = 1; j<21; j++) {
				myWriter.write("Tính đến thời điểm ngày " + out[0][j][0]);
				myWriter.write(", VN_Index ");
				if (checkNegative(out[0][j][2]) == 1) {
					myWriter.write("giảm ");
					myWriter.write(out[0][j][2]);
					myWriter.write(" xuống ");
					myWriter.write(out[0][j][1]);
				} else {
					myWriter.write("tăng ");
					myWriter.write(out[0][j][2]);
					myWriter.write(" lên ");
					myWriter.write(out[0][j][1]);
				}
				
				myWriter.write("; Hnx_Index ");
				if (checkNegative(out[2][j][2]) == 1) {
					myWriter.write(" giảm ");
					myWriter.write(out[2][j][2] + " ");
					myWriter.write("xuống ");
					myWriter.write(out[2][j][1] + " ");
				} else {
					myWriter.write(" tăng ");
					myWriter.write(out[2][j][2] + " ");
					myWriter.write("lên ");
					myWriter.write(out[2][j][1] + " ");
				}
				
				myWriter.write("và Upcom_Index ");
				if (checkNegative(out[1][j][2]) == 1) {
					myWriter.write("giảm ");
					myWriter.write(out[1][j][2]);
					myWriter.write(" xuống ");
					myWriter.write(out[1][j][1]);
				} else {
					myWriter.write("tăng ");
					myWriter.write(out[1][j][2]);
					myWriter.write(" lên ");
					myWriter.write(out[1][j][1]);
				}
				myWriter.write(".\n");	
			}
			
			//Style 35-22:
			for (int j = 1; j<21; j++) {
				myWriter.write("Tại thời điểm ngày " + out[0][j][0]);
				myWriter.write(",chỉ số VN_Index ");
				if (checkNegative(out[0][j][2]) == 1) {
					myWriter.write("giảm ");
					myWriter.write(out[0][j][2]);
					myWriter.write(" xuống ");
					myWriter.write(out[0][j][1]);
				} else {
					myWriter.write("tăng ");
					myWriter.write(out[0][j][2]);
					myWriter.write(" lên ");
					myWriter.write(out[0][j][1]);
				}
				
				myWriter.write("; Hnx_Index ");
				if (checkNegative(out[2][j][2]) == 1) {
					myWriter.write(" giảm ");
					myWriter.write(out[2][j][2] + " ");
					myWriter.write("xuống ");
					myWriter.write(out[2][j][1]);
				} else {
					myWriter.write(" tăng ");
					myWriter.write(out[2][j][2] + " ");
					myWriter.write("lên ");
					myWriter.write(out[2][j][1]);
				}
				myWriter.write(".\n");	
			}
			
		    myWriter.close();
		    System.out.println("Successfully wrote to the file.");
		}
		
		catch (IOException e){
			System.out.println("An error occurred.");
		    e.printStackTrace();
			
		}
		
	}
	
	public static void outputRestart() {
		try {
			FileWriter myWriter = new FileWriter("output.txt");
			myWriter.write("\n");
		    
		    myWriter.close();
		    System.out.println("Successfully clear output");
		}
		catch (IOException e){
			System.out.println("An error occurred in output clearing.");
		    e.printStackTrace();
			
		}
	}
	
	public static void checkOutputFile() {
	try {
		File myObj = new File("output.txt");
		if (myObj.createNewFile()) {
			System.out.println("File created: " + myObj.getName());
	    } else {
	        System.out.println("File already exists.");
	    }
	 } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	 }
		
	}
	static XSSFRow row;
	public static void main(String args[])throws Exception { 
		outputRestart();
		ArrayList<String> Column = new ArrayList<String>();
		String[][][] dayData = new String[3][21][10];
		
		
		checkOutputFile();
		
	  File file = new File("D:\\Java Workspace\\3-STOCK-INDEX.xlsx");
	  FileInputStream fIP = new FileInputStream(file);
      int i = 0;
      int j = 0;
      int k = 0;
      
	  XSSFWorkbook workbook = new XSSFWorkbook(fIP);
      XSSFSheet spreadsheetVN_INDEX = workbook.getSheetAt(0);
      Iterator < Row >  rowIterator0 = spreadsheetVN_INDEX.iterator();

      while (rowIterator0.hasNext()) { 	  
         row = (XSSFRow) rowIterator0.next();
         Iterator < Cell >  cellIterator = row.cellIterator();
         
         while ( cellIterator.hasNext()) {

            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
               case Cell.CELL_TYPE_NUMERIC:
            	  if (HSSFDateUtil.isCellDateFormatted(cell)) {
            		  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            		  dayData[i][j][k] = df.format(cell.getDateCellValue()); 		  
            	  } 
            	  break;
               
               case Cell.CELL_TYPE_STRING:
            	   dayData[i][j][k] = cell.getStringCellValue();
            	   break;
            }
            k++;
         }
         k = 0;
         System.out.println();
         j++;
      }
      j = 0;
      i++;
      
      XSSFSheet spreadsheetUPCOM_INDEX = workbook.getSheetAt(1);
      Iterator < Row >  rowIterator1 = spreadsheetUPCOM_INDEX.iterator();

      
      while (rowIterator1.hasNext()) { 	  
         row = (XSSFRow) rowIterator1.next();
         Iterator < Cell >  cellIterator = row.cellIterator();
         
         while ( cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
               case Cell.CELL_TYPE_NUMERIC:
            	  if (HSSFDateUtil.isCellDateFormatted(cell)) {
            		  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            		  dayData[i][j][k] = df.format(cell.getDateCellValue()); 		  
            	  } 
            	  break;
               
               case Cell.CELL_TYPE_STRING:
            	   System.out.print(cell.getStringCellValue() + " \t\t ");
            	   dayData[i][j][k] = cell.getStringCellValue();
            	   break;
            }
            k++;
         }
         k = 0;
         System.out.println();
         j++;
      }
      j = 0;
      i++;
      
      XSSFSheet spreadsheetHNX_INDEX = workbook.getSheetAt(2);
      Iterator < Row >  rowIterator2 = spreadsheetHNX_INDEX.iterator();

      
      while (rowIterator2.hasNext()) { 	  
         row = (XSSFRow) rowIterator2.next();
         Iterator < Cell >  cellIterator = row.cellIterator();
         
         while ( cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
               case Cell.CELL_TYPE_NUMERIC:
            	  if (HSSFDateUtil.isCellDateFormatted(cell)) {
            		  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            		  System.out.print("bruh");
            		  dayData[i][j][k] = df.format(cell.getDateCellValue()); 		  
            	  } 
            	  break;
               
               case Cell.CELL_TYPE_STRING:
            	   System.out.print(cell.getStringCellValue() + " \t\t ");
            	   dayData[i][j][k] = cell.getStringCellValue();
            	   break;
               case Cell.CELL_TYPE_BLANK:
            	   break;
            }
            k++;
         }
         k = 0;
         System.out.println();
         j++;
      }
      j = 0;
      i++;
      
      for (int j1 = 0; j1<21; j1++) {
    	  for (int k1 = 0; k1<10; k1++) {
    		  System.out.print(" "+dayData[1][j1][k1]+" ");  	  
    	  }
    	  System.out.println();
      }
      output(dayData);
      fIP.close();
	}  
}  