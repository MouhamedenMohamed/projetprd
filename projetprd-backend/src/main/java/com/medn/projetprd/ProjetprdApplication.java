package com.medn.projetprd;
import java.io.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetprdApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
	
//		FolderOperations.FolderImport();
		
		SpringApplication.run(ProjetprdApplication.class, args);

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
