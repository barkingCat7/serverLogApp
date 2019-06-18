package com.seyid.app.models;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Long> {
	// List<Record> findAllByDateTimeBetween()

	@Query("select r.ipAddress from Record r where r.dateTime BETWEEN ?1 AND ?2 GROUP BY r.ipAddress HAVING count(r.ipAddress) >= ?3")
	List<String> findIpList(Timestamp startDate, Timestamp endDate, Long threshold);
}