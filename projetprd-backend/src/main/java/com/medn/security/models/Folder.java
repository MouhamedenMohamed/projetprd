package com.medn.security.models;

import jakarta.persistence.*;

@Entity
@Table(name="folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String folderName;

    
    private Long parentFolderid;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	

	public Long getParentFolderid() {
		return parentFolderid;
	}

	public void setParentFolderid(Long parentFolderid) {
		this.parentFolderid = parentFolderid;
	}


    
    

    
}
