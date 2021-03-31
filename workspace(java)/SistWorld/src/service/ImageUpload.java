package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.JFileChooser;

public class ImageUpload {
	
	public ImageUpload() {
		// Choose file
		JFileChooser fc = new JFileChooser();
		int result = fc.showOpenDialog(null);
		// Make sure that a file was chosen, else exit
		if (result != JFileChooser.APPROVE_OPTION) {
		    System.exit(0);
		}
		// Get file path
		String path = fc.getSelectedFile().getAbsolutePath();
		// Create folder "images" (variable success will be true if a folder was created and false if it did not)
		File folder = new File("images");
		boolean success = folder.mkdir();
		// Get the destination of the folder and the new image (image.jpg will be the new name)
		String destination = folder.getAbsolutePath() + File.separator + "img.jpg";
		try {
		    // Copy file from source to destination
		    FileChannel source = new FileInputStream(path).getChannel();
		    FileChannel dest = new FileOutputStream(destination).getChannel();
		    dest.transferFrom(source, 0, source.size());
		    // Close shit
		    source.close();
		    dest.close();
		    System.out.println("Done");
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
