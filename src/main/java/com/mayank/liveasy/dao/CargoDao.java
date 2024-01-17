package com.mayank.liveasy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayank.liveasy.model.Cargo;

public interface CargoDao extends JpaRepository<Cargo,Long> {
    List<Cargo> findByShipperId(String shipperId);
}
