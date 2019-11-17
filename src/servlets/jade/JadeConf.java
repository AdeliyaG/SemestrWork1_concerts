package servlets.jade;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.exceptions.JadeException;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JadeConf {
    public static JadeConfiguration conf = new JadeConfiguration();

    static {
        String path = JadeConf.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        File f = new File(path);
        conf.setTemplateLoader(new MyTemplateLoader(f.getParentFile().getParent()));
        conf.setPrettyPrint(true);
    }

    public static void render(String template, Map<String, Object> model, HttpServletResponse resp) throws IOException {
        try {
            conf.renderTemplate(conf.getTemplate(template), model, resp.getWriter());
        } catch (JadeException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
