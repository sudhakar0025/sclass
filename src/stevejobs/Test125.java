package stevejobs;
import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

public class Test125
{
	public static void main(String[] args) throws Exception
	{
		//Connect to Excel file
		File f=new File("Book1.xls");
		//Open that excel file for reading
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);//0 means Sheet1
		int nour=rsh.getRows();
		//Open excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);//0 means Sheet1
		//Data driven from 2nd row(index is 1)
		for(int i=1;i<nour;i++)
		{
			int x=Integer.parseInt(rsh.getCell(0,i).getContents());
			int y=Integer.parseInt(rsh.getCell(1,i).getContents());
			int z=x+y;
			Number n=new Number(2,i,z);
			wsh.addCell(n);	
		}
		//Save excel
		wwb.write(); //save
		rwb.close();
		wwb.close();
		
		
		

	}

}
