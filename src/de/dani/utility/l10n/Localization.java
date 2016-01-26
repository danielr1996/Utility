package de.dani.utility.l10n;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Localization {
	private Map<String, Map<String, String>> langs;
	private String lang; 
	
	public Localization(String lang){
		this.lang = lang;
		langs = JSONReader.getMap(new File("res"+File.separator+"langs.json"));
	}
	
	public String get(String key, String lang){
		if(langs==null || langs.get(lang) == null || langs.get(lang).get(key) == null){
			return "";
		}
		return langs.get(lang).get(key);
	}
	
	public String get(String key){
		return get(key, lang);
	}
	
	public void setLang(String lang){
		this.lang = lang;
	}

	public List<String> getAvailableLangs() {
		List<String> aLangs = new ArrayList<String>();
		aLangs.addAll(langs.keySet());
		return aLangs;
	}
}
