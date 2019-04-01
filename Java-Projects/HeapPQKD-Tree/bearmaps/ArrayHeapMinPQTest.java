package bearmaps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayHeapMinPQTest {

    @Test
    public void testAddContains() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("Boca", 1);
        pq.add("Bucholz", 2);
        pq.add("Plantation", 3);
        assertEquals(3, pq.size());
        assertTrue(pq.contains("Boca"));
        assertTrue(pq.contains("Bucholz"));
        assertTrue(pq.contains("Plantation"));
    }

    @Test
    public void testGetSmallest() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("Boca", 1);
        pq.add("Bucholz", 2);
        pq.add("Plantation", 3);
        assertEquals("Boca", pq.getSmallest());
    }

    @Test
    public void testRemoveSmallestSize() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("Boca", 1);
        pq.add("Bucholz", 2);
        pq.add("Plantation", 3);
        assertEquals("Boca", pq.removeSmallest());
        assertEquals(2, pq.size());
        assertEquals("Bucholz", pq.removeSmallest());
        assertEquals(1, pq.size());
        assertEquals("Plantation", pq.removeSmallest());
        assertEquals(0, pq.size());
    }

    @Test
    public void testChangePriority() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("Boca", 1);
        pq.add("Bucholz", 2);
        pq.add("Plantation", 3);
        pq.changePriority("Boca", 4);
        assertEquals("Bucholz", pq.getSmallest());
    }
}
