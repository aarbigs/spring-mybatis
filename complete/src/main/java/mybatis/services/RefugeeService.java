package mybatis.services;

import mybatis.mappers.RefugeeMapper;
import mybatis.mymodel.RefugeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by aaron on 7/24/17.
 */
@Service
public class RefugeeService {
    @Autowired
    RefugeeMapper refugeeMapper;


//    public ArrayList<refugee> getAllRefugees(){
//        return userMapper.getAllRefugees();
//    }
    public int addNew(RefugeeModel refugee) {
        return refugeeMapper.addNew(refugee);
//        return refugeeMapper.get(refugee.getId());
    }
//
    public RefugeeModel updateRefById(RefugeeModel refugee) {
        return refugeeMapper.updateRefById(refugee);
    }

    public void deleteRefById(int id) {
        refugeeMapper.deleteRefById(id);

    }
    public RefugeeModel getByID(int id){
        return refugeeMapper.getByID(id);
    }

    public int getRefugeeNumber(int year1, int year2, String country_territory){
        return refugeeMapper.getRefugeeNumber(year1, year2, country_territory);
    }

}
