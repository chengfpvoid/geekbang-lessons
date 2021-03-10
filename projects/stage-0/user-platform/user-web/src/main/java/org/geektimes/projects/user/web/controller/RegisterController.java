package org.geektimes.projects.user.web.controller;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

@Path("")
public class RegisterController implements PageController {

    private UserService userService;

    @Path("/register")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(request.getParameter("phone"));
        userService = ComponentContext.getInstance().getComponent("bean/UserService");
        try {
            userService.register(user);
        } catch (Exception e) {
            request.setAttribute("info", e.getMessage());
            return "info.jsp";
        }

        return "login-form.jsp";
    }
}
