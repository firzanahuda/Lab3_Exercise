package demo.bytestream.data;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * This program demonstrate reading byte-based data as it intended type 
 * it is using DataInputStream.
 * 
 * The data represents s 6 days reading of daily rainfall in station Cheng 
 * (Taman Merdeka) in Melaka Tengah district.
 * 
 * The program calculates the average rainfall in station Cheng and display it on the console.
 * 
 * @author FirzanaHuda
 *
 */
public class RainfallDataReader {

	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "RainfallCheng.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			int rainfall = 0;
			int totalRainfall = 0;
			int noOfRecords = 0;
			String date = "";
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				date = dis.readUTF();
				rainfall = dis.read();
				System.out.println( date + "\t" + rainfall);
				
				// Calculate total rainfall
				totalRainfall += rainfall;
				noOfRecords ++;
			}
			
			// 4. Close stream
			dis.close();
			
			// Calculate average Rainfall
			double averageRainfall = (double) totalRainfall / (double) noOfRecords;
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.print("\nAverage rainfall for " + noOfRecords 
					+ " days in Station Cheng: " + formattedAverage + "%");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}

}