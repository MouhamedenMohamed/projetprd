package com.medn.projetprd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medn.projetprd.models.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

}
