package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		List<String> accounts = new ArrayList<>();
		accounts.add("NamNV23");
		accounts.add("HieuNT34");
		accounts.add("ThaiNV7");
		accounts.add("LamBT8");
		String name = "Nguyen Thi Hieu";
		String name2 = "Nguyen Thi Hieu";// Lúc nhập vào

		System.out.println(changeToSummaryName(name));

		System.out.println(genAccount(changeToSummaryName(name), accounts)); // In ra sau khi gen

		accounts.add(genAccount(changeToSummaryName(name), accounts));
		System.out.println(genAccount(changeToSummaryName(name2), accounts));// Thêm vào danh sách
	}

	public static String changeToSummaryName(String fullName) {
		StringBuilder abbreviatedName = new StringBuilder();
		String[] nameParts = fullName.split(" ");
		for (String  namePart  : nameParts){
			System.out.println(namePart);
		}
		abbreviatedName.append(nameParts[nameParts.length-1]);
		for (int i = 0; i < nameParts.length-1; i++) {
			abbreviatedName.append(nameParts[i].charAt(0));
		}
		return abbreviatedName.toString();
	}

	public static String genAccount(String fullName, List<String> accounts){
		String output = fullName; // NamNV
		for (String name : accounts){
			if (name.contains(fullName)){ // NamNV23  contain NamNV
				fullName = name; // => fullname =  NamNV23
			}
		}
		if (output.equals(fullName)){
			return output; // => NamNV neu chua co NamNV ton tai
		}else {
			StringBuilder abbreviatedName = new StringBuilder();
			String[] nameParts = fullName.split(output); // output = NamNV nhung ton tai mot NamNV23
			int count = Integer.parseInt(nameParts[nameParts.length-1]);
			count = count + 1;
			output = output + count;
			return output;
		}
	}

}
