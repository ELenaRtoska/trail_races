package elena.rtoska.trail_races_project.web.servlets;

import elena.rtoska.trail_races_project.model.Order;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/selectRace.do")
public class SelectRace extends HttpServlet {

    private final SpringTemplateEngine templateEngine;

    public SelectRace(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectedRaceType = req.getParameter("race");
        Order order = new Order();
        order.setRaceType(selectedRaceType);
        HttpSession session = req.getSession();
        session.setAttribute("order", order);
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("raceType", selectedRaceType);
        this.templateEngine.process("selectRaceSize", webContext, resp.getWriter());
    }
}
