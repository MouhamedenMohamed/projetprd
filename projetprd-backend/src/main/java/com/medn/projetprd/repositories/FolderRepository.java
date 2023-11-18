package com.medn.projetprd.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medn.projetprd.models.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

    @Query("SELECT f FROM Folder f WHERE f.parentFolderid = :parentId")
    List<Folder> findAllByParentFolderIdCustomQuery(Long parentId);
}
