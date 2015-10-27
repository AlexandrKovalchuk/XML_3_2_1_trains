import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by a_kovalchuk on 17.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        Trains trains = new Trains();

        try{
            File file = new File("C:\\Users\\a_kovalchuk\\IdeaProjects\\XML_3_2_Task_1_Trains\\src\\Trains.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);
            System.out.println(trains);
        }catch (JAXBException e){
            e.printStackTrace();
        }
        //trains.add(new Train("3","Kiev", "Lviv", "09/17/2015", "21:34"));
        //trains.add(new Train("4","Kiev", "Ujgorod", "09/17/2015", "20:44"));

        trains.manualAdd();

        System.out.println("List of trains 15:00-19:00");
        trains.listOfTrains("15:00","19:00");
        try{
            File file = new File("C:\\Users\\a_kovalchuk\\IdeaProjects\\XML_3_2_Task_1_Trains\\src\\Trains.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(trains, file);
            marshaller.marshal(trains, System.out);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
