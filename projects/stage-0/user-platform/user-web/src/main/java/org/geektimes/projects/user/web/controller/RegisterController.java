package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

@Path("")
public class RegisterController implements PageController {

    private UserService userService = new UserServiceImpl();

    @Path("/register")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(request.getParameter("phone"));
        boolean isSuccess = userService.register(user);
        if (!isSuccess) {
            request.setAttribute("info", "注册失败");
        } else {
            request.setAttribute("info","注册成功");
        }
        return "info.jsp";
    }
}
