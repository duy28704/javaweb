package com.example.laptopshop.controller;

import java.util.List;
import java.util.Optional;

import com.example.laptopshop.dto.LaptopDTO;
import com.example.laptopshop.entity.User;
import com.example.laptopshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.laptopshop.entity.Laptop;
import com.example.laptopshop.service.LaptopService;

@RestController
//@RequestMapping("/admin") giúp bạn không phải lặp đi lặp lại /admin ở mỗi method.
//chuyển hướng màn hình
@RequestMapping("/api/v1/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/list")
    public ResponseEntity<List<Laptop>> getAllLaptop() {
        List<Laptop>  laptops = laptopService.getAllLaptops();
        return ResponseEntity.ok(laptops);
    }
    @GetMapping("/laptop/{id}")
    public ResponseEntity<Optional<Laptop>> getLaptopById(@PathVariable Long id) {
        Optional<Laptop> laptop = laptopService.getLaptopById(id);
        if (laptop.isPresent()) {
            return ResponseEntity.ok(laptop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<String> addLaptop(
            @RequestPart("laptop") LaptopDTO laptopDTO,
            @RequestParam(value = "imageFile", required = false) MultipartFile[] imageFile) {

        boolean success = laptopService.addLaptop(laptopDTO,imageFile);
        if (success) {
            return ResponseEntity.ok("Thêm laptop thành công");
        } else {
            return ResponseEntity.badRequest().body("Thêm thất bại, dữ liệu thiếu hoặc không hợp lệ");
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editLaptop(@PathVariable Long id, @RequestBody LaptopDTO laptopDTO) {
        boolean success = laptopService.editLaptop(id, laptopDTO);
        if (success) {
            return ResponseEntity.ok("Cập nhật laptop thành công");
        } else {
            return ResponseEntity.badRequest().body("Không tìm thấy laptop hoặc dữ liệu sai");
        }
    }

    // 5. Xóa laptop
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable Long id) {
        boolean success = laptopService.deleteLaptop(id);
        if (success) {
            return ResponseEntity.ok("Đã xóa laptop thành công");
        } else {
            return ResponseEntity.badRequest().body("Không tìm thấy laptop");
        }
    }
}
