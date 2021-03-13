package com.faronics.ultilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getApplicationUrl() {
		String url = pro.getProperty("BaseUrl");
		return url;
	}

	public String getUserEmailAddress() {
		String email = pro.getProperty("Email");
		return email;
	}

	public String getUserEmailPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}

}
