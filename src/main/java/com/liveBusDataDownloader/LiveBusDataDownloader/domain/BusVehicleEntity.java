package com.liveBusDataDownloader.LiveBusDataDownloader.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BusVehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Line;

    private String VehicleCode;

    private Double Speed;

    private Integer VehicleId;

    private Double Lon;

    private Date DataGenerated;

    private String VehicleService;

    private String Route;

    private Integer Delay;

    private Double Lat;

    private Integer GPSQuality;


}
