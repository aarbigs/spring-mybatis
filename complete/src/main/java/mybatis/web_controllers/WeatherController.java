package mybatis.web_controllers;

import mybatis.mymodel.Darkskymodel.DarkSkyNumber5;
import mybatis.services.DarkSkyService;
import mybatis.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by aaron on 8/3/17.
 */
@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/weekly")
    public String getWeeklyWeather( @RequestParam(value ="latitude")double latitude,
                                    @RequestParam(value ="longitude")double longitude,
                                    Model model) {

        ArrayList<DarkSkyNumber5> weeklyForecasts = weatherService.getForecastByLatLngWkly(latitude, longitude);

        model.addAttribute("weeklyForecasts", weeklyForecasts);

        return "forecast";
    }



}
