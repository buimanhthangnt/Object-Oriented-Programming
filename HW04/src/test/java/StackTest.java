import oop.util.Stack;
import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {
    Stack s = new Stack();
    @Test
    public void testGetSize() {
        assertEquals(true,s.isEmpty());
        s.push("Programing");
        s.push("Object");
        s.push("Oriented");
        assertEquals(3,s.getSize(),0.001);
    }
    @Test
    public void testPush() {
        s.push("Programing");
        s.push("Object");
        s.push("Oriented");
        assertEquals("Oriented",s.top());
    }
    @Test
    public void testPop() {
        s.push("Programing");
        s.push("Object");
        s.push("Oriented");
        assertEquals("Oriented",s.pop());
        assertEquals("Object",s.pop());
        assertEquals("Programing",s.top());
    }
}
