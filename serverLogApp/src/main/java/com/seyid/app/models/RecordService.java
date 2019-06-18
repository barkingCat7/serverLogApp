package com.seyid.app.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
	private static final Logger logger = LoggerFactory.getLogger(Logger.class);
	@Autowired
	private RecordRepository recordRepository;
	@Autowired
	private BlockedIpService blockedIpService;

	public Record getRecord(Long id) {
		return recordRepository.findById(id).get();
	}

	public void saveRecord(Record record) {
		recordRepository.save(record);
	}

	public void parseLog(String logPath) throws IOException, ParseException {
		InputStream inputStream = getClass().getResourceAsStream(logPath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		int counter = 0;
		while ((line = reader.readLine()) != null) {
			counter++;
			StringTokenizer stringTokenizer = new StringTokenizer(line, "|");
			Record r = new Record();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			Date parsedDate = dateFormat.parse(stringTokenizer.nextToken());
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			r.setDateTime(timestamp);
			r.setIpAddress(stringTokenizer.nextToken());
			r.setReqMethod(stringTokenizer.nextToken());
			r.setReqResponse(stringTokenizer.nextToken());
			r.setUserInfo(stringTokenizer.nextToken());
			// r.printRecord();
			// list.add(r);
			recordRepository.save(r);
			logger.warn("Wait while program parses and saves record #" + counter + " to Database");
		}
		// return list;
	}

	public void saveLog(List<Record> list) {
		list.forEach(record -> recordRepository.save(record));
	}

	public List<String> searchByParams(Timestamp startTime, String duration, Long threshold) {
		String comment = "Blocked due to exceeding " + threshold + " requests per hour";
		Timestamp endDate = new Timestamp(startTime.getTime() + 60 * 60 * 1000);
		if (duration.equals("daily")) {
			endDate = new Timestamp(startTime.getTime() + 60 * 60 * 1000 * 24);
			comment = new String("Blocked due to exceeding " + threshold + " requests per day");
		}
		List<String> list = recordRepository.findIpList(startTime, endDate, threshold);
		// list.forEach(item -> System.out.println(item + "is " + comment));
		blockedIpService.saveIpList(list, comment);
		return list;
	}

}
