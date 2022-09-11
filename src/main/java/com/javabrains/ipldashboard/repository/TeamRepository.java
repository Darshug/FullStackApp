package com.javabrains.ipldashboard.repository;

import com.javabrains.ipldashboard.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
        Team findByName(String name);
}
