import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by a_kovalchuk on 17.09.2015.
 */

@XmlRootElement(name="train")
public class Train {
    private String id ;
    private String from;
    private String to;
    private String date;
    private String departure;

    public Train(){}

    public Train(String id, String from, String to, String date, String departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    @XmlAttribute(name="id")
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getDeparture() {
        return departure;
    }

    @Override
    public String toString(){
        String string = "";
        return string = "Train id: " + this.id + "; from: " + this.from + "; to: " + this.to + "; date: " + this.date + "; departure: " + this.departure;
    }
}
