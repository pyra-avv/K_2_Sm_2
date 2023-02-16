public class KelvinFahrenheit implements Converter {
    @Override
    public double convert(double x) {
        return ((x - 273.15) * 5 / 9) + 32;
    }
}
