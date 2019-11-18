package servlets;

import HelperMethods.CookieHelper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private CookieHelper cookieHelper = new CookieHelper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        cookieHelper.deleteCookie(req, resp);
        resp.sendRedirect("/");
    }
}
