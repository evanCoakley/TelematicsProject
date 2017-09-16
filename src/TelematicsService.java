import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class TelematicsServices {

    void report(VehicleInfo vehicleInfo) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(vehicleInfo);

            try {
                File file = new File(Integer.toString(vehicleInfo.getVIN()) + ".json");
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(json);
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (JsonProcessingException e) {
                
            }

        }


    }}