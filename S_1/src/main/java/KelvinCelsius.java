public class KelvinCelsius implements Converter {
    @Override
    public double convert(double x) {
        return x - 273.15;
    }
}
