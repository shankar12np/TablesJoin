package org.practice.appledemo.Service;

import org.practice.appledemo.Entity.ComputerDetails;
import org.practice.appledemo.Entity.Computers;
import org.practice.appledemo.Model.ComputerDetailsPOJO;
import org.practice.appledemo.Model.ComputerPOJO;
import org.practice.appledemo.Repository.ComputerDetailsRepo;
import org.practice.appledemo.Repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private ComputerDetailsRepo computerDetailsRepo;

    public void addComputers(ComputerPOJO computerPOJO) {
        Computers computers = new Computers();
        computers.setComputerId(UUID.randomUUID().toString());
        computers.setComputerName(computerPOJO.getComputerName());
        computers.setYear(computerPOJO.getYear());

        List<ComputerDetailsPOJO> computerDetailsPOJOList = computerPOJO.getComputerDetails();
        List<ComputerDetails> computerDetailsList = new ArrayList<>();
        for (ComputerDetailsPOJO computerDetailsPOJO : computerDetailsPOJOList) {
            ComputerDetails computerDetails = new ComputerDetails();
            computerDetails.setCompDtlId(computerDetailsPOJO.getCompDtlId());
            computerDetails.setTrimName(computerDetailsPOJO.getTrimName());
            computerDetails.setScreenSize(computerDetailsPOJO.getScreenSize());
            computerDetails.setRam(computerDetailsPOJO.getRam());
            computerDetails.setSsd(computerDetailsPOJO.getSsd());
            computerDetails.setComputers(computers);
            computerDetailsList.add(computerDetails);
        }

        computers.setComputerDetails(computerDetailsList);

        computerRepository.save(computers);
    }

    public void addDetails(ComputerDetailsPOJO computerDetailsPOJO) {
        ComputerDetails computerDetails = new ComputerDetails();
        computerDetails.setCompDtlId(computerDetailsPOJO.getCompDtlId());
        computerDetails.setTrimName(computerDetailsPOJO.getTrimName());
        computerDetails.setScreenSize(computerDetailsPOJO.getScreenSize());
        computerDetails.setSsd(computerDetailsPOJO.getSsd());
        computerDetails.setRam(computerDetailsPOJO.getRam());

        computerDetailsRepo.save(computerDetails);
    }

    public ComputerPOJO getComputerByComputerId(String computerId) {
       Computers computers = computerRepository.findByComputerId(computerId);

        if (computers != null){
        ComputerPOJO computerPOJO = new ComputerPOJO();
        computerPOJO.setComputerId(computers.getComputerId());
        computerPOJO.setComputerName(computers.getComputerName());
        computerPOJO.setYear(computers.getYear());

        List<ComputerDetailsPOJO> computerDetailsPOJOList = new ArrayList<>();
        for (ComputerDetails computerDetails : computers.getComputerDetails()) {
            ComputerDetailsPOJO computerDetailsPOJO = new ComputerDetailsPOJO();
            computerDetailsPOJO.setCompDtlId(computerDetails.getCompDtlId());
            computerDetailsPOJO.setTrimName(computerDetails.getTrimName());
            computerDetailsPOJO.setScreenSize(computerDetails.getScreenSize());
            computerDetailsPOJO.setRam(computerDetails.getRam());
            computerDetailsPOJO.setSsd(computerDetails.getSsd());
            computerDetailsPOJOList.add(computerDetailsPOJO);
        }
        computerPOJO.setComputerDetails(computerDetailsPOJOList);


            return computerPOJO;
        } else {

            throw new RuntimeException("Computer with Id " + computerId + " does not exist");
//            Logger.getLogger(getClass().getName()).log(Level.WARNING, "Computer with ID " + computerId + " does not exist");
//            return null;
        }
    }

    public List<ComputerPOJO> getAllComputers() {
        List<Computers> data = computerRepository.findAll();
        List<ComputerPOJO> computerPOJOList = new ArrayList<>();
        for (Computers computers : data) {
            ComputerPOJO computerPOJO = new ComputerPOJO();
            computerPOJO.setComputerId(computers.getComputerId());
            computerPOJO.setComputerName(computers.getComputerName());
            computerPOJO.setYear(computers.getYear());

            List<ComputerDetailsPOJO> computerDetailsPOJOList = getComputerDetailsPOJOS(computers);

            computerPOJO.setComputerDetails(computerDetailsPOJOList);

            computerPOJOList.add(computerPOJO);

        }
        return computerPOJOList;

    }

    private static List<ComputerDetailsPOJO> getComputerDetailsPOJOS(Computers computers) {
        List<ComputerDetails> computerDetailsList = computers.getComputerDetails();
        List<ComputerDetailsPOJO> computerDetailsPOJOList = new ArrayList<>();
        for (ComputerDetails computerDetails : computerDetailsList) {
            ComputerDetailsPOJO computerDetailsPOJO = new ComputerDetailsPOJO();
            computerDetailsPOJO.setCompDtlId(computerDetails.getCompDtlId());
            computerDetailsPOJO.setTrimName(computerDetails.getTrimName());
            computerDetailsPOJO.setRam(computerDetails.getRam());
            computerDetailsPOJO.setScreenSize(computerDetails.getScreenSize());
            computerDetailsPOJO.setSsd(computerDetails.getSsd());
            computerDetailsPOJOList.add(computerDetailsPOJO);

        }
        return computerDetailsPOJOList;
    }

}
