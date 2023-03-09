public interface ITaskProcessor {

    /**
     * @return сумма элементов массива данных в задаче
     * или null если буфер пуст
     */
    Integer process();
}
