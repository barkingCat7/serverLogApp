package com.seyid.app.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Timestamp dateTime;
	private String ipAddress;
	private String reqMethod;
	private String reqResponse;
	private String userInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getReqMethod() {
		return reqMethod;
	}

	public void setReqMethod(String reqMethod) {
		this.reqMethod = reqMethod;
	}

	public String getReqResponse() {
		return reqResponse;
	}

	public void setReqResponse(String reqResponse) {
		this.reqResponse = reqResponse;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public void printRecord() {
		System.out.println(
				"Date: " + this.getDateTime() + ", IP: " + this.getIpAddress() + ", ReqMethod: " + this.getReqMethod()
						+ ", ReqResponse: " + this.getReqResponse() + ", User Agent: " + this.getUserInfo());
	}

}
