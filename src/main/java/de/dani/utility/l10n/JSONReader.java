package de.dani.utility.l10n;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONReader {

	public static Map<String, Map<String, String>> getMap(File f) {
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String content="", s;
			
			//Read File Contents
			while ((s = br.readLine()) != null) {
				content += s;
			}

			//Map JSON to Map
			JSONObject json = new JSONObject(content);
			JSONArray langs = json.getJSONArray("langs");

			for (Object oLang : langs) {
				JSONObject jLang = (JSONObject) oLang;
				String keyLang = JSONObject.getNames(jLang)[0];
				JSONArray jWords = jLang.getJSONArray(keyLang);
				Map<String, String> mPair = new HashMap<String, String>();
				for (Object oPair : jWords) {
					JSONObject jPair = (JSONObject) oPair;
					String key = JSONObject.getNames(jPair)[0];
					String value = jPair.get(key).toString();
					mPair.put(key, value);
				}
				map.put(keyLang, mPair);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(JSONException e){
			System.err.println("A JSON Error occured. Maybe this file is not in JSON format!");
			e.printStackTrace();
		}
		return map;
	}
}
