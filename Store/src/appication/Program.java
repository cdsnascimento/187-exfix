package appication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		String strPath = "C:\\Users\\Note_Nascimento\\Documents\\MeuProjetos\\ws-files\\187-exfix\\in\\products.csv";
		
		File file = new File(strPath);
		
		boolean success = new File(file.getParent() + "\\out\\").mkdir();
		
		String newStrPath = file.getParent() + "\\out\\summary.csv";

		try( BufferedReader br = new BufferedReader(new FileReader(strPath))){
			
			String line = br.readLine();
			String name;
			Double price;
			Integer quantity;
			
			while (line != null) {

				String[] vect = line.split(",");
				
				name = vect[0];
				price = Double.parseDouble(vect[1]) ;
				quantity = Integer.parseInt(vect[2]);
				
				Product product = new Product(name, quantity, price);
				
				line = br.readLine();
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(newStrPath, true))){
					
					bw.write(product.toString());
					bw.newLine();
					
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			if (success) {
				System.out.printf("Directory: out and file: summary.csv createds successfully");
			}
			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
