package com.example.laptopshop.repository;

import java.util.List;


import com.example.laptopshop.entity.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository//kho hàng ????
public interface LaptopRepository extends JpaRepository<Laptop,Integer> {
    
    @Query("From Laptop where laptop_name = :name OR laptop_model =:model")
    List<Laptop> getLaptopByNameOrModel(String name, String model);
    //List<Laptop> getLaptopByNameOrModel(@Param("name") String name, @Param("model") String model);
    //@Param giúp bạn liên kết tham số trong phương thức Java với tham số trong câu truy vấn.
    
    //JPQL (Java Persistence Query Language) query dùng trong Spring Data JPA.
    @Query("FROM Laptop l WHERE l.laptop_name LIKE %:keyword% OR l.laptop_model LIKE %:keyword%")
        Page<Laptop> searchByNameOrModel(@Param("keyword") String keyword, Pageable pageable);
}