package org.practice.appledemo.Repository;

import org.practice.appledemo.Entity.Computers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computers, Long> {
    Computers findByComputerId(String computerId);
}
