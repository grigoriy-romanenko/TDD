package tdd.task_3_11_3;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;

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
        assertSame(valueToSave, map.get("one"));
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
        assertFalse(new Integer(1).equals(map.get(key)));
        assertEquals(new Integer(2), map.get(key));
    }

    /**
     * Test case: clear() method removes all its content
     */
    @Test
    public void shouldClear() {
        String key = "key";
        map.put(key, 1);
        map.clear();
        assertNull(map.get(key));
        assertEquals(map.size(), 0);
    }

    /**
     * Test case: null value can be used as a key
     */
    @Test
    public void shouldAddElementWithNullKey() {
        map.put(null, 1);
        assertEquals(new Integer(1), map.get(null));
    }
}
