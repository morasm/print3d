package com.moras.print3d.backend.service;

import java.util.List;

import com.moras.print3d.backend.entity.ClientProfile;

public interface ClientProfileService {

	public List<ClientProfile> findAll();
	
	public ClientProfile findById(int theId);
	
	public void save(ClientProfile theClientProfile);
	
}
