package tdd.task_3_11_3;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HashMapTest {

    private Map<String, Integer> map;

    @Before
    public void init() {
        map = new HashMap<String, Integer>();
    }

    /**
     * Test case: an object stored with the put() method
     * can be retrieved with the get() method
     */
    @Test
    public void shouldRetrieveStoredValue() {
        Integer valueToSave = 1;
        map.put("one", valueToSave);
        assertSame("Value cannot be retrieved after it was added",
                valueToSave, map.get("one"));
    }

    /**
     * Test case: adding a second object with the same key
     * results in the old value being replaced
     */
    @Test
    public void shouldReplaceValueIfKeyAlreadyExists() {
        String key = "key";
        map.put(key, 1);
        map.put(key, 2);
        assertEquals("Old value was not replaced",
                new Integer(2), map.get(key));
    }

    /**
     * Test case: clear() method removes all its content
     */
    @Test
    public void shouldClear() {
        String key = "key";
        map.put(key, 1);
        map.clear();
        assertNull("Previously added value is not deleted", map.get(key));
        assertEquals("Map is not empty", map.size(), 0);
    }

    /**
     * Test case: null value can be used as a key
     */
    @Test
    public void shouldAddElementWithNullKey() {
        map.put(null, 1);
        assertEquals("Cannot put element with null key",
                new Integer(1), map.get(null));
    }
}
