package mybatis.mappers;

import mybatis.mymodel.RefugeeModel;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
/**
 * Created by aaron on 7/24/17.
 */
@Mapper
public interface RefugeeMapper {
    //String GET_ALL_ACTIVE_USERS = "SELECT * FROM immigrants.refugees_all";
    //String GET_BY_ID = "SELECT * FROM `mybatis-test`.Users where id = #{id}";

    String INSERT_REFUGEE = "INSERT INTO immigrants.refugees_all (country_territory, origin, refugees, year) values (#{country_territory}, #{origin}, #{refugees}, #{year})";
    String GET_BY_ID = "SELECT * FROM immigrants.refugees_all where id=#{id}";
    String UPDATE_REFUGEE_YEAR = "UPDATE immigrants.refugees_all set Year=#{Year} where id=#{id}";
    String DELETE_REFUGEE = "DELETE FROM immigrants.refugees_all WHERE id=#{id}";
    String GET_FROM_COUNTRY = "SELECT sum(refugees) as sum_refugees from `immigrants`.refugees_all where year between year=#{year1} and year=#{year2} and country_territory=#{country_territory};";

    @Insert(INSERT_REFUGEE)
    public int addNew(RefugeeModel refugee);

    @Select (GET_BY_ID)
    public RefugeeModel getByID(int id);

    @Update(UPDATE_REFUGEE_YEAR)
    public RefugeeModel updateRefById (RefugeeModel refugee);

    @Delete(DELETE_REFUGEE)
    public int deleteRefById(int id);

    @Select(GET_FROM_COUNTRY)
    int getRefugeeNumber(@Param("year1")int year1, @Param("year2") int year2, @Param("country_territory") String country_territory);

}
