package com.moras.print3d.backend.service;

import java.util.List;

import com.moras.print3d.backend.entity.FileData;

public interface FileDataService {

	public List<FileData> findAll();
	
	public FileData findByName(String fileName);
	
	public void save(FileData theFileData);
}
