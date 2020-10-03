package br.gsj.schema;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchemaLoader {

	private static String[] HEADERS;

	//private static File inputHeader = new File("src/main/resources/headers.txt");
	private static File inputHeader = new File("headers.txt");

	
	public static String[] getHeaders() {
		if (HEADERS == null) {

			List<String> listColumns = new ArrayList<String>();
			try {
				Scanner myReader = new Scanner(inputHeader);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					listColumns.add(data);
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Could not find headers.txt");
			}
			String ex[] = new String[1];
			HEADERS = listColumns.toArray(ex);
		}
		
		return HEADERS;

	}

}
