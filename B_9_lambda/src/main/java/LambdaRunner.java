import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaRunner {

    /**
     * 1 - 5, 7, 8, 1* - 10*
     * @param lambda лямбда-выражение
     * @param t параметр
     * @return результат
     */
    public static <T, R> R LambdaF1(Function<T, R> lambda, T t) {
        return lambda.apply(t);
    }

    /**
     * 6
     * @param lambda лямбда-выражение
     * @param t параметр
     * @param u параметр
     * @return результат
     */
    public static <T, U, R> R LambdaF2(BiFunction<T, U, R> lambda, T t, U u) {
        return lambda.apply(t, u);
    }

    /**
     * 9
     * @param lambda лямбда-выражение
     * @param t параметр
     * @param u параметр
     * @param q параметр
     * @param p параметр
     * @return результат
     */
    public static <T, U, Q, P, R> R LambdaF4(Function4<T, U, Q, P, R> lambda, T t, U u, Q q, P p) {
        return lambda.apply(t, u, q, p);
    }







}
