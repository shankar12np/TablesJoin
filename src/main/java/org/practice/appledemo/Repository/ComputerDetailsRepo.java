package org.practice.appledemo.Repository;

import org.practice.appledemo.Entity.ComputerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerDetailsRepo extends JpaRepository<ComputerDetails, Long> {
}
