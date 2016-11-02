package com.anjali.testng.project.service.email;

import org.springframework.stereotype.Service;

@Service
public class RandomEmailGenerator implements EmailGenerator {

	@Override
	public String generate() {
		return "feedback@yoursite.com";
	}

}