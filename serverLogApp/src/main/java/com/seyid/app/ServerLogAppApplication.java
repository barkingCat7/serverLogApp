package com.seyid.app;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seyid.app.models.RecordService;

@SpringBootApplication
public class ServerLogAppApplication implements ApplicationRunner {
	@Autowired
	private RecordService recordService;

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ServerLogAppApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws ParseException, IOException {
		System.out.println("app runs");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd.hh:mm:ss");
		// System.out.println(args[0] + " " + args[1]);
		java.util.Date parsedDate = dateFormat.parse(args.getOptionValues("startDate").get(0));
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		String duration = args.getOptionValues("duration").get(0);
		Long threshold = Long.parseLong(args.getOptionValues("threshold").get(0));
		String logPath = args.getOptionValues("accesslog").get(0);
		// System.out.println(timestamp + " " + duration + " " + threshold);
		recordService.parseLog(logPath);
		recordService.searchByParams(timestamp, duration, threshold);
	}

}
