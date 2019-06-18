package com.seyid.app.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockedIpService {
	@Autowired
	private BlockedIpRepository blockedIpRepository;

	public BlockedIp getBlockedIp(Long id) {
		return blockedIpRepository.findById(id).get();
	}

	public void saveBlockedIp(BlockedIp blockedIp) {
		blockedIpRepository.save(blockedIp);
	}

	public void saveIpList(List<String> list, String comment) {
		// list.forEach(item -> blockedIpRepository.save(new BlockedIp(item,
		// comment)));
		if (list.size() == 0) {
			System.out.println("No threshold exceeding Ip Addresses found for this duration");
		}
		for (String item : list) {
			blockedIpRepository.save(new BlockedIp(item, comment));
			System.out.println(item + " is " + comment);
		}
	}
}
