package mybatis.mymodel.Darkskymodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 7/27/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DarkSkyNumber4 {

    double precipIntensity;  //: 0.022,
    double precipProbability;  //: 0.62,
    //String precipType;  //: "rain",
    double temperature;  //: 84.09,
    double apparentTemperature;  //: 92.39,
    double dewPoint;  //: 75.3,
    double humidity;  //: 0.75,
    double windSpeed;  //: 20.96,
    double windGust;  //: 31.27,
    double windBearing;  //: 276,
    int cloudCover;  //: 1,
    double pressure;  //: 1006.6,
    double ozone;  //: 262.42,
    int avguvIndex;  //: 3

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

//    public String getPrecipType() {
//        return precipType;
//    }
//
//    public void setPrecipType(String precipType) {
//        this.precipType = precipType;
//    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public double getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(double windBearing) {
        this.windBearing = windBearing;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }

    public int getAvguvIndex() {
        return avguvIndex;
    }

    public void setAvguvIndex(int avguvIndex) {
        this.avguvIndex = avguvIndex;
    }
}
