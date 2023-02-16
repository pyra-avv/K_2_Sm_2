public class FahrenheitKelvin implements Converter {
    @Override
    public double convert(double x) {
        return (x - 32) * 5 / 9 + 273.15;
    }
}
