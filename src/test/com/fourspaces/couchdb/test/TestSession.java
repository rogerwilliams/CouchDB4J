package com.fourspaces.couchdb.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.fourspaces.couchdb.Session;

public class TestSession {
	public static Session getTestSession() {
		Properties props = new Properties();
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("couchdb-test.properties");
			props.load(is);
			//return new Session(props.getProperty("host"),Integer.parseInt(props.getProperty("port")));
			return new Session(props.getProperty("host"),
					Integer.parseInt(props.getProperty("port")),
					props.getProperty("username"),
					props.getProperty("password"),
					Boolean.parseBoolean(props.getProperty("usesAuth")),
					Boolean.parseBoolean(props.getProperty("secure")));
		} catch (Exception e) {
			return new Session("127.0.0.1",5984);
			//throw new RuntimeException(e);
		}		
	}
	@Test
	public void noop() {} // just to avoid junit warning
}
