package net.buttology.avt.util;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileHandler {

	public static void extractInternalFile(String resource, File target) throws Exception {
		InputStream is = FileHandler.class.getResourceAsStream(resource);
		if(is == null) {
			throw new Exception("Failed to get resource from jar: "+resource);
		}
		Files.copy(is, target.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static XMLParser readInternalXmlFile(String file) {
		InputStream is = FileHandler.class.getResourceAsStream(file);
		XMLParser xml = new XMLParser();
		xml.read(is);
		return xml;
	}
	
}
