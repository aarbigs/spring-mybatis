package mybatis.mymodel;

/**
 * Created by aaron on 7/25/17.
 */
public class Breweries {

    String id; //: "IRqZSn",
    String name; //: "Indian Wells Brewing Company",
    String nameShortDisplay; //: "Indian Wells",
    String description; //: "Proudly producing fine ales & lagers since 1995. One of California's favorite microbreweries!",
    String website; //: "http://www.mojavered.com/",
    String established; //: "1995",
    String isOrganic; //: "N",
    Image images; //: {},
    String status; //: "verified",
    String statusDisplay; //: "Verified",
    String createDate; //: "2012-01-03 02:41:58",
    String updateDate; //: "2015-12-22 14:48:48",
    String isMassOwned; //: "N",
    String brandClassification; //: "craft",
    Location[] locations; //: []


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameShortDisplay() {
        return nameShortDisplay;
    }

    public void setNameShortDisplay(String nameShortDisplay) {
        this.nameShortDisplay = nameShortDisplay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    public String getIsOrganic() {
        return isOrganic;
    }

    public void setIsOrganic(String isOrganic) {
        this.isOrganic = isOrganic;
    }

    public Image getImages() {
        return images;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDisplay() {
        return statusDisplay;
    }

    public void setStatusDisplay(String statusDisplay) {
        this.statusDisplay = statusDisplay;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getIsMassOwned() {
        return isMassOwned;
    }

    public void setIsMassOwned(String isMassOwned) {
        this.isMassOwned = isMassOwned;
    }

    public String getBrandClassification() {
        return brandClassification;
    }

    public void setBrandClassification(String brandClassification) {
        this.brandClassification = brandClassification;
    }

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }
}
