package com.erta.radar.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    // todo plate object
    private String plateNumber;
    // todo driver object
    private String driver;
    @OneToMany(mappedBy = "vehicle", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Maintenance> maintenances = new ArrayList<>();
    private int kilometer;
    // todo enum brand-model
    private String brand;
    private String model;

}