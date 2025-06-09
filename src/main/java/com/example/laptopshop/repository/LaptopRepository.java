package com.example.laptopshop.repository;

import java.time.LocalDateTime;
import java.util.List;


import com.example.laptopshop.entity.Laptop;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {
    List<Laptop> findAllByDeletedTrueAndRestoredFalseAndDeletedAtBefore(LocalDateTime time);
    List<Laptop> findAllByDeletedTrue();
    List<Laptop> findByDeletedFalse();
}