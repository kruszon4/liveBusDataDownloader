package com.liveBusDataDownloader.LiveBusDataDownloader.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusVehiclePojo {

    private String DataGenerated;

    private String Line;

    private String VehicleCode;

    private Double Speed;

    private Integer VehicleId;

    private Double Lon;

    private String VehicleService;

    private String Route;

    private Integer Delay;

    private Double Lat;

    private Integer GPSQuality;


}
