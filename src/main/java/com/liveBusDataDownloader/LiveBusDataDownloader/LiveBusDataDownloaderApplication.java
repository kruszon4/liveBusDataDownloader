package com.liveBusDataDownloader.LiveBusDataDownloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LiveBusDataDownloaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveBusDataDownloaderApplication.class, args);
	}

}
