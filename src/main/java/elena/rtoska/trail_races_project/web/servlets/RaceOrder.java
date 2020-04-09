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

@WebServlet(urlPatterns = "/raceOrder.do")
public class RaceOrder extends HttpServlet {

    private final SpringTemplateEngine templateEngine;

    public RaceOrder(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectedRaceSize = req.getParameter("race_size");
        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        order.setRaceSize(selectedRaceSize);
        session.setAttribute("order", order);
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("raceType", order.getRaceType());
        webContext.setVariable("raceSize", selectedRaceSize);
        this.templateEngine.process("deliveryInfo", webContext, resp.getWriter());
    }

}

