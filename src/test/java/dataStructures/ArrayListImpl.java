package dataStructures;

public class ArrayListImpl implements List {
    private String[] array;
    private int initialCapacity = 10;
    private int size;

    public ArrayListImpl() {
        array = new String[initialCapacity];
    }

    @Override
    public void add(String newEl) {
        if (size > array.length - 1) {
            array = getDoubledArray(array);
        }
        array[size] = newEl;
        size++;
    }

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public void remove(int index) {

        for (int i = index; i < array.length -1; i++) {
            array[i] = array[i+1];
        }
        size--;

        if(size < array.length/2){
            array = cutArray(array);
        }

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private String[] getDoubledArray(String[] array) {
        String[] newArray = new String[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    private String[] cutArray(String[] array){
        String[] newArray = new String[array.length/2];
        for (int i = 0; i <array.length/2 ; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
