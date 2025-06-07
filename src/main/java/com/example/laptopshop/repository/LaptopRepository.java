package com.example.laptopshop.repository;

import java.util.List;


import com.example.laptopshop.entity.Laptop;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository//kho hàng ????
public interface LaptopRepository extends JpaRepository<Laptop,Long> {

}