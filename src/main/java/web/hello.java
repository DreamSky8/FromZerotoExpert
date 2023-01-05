package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class hello extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=gbk");
        PrintWriter pw = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies) {
            if("visit".equals(cookie.getName()) && cookie.getValue().equals("1")){
                pw.println("嗨，欢迎您再次到 from zero to expert.");
                return;
            }
        }
        Cookie cookie = new Cookie("visit","1");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
        pw.println("嗨，欢迎您来到 from zero to expert.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}


