import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ServisSerializableTest {

    @Test
    void Person() throws ClassNotFoundException, IOException  {
        Person person1 = new Person("Иванова", "Глюка", "Андреевна",
                new Data(1, 12, 2000));
        try(FileOutputStream file1 = new FileOutputStream("person.txt")) {
            ServisSerializable.writePerson(file1, person1);
        }
        try(FileInputStream file2 = new FileInputStream("person.txt")) {
            Person person2 = ServisSerializable.readPerson(file2);
            assertEquals(person1, person2);
        }
    }

    @Test
    void Flat() throws ClassNotFoundException, IOException {
        Flat flat1 =new Flat(3, 70, new Person("Иванова", "Глюка", "Андреевна",
                new Data(1, 12, 2000)),
                new Person("Иванов", "Шизоид", "Парфентич",
                    new Data(2, 6, 1999)));
        try(FileOutputStream file1 = new FileOutputStream("flat.txt")) {
            ServisSerializable.writeFlat(file1, flat1);
        }
        try(FileInputStream file2 = new FileInputStream("flat.txt")) {
            Flat flat2 = ServisSerializable.readFlat(file2);
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
        try(FileOutputStream file1 = new FileOutputStream("house.txt")) {
            ServisSerializable.writeHouse(file1, house1);
        }
        try(FileInputStream file2 = new FileInputStream("house.txt")) {
            House house2 = ServisSerializable.readHouse(file2);
            assertEquals(house1, house2);
        }
    }
}