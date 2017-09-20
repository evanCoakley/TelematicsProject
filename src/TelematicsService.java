import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.text.html.HTML;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TelematicsService {

    ArrayList<VehicleInfo> vehicleList = new ArrayList<>();

     void report(VehicleInfo vehicleInfo) throws IOException {

         // (1) create and write out a JSON file
         ObjectMapper mapper = new ObjectMapper();
         try {
             String json = mapper.writeValueAsString(vehicleInfo);

             try {
                 File file = new File(Integer.toString(vehicleInfo.getVIN()) + ".json");
                 FileWriter fileWriter = new FileWriter(file);
                 fileWriter.write(json);
                 fileWriter.close();
             } catch (JsonProcessingException e) {
                 e.printStackTrace();
             }
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         // (2)



         File file = new File(".");
         for (File f : file.listFiles()) {
             if (f.getName().endsWith(".json")) {
                 Scanner scanner = new Scanner(f);
                 // Now you have a File object named "f".
                 // You can use this to create a new instance of Scanner
                 String json = scanner.next();
                 VehicleInfo vi = mapper.readValue(json, VehicleInfo.class);    // creating object

                 // add new obj to list
                 vehicleList.add(vi);

             }
         }
         String html = htmlMerge();

         }// (3)


        // generate the entire HTML - consists of all the vehicles on separate TR
        private String htmlMerge() {
            String topHTML = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Vehicle Telematics Dashboard</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h1 align=\"center\">Averages for 2 vehicles</h1>\n" +
                    "\n" +
                    "<h1 align=\"center\">History</h1>\n" +
                    "<table align=\"center\" border=\"1\">\n" +
                    "    <th>\n" +
                    "        <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>";
            String midHTML = "";
            for (VehicleInfo v : vehicleList) {

                // spin thru add each v as a new TR line
                midHTML += "<tr>\n" +
                        "        <td align=\"center\">#vin</td><td align=\"center\">#odom</td><td align=\"center\">#consum</td><td align=\"center\">#lastoil</td><td align=\"center\">#engine</td>\n" +
                        "    </tr>"
                                .replaceFirst("#vin", String.valueOf(v.getVIN()))
                                .replaceFirst("#odom", String.valueOf(v.getOdometer()))
                                .replaceFirst("#consum", String.valueOf(v.getConsumption()))
                                .replaceFirst("#lastoil", String.valueOf(v.getOdometerFromLastOilChange()))
                                .replaceFirst("#engine", String.valueOf(v.getEngineSizeInLiters()));

            }
            String bottomHTML = "</table>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>";

            return topHTML + midHTML + bottomHTML;
        }


}
























