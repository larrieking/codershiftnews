/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codershift.ejb;

import API.NewsItem;
import com.codershift.entity.Punch;

import com.crownexponent.codershiftnews.bean.PunchFacade;
import com.crownexponent.punchscrapper.ScrapePunch;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author ISSAH OJIVO
 */

@Singleton
@Startup
public class ReadTimerr {
    
    private int pageCounter = 4068;
    private List<NewsItem>newsItem = new ArrayList<>();
    @EJB
    private PunchFacade facde;

    @Schedule(minute = "*/1", hour = "*", persistent = false)
    
    public void myTimer() {
        System.out.println("Timer started");
        if(pageCounter <1){
            System.out.println("Finished");
        }
        else{
        try{
       newsItem =  ScrapePunch.read(pageCounter);
        }
        catch(Exception e){
            System.out.println("an error occured");
        }
        if(!newsItem.isEmpty()){
       System.out.println(newsItem.get(0).getStyle());
       
       //newsItem.stream().forEach(x -> getFacde().create(x));
        //System.out.println("Timer event: " + new Date());
        for(NewsItem item : newsItem){
            Punch punch = new Punch();
            punch.setDa(item.getDate());
            punch.setStyle(item.getStyle());
            punch.setSummary(item.getSummary());
            punch.setTheURL(item.getTheURL());
            punch.setTitle(item.getTitle());
            getFacde().createNewsItem(punch);
        }
        
        }
          
        newsItem.clear();
        pageCounter-=1;
        System.out.println("done");
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     * @return the facde
     */
    public PunchFacade getFacde() {
        return facde;
    }
}
