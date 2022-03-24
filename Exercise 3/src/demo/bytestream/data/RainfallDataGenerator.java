package demo.bytestream.data;

	
	import java.io.DataOutputStream;
	import java.io.FileOutputStream;

	/**
	 * This program demonstrate writing byte-based data using DataOuputStream.
	 * The data is written in its original type into the stream.  
	 * 
	 * The data represents 6 days reading of daily rainfall in station Cheng 
     * (Taman Merdeka) in Melaka Tengah district.
	 * 
	 * @author FirzanaHuda
	 *
	 */
	public class RainfallDataGenerator {

		public static void main(String[] args) {
			
			
			// 1. Declare output file 
			String outFile = "RainfallCheng.txt";
			
			// Data declaration
			String date[] = {"18 March", "19 March", "20 March", "21 March", "22 March", 
					"23 March"};
			int rainfall[] = {7, 0, 0, 8, 0, 0};
			
			try {
				
				// 2. Create stream to read data
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
				
				// Process data
				for (int index = 0; index < date.length; index++) {
					
					// 3. Write data into data stream
					dos.writeUTF(date[index]);
					dos.writeByte(rainfall[index]);
					
					// 4. Flush for each writing
					dos.flush();
				}
				
				// 5. Close stream
				dos.close();
				
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
			
			// Indicate end of program - Could be successful
			System.out.println("End of program. Check out " + outFile); 
		}

	}



