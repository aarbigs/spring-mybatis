package mybatis.mymodel;

/**
 * Created by aaron on 7/24/17.
 */
public class RefugeeModel{

    int id;
    int year;
    int year1;
    int year2;
    String origin;
    int refugees;
    int credits;
    double gdp;
    double sumOfRefugees;
    String country_territory;
    String Series_name;
    String Country_Name;
    double y2000;
    double y2001;
    double y2002;

    public RefugeeModel(){}

    public RefugeeModel(int Year1, int Year2, String country_territory){
        this.year1 = year1;
        this.year2 = year2;
        this.country_territory = country_territory;
    }

    public RefugeeModel(int Year, String country_territory, String origin){
        this.year = year;
        this.country_territory = country_territory;
        this.origin = origin;
    }

    public RefugeeModel(int id, int year, String origin, int refugees, int credits, double gdp, double sumOfRefugees, String country_territory, String series_name, String country_Name, double y2000, double y2001, double y2002) {
        this.id = id;
        this.year = year;
        this.origin = origin;
        this.refugees = refugees;
        this.credits = credits;
        this.gdp = gdp;
        this.sumOfRefugees = sumOfRefugees;
        this.country_territory = country_territory;
        Series_name = series_name;
        Country_Name = country_Name;
        this.y2000 = y2000;
        this.y2001 = y2001;
        this.y2002 = y2002;
    }

    public int getYear1() {
        return year1;
    }

    public void setYear1(int year1) {
        this.year1 = year1;
    }

    public int getYear2() {
        return year2;
    }

    public void setYear2(int year2) {
        this.year2 = year2;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getRefugees() {
        return refugees;
    }

    public void setRefugees(int refugees) {
        this.refugees = refugees;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public double getSumOfRefugees() {
        return sumOfRefugees;
    }

    public void setSumOfRefugees(double sumOfRefugees) {
        this.sumOfRefugees = sumOfRefugees;
    }

    public String getCountry_territory() {
        return country_territory;
    }

    public void setCountry_territory(String country_territory) {
        this.country_territory = country_territory;
    }

    public String getSeries_name() {
        return Series_name;
    }

    public void setSeries_name(String series_name) {
        Series_name = series_name;
    }

    public String getCountry_Name() {
        return Country_Name;
    }

    public void setCountry_Name(String country_Name) {
        Country_Name = country_Name;
    }

    public double getY2000() {
        return y2000;
    }

    public void setY2000(double y2000) {
        this.y2000 = y2000;
    }

    public double getY2001() {
        return y2001;
    }

    public void setY2001(double y2001) {
        this.y2001 = y2001;
    }

    public double getY2002() {
        return y2002;
    }

    public void setY2002(double y2002) {
        this.y2002 = y2002;
    }
}
