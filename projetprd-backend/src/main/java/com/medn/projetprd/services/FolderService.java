package com.medn.projetprd.services;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medn.projetprd.models.Folder;
import com.medn.projetprd.repositories.FolderRepository;
import org.springframework.web.bind.annotation.PathVariable;


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


    public String getFullChemin(@PathVariable Long id) {
        Stack<String> folderNames = new Stack<>();

        // Traverse the folder hierarchy and push folder names onto the stack
        Long currentId = id;
        while (currentId != null) {
            folderNames.push(getFolderById(currentId).getFolderName());
            currentId = getFolderById(currentId).getParentFolderid();
        }

        // Pop folder names from the stack to construct the reversed path
        StringBuilder reversedPath = new StringBuilder();
        while (!folderNames.isEmpty()) {
            reversedPath.append('/').append(folderNames.pop());
        }

        // The first '/' might be unnecessary, so remove it
        if (!reversedPath.isEmpty()) {
            reversedPath.deleteCharAt(0);
        }

//	    System.out.println(reversedPath.toString());
        return reversedPath.toString();
    }
}
