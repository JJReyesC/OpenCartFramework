package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ObjectFileReader {

	private Properties properties;
	private final String propertyFilePath = "../OpenCartFramework/src/main/java/utils/%s.properties";

	public ObjectFileReader(String page) {
		BufferedReader reader;
		try {
			String path = String.format(propertyFilePath,page);
			reader = new BufferedReader(new FileReader(path));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Object_Repository.properties not found at " + propertyFilePath);
		}
	}

	public Properties getProperties() {
		return properties;
	}
}
