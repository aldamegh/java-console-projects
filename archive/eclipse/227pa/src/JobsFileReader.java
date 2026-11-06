import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.StringBuffer;
import java.util.regex.*;
public class JobsFileReader extends Thread {
	
	
	// Thread for reading from file
			 Thread fileThread = new Thread(() -> {
			 try {
			 BufferedReader br = new BufferedReader(new FileReader("job.txt"));
			 String line;
			 while ((line = br.readLine()) != null) {
			 String[] parts = line.split(":");
			 int id = Integer.parseInt(parts[0]);
			 String[] parts2 = parts[1].split(";");
			 int burstTime = Integer.parseInt(parts2[0]);
			 int memory = Integer.parseInt(parts2[1]);
			 Process p = new Process(id, burstTime, memory);
			 Main.JobQueue.add(p);
			 }
			 br.close();
			 } catch (IOException e) {
			 e.printStackTrace();
			 }
			 });

}

