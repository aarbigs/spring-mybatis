package mybatis.services;

import mybatis.mappers.DarkSkyMapper;
import mybatis.mymodel.Darkskymodel.DarkSkyNumber5;
import mybatis.mymodel.Darkskymodel.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aaron on 8/3/17.
 */
@Service
public class WeatherService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DarkSkyMapper darkSkyMapper;

    public String dateStringFromSeconds(long seconds) {
        Date date = new Date(seconds * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:MM:SS");
        String dateStringFromMillis = sdf.format(date);
        return dateStringFromMillis;
    }

    public ArrayList<DarkSkyNumber5> getForecastByLatLngWkly(double lati, double longi) {
        ArrayList<DarkSkyNumber5> darkSkyNumber5ArrayList = new ArrayList<>();
//        if (populateDB()) {

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
            darkSkyNumber5ArrayList.add(darkSkyNumber5);

        }
        darkSkyMapper.addNew(darkSkyNumber5ArrayList.get(7));
        return darkSkyNumber5ArrayList;
    }
}
