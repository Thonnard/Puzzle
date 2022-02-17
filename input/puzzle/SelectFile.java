package input.puzzle;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

// this class contains a method that is called to present a dialog box that asks to select a propertiesFile
public class SelectFile {
	
	// declaration instance variables (encapsulation: private)
	private String directory;
	private String propertiesFile;
	
	// constructor method
	public SelectFile() {

		// new fileChooser
		JFileChooser fileChooser = new JFileChooser();

		// set directory of dialog box to the user home directory
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

		// create a filter for the file type	
		FileNameExtensionFilter filter = new FileNameExtensionFilter("properties", "properties");
		fileChooser.setFileFilter(filter);

		// set the dialog title
		fileChooser.setDialogTitle("Select a properties file to start the puzzle...");

		// var to check input
		int result = fileChooser.showOpenDialog(null);

		
		// save selected input
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			this.directory = selectedFile.getParent();
			this.propertiesFile = selectedFile.getAbsolutePath();
		} else {
			System.out.println("No propertiesFile selected. Please restart the program and select a propertiesFile to start the puzzle.");
			System.exit(-1);
		}

	}

	// getters and setters
	public String getDirectory() {
		return directory;
	}
	public String getPropertiesFile() {
		return propertiesFile;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public void setPropertiesFile(String propertiesFile) {
		this.propertiesFile = propertiesFile;
	}


}
