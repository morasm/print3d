package com.moras.print3d.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moras.print3d.backend.entity.ClientProfile;
import com.moras.print3d.backend.repository.ClientProfileRepository;

@Service
public class ClientProfileServiceImpl implements ClientProfileService {
	
	private ClientProfileRepository clientProfileRepository;
	
	@Autowired
	public ClientProfileServiceImpl(ClientProfileRepository theClientProfileRepository) {
		clientProfileRepository = theClientProfileRepository;
	}

	@Override
	public List<ClientProfile> findAll() {
		
		return clientProfileRepository.findAll();
	}

	@Override
	public ClientProfile findById(int theId) {
		Optional <ClientProfile> result = clientProfileRepository.findById(theId);
		ClientProfile theClientProfile = null;
		if(result.isPresent()) {
			theClientProfile = result.get();
		}else {
			throw new RuntimeException("Id: " + theId + " not found.");
		}
		
		return theClientProfile;
	}

	@Override
	public void save(ClientProfile theClientProfile) {
		clientProfileRepository.save(theClientProfile);

	}

}
