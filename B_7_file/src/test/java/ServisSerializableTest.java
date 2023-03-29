import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ServisSerializableTest {

    @Test
    void Person() throws ClassNotFoundException, IOException  {
        Person person1 = new Person("Иванова", "Глюка", "Андреевна",
                new Data(1, 12, 2000));
        try(FileOutputStream file1 = new FileOutputStream("person.ser")) {
            ObjectOutputStream stream1 = new ObjectOutputStream(file1);
            ServisSerializable.writePerson(stream1, person1);
        }
        try(FileInputStream file2 = new FileInputStream("person.ser")) {
            ObjectInputStream stream2 = new ObjectInputStream(file2);
            Person person2 = ServisSerializable.readPerson(stream2);
            assertEquals(person1, person2);
        }
    }

    @Test
    void Flat() throws ClassNotFoundException, IOException {
        Flat flat1 =new Flat(3, 70, new Person("Иванова", "Глюка", "Андреевна",
                new Data(1, 12, 2000)),
                new Person("Иванов", "Шизоид", "Парфентич",
                    new Data(2, 6, 1999)));
        try(FileOutputStream file1 = new FileOutputStream("flat.ser")) {
            ObjectOutputStream stream1 = new ObjectOutputStream(file1);
            ServisSerializable.writeFlat(stream1, flat1);
        }
        try(FileInputStream file2 = new FileInputStream("flat.ser")) {
            ObjectInputStream stream2 = new ObjectInputStream(file2);
            Flat flat2 = ServisSerializable.readFlat(stream2);
            assertEquals(flat1, flat2);
        }
    }

    @Test
    void House() throws ClassNotFoundException, IOException {
        House house1 = new House("abcc6780", "улица Красных орлов 8",
                new Person("Высокопарнов", "тип", "Мутнович",
                        new Data(2, 9, 1997)),
                new Flat(3, 70, new Person("Иванова", "Глюка", "Андреевна",
                        new Data(1, 12, 2000)),
                        new Person("Иванов", "Шизоид", "Парфентич",
                            new Data(2, 3, 1999))));
        try(FileOutputStream file1 = new FileOutputStream("house.ser")) {
            ObjectOutputStream stream1 = new ObjectOutputStream(file1);
            ServisSerializable.writeHouse(stream1, house1);
        }
        try(FileInputStream file2 = new FileInputStream("house.ser")) {
            ObjectInputStream stream2 = new ObjectInputStream(file2);
            House house2 = ServisSerializable.readHouse(stream2);
            assertEquals(house1, house2);
        }
    }
}