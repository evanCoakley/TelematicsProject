public class VehicleInfo {

    private int VIN;
    private double Odometer;
    private double Consumption;
    private double OdometerFromLastOilChange;
    private double EngineSizeInLiters;


    public VehicleInfo() {

    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public double getOdometer() {
        return Odometer;
    }

    public void setOdometer(double odometer) {
        Odometer = odometer;
    }

    public double getConsumption() {
        return Consumption;
    }

    public void setConsumption(double consumption) {
        Consumption = consumption;
    }

    public double getOdometerFromLastOilChange() {
        return OdometerFromLastOilChange;
    }

    public void setOdometerFromLastOilChange(double odometerFromLastOilChange) {
        OdometerFromLastOilChange = odometerFromLastOilChange;
    }

    public double getEngineSizeInLiters() {
        return EngineSizeInLiters;
    }

    public void setEngineSizeInLiters(double engineSizeInLiters) {
        EngineSizeInLiters = engineSizeInLiters;
    }
}

