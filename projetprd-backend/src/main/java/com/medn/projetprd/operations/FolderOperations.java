package com.medn.projetprd.operations;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.*;
public class FolderOperations {
	
	public String BidsValidator() throws InterruptedException, IOException {
		String chemin_de_validator="/home/mouhameden/Desktop/security/security(final)/src/main/resources/validator.py";
		String command = "python3 "+chemin_de_validator;
        Process process = Runtime.getRuntime().exec(command);

        // Attendre que le script Python se termine
        int exitCode = process.waitFor();
     // Lire la sortie standard du processus Python
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        StringBuilder pythonOutput = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            pythonOutput.append(line).append("\n");
        }
        
        
         exitCode = process.waitFor();
         String result ;
        if (exitCode == 0) {
//            System.out.println("Le script Python s'est exécuté avec succès.");
            System.out.println("Résultat de l'exécution Python :");
            result = pythonOutput.toString();
        } else {
//            System.err.println("Le script Python a rencontré une erreur.");
            System.err.println("Résultat de l'exécution Python :");
            result = pythonOutput.toString();
        }
		return result;
	}
	
	
public static void FolderImport() {
	        // Specify the path to the folder you want to import
//	        String folderPath = "/home/mouhameden/Téléchargements/bids-examples-master/test";
	        String sourceFolderPath = "/home/mouhameden/Téléchargements/bids-examples-master/test";

	        // Specify the destination folder path
	        String destinationFolderPath = "/home/mouhameden/Téléchargements/bids-examples-master/destination";

	        // Create a File object for the source directory
	        File sourceDirectory = new File(sourceFolderPath);

	        // Create a File object for the destination directory
	        File destinationDirectory = new File(destinationFolderPath);

	        // Check if the source directory exists and is a directory
	        if (sourceDirectory.exists() && sourceDirectory.isDirectory()) {
	            System.out.println("Copying contents of the source directory: " + sourceDirectory.getName());

	            // Ensure that the destination directory exists or create it if necessary
	            if (!destinationDirectory.exists()) {
	                destinationDirectory.mkdirs();
	            }

	            // List the contents of the source directory
	            File[] files = sourceDirectory.listFiles();
	            if (files != null) {
	                for (File file : files) {
	                    // Create a destination file or directory
	                    File destinationFile = new File(destinationDirectory, file.getName());

	                    if (file.isFile()) {
	                        // This is a file
	                        System.out.println("File: " + file.getName());

	                        // Copy the file to the destination directory
	                        try {
	                            Path sourcePath = file.toPath();
	                            Path destinationPath = destinationFile.toPath();
	                            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    } else if (file.isDirectory()) {
	                        // This is a subdirectory
	                        System.out.println("Subdirectory: " + file.getName());

	                        // Recursively copy the subdirectory
	                        copyDirectoryContents(file, destinationFile);
	                    }
	                }
	            }
	        } else {
	            System.err.println("The specified source directory does not exist or is not a directory.");
	        }
	    }


private static void copyDirectoryContents(File source, File destination) {
    File[] files = source.listFiles();
    if (files != null) {
        for (File file : files) {
            File destinationFile = new File(destination, file.getName());

            if (file.isFile()) {
                // This is a file
                System.out.println("File: " + file.getName());
                
                // Copy the file to the destination directory
                try {
                    Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            } else if (file.isDirectory()) {
                // This is a subdirectory
                System.out.println("Subdirectory: " + file.getName());

                // Create the corresponding subdirectory in the destination
                destinationFile.mkdir();

                // Recursively copy the contents of the subdirectory
                copyDirectoryContents(file, destinationFile);
            }
        }
    }
    else {
    	System.out.println("vide .....");
    }
}
	


}
