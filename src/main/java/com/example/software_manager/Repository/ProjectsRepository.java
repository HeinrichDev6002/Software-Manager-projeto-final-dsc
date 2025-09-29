package com.example.software_manager.Repository;

import com.example.software_manager.Model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    List<Projects> findAllByProjectsId(Long id);
}
