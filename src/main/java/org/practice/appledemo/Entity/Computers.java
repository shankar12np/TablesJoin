package org.practice.appledemo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "computers")
public class Computers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String computerId;
    private String computerName;
    private String year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engineer_id")
    private SoftwareEngineers softwareEngineers; // Assuming "software_engineer_id" is the actual column name

    @OneToMany(mappedBy = "computers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ComputerDetails> computerDetails = new ArrayList<>();

}
