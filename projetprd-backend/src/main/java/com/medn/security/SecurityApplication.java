package com.medn.security;
import java.io.BufferedReader;
import java.io.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.medn.security.operations.FolderOperations;
import com.medn.security.services.FolderService;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
	
//		FolderOperations.FolderImport();
		
		SpringApplication.run(SecurityApplication.class, args);

	}
	
// Aexecuter pour la premier foi qu'on run l'application pour creer le dossier root
//    @Bean
//    public CommandLineRunner init(FolderService folderService) {
//        return args -> {
//            // Appel de la méthode pour créer le dossier initial
//            folderService.createInitialFolder();
//        };
//    }

}
