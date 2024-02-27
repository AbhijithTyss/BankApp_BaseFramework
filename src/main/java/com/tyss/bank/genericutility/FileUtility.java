package com.tyss.bank.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author abhijith s
 * It is used to read data from Property file
 */
public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
