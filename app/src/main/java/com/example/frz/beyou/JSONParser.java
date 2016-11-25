package com.example.frz.beyou;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONParser {
    public static String makeHttpRequest(String link) {
        try{
            String stream="";
            String data="";

            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr =  new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();
            if(conn.getResponseCode() == 200){
                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    sb.append(line);
                }
                stream = sb.toString();
                conn.disconnect();
            }
            return stream;
        } catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
}