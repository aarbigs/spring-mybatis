package mybatis.rest_controllers;

import mybatis.mymodel.RefugeeModel;
import mybatis.services.RefugeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Created by aaron on 7/24/17.
 */
@RestController
@RequestMapping("/immigrants")

public class RefugeeController {

    @Autowired
    RefugeeService refugeeService;

    //Create
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public int addNew(@RequestBody RefugeeModel refugee) {
        return refugeeService.addNew(refugee);
    }


    //Update
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public RefugeeModel updateRefById(@RequestBody RefugeeModel refugee) {
        return refugeeService.updateRefById(refugee);
    }

    //Delete
    @RequestMapping(method= RequestMethod.DELETE, value = "/")
    public void deleteRefById (@RequestParam(value="id")int id){
        refugeeService.deleteRefById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public RefugeeModel getById(@RequestParam(value="id")int id) {
        return refugeeService.getByID(id);
    }

    @RequestMapping(value = "/custom", method = RequestMethod.GET)
    public int getCustom(@RequestParam(value="year1")int year1,
                                  @RequestParam(value="year2")int year2,
                                  @RequestParam(value="country_territory")String country_territory) {
        System.out.println(refugeeService.getRefugeeNumber(year1, year2, country_territory));
        return refugeeService.getRefugeeNumber(year1, year2, country_territory);
    }

}
