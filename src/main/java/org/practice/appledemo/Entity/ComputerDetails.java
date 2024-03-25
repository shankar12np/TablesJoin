package org.practice.appledemo.Entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "computer_details")
public class ComputerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String compDtlId;
    private String trimName;
    private String ram;
    private String screenSize;
    private String ssd;

    @ManyToOne
    @JoinColumn(name = "computer_Id")
    private Computers computers;

}
