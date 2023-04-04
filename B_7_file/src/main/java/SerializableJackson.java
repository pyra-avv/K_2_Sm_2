import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class SerializableJackson {
    public static String writePerson(Person person) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter res = new StringWriter();
        mapper.writeValue(res, person);
        return res.toString();
    }

    public static String writeFlat(Flat flat) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter res = new StringWriter();
        mapper.writeValue(res, flat);
        return res.toString();
    }

    public static String writeHouse(House house) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter res = new StringWriter();
        mapper.writeValue(res, house);
        return res.toString();
    }

    public static Person readPerson(String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new StringReader(str), Person.class);
    }

    public static House readHouse(String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new StringReader(str), House.class);
    }

    public static Flat readFlat(String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new StringReader(str), Flat.class);
    }
}
