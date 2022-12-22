package com;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class LockMe {
	static final String path = "/home/helenabtjmayban/Desktop/Assignment Phase 1/FileFolder/";
	
	public static void display() {
		
		System.out.println("PLEASE ENTER OPTION");
		System.out.println("OPTION 1: Retrieve all file in ascending order");
		System.out.println("OPTION 2  Add new file");
		System.out.println("OPTION 3: Delete file");
		System.out.println("OPTION 4: Search file");
		System.out.println("OPTION 5: Exit");
	}
	
	public static void proceed() {
		
		System.out.println("Continue? Press Y for Main Menu");
		Scanner scyn = new Scanner(System.in);
		String inp = scyn.nextLine();
		String inp1 = inp.toUpperCase();
		if (inp1.equals("Y")) {
			display();
		}else {
			System.out.println("EXIT SYSTEM. SEE YOU AGAIN");
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("WELCOME to LOCKME.COM");
		System.out.println("FILE MANAGEMENT TOOLS");
		System.out.println("**********************");
		
		Scanner sc = new Scanner(System.in);
		int opt = 0;
		display();
		try {
			do {
				opt = Integer.parseInt(sc.nextLine());
					
				switch (opt) {
				case 1:
					System.out.println("RETRIEVE ALL FILES IN ASCENDING ORDER");
					
					File fff = new File(path);
					String listoffiles[] = fff.list();
					Arrays.sort(listoffiles);
					System.out.println("Folder name :"+fff.getAbsolutePath());
					for (String fname : listoffiles) {
						System.out.println(fname);
					}
					proceed();
					break;
					
				case 2:
					System.out.println("ADD NEW FILE");
					Scanner sc1 = new Scanner(System.in);
					String f1 = sc1.nextLine();
					
					File ff1 = new File(path +f1);
					
					if (ff1.createNewFile()) {
						System.out.println("File created");
					} else {
						System.out.println(f1 +" file exists. Please create another new file");
					}		
					proceed();			
					break;

				case 3:
					System.out.println("DELETE FILE");
					Scanner sc2 = new Scanner(System.in);
					String f2 = sc2.nextLine();
					
					File ff2 = new File(path +f2);
					
					if (ff2.delete()) {
						System.out.println("File deleted");
					} else {
						System.out.println(f2 +" not found. Please try again");
					}		
					proceed();			
					break;
				
				case 4:
					System.out.println("SEARCH FILE");
					System.out.println("ENTER FILE NAME TO SEARCH");
					Scanner sc3 = new Scanner(System.in);
					String f3 = sc3.next();
					File ff3 = new File(path +f3);
					
					if (ff3.exists()) {
						System.out.println("File exist");
					} else {
						System.out.println("File not found. Please try again");
					}
					proceed();
					break;
				case 5:
					System.out.println("EXIT SYSTEM. SEE YOU AGAIN");
				
					break;
					
				default:
					System.out.println("WRONG OPTION SELECTED");
					proceed();
					break;
				}

			} while (opt>0);	
		
		} catch (Exception e) {
			System.out.println("WRONG OPTION SELECTED");
			proceed();
		}
		

	}
}
