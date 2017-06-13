package com.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This Program is a specific use case for neoload tool which consumes csv
 */


public class CSVCreationForDuration {

	public static void main(String[] args) throws IOException {
		
		
		String Prjname="C:\\Users\\ashutosh\\project.nlp";
		String itrName="SimpleApp_Scenario_Iteration1";
		
		//Time logic is for neload tool
		int HourstoRun=24;
		int ExpSceTimeMinutes=5;
		int NumofItePerHour=(60/ExpSceTimeMinutes);
		
		int TotalnumOfitr = (HourstoRun *NumofItePerHour);
		System.out.println("TotalnumOfitr   "+TotalnumOfitr);
				
		
		String csv = "output.csv";
		CSVCreationForDuration createCSV=new CSVCreationForDuration();
		createCSV.generateCSV(csv,Prjname,itrName,TotalnumOfitr);
		
	}
	
	public void generateCSV(String csvName,String p1,String p2,int count) throws IOException{
		

		String finalConcat=p1+","+p2;
		System.out.println("finalConcat String :"+finalConcat);
		
		ArrayList<String> alist=new ArrayList<String>();
		File file=new File(csvName);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		else{
			
			for(int i=0 ; i<count;i++){
						
				alist.add(finalConcat);
			}
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);	
	 Iterator<String> its=alist.iterator();
	 while(its.hasNext()) {
         String element = its.next();
         System.out.print(element + "\n ");
         bw.write(element+"\n");
         
      }
		
	 bw.close();
		
	System.out.println("CSV generated "); 
	
	}
	
}
