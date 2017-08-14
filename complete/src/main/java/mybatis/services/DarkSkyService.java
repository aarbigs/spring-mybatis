package mybatis.services;
import mybatis.exceptions.APIException;
import mybatis.mappers.DarkSkyMapper;
import mybatis.mymodel.Darkskymodel.DarkSkyNumber3;
import mybatis.mymodel.Darkskymodel.DarkSkyNumber4;
import mybatis.mymodel.Darkskymodel.DarkSkyNumber5;
import mybatis.mymodel.Darkskymodel.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by aaron on 7/26/17.
 */
@Service

public class DarkSkyService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DarkSkyMapper weatherMapper;

    public Location getForecastByLatLng(double lati, double longi){
        Location darkSky = restTemplate.getForObject("https://api.darksky.net/forecast/bc22b26533e2408b35a0f5fa86ec8efd/"+lati+","+longi+"/", Location.class);
        return darkSky;
    }

    public long TimeToSeconds(String dateStr){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate;
        long timeMilli = 0;
        try {
            startDate = df.parse(dateStr);
            timeMilli = startDate.getTime();
            //String newDateString = df.format(startDate);
            //System.out.println(newDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return timeMilli/1000;
    }


    public Location getForecastByLatLngDate(double lati, double longi, String dateStr) {
        String url = "https://api.darksky.net/forecast/bc22b26533e2408b35a0f5fa86ec8efd/"+lati+","+longi+","+TimeToSeconds(dateStr);
        Location darkSky = restTemplate.getForObject(
                url, Location.class);
        return darkSky;
    }

    public String dateStringFromSeconds(long seconds) {
        Date date = new Date(seconds*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:MM:SS");
        String dateStringFromMillis = sdf.format(date);
        return dateStringFromMillis;
    }


    public ArrayList<DarkSkyNumber3> getForecastByLatLngDateTo2016(double lati, double longi, String dateStr) {

            ArrayList<DarkSkyNumber3> yearIncrementing = new ArrayList<>();

            for (long i = TimeToSeconds(dateStr); i < 1483228800; i += 31557600) {

                String url = "https://api.darksky.net/forecast/bc22b26533e2408b35a0f5fa86ec8efd/" + lati + "," + longi + "," + i;
                Location darkSky = restTemplate.getForObject(url, Location.class);

                DarkSkyNumber3 darkSkyNumber3 = new DarkSkyNumber3();

                darkSkyNumber3.setDate(dateStringFromSeconds(i));
                darkSkyNumber3.setSummary(darkSky.getDaily().getData()[0].getSummary());
                darkSkyNumber3.setSunriseTime(dateStringFromSeconds(darkSky.getDaily().getData()[0].getSunriseTime()));
                darkSkyNumber3.setSunsetTime(dateStringFromSeconds(darkSky.getDaily().getData()[0].getSunsetTime()));
                darkSkyNumber3.setPrecipProbability(darkSky.getDaily().getData()[0].getPrecipProbability());
                darkSkyNumber3.setTemperatureMax(darkSky.getDaily().getData()[0].getTemperatureMax());
                yearIncrementing.add(darkSkyNumber3);
            }
                return yearIncrementing;


        }

    public DarkSkyNumber4 getForecastByLatLngHrly(double lati, double longi){
        String url = "https://api.darksky.net/forecast/bc22b26533e2408b35a0f5fa86ec8efd/"+lati+","+longi;
        Location darkSky = restTemplate.getForObject(url, Location.class);

        DarkSkyNumber4 darkSkyNumber4 = new DarkSkyNumber4();
        int i = 0;

        for (i = 0;i < darkSky.getHourly().getData().length; i++){
            darkSkyNumber4.setPrecipIntensity(darkSkyNumber4.getPrecipIntensity() + darkSky.getHourly().getData()[i].getPrecipIntensity());
            darkSkyNumber4.setPrecipProbability(darkSkyNumber4.getPrecipProbability() + darkSky.getHourly().getData()[i].getPrecipProbability());
            darkSkyNumber4.setTemperature(darkSkyNumber4.getTemperature() + darkSky.getHourly().getData()[i].getTemperature());
            darkSkyNumber4.setApparentTemperature(darkSkyNumber4.getApparentTemperature() + darkSky.getHourly().getData()[i].getApparentTemperature());
            darkSkyNumber4.setDewPoint(darkSkyNumber4.getDewPoint() + darkSky.getHourly().getData()[i].getDewPoint());
            darkSkyNumber4.setHumidity(darkSkyNumber4.getHumidity() + darkSky.getHourly().getData()[i].getHumidity());
            darkSkyNumber4.setWindSpeed(darkSkyNumber4.getWindSpeed() + darkSky.getHourly().getData()[i].getWindSpeed());
            darkSkyNumber4.setWindGust(darkSkyNumber4.getWindGust() + darkSky.getHourly().getData()[i].getWindGust());
            darkSkyNumber4.setWindBearing(darkSkyNumber4.getWindBearing() + darkSky.getHourly().getData()[i].getWindBearing());
            darkSkyNumber4.setCloudCover(darkSkyNumber4.getCloudCover() + darkSky.getHourly().getData()[i].getCloudCover());
            darkSkyNumber4.setPressure(darkSkyNumber4.getPressure() + darkSky.getHourly().getData()[i].getPressure());
            darkSkyNumber4.setOzone(darkSkyNumber4.getOzone() + darkSky.getHourly().getData()[i].getOzone());
            darkSkyNumber4.setAvguvIndex(darkSkyNumber4.getAvguvIndex() + darkSky.getHourly().getData()[i].getUvIndex());

        }
        darkSkyNumber4.setPrecipIntensity(Math.round((darkSkyNumber4.getPrecipIntensity() / (i+1))*100d)/100d);
        darkSkyNumber4.setPrecipProbability(Math.round((darkSkyNumber4.getPrecipProbability() / (i+1))*100d)/100d);
        darkSkyNumber4.setTemperature(Math.round((darkSkyNumber4.getTemperature() / (i+1))*100d)/100d);
        darkSkyNumber4.setApparentTemperature(Math.round((darkSkyNumber4.getApparentTemperature() / (i+1))*100d)/100d);
        darkSkyNumber4.setDewPoint(Math.round((darkSkyNumber4.getDewPoint() / (i+1))*100d)/100d);
        darkSkyNumber4.setHumidity(Math.round((darkSkyNumber4.getHumidity() / (i+1))*100d)/100d);
        darkSkyNumber4.setWindSpeed(Math.round((darkSkyNumber4.getWindSpeed() / (i+1))*100d)/100d);
        darkSkyNumber4.setWindGust(Math.round((darkSkyNumber4.getWindGust() / (i+1))*100d)/100d);
        darkSkyNumber4.setWindBearing(Math.round((darkSkyNumber4.getWindBearing() / (i+1))*100d)/100d);
        darkSkyNumber4.setCloudCover(darkSkyNumber4.getCloudCover() / (i+1));
        darkSkyNumber4.setPressure(Math.round((darkSkyNumber4.getPressure() / (i+1))*100d)/100d);
        darkSkyNumber4.setOzone(Math.round((darkSkyNumber4.getOzone() / (i+1))*100d)/100d);
        darkSkyNumber4.setAvguvIndex(darkSkyNumber4.getAvguvIndex() / (i+1));

        return darkSkyNumber4;
    }

    @Cacheable("DarkSky")
    public ArrayList<DarkSkyNumber5> getForecastByLatLngWkly(double lati, double longi) throws APIException {
        System.out.println("dark sky method hit");
        ArrayList<DarkSkyNumber5> darkSkyNumber5ArrayList = new ArrayList<>();
        if (populateDB()) {
            System.out.println("1");
            String url = "https://api.darksky.net/forecast/bc22b26533e2408b35a0f5fa86ec8efd/" + lati + "," + longi;
            Location darkSky;
            try {
                darkSky = restTemplate.getForObject(url, Location.class);
                if (darkSky.getDaily().getData().length<1){
                    throw new APIException();
                }
            } catch (Exception anyException){
                throw anyException;
            }
            DarkSkyNumber5 darkSkyNumber5;
            for (int i = 0; i < darkSky.getDaily().getData().length; i++) {
                System.out.println("looping");
                darkSkyNumber5 = new DarkSkyNumber5();

                darkSkyNumber5.setDate(dateStringFromSeconds(darkSky.getDaily().getData()[i].getTime()));
                darkSkyNumber5.setSummary(darkSky.getDaily().getData()[i].getSummary());
                darkSkyNumber5.setSunrise(dateStringFromSeconds(darkSky.getDaily().getData()[i].getSunriseTime()));
                darkSkyNumber5.setSunset(dateStringFromSeconds(darkSky.getDaily().getData()[i].getSunsetTime()));
                darkSkyNumber5.setPrecipProbability(darkSky.getDaily().getData()[i].getPrecipProbability());
                darkSkyNumber5.setTemperatureMax(darkSky.getDaily().getData()[i].getTemperatureMax());
                darkSkyNumber5.setWindSpeed(darkSky.getDaily().getData()[i].getWindSpeed());
                darkSkyNumber5ArrayList.add(darkSkyNumber5);
                //weatherMapper.addNew(darkSkyNumber5);
            }

            System.out.println("done looping");
            weatherMapper.addNew(darkSkyNumber5ArrayList.get(7));
            System.out.println("returning");
            return darkSkyNumber5ArrayList;
        } else {
            //TODO: ask ryan why we have two return statements
            //return 8 most recent records from the database as daily forecast objects aka darkSkyNumber5 objects
            darkSkyNumber5ArrayList = weatherMapper.getWeeklyForecast();
            return darkSkyNumber5ArrayList;
        }
    }
//
//    private boolean populateMissingDataDB() {
//        //Check the database to see if you have the most recent forecast - <today> plus seven days
//        // If we do have the most recent forecast then return that forecast (today + seven days from the database)
//        // If we do not have the most recent forecast we need to call the darksky api and insert the last day of the forecast
//        return false;
//    }
//
    public int initialDBPopulation(double lati, double longi) {
        String url = "https://api.darksky.net/forecast/bc22b26533e2408b35a0f5fa86ec8efd/" + lati + "," + longi;
        Location darkSky = restTemplate.getForObject(url, Location.class);
        DarkSkyNumber5 darkSkyNumber5;
        for (int i = 0; i < darkSky.getDaily().getData().length; i++) {

            darkSkyNumber5 = new DarkSkyNumber5();

            darkSkyNumber5.setDate(dateStringFromSeconds(darkSky.getDaily().getData()[i].getTime()));
            darkSkyNumber5.setSummary(darkSky.getDaily().getData()[i].getSummary());
            darkSkyNumber5.setSunrise(dateStringFromSeconds(darkSky.getDaily().getData()[i].getSunriseTime()));
            darkSkyNumber5.setSunset(dateStringFromSeconds(darkSky.getDaily().getData()[i].getSunsetTime()));
            darkSkyNumber5.setPrecipProbability(darkSky.getDaily().getData()[i].getPrecipProbability());
            darkSkyNumber5.setTemperatureMax(darkSky.getDaily().getData()[i].getTemperatureMax());
            darkSkyNumber5.setWindSpeed(darkSky.getDaily().getData()[i].getWindSpeed());
            darkSkyNumber5.setLatitude(darkSky.getLatitude());
            darkSkyNumber5.setLongitude(darkSky.getLongitude());
            weatherMapper.addNew(darkSkyNumber5);
        }
        return 1;
    }

    private boolean populateDB() {
        Date date = new Date();
        date = addEightDays(date);
        System.out.println(weatherMapper.getMostRecentDate());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dbDateStr = sdf.format(date);
        //String dbDateStr2 = sdf.format(weatherMapper.getMostRecentDate());
        System.out.println(dbDateStr);
        //int val = dbDateStr2.compareTo(dbDateStr);
        try {
            int val = weatherMapper.getMostRecentDate().compareTo(dbDateStr);
            System.out.println(val);
            if (val == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e){
            return false;
        }
    }
        //ask DB for most recent forecast date

    public Date addEightDays(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 7);
        return c.getTime();
    }
}

