package testee.pojo;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;

public class YamlParser {

    public static Config getConfig(){
        Yaml yaml = new Yaml();
        try (InputStream inputStream = YamlParser.class.getResourceAsStream("/config.yml");) {
            return yaml.loadAs(inputStream, Config.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load YAML config", e);
        }
    }
}
