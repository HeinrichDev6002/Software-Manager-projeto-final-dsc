package com.example.software_manager.Repository;

import com.example.software_manager.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAllByTeamId(Long id);
}
