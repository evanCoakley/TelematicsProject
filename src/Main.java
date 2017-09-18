import java.io.IOException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter VIN Number: ");
        int VIN = scanner.nextInt();

        System.out.println("Enter Number on Odometer: ");
        double Odometer = scanner.nextDouble();

        System.out.printf("Enter Amount of Consumption: ");
        double Consumption = scanner.nextDouble();

        System.out.println("Enter Odometer from last oil change: ");
        double OdemeterFromLastOilChange = scanner.nextDouble();

        System.out.println("Enter Engine size in liters: ");
        double EngineSizeInLiters = scanner.nextDouble();

        VehicleInfo vehicleInfo = new VehicleInfo(VIN, Odometer, Consumption, OdemeterFromLastOilChange, EngineSizeInLiters);

        TelematicsService service = new TelematicsService();

        service.report(vehicleInfo);




    }
}
