package com.medn.projetprd.repositories;

import com.medn.projetprd.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medn.projetprd.models.File;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    @Query("SELECT f FROM File f WHERE f.parentFolderid = :parentId")
    List<File> findAllByParentFolderIdCustomQuery(Long parentId);
}
