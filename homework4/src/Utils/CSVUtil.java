package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;

public class CSVUtil {
	private  String csvFilePath;
	
	

	public String getCsvFilePath() {
		return csvFilePath;
	}

	public void setCsvFilePath(String csvFilePath) {
		this.csvFilePath = csvFilePath;
	}


	/**
	 * 获取一行数据
	 * @param csvFilePath
	 * @param rowNum
	 * @return
	 */
	public String[] getRowData(long rowNum){
		String[] rowStrings = {};
		try {
			CsvReader reader = new CsvReader(csvFilePath, ',');
			//CsvWriter writer = new CsvWriter(targetFile,',');
			//writer.setForceQualifier(true);
			//读取文件头
			String[] header ={};
			while (reader.readRecord()) {
				if (0==reader.getCurrentRecord()) {
					header = reader.getValues();
				}
				if (rowNum ==reader.getCurrentRecord()) {
					String rowString = reader.getRawRecord();
					rowStrings =rowString.split(",");
				}
			}
			
			reader.close();
			//writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowStrings;
	}
	
	
	public long getAllNum(){
		
		long rowAllNum=0;
		
		try {
			CsvReader reader = new CsvReader(csvFilePath, ',');
			//CsvWriter writer = new CsvWriter(targetFile,',');
			//writer.setForceQualifier(true);
			//读取文件头
			String[] header ={};
			while (reader.readRecord()) {
				if (0==reader.getCurrentRecord()) {
					header = reader.getValues();
				}
				rowAllNum = reader.getCurrentRecord();
			}
			reader.close();
			//writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowAllNum;
	}

}
