package org.practice.appledemo.Service;

import org.practice.appledemo.Entity.ComputerDetails;
import org.practice.appledemo.Entity.Computers;
import org.practice.appledemo.Entity.SoftwareEngineers;
import org.practice.appledemo.Model.ComputerDetailsPOJO;
import org.practice.appledemo.Model.ComputerPOJO;
import org.practice.appledemo.Model.EngineersPOJO;
import org.practice.appledemo.Model.EngineersRequest;
import org.practice.appledemo.Repository.SoftwareEngineersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<EngineersPOJO> getAllEngineers() {
        List<SoftwareEngineers> softwareEngineers = softwareEngineersRepo.findAll();
        List<EngineersPOJO> engineersPOJOList = new ArrayList<>();
        for (SoftwareEngineers softwareEngineers1 : softwareEngineers) {
            EngineersPOJO engineersPOJO = new EngineersPOJO();
            engineersPOJO.setEngineerId(softwareEngineers1.getEngineerId());
            engineersPOJO.setEngineerName(softwareEngineers1.getEngineerName());

            List<Computers> computers = softwareEngineers1.getComputers();
            List<ComputerPOJO> computerPOJOS = new ArrayList<>();
            for (Computers computer : computers) {
                ComputerPOJO computerPOJO = new ComputerPOJO();
                computerPOJO.setComputerId(computer.getComputerId());
                computerPOJO.setComputerName(computer.getComputerName());
                computerPOJO.setYear(computer.getYear());

                List<ComputerDetails> computerDetailsList = computer.getComputerDetails();
                List<ComputerDetailsPOJO> computerDetailsPOJOList = new ArrayList<>();
                for (ComputerDetails computerDetails : computerDetailsList) {
                    ComputerDetailsPOJO computerDetailsPOJO = new ComputerDetailsPOJO();
                    computerDetailsPOJO.setCompDtlId(computerDetails.getCompDtlId());
                    computerDetailsPOJO.setTrimName(computerDetails.getTrimName());
                    computerDetailsPOJO.setScreenSize(computerDetails.getScreenSize());
                    computerDetailsPOJO.setRam(computerDetails.getRam());
                    computerDetailsPOJO.setSsd(computerDetails.getSsd());

                    computerDetailsPOJOList.add(computerDetailsPOJO);
                }
                computerPOJO.setComputerDetails(computerDetailsPOJOList);

                computerPOJOS.add(computerPOJO);
            }

            // Set the list of computers to the engineersPOJO
            engineersPOJO.setComputer(computerPOJOS);

            engineersPOJOList.add(engineersPOJO);
        }

        return engineersPOJOList;
    }



}
