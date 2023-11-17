package com.medn.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medn.security.models.File;
import com.medn.security.models.Folder;
import com.medn.security.repositories.FileRepository;
import com.medn.security.repositories.FolderRepository;


@Service
public class FolderService {
	@Autowired
    private FolderRepository folderRepository; // Ensure that you inject your repository correctly

    // Get a folder by its ID
    public Folder getFolderById(Long folderId) {
        Optional<Folder> folderOptional = folderRepository.findById(folderId);
        return folderOptional.orElse(null);
    }

    // Create a new folder
    public Folder createfolder(Folder folder) {
        return folderRepository.save(folder);
    }

    // Update an existing folder
    public Folder updateFolder(Long folderId, Folder updatedFolder) {
        Optional<Folder> existingFolderOptional = folderRepository.findById(folderId);

        if (existingFolderOptional.isPresent()) {
            Folder existingFolder= existingFolderOptional.get();
            existingFolder.setFolderName(updatedFolder.getFolderName());
//            existingFolder.setFolderPath(updatedFolder.getFolderPath());

            // Set other properties as needed

            return folderRepository.save(existingFolder);
        } else {
            return null; // Handle Folder not found scenario
        }
    }

    // Delete a Folder by its ID
    public void deleteFolder(Long FolderId) {
    	folderRepository.deleteById(FolderId);
    }

    // Get all folders
    public List<Folder> getAllFolder() {
        return folderRepository.findAll();
    }
}
