package com.medn.projetprd.controllers;

import com.medn.projetprd.models.File;

import com.medn.projetprd.services.FileService;
import com.medn.projetprd.services.FolderService;

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
        Long id =fileService.getFileById(idparent).getParentFolderid();
        return folderService.getFullChemin(id)+"/"+fileService.getFileById(idparent).getFileName();

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
