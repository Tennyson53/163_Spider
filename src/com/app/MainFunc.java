package com.app;


import com.fileIO.fileWrite;
import com.fileIO.jarPath;
import com.structure.urlTuple;


/**
 * Created by tenny on 2016/11/28.
 */
public class MainFunc {
    public static void main(String[] args) throws Exception {
        //TODO: mysql operations
        //TODO: move to Project 163_Spider_Save

        urlTuple resTuple;
        int i, j;
        String path_url = jarPath.getJarDir();

        String fileName = path_url + "/StockID_AnnouncementID";

        //i: the page of HTTP request where the spider begins from
        for (i = 0; i < 80000; i++) {
            System.out.println("Start analyzing page " + i);
            GetInfoID client = new GetInfoID();
            String url = "http://quotes.money.163.com/hs/marketdata/service/gsgg.php?host=/hs/marketdata/service/gsgg.php&page=" + String.valueOf(i) + "&query=leixing:00;start:all;end:all&fields=RN,SYMBOL,SNAME,PUBLISHDATE,ANNOUNMT2,ANNOUNMT1&sort=PUBLISHDATE&order=desc&count=25&type=query&initData=[object%20Object]&callback=callback_1604891936&req=2226";
            String page = client.getPages(url);
            resTuple = client.getID(page);
//            resTuple.ShowAll();

            //Output to file
            int icount = resTuple.GetCount();
            String sout = new String();
            for (j = 0; j < icount; j++) {
                sout = sout + resTuple.Stock_ID.get(j) + " " + resTuple.Announcement_ID.get(j) + " " + resTuple.Publish_Date.get(j) + "\n";
            }
            fileWrite.appendWrite(fileName, sout);
        }
        System.out.println("Done!");
    }
}
