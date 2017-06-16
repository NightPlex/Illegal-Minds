package nightplex.util.json;

import com.google.gson.*;

import java.io.FileReader;
import java.nio.file.Paths;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */
public abstract class JsonLoader {

    /**
     * Allows the user to read and/or modify the parsed data.
     *
     * @param reader  the reader instance.
     * @param builder the builder instance.
     */
    public abstract void load(JsonObject reader, Gson builder);


    public abstract String filePath();


    public JsonLoader load() {
        try (FileReader fileReader = new FileReader(Paths.get(filePath()).toFile())) {
            JsonParser parser = new JsonParser();
            JsonArray array = (JsonArray) parser.parse(fileReader);
            Gson builder = new GsonBuilder().create();

            for (int i = 0; i < array.size(); i++) {
                JsonObject reader = (JsonObject) array.get(i);
                load(reader, builder);
            }

            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}