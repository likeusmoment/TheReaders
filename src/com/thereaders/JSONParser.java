package com.thereaders;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {

	public JSONObject parseJson() {
		JSONObject jObj = null;
		String json = "{ \"glossary\": { \"title\": \"example glossary\"}}";

		try {
			jObj = new JSONObject(json);

			JSONObject c = jObj.getJSONObject("glossary");
			Log.d("hwh", "hwh:" + c.getString("title"));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jObj;
	}
}
