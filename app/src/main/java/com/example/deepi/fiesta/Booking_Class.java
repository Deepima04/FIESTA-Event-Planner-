package com.example.deepi.fiesta;

import java.io.Serializable;

/**
 * Created by Deepi on 3/26/2017.
 */
public class Booking_Class implements Serializable
{
    int bookid;
    String bookvenuename;
    String bookvenuecharges;
    String bookeventname;
    String eventcharges;
    String bookpeople;
    String bookcateringcharges;
    String bookdate;

    public String getUserbookid() {
        return userbookid;
    }

    public void setUserbookid(String userbookid) {
        this.userbookid = userbookid;
    }

    String userbookid;

    public String toString()
    {
        return bookusername;
    }

    public String getBookusername() {
        return bookusername;
    }

    public void setBookusername(String bookusername) {
        this.bookusername = bookusername;
    }

    String bookusername;
    public String getBookbudget() {
        return bookbudget;
    }

    public void setBookbudget(String bookbudget) {
        this.bookbudget = bookbudget;
    }

    public String getBooktime() {
        return booktime;
    }

    public void setBooktime(String booktime) {
        this.booktime = booktime;
    }

    public String getBookdate() {
        return bookdate;
    }

    public void setBookdate(String bookdate) {
        this.bookdate = bookdate;
    }

    public String getBookcateringcharges() {
        return bookcateringcharges;
    }

    public void setBookcateringcharges(String bookcateringcharges) {
        this.bookcateringcharges = bookcateringcharges;
    }

    public String getBookpeople() {
        return bookpeople;
    }

    public void setBookpeople(String bookpeople) {
        this.bookpeople = bookpeople;
    }

    public String getEventcharges() {
        return eventcharges;
    }

    public void setEventcharges(String eventcharges) {
        this.eventcharges = eventcharges;
    }

    public String getBookeventname() {
        return bookeventname;
    }

    public void setBookeventname(String bookeventname) {
        this.bookeventname = bookeventname;
    }

    public String getBookvenuecharges() {
        return bookvenuecharges;
    }

    public void setBookvenuecharges(String bookvenuecharges) {
        this.bookvenuecharges = bookvenuecharges;
    }

    public String getBookvenuename() {
        return bookvenuename;
    }

    public void setBookvenuename(String bookvenuename) {
        this.bookvenuename = bookvenuename;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    String booktime;
    String bookbudget;


}
