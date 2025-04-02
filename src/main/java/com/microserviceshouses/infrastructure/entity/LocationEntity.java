package com.microserviceshouses.infrastructure.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locations")
public class LocationEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String sectorOrNeighborhood;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;
}


