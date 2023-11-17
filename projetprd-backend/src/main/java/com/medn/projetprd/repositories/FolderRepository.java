package com.medn.projetprd.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medn.projetprd.models.*;
@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

   
}
