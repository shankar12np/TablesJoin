package org.practice.appledemo.Model;

import lombok.Data;

import java.util.List;

@Data
public class ComputerPOJO {
    private String computerId;
    private String computerName;
    private String year;
    private List<ComputerDetailsPOJO> computerDetails;
}
