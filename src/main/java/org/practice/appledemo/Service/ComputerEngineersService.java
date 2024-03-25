package org.practice.appledemo.Service;

import org.practice.appledemo.Entity.Computers;
import org.practice.appledemo.Entity.SoftwareEngineers;
import org.practice.appledemo.Model.ComputerPOJO;
import org.practice.appledemo.Model.EngineersPOJO;
import org.practice.appledemo.Repository.SoftwareEngineersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerEngineersService {
    @Autowired
    private SoftwareEngineersRepo softwareEngineersRepo;

    public void assignEngineerToComputers(SoftwareEngineers softwareEngineers, List<Computers> computers) {
        if (softwareEngineers != null) {
            EngineersPOJO engineersPOJO = new EngineersPOJO();
            engineersPOJO.setEngineerId(softwareEngineers.getEngineerId());
            engineersPOJO.setEngineerName(softwareEngineers.getEngineerName());

            for (Computers computer : computers) {
                computer.setSoftwareEngineers(softwareEngineers);
            }

            softwareEngineers.setComputers(computers);

            softwareEngineersRepo.save(softwareEngineers);

        }
    }
}
