import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by a_kovalchuk on 17.09.2015.
 */
@XmlRootElement(name="trains")
public class Trains {

    @XmlElement(name="train")
    private List<Train> trains = new ArrayList<Train>();

    public void add(Train train){
        trains.add(train);
    }

    public void manualAdd(){
        Scanner in = new Scanner(System.in);
        System.out.println("Count of trains ? ");
        int count = in.nextInt();
        for(int i = 0; i < count; i++){
            Train train = new Train();
            System.out.println("Please insert ID of train ");
            train.setId(in.nextLine());
            System.out.println("Please insert date ");
            train.setDate(in.nextLine());
            System.out.println("Please insert departure");
            train.setDeparture(in.nextLine());
            System.out.println("Please insert start city");
            train.setFrom(in.nextLine());
            System.out.println("Please insert destination");
            train.setTo(in.nextLine());
            trains.add(train);
        }
    }

    public void listOfTrains(String periodStart, String periodEnd){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date pStart = new Date();
        Date pEnd = new Date();
        Date Departure = new Date();
        try{
            pStart = sdf.parse(periodStart);
            pEnd = sdf.parse(periodEnd);
        }catch (Exception e){
            e.printStackTrace();
        }

        for(Train train:trains){
            try{
                Departure = sdf.parse(train.getDeparture());
                if(Departure.after(pStart)&&Departure.before(pEnd)){
                    System.out.println(train.toString());
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public String toString(){
        return Arrays.toString(trains.toArray());
    }

}
