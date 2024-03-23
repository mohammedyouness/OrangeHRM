package utils;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;


import java.io.FileReader;
import java.io.IOException;


public class JsonManager {

    String jsonReader;
    String jsonFilePath = System.getProperty("user.dir") + "/src/test/java/resources/testData/";
    public JsonManager(String fileName) {
        try {
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(jsonFilePath + fileName + ".json"));
            jsonReader = data.toJSONString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    public String getTestData(String jsonPath) {
        String testData = "";
        try {
            testData = JsonPath.read(jsonReader, jsonPath);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
            Assert.fail("The provided JSON path: '" + jsonPath + "' is invalid or does not exist within the file's: '" + this.jsonFilePath + "' structure");
        }
        return testData;
    }

}