package mybatis.controllers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

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

   }
