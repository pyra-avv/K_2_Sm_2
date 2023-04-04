import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SerializableJacksonTest {

    @Test
    void writePerson() throws IOException {
        Person person1 = new Person("Иванова", "Глюка", "Андреевна",
                new Data(1, 12, 2000));
        assertEquals("{\"surname\":\"Иванова\",\"name\":\"Глюка\",\"patronymic\":\"Андреевна\"," +
                        "\"birthday\":{\"dey\":1,\"month\":\"декабрь\",\"year\":2000}}",
                SerializableJackson.writePerson(person1));
    }

    @Test
    void writeFlat() throws IOException {
        Flat flat1 = new Flat(3, 70, new Person("Иванова", "Глюка", "Андреевна",
                new Data(1, 12, 2000)),
                new Person("Иванов", "Шизоид", "Парфентич",
                        new Data(2, 6, 1999)));
        assertEquals( "{\"room\":3,\"tenants\":[" +
                "{\"surname\":\"Иванова\",\"name\":\"Глюка\",\"patronymic\":\"Андреевна\"," +
                "\"birthday\":{\"dey\":1,\"month\":\"декабрь\",\"year\":2000}}," +
                "{\"surname\":\"Иванов\",\"name\":\"Шизоид\",\"patronymic\":\"Парфентич\"," +
                "\"birthday\":{\"dey\":2,\"month\":\"июнь\",\"year\":1999}}],\"s\":70}",
                SerializableJackson.writeFlat(flat1));
    }

    @Test
    void writeHouse() throws IOException {
        House house1 = new House("abcc6780", "улица Красных орлов 8",
                new Person("Высокопарнов", "тип", "Мутнович",
                        new Data(2, 9, 1997)),
                new Flat(3, 70, new Person("Иванова", "Глюка", "Андреевна",
                        new Data(1, 12, 2000)),
                        new Person("Иванов", "Шизоид", "Парфентич",
                                new Data(2, 3, 1999))));
        assertEquals("{\"cadastralNumber\":\"abcc6780\",\"addres\":\"улица Красных орлов 8\",\"senior\":" +
                "{\"surname\":\"Высокопарнов\",\"name\":\"тип\",\"patronymic\":\"Мутнович\"," +
                "\"birthday\":{\"dey\":2,\"month\":\"сентябрь\",\"year\":1997}}," +
                "\"flats\":[{\"room\":3,\"tenants\":[" +
                "{\"surname\":\"Иванова\",\"name\":\"Глюка\",\"patronymic\":\"Андреевна\"," +
                "\"birthday\":{\"dey\":1,\"month\":\"декабрь\",\"year\":2000}}," +
                "{\"surname\":\"Иванов\",\"name\":\"Шизоид\",\"patronymic\":\"Парфентич\"," +
                "\"birthday\":{\"dey\":2,\"month\":\"март\",\"year\":1999}}]," +
                "\"s\":70}]}", SerializableJackson.writeHouse(house1));
    }

    @Test
    void readPerson() throws IOException {
        String person1str = "{ \"surname\":\"Иванова\",\"name\":\"Глюка\",\"patronymic\":\"Андреевна\"," +
                "\"birthday\":{\"dey\":1,\"month\":\"декабрь\",\"year\":2000}}";
        assertEquals(new Person("Иванова", "Глюка", "Андреевна",
                new Data(1, 12, 2000)),
                SerializableJackson.readPerson(person1str));
    }

    @Test
    void readHouse() throws IOException {
        String house1str =  "{\"cadastralNumber\":\"abcc6780\",\"addres\":\"улица Красных орлов 8\",\"senior\":" +
                "{\"surname\":\"Высокопарнов\",\"name\":\"тип\",\"patronymic\":\"Мутнович\"," +
                "\"birthday\":{\"dey\":2,\"month\":\"сентябрь\",\"year\":1997}}," +
                "\"flats\":[{\"room\":3,\"tenants\":[" +
                "{\"surname\":\"Иванова\",\"name\":\"Глюка\",\"patronymic\":\"Андреевна\"," +
                "\"birthday\":{\"dey\":1,\"month\":\"декабрь\",\"year\":2000}}," +
                "{\"surname\":\"Иванов\",\"name\":\"Шизоид\",\"patronymic\":\"Парфентич\"," +
                "\"birthday\":{\"dey\":2,\"month\":\"март\",\"year\":1999}}]," +
                "\"s\":70}]}";
        assertEquals(new House("abcc6780", "улица Красных орлов 8",
                new Person("Высокопарнов", "тип", "Мутнович",
                        new Data(2, 9, 1997)),
                new Flat(3, 70, new Person("Иванова", "Глюка", "Андреевна",
                        new Data(1, 12, 2000)),
                        new Person("Иванов", "Шизоид", "Парфентич",
                                new Data(2, 3, 1999)))),
                SerializableJackson.readHouse(house1str));
    }

    @Test
    void readFlat() throws IOException {
        String flat1str = "{\"room\":3,\"tenants\":[" +
                "{\"surname\":\"Иванова\",\"name\":\"Глюка\",\"patronymic\":\"Андреевна\"," +
                "\"birthday\":{\"dey\":1,\"month\":\"декабрь\",\"year\":2000}}," +
                "{\"surname\":\"Иванов\",\"name\":\"Шизоид\",\"patronymic\":\"Парфентич\"," +
                "\"birthday\":{\"dey\":2,\"month\":\"июнь\",\"year\":1999}}],\"s\":70}";
        assertEquals(new Flat(3, 70, new Person("Иванова", "Глюка", "Андреевна",
                new Data(1, 12, 2000)),
                new Person("Иванов", "Шизоид", "Парфентич",
                        new Data(2, 6, 1999))),
                SerializableJackson.readFlat(flat1str));
    }
}