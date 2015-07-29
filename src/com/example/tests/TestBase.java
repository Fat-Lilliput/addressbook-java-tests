/*
 * This class contains methods needed for correctly auto-tests work 
 * and common methods for all application's modules
 */
package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.example.fw.ApplicationManager;

public class TestBase {
	public static ApplicationManager app;
	
	@BeforeClass
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = ApplicationManager.getInstance();
		app.setProperties(properties);
	  }

	@AfterClass
	public void tearDown() throws Exception {
		app.stop();
	}

}
