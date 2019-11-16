package servlets;


import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.FileTemplateLoader;
import de.neuland.jade4j.template.JadeTemplate;
import de.neuland.jade4j.template.TemplateLoader;
import forms.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private String basePath = "C:\\MyJava\\KznAgenda\\frontend\\";

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JadeConfiguration config = new JadeConfiguration();
        TemplateLoader loader = new FileTemplateLoader(basePath, "UTF-8", "pug");
        config.setTemplateLoader(loader);
        config.setBasePath(basePath);
        config.setCaching(false);
        JadeTemplate template = config.getTemplate("register.pug");
        Map<String, Object> model = new HashMap<>();
        config.renderTemplate(template, model,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.signUp(req, resp);
    }

}
