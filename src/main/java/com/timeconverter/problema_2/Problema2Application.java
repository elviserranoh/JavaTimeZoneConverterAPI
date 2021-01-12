package com.timeconverter.problema_2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Problema2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Problema2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
			String str1= new String("HELLO");
			String str2= new String("HELLO");
			if(str1 == str2)
			{
			System.out.println("String 1 == String 2 is true");
			}
			else
			{
			System.out.println("String 1 == String 2 is false");
			}
			
			String Str3 = str2;
			if( str1 == Str3)
			{
			System.out.println("String 2 == String 3 is true");
			}
			else
			{
			System.out.println("String 2 == String 3 is false");
			}
			if(str1.equals(str2))
			{
			System.out.println("String 1 equals string 2 is true");
			}
			else
			{
			System.out.println("String 1 equals string 2 is false");
			}
			
		
	}

}
