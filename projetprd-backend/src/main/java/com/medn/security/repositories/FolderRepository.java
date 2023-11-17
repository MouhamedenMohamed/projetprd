package com.medn.security.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medn.security.models.*;
@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

   
}
