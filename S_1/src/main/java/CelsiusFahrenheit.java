public class CelsiusFahrenheit implements Converter {
    @Override
    public double convert(double x) {
        return (x * 5 / 9) + 32;
    }
}
