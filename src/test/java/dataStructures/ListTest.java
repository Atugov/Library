package dataStructures;

import org.junit.jupiter.api.Test;

public class ListTest {
    @Test
    public void test1(){
        List list = new LinkedListImp();
        for (int i = 0; i < 10; i++) {
            list.add("itteration"+i);
        }
        System.out.println(list.get(9));
    }
}
