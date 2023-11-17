package com.medn.security.controllers;

import com.medn.security.models.File;

import com.medn.security.repositories.FileRepository;
import com.medn.security.services.FileService;
import com.medn.security.services.FolderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/files")
public class FileController {

	@Autowired
    private FileService fileService; // Assurez-vous d'injecter correctement votre service
	@Autowired
	private FolderService folderService; // Assurez-vous d'injecter correctement votre service
	
	
	@GetMapping("/chemin/{idparent}")
    public String getFullChemin(@PathVariable Long idparent) {
	    Stack<String> folderNames = new Stack<>();

	    // Traverse the folder hierarchy and push folder names onto the stack
	    Long currentId = idparent;
	    while (currentId != null) {
	        folderNames.push(folderService.getFolderById(currentId).getFolderName());
	        currentId = folderService.getFolderById(currentId).getParentFolderid();
	    }

	    // Pop folder names from the stack to construct the reversed path
	    StringBuilder reversedPath = new StringBuilder();
	    while (!folderNames.isEmpty()) {
	        reversedPath.append('/').append(folderNames.pop());
	    }

	    // The first '/' might be unnecessary, so remove it
	    if (reversedPath.length() > 0) {
	        reversedPath.deleteCharAt(0);
	    }

//	    System.out.println(reversedPath.toString());
	    return reversedPath.toString();
	}
   
    @GetMapping("/all")
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<File> getFile(@PathVariable Long id) {
        File file = fileService.getFileById(id);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<File> createFile(@RequestBody File file) {
        File createdFile = fileService.createFile(file);
        return new ResponseEntity<>(createdFile, HttpStatus.CREATED);
    }

    @PutMapping("/{fileId}")
    public ResponseEntity<File> updateFile(@PathVariable Long fileId, @RequestBody File updatedFile) {
        File file = fileService.updateFile(fileId, updatedFile);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long fileId) {
        fileService.deleteFile(fileId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
