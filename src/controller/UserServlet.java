package controller;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String page = request.getParameter("page");

        if (page.equalsIgnoreCase("register")) {
            model.User user = new User();
            user.setUserName(request.getParameter("userName"));
            user.setPassword(request.getParameter("password"));
            user.setFullName(request.getParameter("fullName"));

            UserService userService = new UserService();
            userService.insertUser(user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("login")) {
            User user = new User();

            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            User userService = new UserService().getUser(userName, password);
            if (userName != null) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("userName", userName);
                httpSession.setAttribute("password", password);

                Cookie user_cookie = new Cookie("userName", userName);
                response.addCookie(user_cookie);


                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/dashboard.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("../index.jsp");
                requestDispatcher.include(request, response);
            }
        }
        if (page.equalsIgnoreCase("Logout")) {
            HttpSession httpSession = request.getSession(false);
            httpSession.invalidate();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);

        }
        if (page.equalsIgnoreCase("listUser")) {
            User user = new User();
            try{
                List<User> arrayList = new UserService().getUserList();
                request.setAttribute("arrayList",arrayList);
                request.setAttribute("user",user);
            }catch(SQLException e){
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/listUser.jsp");
            requestDispatcher.forward(request, response);
        }
            if (page.equalsIgnoreCase("newUsers")) {
                RequestDispatcher rd = request.getRequestDispatcher("pages/register.jsp");
                rd.forward(request, response);
            }
            if (page.equalsIgnoreCase("oldUsers")) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        if (page.equalsIgnoreCase("updateUser")) {
            RequestDispatcher rd = request.getRequestDispatcher("pages/updateUser.jsp");
            rd.forward(request, response);
        }

        }


        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            doPost(request, response);
        }
    }