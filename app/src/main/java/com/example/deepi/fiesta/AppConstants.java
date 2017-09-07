package com.example.deepi.fiesta;

/**
 * Created by Deepi on 2/11/2017.
 */
public class AppConstants

    {
        public static String DATABASE_NAME="FiestaEventPlanner";
        public static final int DATABASE_VERSION=15;

        //LOGIN TABLE

        public static final String LOGINTABLE="LOGIN";
        public static final String LOGIN_ID="ID";
        public static final String LOGIN_USERNAME="USERNAME";
        public static final String LOGIN_USERPASS="PASSWORD";
        public static final String LOGIN_MAILID="mailid";
        public static final String LOGIN_PHONENUMBER="userphone";

        static final String LOGIN_CREATE ="create table "+LOGINTABLE+"("+LOGIN_ID+" integer primary key autoincrement,"+LOGIN_USERNAME+" text,"+LOGIN_MAILID+" text,"+LOGIN_PHONENUMBER+" text,"+LOGIN_USERPASS+" text)";

        //PLACE TABLE

        /*public static final String TABLE_NAME="place";
        public static final String COLUMN_ID="pid";
        public static final String COLUMN_NAME="pname";

        public static final String QUERY="create table "+TABLE_NAME+"("+COLUMN_ID+" integer primary key,"+COLUMN_NAME+" text)";
*/
        //VENUE TABLE

        public static final String TABLE_MNAME="venue";
        public static final String COLUMN_MID="vid";
        public static final String COLUMN_MNAME="vname";
        public static final String COLUMN_ADDRESS="address";
        public static final String COLUMN_CHARGES="charges";
        public static final String COLUMN_CAPACITY="capacity";
        public static final String COLUMN_PHNO="phno";
        public static final String COLUMN_DESCRIPTION="description";
        public static final String COLUMN_CATERING="catering";
        public static final String COLUMN_LAT="latitude";
        public static final String COLUMN_LONG="longitude";
        public static final String COLUMN_PLACENAME="place_name";

        //public static final String MQUERY="create table "+TABLE_MNAME+"("+COLUMN_MID+" integer primary key autoincrement,"+COLUMN_MNAME+" text,"+COLUMN_ADDRESS+" text,"+COLUMN_CHARGES+" text,"+COLUMN_CAPACITY+" text,"+COLUMN_IMAGE+" blob,"+COLUMN_DESCRIPTION+" text,"+COLUMN_PHNO+" text,"+COLUMN_PLACENAME+" text,"+COLUMN_DECORATION+" text,"+COLUMN_MUSIC+" text,"+COLUMN_BAR+" text,"+COLUMN_CATERING+" text,"+COLUMN_LAT+" text,"+COLUMN_LONG+" text)";


        public static final String QUERYY="create table "+TABLE_MNAME+"("+COLUMN_MID+" integer primary key autoincrement,"+COLUMN_MNAME+" text,"+COLUMN_ADDRESS+" text,"+COLUMN_CHARGES+" text,"+COLUMN_CAPACITY+" text,"+COLUMN_DESCRIPTION+" text,"+COLUMN_PHNO+" text,"+COLUMN_PLACENAME+" text,"+COLUMN_CATERING+" text,"+COLUMN_LAT+" text,"+COLUMN_LONG+" text)";

        //WEDDING TABLE

        public static final String TABLE_WEDDING="customizewedding";
        public static final String COLUMN_WEDID="wedid";
        public static final String COLUMN_WED_CATEGORY="wedcategory";
        public static final String COLUMN_FLORALSTAGE="floralstage";
        public static final String COLUMN_OPENWEDDING="openwedding";
        public static final String COLUMN_ETHNICSTAGE="ethnicstage";
        public static final String COLUMN_BALLOONSTAGE="balloonstage";
        public static final String COLUMN_PEARLYWHITE="pearlywhite";
        public static final String COLUMN_SATIN="satin";
        public static final String COLUMN_REDNGOLD="redngold";
        public static final String COLUMN_WHITENPINK="whitenpink";
        public static final String COLUMN_MANDAP="mandap";
        public static final String COLUMN_OUTDOORFLORAL="outdoorfloral";
        public static final String COLUMN_MUSICFACILITY="musicfacility";
        public static final String COLUMN_BARFACILITY="barfacility";
        public static final String COLUMN_WEDDINGCAKE="weddingcake";
        public static final String COLUMN_ROOM="room";

        public static final String QUERYYWEDDING="create table "+TABLE_WEDDING+"("+COLUMN_WEDID+" integer primary key autoincrement,"+COLUMN_WED_CATEGORY+" text,"+COLUMN_FLORALSTAGE+" text,"+COLUMN_OPENWEDDING+" text,"+COLUMN_ETHNICSTAGE+" text,"+COLUMN_BALLOONSTAGE+" text,"+COLUMN_PEARLYWHITE+" text,"+COLUMN_SATIN+" text,"+COLUMN_REDNGOLD+" text,"+COLUMN_WHITENPINK+" text,"+COLUMN_MANDAP+" text,"+COLUMN_OUTDOORFLORAL+" text,"+COLUMN_MUSICFACILITY+" text,"+COLUMN_BARFACILITY+" text,"+COLUMN_WEDDINGCAKE+" text,"+COLUMN_ROOM+" text)";



        //BOOKING TABLE

        public static final String TABLE_BOOK="book";

        public static final String COLUMN_BOOKID="bookid";
        public static final String COLUMN_USERBOOKID="userbookid";
        public static final String COLUMN_BOOKVENUENAME="bookvenuename";
        public static final String COLUMN_BOOKUSERNAME="bookusername";
        public static final String COLUMN_BOOKVENUECHARGES="bookvenuecharges";
        public static final String COLUMN_BOOKEVENTNAME="bookeventname";
        public static final String COLUMN_EVENTCHARGES="eventcharges";
        public static final String COLUMN_BOOKPEOPLE="bookpeople";
        public static final String COLUMN_BOOKCATERINGCHARGES="bookcateringcharges";
        public static final String COLUMN_BOOKDATE="bookdate";
        public static final String COLUMN_BOOKTIME="booktime";
        public static final String COLUMN_BOOKBUDGET="bookbudget";

        public static final String QUERYYBOOKING="create table "+TABLE_BOOK+"("+COLUMN_BOOKID+" integer primary key autoincrement,"+COLUMN_USERBOOKID+" text,"+COLUMN_BOOKVENUENAME+" text,"+COLUMN_BOOKUSERNAME+" text,"+COLUMN_BOOKVENUECHARGES+" text,"+COLUMN_BOOKEVENTNAME+" text,"+COLUMN_EVENTCHARGES+" text,"+COLUMN_BOOKPEOPLE+" text,"+COLUMN_BOOKCATERINGCHARGES+" text,"+COLUMN_BOOKDATE+" text,"+COLUMN_BOOKTIME+" text,"+COLUMN_BOOKBUDGET+" text)";



        //bookid table


        public static final String TABLE_BOOKIDD="bookid";

        public static final String COLUMN_BOOKIDD="bookiduser";
        public static final String COLUMN_UPDATEID="updateid";
        public static final String COLUMN_UPDATENAME="updatename";

        public static final String QUERYYBOOKID="create table "+TABLE_BOOKIDD+"("+COLUMN_BOOKIDD+" integer primary key autoincrement,"+COLUMN_UPDATENAME+" text,"+COLUMN_UPDATEID+" text)";

    }


