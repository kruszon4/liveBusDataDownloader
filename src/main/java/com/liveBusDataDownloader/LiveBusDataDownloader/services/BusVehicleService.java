package com.liveBusDataDownloader.LiveBusDataDownloader.services;


import com.google.gson.Gson;
import com.liveBusDataDownloader.LiveBusDataDownloader.domain.BusVehicleEntity;
import com.liveBusDataDownloader.LiveBusDataDownloader.domain.repository.BusVehicleRepository;
import com.liveBusDataDownloader.LiveBusDataDownloader.model.BusVehiclePojo;
import com.liveBusDataDownloader.LiveBusDataDownloader.model.VehiclePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusVehicleService {

    @Autowired
    BusVehicleRepository busVehicleRepository;

    private RestTemplate restTemplate = new RestTemplate();
    String urlPath = "http://ckan2.multimediagdansk.pl/gpsPositions";
    Gson gson = new Gson();
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Transactional
    @Scheduled(cron = "00 * * ? * *")
    @Scheduled(cron = "20 * * ? * *")
    @Scheduled(cron = "40 * * ? * *")
    public void saveAllVehicle() throws IOException {

        System.out.println("[BUS] Pobieram dane z ");

        Date date = new Date();
        System.out.println(date);
        long l1 = System.currentTimeMillis();

        String response = restTemplate.getForObject(urlPath, String.class);

        VehiclePojo vehiclePojo = gson.fromJson(response, VehiclePojo.class);

        List<BusVehiclePojo> vehicles = vehiclePojo.getVehicles();

        List<BusVehicleEntity> collect = vehicles.stream().map(this::map).collect(Collectors.toList());
        busVehicleRepository.saveAll(collect);

        long l = System.currentTimeMillis();
        System.out.println("COMPLETED!");
        System.out.print("Zapis trwał: ");
        System.out.print((double)(l-l1)/1000);
        System.out.println(" s");
        System.out.println();


    }

    private BusVehicleEntity map(BusVehiclePojo source) {
        if (source == null) {
            return null;
        }
        BusVehicleEntity busVehicleEntity = new BusVehicleEntity();

        try {
            busVehicleEntity.setDataGenerated(sf.parse(source.getDataGenerated()));
            busVehicleEntity.setDelay(source.getDelay());
            busVehicleEntity.setGPSQuality(source.getGPSQuality());
            busVehicleEntity.setLat(source.getLat());
            busVehicleEntity.setLine(source.getLine());
            busVehicleEntity.setLon(source.getLon());
            busVehicleEntity.setRoute(source.getRoute());
            busVehicleEntity.setSpeed(source.getSpeed());
            busVehicleEntity.setVehicleCode(source.getVehicleCode());
            busVehicleEntity.setVehicleId(source.getVehicleId());
            busVehicleEntity.setVehicleService(source.getVehicleService());


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return busVehicleEntity;

    }


}

