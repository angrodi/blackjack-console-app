package com.bytesw.blackjackconsoleapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BlackjackConsoleAppApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackConsoleAppApplication.class, args);
	}


	public static void ClearConsole(){
		try{
			String operatingSystem = System.getProperty("os.name"); //Check the current operating system

			if(operatingSystem.contains("Windows")){
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
				Process startProcess = pb.inheritIO().start();
				startProcess.waitFor();
			} else {
				ProcessBuilder pb = new ProcessBuilder("clear");
				Process startProcess = pb.inheritIO().start();

				startProcess.waitFor();
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}


}
