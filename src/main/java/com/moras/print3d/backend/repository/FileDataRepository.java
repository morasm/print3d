package com.moras.print3d.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moras.print3d.backend.entity.FileData;

public interface FileDataRepository extends JpaRepository<FileData, Integer> {

}
