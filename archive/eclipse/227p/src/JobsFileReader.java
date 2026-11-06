import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.StringBuffer;
import java.util.regex.*;
public class JobsFileReader extends Thread {

	private final String Path;
	private Scanner JobsReader;
	
	public JobsFileReader(String path, Scanner jobsReader) {
		super();
		Path = path;
		JobsReader = jobsReader;
	}
	
	public void run() {
		try {
			
			if(JobsReader.hasNext("(?i:Begin)")) JobsReader.nextLine();
			while(!JobsReader.hasNext("(?i)End")) {
				// the regular expression ":|;" matches either a colon (:) or a semicolon (;)
				String line[] = JobsReader.nextLine().split(":|;");
				String ID = line[0];
				String Memory = line[1];
				String Time = line[2];
				Process process = new Process(Time, Memory, ID);
				if(process.getMemory() > Main.AllowedMemory) {
					FileWriter f = new FileWriter(
							new File(
									System.getProperty("user.home") + File.separator + "ExcessProcesses.txt"
									)
							);
					f.write("Process" + process.getID() + " was not allocated: " + process.getMemory());
					continue;
				}
				Main.JobQueue.add(process);
				Main.JobQueue.notify();
				Main.numOfProcesses++;
				Main.AllowedMemory -= process.getMemory();
				
			}
			
			JobsReader.close();
			return;
			
			
		} catch(InputMismatchException e) {
			System.out.println("The text file for jobs' data is not written in the required format. Modify it and then relaunch this program.");
			JobsReader.close();
		} catch(IOException d) {
			d.printStackTrace();
		}
		
	}
	
}

