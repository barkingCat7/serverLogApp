// package com.seyid.app.controllers;
//
// import java.io.IOException;
// import java.sql.Timestamp;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.List;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
//
// import com.seyid.app.models.Record;
// import com.seyid.app.models.RecordService;
//
// @RestController
// @ComponentScan
// public class RecordRestController {
//
// @Autowired
// private RecordService recordService;
//
// // @RequestMapping("/logs")
// // public List<Log> getAllLogs() {
// //
// // return LogService.getAllLogs();
// // }
// @RequestMapping("/log")
// public void parseLog() throws IOException, ParseException {
// recordService.parseLog("/access.log");
// }
//
// @RequestMapping("/records/{id}")
// public Record getLog(@PathVariable Long id) {
// System.out.println("AAA");
// return recordService.getRecord(id);
// }
//
// @RequestMapping(method = RequestMethod.POST, value = "/records")
// public void addRecord(@RequestBody Record record) {
// recordService.saveRecord(record);
// }
//
// @RequestMapping(value = "/findIPs")
// public List<String> findIPs() throws ParseException {
// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd
// hh:mm:ss.SSS");
// java.util.Date parsedDate = dateFormat.parse("2017-01-01 00:00:00.000");
// Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
// return recordService.searchByParams(timestamp, "daily", 500L);
//
// }
// }
