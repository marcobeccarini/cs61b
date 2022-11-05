package randomizedtest;

import org.junit.Test;
import static org.junit.Assert.*;


public class Tests {
    @Test
    public void testThreeAndThreeRemoveFunc(){
        AListNoResizing<Integer> List1 = new AListNoResizing<>();
        BuggyAList<Integer> List2 = new BuggyAList<>();

        List1.addLast(4);
        List2.addLast(4);

        List1.addLast(5);
        List2.addLast(5);

        List1.addLast(6);
        List2.addLast(6);

        assertEquals(List1.size(), List2.size());
        assertEquals(List1.removeLast(), List2.removeLast());
        assertEquals(List1.removeLast(), List2.removeLast());
        assertEquals(List1.removeLast(), List2.removeLast());

    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = L2.size();
                assertEquals(size, sizeB);
            }
            else if (operationNumber == 2) {
                if(L.size()>0 && L2.size()>0){
                    int removed = L.removeLast();
                    int removedBuggy = L2.removeLast();
                    assertEquals(removed, removedBuggy);

                }
            }
            else if (operationNumber == 3) {
                if(L.size()>0 && L2.size()>0){
                    int last = L.getLast();
                    int lastBuggy = L2.getLast();

                    assertEquals(last, lastBuggy);

                }
            }
        }
    }


}
