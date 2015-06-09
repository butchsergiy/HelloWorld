package com.edvantis.jt_14;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		
		String name;
		int age=0;
		LocalDate 	birthDate;
		Period 		ageFull;
		LocalDate	currentDate = LocalDate.now(); 
		DayOfWeek 	currDayOfWeek;
		DayOfWeek 	birthDayOfWeek;
		
		System.out.println("*** Hello world ***\n");		

		
		
////////////////////////////////////////////////////////////////////////////////		
// input of the data                                        			      //		

		Scanner inp=new Scanner(System.in);
		System.out.println("** What is your name ?");
		name=inp.nextLine();
			System.out.println("\nHello "+name.toUpperCase()+" !");
		
		while(true){
			try{
				System.out.println("** Please enter your birthday date like: YYYY-MM-DD");
				birthDate=LocalDate.parse(inp.next());
				if (birthDate.isAfter(currentDate)){ 
					throw  new DateTimeParseException("error == birthDate.isAfter(currentDate)", "MyExceptionexc", 0);
				}
				break;
			}catch(DateTimeParseException e){System.out.println(e.getMessage()+"\n** Please enter date like: 1980-12-31"); };
		}
		
		inp.close();
			
		
		
//////////////////////////////////////////////////////////////////////////////			
// just some info for user 													//
		
		ageFull=birthDate.until(currentDate);
		
		age=ageFull.getYears();
		
		currDayOfWeek=currentDate.getDayOfWeek();
		birthDayOfWeek=birthDate.getDayOfWeek();
			

		System.out.println("\n"+name.toUpperCase()+", You was born in "+birthDate+"\nToday is "+currentDate);
		System.out.println("Now You have "+ageFull.getYears()+" years, " + ageFull.getMonths()+ " month, " + ageFull.getDays()+ " days." );
		
		System.out.println("\nCurrent day of the week is - "+ currDayOfWeek);
		System.out.println("You was born in - "+birthDayOfWeek);		
		
	
		
///////////////////////////////////////////////////////////////////////////////		
// here I create Array of all days of week when User celebrates his birthday //

		int[] daysOfWeekCount={0,0,0,0,0,0,0};
		DayOfWeek[] bdaysOfWeek=new DayOfWeek[age+1];

	
		for(int i=0; i<age+1; i++){														// print year and day of birthday	
			LocalDate birthDateI=birthDate.plusYears(i);
			bdaysOfWeek[i]=birthDateI.getDayOfWeek();
			System.out.println("in "+ birthDateI.getYear()+ " you selebrate your birthday at " + bdaysOfWeek[i] );
		}
		
		System.out.println("\nYou selebrate "+bdaysOfWeek.length + " birthdays.");
		
		
		for(int i=0; i<age; i++){
			if (bdaysOfWeek[i].toString()=="MONDAY") daysOfWeekCount[0]++;
			if (bdaysOfWeek[i].toString()=="TUESDAY") daysOfWeekCount[1]++;
			if (bdaysOfWeek[i].toString()=="WEDNESDAY") daysOfWeekCount[2]++;
			if (bdaysOfWeek[i].toString()=="THURSDAY") daysOfWeekCount[3]++;
			if (bdaysOfWeek[i].toString()=="FRIDAY") daysOfWeekCount[4]++;
			if (bdaysOfWeek[i].toString()=="SATURDAY") daysOfWeekCount[5]++;
			if (bdaysOfWeek[i].toString()=="SUNDAY") daysOfWeekCount[6]++;
		}
		
		for(int i=0; i<6; i++) System.out.println(daysOfWeekCount[i]+ " tines in "+ DayOfWeek.of(i+1));

////////////////////////////////////////////////////////////////////////////
// 

	}

}
