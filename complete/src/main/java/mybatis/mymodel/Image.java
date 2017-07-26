package mybatis.mymodel;

/**
 * Created by aaron on 7/25/17.
 */
public class Image {

    String icon; //: "https://s3.amazonaws.com/brewerydbapi/brewery/IRqZSn/upload_5HvuWn-icon.png",
    String medium; //: "https://s3.amazonaws.com/brewerydbapi/brewery/IRqZSn/upload_5HvuWn-medium.png",
    String large; //: "https://s3.amazonaws.com/brewerydbapi/brewery/IRqZSn/upload_5HvuWn-large.png",
    String squareMedium; //: "https://s3.amazonaws.com/brewerydbapi/brewery/IRqZSn/upload_5HvuWn-squareMedium.png",
    String squareLarge; //: "https://s3.amazonaws.com/brewerydbapi/brewery/IRqZSn/upload_5HvuWn-squareLarge.png"

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSquareMedium() {
        return squareMedium;
    }

    public void setSquareMedium(String squareMedium) {
        this.squareMedium = squareMedium;
    }

    public String getSquareLarge() {
        return squareLarge;
    }

    public void setSquareLarge(String squareLarge) {
        this.squareLarge = squareLarge;
    }
}
