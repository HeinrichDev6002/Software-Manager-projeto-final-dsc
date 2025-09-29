package com.example.software_manager.Repository;

import com.example.software_manager.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByImageId(Long id);
}
