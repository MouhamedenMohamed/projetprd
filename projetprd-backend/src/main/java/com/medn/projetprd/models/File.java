package com.medn.projetprd.models;

import jakarta.persistence.*;

@Entity
@Table(name="files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fileName;

    private Long parentFolderid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getParentFolderid() {
		return parentFolderid;
	}

	public void setParentFolderid(Long parentFolderid) {
		this.parentFolderid = parentFolderid;
	}


    
    
}
