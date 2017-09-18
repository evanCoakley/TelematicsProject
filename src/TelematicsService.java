import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.text.html.HTML;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TelematicsService {

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
         ArrayList<VehicleInfo> vehicleList = new ArrayList<>();


         File file = new File(".");
         for (File f : file.listFiles()) {
             if (f.getName().endsWith(".json")) {
                 Scanner scanner = new Scanner(f);
                 // Now you have a File object named "f".
                 // You can use this to create a new instance of Scanner
                 String json = scanner.next();
                 VehicleInfo vi = mapper.readValue(json, VehicleInfo.class);

                 String html = htmlMerge(vi);
             }
         }
     }




    private String htmlMerge(VehicleInfo vi) {
        return null;
        String html =  (<tr>
        <td align="center">#</td><td align="center">#</td><td align="center">#</td><td align="center">#</td><td align="center">#</td>
    </tr>)
    }
}
         // (3)























