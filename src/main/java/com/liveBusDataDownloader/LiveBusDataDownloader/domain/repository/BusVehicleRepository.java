package com.liveBusDataDownloader.LiveBusDataDownloader.domain.repository;

import com.liveBusDataDownloader.LiveBusDataDownloader.domain.BusVehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusVehicleRepository extends JpaRepository<BusVehicleEntity, Long> {
}
