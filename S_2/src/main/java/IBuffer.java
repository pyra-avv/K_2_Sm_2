public interface IBuffer { // буфер элементов произвольного типа
    void set(Task e);
    Object get();
    int getSize();
    void del();
    boolean noNull();
}
