package mybatis.controllers;

import mybatis.mymodel.Beer;
import mybatis.mymodel.BeerHomework;
import mybatis.services.BeerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by aaron on 7/25/17.
 */
@RestController
public class BeerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BeerService beerService;

    @RequestMapping("/beer")
    public Beer getRandomBeer() {
        Beer beer = restTemplate.getForObject(
                "http://api.brewerydb.com/v2/beer/random?key=97ea7ef4036e000cefeddbe1d48d6d10", Beer.class);
        return beer;
    }

    @RequestMapping("/beer/homework")
    public BeerHomework beerHomework(){
        BeerHomework beerHomework = beerService.unicorn();
        return beerHomework;
    }
}
