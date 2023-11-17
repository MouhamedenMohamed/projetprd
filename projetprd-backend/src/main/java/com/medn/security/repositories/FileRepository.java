package com.medn.security.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medn.security.models.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

}
