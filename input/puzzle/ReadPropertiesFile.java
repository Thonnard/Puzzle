package input.puzzle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// this class gets the solution and filename of the puzzle from the propertiesFile
public class ReadPropertiesFile {

	// declaration instance variables (encapsulation: private)
	private String filenameTask;
	private String solution;
	private Properties propertiesFile = new Properties();
	private InputStream input = null;

	// constructor method
	public ReadPropertiesFile(String propertiesFilename) {
		try {	

			// get filename 
			input = new FileInputStream(propertiesFilename);

			// load a properties file
			propertiesFile.load(input);

			// get solution
			if(propertiesFile.getProperty("solution") != null) {
				this.solution = propertiesFile.getProperty("solution");
			} else {
				System.out.println("Solution not provided...");
				System.out.println("Please restart the program and select a correct propertiesFile...");
				System.exit(-1);
			}			

			// get filenameTask
			if(propertiesFile.getProperty("filename") != null) {
				this.filenameTask = propertiesFile.getProperty("filename");
			} else {
				System.out.println("Puzzle information not provided...");
				System.out.println("Please restart the program and select a correct propertiesFile...");
				System.exit(-1);
			}			

		} catch (IOException io) {
			System.out.println("An IO exception occurred: " + io);
		} finally {
			if (input != null) {
				System.out.println("Properties file succesfully loaded.");
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}		

	}

	// getters and setters
	public String getSolution() {
		return solution;
	}
	public String getFilenameTask() {
		return filenameTask;
	}
	public void setFilenameTask(String filenameTask) {
		this.filenameTask = filenameTask;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}

}



