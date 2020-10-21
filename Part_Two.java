package com.project_File_IO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.util.*;



public class Part_Two extends Part_One{
	
	
	public static void main(String[] args) {
		
		boolean continueCode = true;
		
			try(BufferedReader br = new BufferedReader(new FileReader(args[0]));
			Scanner Scanner = new Scanner(new File(args[0]));
			PrintWriter conferenceOut = new PrintWriter("conference.txt");
			PrintWriter lodgingOut = new PrintWriter("lodging.txt");
			PrintWriter dinnerOut = new PrintWriter("dinner.txt");){
				String line;
			    while ((line = br.readLine()) != null) {
					
					String inputLine = Scanner.nextLine();
					Scanner lineScan = new Scanner(inputLine);
					lineScan.useDelimiter(";");
					String name = lineScan.next();
					String service = lineScan.next();
					double amount = lineScan.nextDouble();
					String date = lineScan.next();
					
					if(service.equalsIgnoreCase("conference")) {
						writeSale(conferenceOut, name, service, amount, date);
						
					}
					else if(service.equalsIgnoreCase("lodging")) {
						writeSale(lodgingOut, name, service, amount, date);
					
					}
					else if(service.equalsIgnoreCase("dinner")) {
						writeSale(dinnerOut, name, service, amount, date);
						
					}
						
					if(!Scanner.hasNextLine()) {
						continueCode = false;
						conferenceOut.close();
						lodgingOut.close();
						dinnerOut.close();
						System.out.println("Compilation Complete.");
					}
						
						
				}
			}
			catch(FileNotFoundException e) {
				System.out.println("File was not found. Try Again: ");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			catch(NoSuchElementException e) {
				System.out.println("File format not valid. Try Again: ");
			}
			
	}

}
