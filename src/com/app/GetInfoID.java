package com.app;

import com.structure.urlTuple;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by tenny on 2016/11/28.
 */


public class GetInfoID {

    public String getPages(String _url) throws IOException {

        //Create Http Connection
        HttpURLConnection conn = (HttpURLConnection) (new URL(_url).openConnection());

        InputStream inS = null;
        InputStreamReader inSR = null;
        BufferedReader bR = null;
        String content = null;
        String line = null;
        inS = conn.getInputStream();
        inSR = new InputStreamReader(inS);
        bR = new BufferedReader(inSR);
        line = bR.readLine();
        while (line != null) {
            content += line;
            line = bR.readLine();
        }
        return content;
    }

    public urlTuple getID(String text) throws JSONException {
        //JSON
        ArrayList<String> symbols = new ArrayList();
        ArrayList<String> announcements = new ArrayList();
        ArrayList<String> publishdata = new ArrayList();
        urlTuple urlT = new urlTuple();
        int pre = text.indexOf('(');
        text = text.substring(pre + 1, text.length() - 1);
        JSONObject JSONobj = new JSONObject(text);
        JSONArray JSONarr = (JSONArray) JSONobj.get("list");
        int i;
        for (i = 0; i < JSONarr.length(); i++) {
            JSONobj = JSONarr.getJSONObject(i);
            String symbol = (String) JSONobj.get("SYMBOL");
            String announcementID = (String) JSONobj.get("ANNOUNMTID");
            String publishDate = (String) JSONobj.get("PUBLISHDATE");

            symbols.add(symbol);
            announcements.add(announcementID);
            publishdata.add(publishDate);
//            System.out.print(symbol+" ");
//            System.out.println(announcementID);
        }
        urlT.Stock_ID = symbols;
        urlT.Announcement_ID = announcements;
        urlT.Publish_Date = publishdata;
        return urlT;
    }


}
