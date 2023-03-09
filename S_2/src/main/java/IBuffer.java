public interface IBuffer { // буфер элементов произвольного типа

    /**
     * добавить элемент в буфер
     * @param e элемент
     */
    void set(Task e);

    /**
     * взять элемент из буфера
     * @return элемент
     */
    Object get();

    /**
     * @return количество элементов в буфере,
     */
    int getSize();

    /**
     * очистка буфера
     */
    void del();

    /**
     * проверка на пустоту
     * @return буфео не пустой
     */
    boolean noNull();
}
