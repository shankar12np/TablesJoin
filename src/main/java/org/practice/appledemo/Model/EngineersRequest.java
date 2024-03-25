package org.practice.appledemo.Model;

import lombok.Data;
import org.practice.appledemo.Entity.Computers;

import java.util.List;

@Data
public class EngineersRequest {
    private EngineersPOJO engineersPOJO;
    private List<Computers> computers;
}
