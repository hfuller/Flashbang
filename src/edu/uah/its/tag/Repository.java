package edu.uah.its.tag;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Repository {

	private String name;
	private String description;
	private String url;
	private String regex;
	private String prefix;
	
	Logger logger = null;
	
	public Repository() {
		logger = Logger.getLogger(this.getClass().getPackage().getName());
	}
	
	public Repository(String n, String d, String u, String r, String p) {
		this();
		setName(n); setDescription(d); setUrl(u); setRegex(r); setPrefix(p);
	}
	
	public Repository(File f) {
		this();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Document doc = null;
		try {
			doc = dBuilder.parse(f);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element el = doc.getDocumentElement();
		
		setName(el.getAttribute("name"));
		setDescription(el.getElementsByTagName("description").item(0).getTextContent());
		setUrl(el.getElementsByTagName("url").item(0).getTextContent());
		setRegex(el.getElementsByTagName("regex").item(0).getTextContent());
		setPrefix(el.getElementsByTagName("prefix").item(0).getTextContent());
		
	}

	public String toString() {
		//return "[Repository \"" + name + "\" (" + description + ")]";
		return description;
	}
	
	//////////////////////////////////////////////////
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	
}
