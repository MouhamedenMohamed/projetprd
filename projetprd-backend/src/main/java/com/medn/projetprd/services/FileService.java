package com.medn.projetprd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medn.projetprd.models.File;
import com.medn.projetprd.repositories.FileRepository;

@Service
public class FileService {
	@Autowired
    private FileRepository fileRepository; // Ensure that you inject your repository correctly

    // Get a file by its ID
    public File getFileById(Long fileId) {
        Optional<File> fileOptional = fileRepository.findById(fileId);
        return fileOptional.orElse(null);
    }

    // Create a new file
    public File createFile(File file) {
        return fileRepository.save(file);
    }

    // Update an existing file
    public File updateFile(Long fileId, File updatedFile) {
        Optional<File> existingFileOptional = fileRepository.findById(fileId);

        if (existingFileOptional.isPresent()) {
            File existingFile = existingFileOptional.get();
            existingFile.setFileName(updatedFile.getFileName());
//            existingFile.setFilePath(updatedFile.getFilePath());

            // Set other properties as needed

            return fileRepository.save(existingFile);
        } else {
            return null; // Handle file not found scenario
        }
    }

    // Delete a file by its ID
    public void deleteFile(Long fileId) {
        fileRepository.deleteById(fileId);
    }

    // Get all files
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
