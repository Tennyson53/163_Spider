package com.structure;

import java.util.ArrayList;

/**
 * Created by tenny on 2016/11/28.
 */
public class urlTuple {
    public ArrayList<String> Stock_ID;
    public ArrayList<String> Announcement_ID;
    public ArrayList<String> Publish_Date;

    public void ShowAll() {
        for (int i = 0; i < Stock_ID.size(); i++) {
            System.out.print(Stock_ID.get(i) + " ");
            System.out.print(Announcement_ID.get(i) + " ");
            System.out.println(Publish_Date.get(i));
        }
    }

    public int GetCount() {
        return Stock_ID.size();
    }
}
