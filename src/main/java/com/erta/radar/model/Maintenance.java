package com.erta.radar.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double cost;
    private String description;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;
}
