package org.practice.appledemo.Model;

import lombok.Data;

import java.util.List;

@Data
public class EngineersPOJO {
    private String engineerId;

    private String engineerName;

    private List<ComputerPOJO> computer;
}
