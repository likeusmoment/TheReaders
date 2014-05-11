package com.thereaders;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnector {

	public static String getHTML(URL url) {
		byte[] byteArr = new byte[1024];
		int bytesRead = 0;
		StringBuilder strbld = new StringBuilder();

		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedInputStream bis = new BufferedInputStream(
					conn.getInputStream());

			while ((bytesRead = bis.read(byteArr)) != -1) {
				strbld.append(byteArr.toString());
			}

			System.out.println(strbld);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return strbld.toString();
	}

}
