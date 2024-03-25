package org.practice.appledemo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "software_engineers")
public class SoftwareEngineers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String engineerId;

    private String engineerName;

    @OneToMany(mappedBy = "softwareEngineers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Computers> computers = new ArrayList<>();
}
