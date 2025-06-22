class DataStrucEx7 {
    public static double forecastValue(double currentValue, double rate, int years) {
        if (years == 0)
            return currentValue;
        return forecastValue(currentValue * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        double result = forecastValue(1000, 0.1, 3);
        System.out.println("Future Value: Rs." + result);
    }
}
