package dataStructures;

import org.junit.jupiter.api.Test;

public class ListTest {
    @Test
    public void test1(){
        List list = new LinkedListImp();
        for (int i = 0; i < 10; i++) {
            list.add("iteration"+i);
        }
        System.out.println(list.get(9));
        list.remove(6);
        list.remove(6);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test2(){
        List list2 = new ArrayListImpl();
        for (int i = 0; i < 10; i++) {
            list2.add("iteration" + i);
        }
        list2.remove(2);
        list2.remove(2);
        list2.remove(2);
        list2.remove(2);
        list2.remove(1);
        list2.remove(0);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
    }
}
