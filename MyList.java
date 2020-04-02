import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private  Object elements[];
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];

    }


    public MyList(int capacity){
        elements = new Object[capacity];

    }
    private void ensursCapa(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(int index, E e){
        if(size == elements.length){
            ensursCapa();
        }
        elements[size++] = e;

    }


    public E remove( int index){
        E element = (E) elements[index];
        for(int i = 0; i < size; i++){
           elements[i] = elements[i+1];
        }
        size--;
        return element;

    }
    public int size(){
        return size;
    }
    public E clone(){
       MyList<E> myList = new MyList<E>();
       myList.elements = elements;
       myList.size = size;
       return (E) myList;
    }
    public boolean contains(E o){
        for(int i = 0; i< size;i++){
        if((E) elements[i] == o){
            return true;
        }
        }
        return false;
    }
    public int indexOf(E o){
        int index = -1;
        for(int i = 0; i< size; i++){
            if((E) elements[i] == o){
                index= i;
                break;
            }
        }
        return  index;
    }
    public boolean add(E e){
        if(size == DEFAULT_CAPACITY){
            ensursCapa();
        }
        if(e == null){
            return false;
        }
        return true;
    }

    public E get (int i){
        if(i>= size || i< 0){
            throw  new IndexOutOfBoundsException("Index" + i + ",Size" +i);
        }
        return (E) elements[i];
    }
    public void clear(){
        size = 0;
        elements = null;
    }


}
