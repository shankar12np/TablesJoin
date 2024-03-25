package org.practice.appledemo.Repository;

import org.practice.appledemo.Entity.SoftwareEngineers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareEngineersRepo extends JpaRepository<SoftwareEngineers, Long> {

}
