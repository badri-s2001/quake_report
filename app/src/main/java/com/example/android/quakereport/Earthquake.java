package com.example.android.quakereport;

public class Earthquake
{
    private double mMagnitude;
    private String mPlace;
    private long mTimeinMilliseconds;
    private String mUrl;

    public Earthquake (double magnitude, String place, long timeinmilliseconds, String url)
    {
        mMagnitude = magnitude;
        mPlace = place;
        mTimeinMilliseconds = timeinmilliseconds;
        mUrl = url;
    }

    public double getMagnitude()
    {
        return mMagnitude;
    }

    public String  getPlace()
    {
        return mPlace;
    }

    public long getTimeinMilliseconds()
    {
        return mTimeinMilliseconds;
    }

    public String getUrl()
    {
        return mUrl;
    }

}
