package HelperMethods;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieHelper {

    public void addCookie(HttpServletRequest req, HttpServletResponse resp, String email) {
        HttpSession session = req.getSession(true);
        if (req.getParameter("rememberMe") != null) {
            Cookie cLogin = new Cookie("cookemail", email);
            cLogin.setMaxAge(10000);
            resp.addCookie(cLogin);
        }
        session.setAttribute("current_user", email);
    }

    public static boolean checkCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookemail")) {
                req.getSession().setAttribute("current_user", cookie.getValue());
                return true;
            }
        }
        return false;
    }


    public void deleteCookie(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.setAttribute("current_user", null);
        session.invalidate();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookemail")) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
    }
}
