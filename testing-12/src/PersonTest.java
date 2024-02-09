import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testCreatePerson() {
        Person person = new Person("Alice");
        assertNotNull(person, "");
        assertEquals("Alice", person.getName(), "Name should be 'Alice'");
    }

    @Test
    void testSetName() {
        Person person = new Person("Alice");
        person.setName("Bob");
        assertEquals("Bob", person.getName(), "Name should change to 'Bob'");
    }
}
