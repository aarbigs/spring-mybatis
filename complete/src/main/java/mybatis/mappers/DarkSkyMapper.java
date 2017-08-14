package mybatis.mappers;

import mybatis.mymodel.Darkskymodel.DarkSkyNumber5;
import mybatis.mymodel.RefugeeModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * Created by aaron on 7/27/17.
 */
@Mapper
public interface DarkSkyMapper {

    String INSERT_FORECAST = "INSERT INTO `Weather`.WeatherForecast (date, summary, sunrise, sunset, precipProbability, temperatureMax, windSpeed) values (#{date}, #{summary}, #{sunrise}, #{sunset}, #{precipProbability}, #{temperatureMax}, #{windSpeed})";

    String GET_DAILY_FORECAST = "SELECT * FROM `Weather`.WeatherForecast WHERE date <= (select max(date))" +
            "ORDER BY date desc LIMIT 8";

    String GET_MOST_RECENT_DATE = "SELECT date FROM `Weather`.WeatherForecast ORDER BY date desc LIMIT 1";

    @Insert(INSERT_FORECAST)
    public int addNew(DarkSkyNumber5 darkSkyNumber5);

    @Select(GET_DAILY_FORECAST)
    ArrayList<DarkSkyNumber5> getWeeklyForecast();

    @Select(GET_MOST_RECENT_DATE)
    public String getMostRecentDate();


}
