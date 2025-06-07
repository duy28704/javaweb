package com.example.laptopshop.service;

import java.util.List;
import java.util.Optional;

import com.example.laptopshop.dto.LaptopDTO;
import com.example.laptopshop.dto.ProfileForm;
import com.example.laptopshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.laptopshop.entity.Laptop;
import org.springframework.web.multipart.MultipartFile;

public interface LaptopService {
    /*List<Laptop> getLaptops();
    Laptop saveLaptop(Laptop laptop);
    Laptop getLaptopById(Integer id);
    void deleteLaptop(Integer id);
    Laptop updateLaptop(Laptop laptop);
    List<Laptop> getLaptopByNameOrModel(String name, String model);
    public Page<Laptop> getLaptops1(Pageable pageable);
    public Page<Laptop> getLaptopByNameOrModel1(String keywork, Pageable pageable) ;*/
    public boolean addLaptop(LaptopDTO laptopDTO, MultipartFile[] imageFiles);
    public boolean editLaptop(Long id , LaptopDTO laptopDTO);
    public boolean deleteLaptop(Long id);
    public List<Laptop> getAllLaptops();
    public Optional<Laptop> getLaptopById(Long id);
}
