package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/lang")
public class LanguageServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("language", entity.Language.getLocale(req.getParameter("lang")).toString());
        System.out.println(req.getRequestURL().toString());
        resp.sendRedirect("/login");
    }
}