public class Radar {

    static int ONE_HOUR = 3600;
    static int ONE_KILOMETTER = 1000;

    public static boolean esMulta(double metters, double  maxTime, double timeSeconds){
        double km = metters / ONE_KILOMETTER;
        double timeHours = timeSeconds / ONE_HOUR;
        double medianTime = km / timeHours;

        return !(medianTime < maxTime);

    }
}
