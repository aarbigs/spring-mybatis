package mybatis.services;

import mybatis.mymodel.Beermodel.Beer;
import mybatis.mymodel.Beermodel.BeerHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by aaron on 7/25/17.
 */
@Service
public class BeerService {

    @Autowired
    RestTemplate restTemplate;

    public BeerHomework unicorn(){
        //fill in required logic here
        Beer beer = restTemplate.getForObject(
                "http://api.brewerydb.com/v2/beer/random?key=97ea7ef4036e000cefeddbe1d48d6d10", Beer.class);

        String id = beer.getData().getId();
        Beer beerWithBrewery = restTemplate.getForObject(
                "http://api.brewerydb.com/v2/beer/" + id + "?withBreweries=Y&key=97ea7ef4036e000cefeddbe1d48d6d10", Beer.class);

        String name = beerWithBrewery.getData().getName();
        String brewery = beerWithBrewery.getData().getBreweries()[0].getName();
        String city = beerWithBrewery.getData().getBreweries()[0].getLocations()[0].getLocality();
        String state = beerWithBrewery.getData().getBreweries()[0].getLocations()[0].getRegion();

        BeerHomework returnVal = new BeerHomework();
        returnVal.setName(name);
        returnVal.setBrewery(brewery);
        returnVal.setBreweryCity(city);
        returnVal.setBreweryState(state);

        return returnVal;

    }


}
