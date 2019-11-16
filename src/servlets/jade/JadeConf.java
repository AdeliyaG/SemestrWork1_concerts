package servlets.jade;

import de.neuland.jade4j.JadeConfiguration;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class JadeConf {
    public static JadeConfiguration conf = new JadeConfiguration();

    static {
        conf.setTemplateLoader(new MyTemplateLoader("/home/niyaz/Projects/KznAgenda/web"));
        conf.setPrettyPrint(true);
    }

    public static void render(String template, Map<String, Object> model, HttpServletResponse resp) throws IOException {
        conf.renderTemplate(conf.getTemplate(template), model, resp.getWriter());
    }
}
