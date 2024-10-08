package api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

    public String obterDados(String obterJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(obterJson)));
    }
}
