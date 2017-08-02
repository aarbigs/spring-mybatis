package mybatis.controllers;

import mybatis.mymodel.Beermodel.Beer;
import mybatis.mymodel.Darkskymodel.DarkSkyNumber3;
import mybatis.mymodel.Darkskymodel.DarkSkyNumber4;
import mybatis.mymodel.Darkskymodel.DarkSkyNumber5;
import mybatis.mymodel.Darkskymodel.Location;
import mybatis.mymodel.RefugeeModel;
import mybatis.services.BeerService;
import mybatis.services.DarkSkyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    @RequestMapping("/weather/history")
    public ArrayList<DarkSkyNumber3> getWeatherTo2016(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng,
                                                     @RequestParam(value="date")String dateStr) {
        return darkSkyService.getForecastByLatLngDateTo2016(lat, lng, dateStr);
    }

    @RequestMapping("/weather/hourly")
    public DarkSkyNumber4 getWeatherHourly(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng) {
        return darkSkyService.getForecastByLatLngHrly(lat, lng);
    }

    @RequestMapping("/weather/weekly")
    public ArrayList<DarkSkyNumber5> getWeatherWeekly(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng) {
        return darkSkyService.getForecastByLatLngWkly(lat, lng);
    }

    // ryan says stop looking at this method
    @RequestMapping(method = RequestMethod.GET, value = "/weather/weeklyDB")
    public ArrayList<DarkSkyNumber5> addNew(@RequestParam(value="lat")double lat, @RequestParam(value="lng")double lng) {
        return darkSkyService.getForecastByLatLngWkly(lat,lng);
    }
}
