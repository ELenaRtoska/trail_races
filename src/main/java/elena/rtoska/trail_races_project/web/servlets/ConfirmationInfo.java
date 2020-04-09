package elena.rtoska.trail_races_project.web.servlets;


import elena.rtoska.trail_races_project.model.Order;
import elena.rtoska.trail_races_project.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {

    private final OrderService orderService;
    private final SpringTemplateEngine templateEngine;

    public ConfirmationInfo(OrderService orderService, SpringTemplateEngine templateEngine) {
        this.orderService = orderService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("clientName");
        String address = req.getParameter("clientAddress");
        String phoneNumber = req.getParameter("phoneNumber");
        String dateOfBirth = req.getParameter("dateOfBirth");

        Order fromSession = (Order)req.getSession().getAttribute("order");

        Order orderToDisplay = orderService.placeOrder(fromSession.getRaceType(), fromSession.getRaceSize(), name, address, phoneNumber, dateOfBirth);
        req.getSession().setAttribute("order", orderToDisplay);

        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("order", orderToDisplay);
        this.templateEngine.process("confirmationInfo", webContext, resp.getWriter());
    }
}
