package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EarthquakeAdapter extends ArrayAdapter<Earthquake>
{
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> words)
    {
        super(context, 0, words);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }




        Earthquake currentEarthquake = getItem(position);

        Double magnitude = currentEarthquake.getMagnitude();

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitudeview);
        String formattedMagnitude = formatMagnitude(magnitude);
        magnitudeView.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String Place = currentEarthquake.getPlace();

        TextView distanceTextView = (TextView) listItemView.findViewById(R.id.distance_text_view);
        String formattedDistance = formatDistance(Place);
        distanceTextView.setText(formattedDistance);

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_text_view);
        String formattedPlace = formatPlace(Place);
        placeTextView.setText(formattedPlace);

        Date dateobject = new Date(currentEarthquake.getTimeinMilliseconds());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        String fortmattedDate = formatDate(dateobject);
        dateTextView.setText(fortmattedDate);

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        String formattedTime = formatTime(dateobject);
        timeTextView.setText(formattedTime);

        /**
         * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
         */
        return listItemView;
    }

    private String formatMagnitude(double magnitude)
    {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude)
    {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatDistance(String place)
    {
        if(place.contains("of"))
        {
            String[] parts = place.split("(?<=of)");
            String part1 = parts[0];
            return part1;
        }
        else
        {
            String near = "Near the";
            return near;
        }
    }

    private String formatPlace(String place)
    {
        if(place.contains("of"))
        {
            String[] parts = place.split("of ");
            String part2 = parts[1];
            return part2;
        }
        else
        {
            return place;
        }
    }

    private String formatDate(Date dateObject)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject)
    {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}

