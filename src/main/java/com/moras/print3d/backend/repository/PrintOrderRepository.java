package com.moras.print3d.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moras.print3d.backend.entity.PrintOrder;

public interface PrintOrderRepository extends JpaRepository<PrintOrder, Integer> {

}
