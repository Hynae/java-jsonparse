import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Compile : javac -cp .:json-simple-1.1.1.jar WeatherParse.java
// Execute : java -cp .:json-simple-1.1.1.jar WeatherParse

public class WeatherParse {

    private static String JSON_WEATHER_PATH = "weather.json";

    public static void main(String[] args) {

        FileReader jsonFile = null;
        try {
            // lecture du fichier json
            jsonFile = new FileReader(JSON_WEATHER_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        JSONParser parser = new JSONParser();
        Object jsonParsed = null;
        try {
            jsonParsed = parser.parse(jsonFile);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
}

    JSONObject root = (JSONObject) jsonParsed;
    String name = (String) root.get("name");

    System.out.println(name);
    JSONObject coord = (JSONObject) root.get("coord");
    String lat = (String) String.valueOf(coord.get("lat"));
    System.out.println(lat);
    String lon = (String) String.valueOf(coord.get("lon")); 
    System.out.println(lon);
 
    JSONArray weathers = (JSONArray) root.get("weather");
    for (int i=0; i < weathers.size(); i++) {
        JSONObject weather = (JSONObject) weathers.get(i);
        String main = (String) weather.get("main");
        System.out.println(main);
        }

 

        // TODO parser le fichier

        // TODO récupérer la racine du document

        // TODO afficher la valeur de l'attribut "name" de la racine

        // TODO afficher les valeurs des attributs "lat" et "lon" de l'élément "coord" contenu dans la racine

        // TODO parcourir tous les éléments de "weather" et afficher le contenu de "main"

        /*
            Résultat attendu :
            * City name: London
            * City latitude: 51.51
            * City longitude: -0.13
            * Weather: Drizzle
            * Weather: Clear
        */
    }
}
