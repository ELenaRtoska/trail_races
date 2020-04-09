package elena.rtoska.trail_races_project.web.servlets;

import elena.rtoska.trail_races_project.service.RaceService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "show-race", urlPatterns = "")
public class ShowRace extends HttpServlet {

    private final RaceService raceService;
    private final SpringTemplateEngine templateEngine;

    public ShowRace(RaceService raceService, SpringTemplateEngine templateEngine) {
        this.raceService = raceService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("races", this.raceService.getAll());
        this.templateEngine.process("listRaces", context, resp.getWriter());
    }
}
