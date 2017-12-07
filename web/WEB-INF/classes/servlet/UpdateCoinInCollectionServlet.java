package servlet;

import dto.UserSessionDto;
import service.MyCollectionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-coin-in-collection")
public class UpdateCoinInCollectionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSessionDto userSessionDto = (UserSessionDto) req.getSession().getAttribute("currentUser");
        long amount = Long.valueOf(req.getParameter("coinAmount"));
        long coinDescriptionId = Long.valueOf(req.getParameter("coinDescriptionId"));
        MyCollectionService.getInstance().updateCoinInCollection(userSessionDto.getUserId(), coinDescriptionId, amount);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
