package elena.rtoska.trail_races_project.web.filters;

import elena.rtoska.trail_races_project.model.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class RaceTypeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        if(!httpRequest.getRequestURI().endsWith("\\.do"))
            chain.doFilter(request, response);
        else if(httpRequest.getRequestURI().equals("/selectRace.do")) {
            if (httpRequest.getParameter("race") != null)
                chain.doFilter(request, response);
            else
                httpResponse.sendRedirect("/");
        }
        else{
            Order sessionOrder = (Order)httpRequest.getSession().getAttribute("order");
            if(sessionOrder != null && sessionOrder.getRaceType() != null)
                chain.doFilter(request, response);
            else
                httpResponse.sendRedirect("/");
        }
    }
}
