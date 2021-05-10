package Model;

import javafx.scene.control.Tab;

import java.util.Arrays;

public class MyArraylist<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] Table;

    public MyArraylist(){
        Table = new Object[DEFAULT_CAPACITY];
    }

    public MyArraylist(int capacity){
        Table = new Object[capacity];
    }

    public void add(E e){
        if(size == Table.length){
            extendTable();
        }
        Table[size++] = e;
    }

    public void add(int index, E e){
        if(index > size)
            throw new IndexOutOfBoundsException();
        if(index < 0)
            throw new NegativeArraySizeException();

        if(size == Table.length){
            extendTable();
        }

        if(Table[index] == null)
            Table[size++] = e;

        else{
            Object temp,swap;
            swap = e;
            for(int i=index; i < size; i++){
                temp = Table[i];
                Table[i] = swap;
                swap = temp;
            }
            Table[size++] = swap;
        }
    }

    public E remove(int index){
        if(index > size)
            throw new IndexOutOfBoundsException();
        if(index < 0)
            throw new NegativeArraySizeException();

        Object[] NewTable = new Object[--size];

        Object e = Table[index];

        System.arraycopy(Table,0, NewTable,0, index);
        System.arraycopy(Table,index + 1, NewTable, index, size - index);

        Table = NewTable;
        return (E) e;
    }

    public E remove(Object e){
        for(int i = 0; i < size; i++){
            if(Table[i].equals(e)) return remove(i);
        }
        return null;
    }

    public int getSize(){
        return size;
    }

    public E get(int index){
        if(index > size)
            throw new IndexOutOfBoundsException();
        if(index < 0)
            throw new NegativeArraySizeException();

        return (E) Table[index];
    }

    public boolean contains(Object e){
        for(int i=0; i<size; i++){
            if(Table[i].equals(e)) return true;
        }
        return false;
    }

    private void extendTable() {
        int newSize = Table.length * 2;
        Table = Arrays.copyOf(Table,newSize);
    }


}
