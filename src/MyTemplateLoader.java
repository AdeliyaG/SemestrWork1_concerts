import de.neuland.jade4j.template.TemplateLoader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyTemplateLoader implements TemplateLoader {
    private String basePath;
    MyTemplateLoader(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public long getLastModified(String s) throws IOException {
        return getFile(s).lastModified();
    }

    @Override
    public Reader getReader(String s) throws IOException {
        return new InputStreamReader(new FileInputStream(getFile(s)), StandardCharsets.UTF_8);
    }

    @Override
    public String getExtension() {
        return "pug";
    }

    private File getFile(String filename) {
        return new File(basePath, filename.replaceFirst("\\.jade$", ".pug"));
    }
}
