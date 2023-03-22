import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServisSerializable {

    public static void writePerson(ObjectOutputStream stream, Person person) throws IOException {
        stream.writeObject(person);
    }

    public static void writeHouse(ObjectOutputStream stream, House house) throws IOException {
        stream.writeObject(house);
    }

    public static void writeFlat(ObjectOutputStream stream, Flat flat) throws IOException {
        stream.writeObject(flat);
    }

    public static Person readPerson(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        return (Person) stream.readObject();
    }

    public static House readHouse(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        return (House) stream.readObject();
    }

    public static Flat readFlat(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        return (Flat) stream.readObject();
    }
}
