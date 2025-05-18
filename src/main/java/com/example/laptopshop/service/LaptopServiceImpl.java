package com.example.laptopshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.laptopshop.entity.Laptop;
import com.example.laptopshop.repository.LaptopRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LaptopServiceImpl implements LaptopService{

    @Autowired// cần thiết phết
    private LaptopRepository lRepository;

    @Override
    public List<Laptop> getLaptops() {
        return lRepository.findAll();
    }
    @Override
    public Laptop saveLaptop(Laptop laptop) {
        return lRepository.save(laptop);
    }

    @Override
    public Laptop getLaptopById(Integer id) {
        Optional<Laptop> laptop= lRepository.findById(id);
        if (laptop.isPresent()) {
            return laptop.get();
        }
        throw new EntityNotFoundException("cannot find "+ id);
    }

    @Override
    public void deleteLaptop(Integer id) {
        lRepository.deleteById(id);
    }

    @Override
    public Laptop updateLaptop(Laptop laptop) {
        return lRepository.save(laptop);
    }
    
    @Override
    public List<Laptop> getLaptopByNameOrModel(String name, String model) {
        return lRepository.getLaptopByNameOrModel(name,model);
    }
    @Override
    public Page<Laptop> getLaptops1(Pageable pageable) {
        // TODO Auto-generated method stub
        return lRepository.findAll(pageable);
    }
    @Override
    public Page<Laptop> getLaptopByNameOrModel1(String keywork,  Pageable pageable) {
         return lRepository.searchByNameOrModel(keywork, pageable);
    }
    
}