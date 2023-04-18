import java.io.*;

public class ServisSerializable {

    public static void writePerson(OutputStream s, Person person) throws IOException {
        try(ObjectOutputStream stream = new ObjectOutputStream(s)) {
            stream.writeObject(person);
        }
    }

    public static void writeHouse(OutputStream s, House house) throws IOException {
        try (ObjectOutputStream stream = new ObjectOutputStream(s)) {
            stream.writeObject(house);
        }
    }

    public static void writeFlat(OutputStream s, Flat flat) throws IOException {
        try(ObjectOutputStream stream = new ObjectOutputStream(s)) {
            stream.writeObject(flat);
        }
    }

    public static Person readPerson(InputStream s) throws ClassNotFoundException, IOException {
        try(ObjectInputStream stream = new ObjectInputStream(s)) {
            return (Person) stream.readObject();
        }
    }

    public static House readHouse(InputStream s) throws ClassNotFoundException, IOException {
        try(ObjectInputStream stream = new ObjectInputStream(s)) {
            return (House) stream.readObject();
        }
    }

    public static Flat readFlat(InputStream s) throws ClassNotFoundException, IOException {
        try(ObjectInputStream stream = new ObjectInputStream(s)) {
            return (Flat) stream.readObject();
        }
    }
}
