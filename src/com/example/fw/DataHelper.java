package com.example.fw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
import static com.example.fw.ApplicationManager.currentDb;

public class DataHelper{

//	public static void main(String[] args) throws IOException {
//	}
	
	public static void applyData (String newData) throws IOException {
		Files.deleteIfExists(Paths.get(currentDb));
		Files.copy(Paths.get(newData), Paths.get(currentDb));
		
	}

}
