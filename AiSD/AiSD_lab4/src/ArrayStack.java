

public class ArrayStack<T> implements IStack<T> {

    private static final int DEFAULT_CAPACITY = 16;
    T array[];
    int topIndex;

    @SuppressWarnings("unchecked")
    public ArrayStack (int initialSize){
        array=(T[])(new Object[initialSize]);
        topIndex=0;
    }
    public ArrayStack (){
        this(DEFAULT_CAPACITY);
    }
    @Override
    public boolean isEmpty() {
        return topIndex==0;
    }
    @Override
    public boolean isFull() {
        return topIndex==array.length;
    }
    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[--topIndex];
    }
    @Override
    public void push(T elem) throws FullStackException {
        if(isFull())
            throw new FullStackException();
        array[topIndex++]=elem;

    }
    @Override
    public int size() {
        return topIndex;
    }
    @Override
    public T top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[topIndex-1];
    }
    public void odwracanie() throws EmptyStackException, FullStackException {
        ArrayStack<T> lista = new ArrayStack<>(this.size());
        int count = 0;
        T top;
        while(count !=this.size()-1){
            top = this.pop();
            while (count!=this.size())
                lista.push(this.pop());

            this.push(top);
            while(lista.size() != 0)
                this.push(lista.pop());

            count++;

        }
    }

}
