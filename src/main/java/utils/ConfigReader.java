package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties intializeProperties()
	{
		
		Properties prop=new Properties();
		
		File filePath=new File(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			prop.load(fis);
			} 
		catch (IOException e) {
		
			e.printStackTrace();
		}
	
		return prop;
	}
	

}
