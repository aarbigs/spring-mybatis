package mybatis.mymodel.Darkskymodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 7/26/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hourly {

    String summary; //: "Rain until tomorrow afternoon and breezy starting this evening.",
    String icon; //: "rain",
    Data[] data; //: []

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
