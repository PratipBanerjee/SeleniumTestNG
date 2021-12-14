package framework.dataprovidermanager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ExcelReader {

    private String sheetDirectory = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData";

    public List<HashMap<String, String>> GetTestData(String sheetName)
    {
        List <HashMap<String, String>> data = new ArrayList<>();

        try
        {
            FileInputStream testdatarepository = new FileInputStream(sheetDirectory+"\\TestData.xlsx");
            XSSFWorkbook testdatarepositorywb = new XSSFWorkbook(testdatarepository);
            XSSFSheet testdatarepositorysheet = testdatarepositorywb.getSheet(sheetName);
            Row columnnamerow = testdatarepositorysheet.getRow(0);
            for(int row = 1; row<testdatarepositorysheet.getPhysicalNumberOfRows(); row++)
            {
                Row currentRow = testdatarepositorysheet.getRow(row);
                HashMap<String, String> currentRowData = new HashMap<>();
                for(int cell = 0; cell<currentRow.getPhysicalNumberOfCells(); cell++)
                {
                    Cell currentCell = currentRow.getCell(cell);
                    currentRowData.put(columnnamerow.getCell(cell).getStringCellValue(), currentCell.getStringCellValue());
                }

                data.add(currentRowData);
            }

            testdatarepositorywb.close();
            testdatarepository.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return data;
    }


}
