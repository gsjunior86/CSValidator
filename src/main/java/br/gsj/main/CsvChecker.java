package br.gsj.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.gsj.schema.SchemaLoader;

public class CsvChecker {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		if (args.length < 1)
			throw new IllegalArgumentException("Usage: <csv_input_file>");

		File inputFile = new File(args[0]);
		if (!inputFile.exists())
			throw new IllegalArgumentException("Input file does not exists.");

		FileReader fr = new FileReader(inputFile); // reads the file
		BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
		String line = br.readLine();
		if(line == null)
			throw new Exception("File is Empty");
		
		String[] headers = SchemaLoader.getHeaders();
		String[] fileHeader = line.split(",");
		
		if(headers.length != fileHeader.length)
			throw new Exception("Header is not as expected");
		
		for (int i = 0; i < headers.length; i++) {
			if(!headers[i].equals(fileHeader[i]))
				throw new Exception("Header is not as expected. Wrong Column : " + fileHeader[i]);
		}
		
		int nLine = 2;
		while ((line = br.readLine()) != null) {
			String[] lineData = line.split(",");
			if(lineData.length < headers.length)
				throw new Exception("Missing Columns at line : " + nLine);
			
			if(lineData.length > headers.length)
				throw new Exception("Extra Columns at line : " + nLine);
			
			for(String value: lineData)
				checkIfStringHasWrongChars(value);
			
			
			nLine +=1;
		}
		
		System.out.println("CSV File is OK");

	}
	
	
	public static void checkIfStringHasWrongChars(String value) throws Exception {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(value);
		if (m.find())
			throw new Exception("Invalid character on String: " + value);
	}

}
