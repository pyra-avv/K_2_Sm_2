public interface IBuffer { // буфер элементов произвольного типа
    void set(Object e);
    Object get();
    int getSize();
    void del();
    boolean noNull();
}
