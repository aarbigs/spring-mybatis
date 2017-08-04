package mybatis.rest_controllers;

import mybatis.mymodel.Darkskymodel.DarkSkyNumber3;
import mybatis.mymodel.Darkskymodel.DarkSkyNumber4;
import mybatis.mymodel.Darkskymodel.DarkSkyNumber5;
import mybatis.mymodel.Darkskymodel.Location;
import mybatis.services.DarkSkyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by aaron on 7/26/17.
 */
@RestController
public class DarkSkyController {

    @Autowired
    DarkSkyService darkSkyService;

    @RequestMapping("/weather")
    public Location getWeather(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng) {
        return darkSkyService.getForecastByLatLng(lat, lng);
    }

    @RequestMapping("/weather/date")
    public Location getWeather(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng,
                               @RequestParam(value="date")String dateStr) {
        return darkSkyService.getForecastByLatLngDate(lat, lng, dateStr);
    }

    // This API call returns the weather on a specific date and then the weather on the same date for the next seven years.
    @RequestMapping("/weather/history")
    public ArrayList<DarkSkyNumber3> getWeatherTo2016(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng,
                                                     @RequestParam(value="date")String dateStr) {
        return darkSkyService.getForecastByLatLngDateTo2016(lat, lng, dateStr);
    }

    // This API call returns the average of the  hourly forecasts for a specific latitude and longitude
    @RequestMapping("/weather/hourly")
    public DarkSkyNumber4 getWeatherHourly(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng) {
        return darkSkyService.getForecastByLatLngHrly(lat, lng);
    }

    @RequestMapping("/weather/weekly")
    public ArrayList<DarkSkyNumber5> getWeatherWeekly(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng) {
        return darkSkyService.getForecastByLatLngWkly(lat, lng);
    }

    // This API call returns the next 7 days forecast - it checks the DB first to see if the DB contains
    // all the data. If it does, it returns DB data. If it does not it makes an API request to DarkSky to get the forecast
    // it then backfills any missing data in the DB before returning the results
    @RequestMapping(method = RequestMethod.GET, value = "/weather/weeklyDB")
    public ArrayList<DarkSkyNumber5> addNew(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng) {
        return darkSkyService.getForecastByLatLngWkly(lat,lng);
    }
    // This API call populates the database with 8 records using the initialDBPopulation method
    @RequestMapping(method = RequestMethod.GET, value = "/weather/populate")
    public int populate(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng) {
        return darkSkyService.initialDBPopulation(lat,lng);
    }
}
