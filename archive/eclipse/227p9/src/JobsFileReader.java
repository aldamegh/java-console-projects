import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.StringBuffer;
import java.util.regex.*;
public class JobsFileReader extends Thread {

	private final StringBuffer Path;
	private Scanner JobsReader;
	
	public JobsFileReader(StringBuffer path, Scanner jobsReader) {
		super();
		Path = path;
		JobsReader = jobsReader;
	}
	
	public void run() {
		try {
			
			if(JobsReader.hasNext("(?i:Begin)")) 
				JobsReader.nextLine();
			while(!JobsReader.hasNext("(?i)End")) {
				// the regular expression ":|;" matches either a colon (:) or a semicolon (;)
				String line[] = JobsReader.nextLine().split(":|;");
				String ID = line[0];
				String Memory = line[2];
				String Time = line[1];
				Process process = new Process(Time, Memory, ID);
				// this thread, if the text file does not exist, creates a text file for writing logging information for the ID and memory of a process exceeding the available memory.
				File f = new File(System.getProperty("user.home") + File.separator + "ExcessProcesses.txt");
				FileWriter fw = new FileWriter(f);
				// ----------------------------------------------------------------------------------------------------------
				if(process.getMemory() > Main.AllowedMemory) {
					fw.write("Process" + process.getID() + " was not allocated: " + process.getMemory());
					continue;
				}
				Main.JobQueue.add(process);
				Main.numOfProcesses++;
				Main.AllowedMemory -= process.getMemory();
				fw.close();
			}
			
			JobsReader.close();
			
			
		} catch(InputMismatchException e) {
			System.out.println("The text file for jobs' data is not written in the required format. Modify it and then relaunch this program.");
			JobsReader.close();
		} catch(IOException d) {
			d.printStackTrace();
		}
		
	}
	
}

