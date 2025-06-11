package com.satyam.learningTest.util;

import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.MarkedYAMLException;

import com.satyam.learningTest.pojo.Config;

public class YamlUnMarshaller {

    private final String path;

    public YamlUnMarshaller(String path) {
        if (path == null ) 
            throw new ConfigLoadException("Configuration path must not be null");
        
        if(path.trim().isEmpty())
        	throw new ConfigLoadException("Configuration path must not be empty");
        
        this.path = path;
    }

    public Config load() {
        try (InputStream input = getInputStream(path)) {
            return parseYaml(input);
        } catch (ConfigLoadException e) {
            throw e;
        } catch (MarkedYAMLException e) {
            // Extract line/column and problem details
            String msg = String.format("YAML syntax error in file: %s at line %d, column %d: %s",
                    path,
                    e.getProblemMark().getLine() + 1, // line numbers are 0-based
                    e.getProblemMark().getColumn() + 1,
                    e.getProblem());

            throw new ConfigLoadException(msg, e);

        }
        catch (Exception e) {
            throw new ConfigLoadException("Unexpected error loading config from: " + path, e);
        }
    }

    private InputStream getInputStream(String strPath) throws IOException {
        InputStream stream = YamlUnMarshaller.class.getResourceAsStream(strPath);
        if (stream == null) {
            throw new ConfigLoadException("File not found at path: " + strPath);
        }
        return stream;
    }

    private Config parseYaml(InputStream input) {
        Yaml yaml = new Yaml();
        Config config = yaml.loadAs(input, Config.class);
        return config;
    }
}
