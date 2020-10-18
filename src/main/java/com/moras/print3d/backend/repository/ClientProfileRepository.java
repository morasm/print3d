package com.moras.print3d.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moras.print3d.backend.entity.ClientProfile;

public interface ClientProfileRepository extends JpaRepository<ClientProfile, Integer> {

}
