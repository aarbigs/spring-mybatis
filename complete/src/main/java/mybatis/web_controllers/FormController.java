package mybatis.web_controllers;

import mybatis.mymodel.Darkskymodel.DarkSkyNumber5;
import mybatis.mymodel.Darkskymodel.WeatherInputs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class FormController {


//    @GetMapping("/weeklyweather")
    @RequestMapping(value = "/test/form", method = RequestMethod.GET )
    public String weatherInputs(Model model) {
        System.out.println("step 1");
        model.addAttribute("weatherInputs", new WeatherInputs());
        System.out.println("step 2");
        return "inputs";
    }

//    @PostMapping("/weeklyweather")
    @RequestMapping(value = "/test/form", method = RequestMethod.POST )
    public String weatherSomething( Model model, WeatherInputs weatherInputs) {

        System.out.println("step 3");
        //model.addAttribute("weatherInputs", weatherInputs);
        return "redirect:/weekly?latitude="+weatherInputs.getLatitude()+"&longitude="+weatherInputs.getLongitude();
    }

}
