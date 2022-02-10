public interface Queue<T>{
    void pushLast(int newElement);

    int popFirst();

    int peekFirst();

    int getSize();
}
