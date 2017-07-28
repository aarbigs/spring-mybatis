package mybatis.mymodel.Beermodel;

/**
 * Created by aaron on 7/25/17.
 */
public class Country {

    String isoCode;  //: "US",
    String name;  //: "UNITED STATES",
    String displayName;  //: "United States",
    String isoThree;  //: "USA",
    String numberCode;  //: 840,
    String createDate;  //: "2012-01-03 02:41:33"

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getIsoThree() {
        return isoThree;
    }

    public void setIsoThree(String isoThree) {
        this.isoThree = isoThree;
    }

    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String numberCode) {
        this.numberCode = numberCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
