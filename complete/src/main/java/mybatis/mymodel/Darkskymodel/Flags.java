package mybatis.mymodel.Darkskymodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aaron on 7/26/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flags {

    String[] sources; //: [],
    //String [] isd-stations; //: [],
    String units; //: "us"

    public String[] getSources() {
        return sources;
    }

    public void setSources(String[] sources) {
        this.sources = sources;
    }

//    public String[] getIsd() {
//        return isd;
//    }
//
//    public void setIsd(String[] isd) {
//        this.isd = isd;
//    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
