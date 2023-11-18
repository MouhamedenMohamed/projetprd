package com.medn.projetprd.models;

import jakarta.persistence.*;

@Entity
@Table(name="folders")
public class Folder extends Document{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isFolder = true;
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

	public boolean isFolder() {
		return isFolder;
	}

	public void setFolder(boolean folder) {
		isFolder = folder;
	}
}
