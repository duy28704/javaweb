package com.example.laptopshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_laptop")
public class Laptop {
    /*@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )//id tự động sinh, ko cần thêm id lúc save 1 new one
    private int id;

    private String laptop_name;

    private String laptop_model;

    private String laptop_originalPrice;

    private String laptop_currentPrice;

    private String laptop_discord;

    private String laptop_link;

    private String laptop_description;

    public void setId(Integer id) {
        this.id = id;
    }*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "link")
    private String link;

    @Column(name = "cpu_name")
    private String cpu_name;

    @Column(name = "cores")
    private String cores;

    @Column(name = "threads")
    private String threads;

    @Column(name = "base_speed")
    private String base_speed;

    @Column(name = "max_speed")
    private String max_speed;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "original_price")
    private String original_price;

    @Column(name = "current_price")
    private String current_price;

    @Column(name = "discount")
    private String discount;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "size")
    private String size;

    @Column(name = "material_type")
    private String material_type;

    @Column(name = "battery_system")
    private String battery_system;

    @Column(name = "os_system")
    private String os_system;

    @Column(name = "release_time")
    private String release_time;

    @Column(name = "connectivity_ports", columnDefinition = "TEXT")
    private String connectivity_ports;

    @Column(name = "wireless")
    private String wireless;

    @Column(name = "webcams")
    private String webcams;

    @Column(name = "features", columnDefinition = "TEXT")
    private String features;

    @Column(name = "keyboard_lights", columnDefinition = "TEXT")
    private String keyboard_lights;

    @Column(name = "ram_type")
    private String ram_type;

    @Column(name = "ram_speed")
    private String ram_speed;

    @Column(name = "max_ram_size")
    private String max_ram_size;

    @Column(name = "hard_drive")
    private String hard_drive;

    @Column(name = "review", columnDefinition = "TEXT")
    private String review;

    @Column(name = "image_url", columnDefinition = "TEXT")
    private String image_url;

    @Column(name = "screen_type")
    private String screen_type;

    @Column(name = "resolution")
    private String resolution;

    @Column(name = "refresh_rate")
    private String refresh_rate;

    @Column(name = "color_depth", columnDefinition = "TEXT")
    private String color_depth;

    @Column(name = "screen_technology", columnDefinition = "TEXT")
    private String screen_technology;

    @Column(name = "screen_card")
    private String screen_card;

    @Column(name = "sound_technology", columnDefinition = "TEXT")
    private String sound_technology;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    public String getFirstImageUrl() {
        if (this.image_url == null || this.image_url.trim().isEmpty()) {
            return "/img/default_laptop.jpg"; // ảnh mặc định khi không có ảnh
        }
        String[] urls = this.image_url.split("\\|");
        return urls[0].trim();
    }

}
