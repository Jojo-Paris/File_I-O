package com.project_File_IO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;
import java.util.*;



public class Part_One {
	
	private static void start() {
		System.out.println("Hello HotelPerson Welcome!\n");
	}
	
	public static void writeSale(PrintWriter o, String Name, String service,
			double amount, String date) {
		
		o.print(Name);
		o.print(";");
		o.print(service);
		o.print(";");
		o.print(amount);
		o.print(";");
		o.print(date);
		o.println();
		
	}

	public static void main(String[] args) {
		
		start();	
		boolean continueCode = true;
		try(PrintWriter writer = new PrintWriter("sales.txt");)
		{
			while(continueCode) {
				
			
				Scanner Scanner = new Scanner(System.in);
				
				System.out.println("Please Enter A First Name With No Spaces:");
				
				while(!Scanner.hasNext("[A-Za-z]+")) {
					System.out.println("\nThats Not A Formal First Name. Try Again. ");
					Scanner.next();
				}
				String firstName = Scanner.next();
				
				System.out.println("\nPlease Enter A Last Name With No Spaces:");
				
				while(!Scanner.hasNext("[A-Za-z]+")) {
					System.out.println("\nThats Not A Formal Last Name. Try Again. ");
					Scanner.next();
				}
				
				String lastName = Scanner.next();
				
				System.out.println("\nPlease Enter Either Dinner, Conference, or Lodging");
				
				String checkService = Scanner.next();
				while(!checkService.equalsIgnoreCase("dinner") && !checkService.equalsIgnoreCase("conference") && !checkService.equalsIgnoreCase("lodging")) {
					System.out.println("\nThats Not A Formal Type of Service Here. Try Again. ");
					checkService = Scanner.next();
				}
				
				String Name = firstName + " " + lastName;
				
				String service = checkService;
				
				System.out.println("\nPlease Enter The Amount in a Decimal Value. ");
				
				while(!Scanner.hasNextDouble()) {
					System.out.println("\nThats Not A Formal Decimal. Try Again. ");
					Scanner.next();
				}
				double amount = Scanner.nextDouble();
				
				System.out.println("");
				
				System.out.println("Please Enter A Month with Two Numbers or Less");
				String checkMonth = Scanner.next();
				while(!(checkMonth.length() <= 2)) {
					System.out.println("\nThats Not A Formal Month with Two or Less Numbers ");
					checkMonth = Scanner.next();
				}
				String month = checkMonth;
				
				System.out.println("Please Enter A Day with Two Numbers or Less");
				String checkDay = Scanner.next();
				while(!(checkDay.length() <= 2)) {
					System.out.println("\nThats Not A Formal Day with Two or Less Numbers ");
					checkDay = Scanner.next();
				}
				String day = checkDay;
				
				System.out.println("Please Enter A Year with Four Numbers: ");
				String checkYear = Scanner.next();
				while(!(checkYear.length() == 4)) {
					System.out.println("\nThats Not A Formal Year with Four Numbers ");
					checkYear = Scanner.next();
				}
				String year = checkYear;
				
				String date = month + "/" + day + "/" + year;
				
				writeSale(writer, Name, service, amount, date);
				
				System.out.println("\nWould you like Another Sale? yes or no?");
				
				String stringContinue = Scanner.next();
				if(stringContinue.equalsIgnoreCase("no")) {
					continueCode = false;
					writer.close();
				}	
			}
		}
		catch(FileNotFoundException e) {
				System.out.println("File was not found. Try Again: ");
		}
		catch(NoSuchElementException e) {
				System.out.println("File format not valid. Try Again: ");
		}
	}

}
