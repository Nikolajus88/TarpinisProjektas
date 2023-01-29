package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MakeJson {


    public void MakeJsonFile() throws IOException {
        List<Object> objects = session.createCriteria(HibernateUtil.class).list();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(objects);
        FileWriter fileWriter = new FileWriter("MyJson.json");
        fileWriter.write(json);
        fileWriter.close();

    }


}
