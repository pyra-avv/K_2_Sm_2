public class CelsiusKelvin implements Converter {
    @Override
    public double convert(double x) {
        return x + 273.15;
    }
}
