package controller;

import PasswordHashing.HashPassword;
import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String page = request.getParameter("page");

        if (page.equalsIgnoreCase("register")) {
            model.User user = new User();
            user.setUserName(request.getParameter("userName"));
            String password = request.getParameter("password");
            password = HashPassword.encode(password);
            user.setPassword(password);
            user.setFullName(request.getParameter("fullName"));

            UserService userService = new UserService();
            userService.insertUser(user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("login")) {
            User user = new User();

            String userName = request.getParameter("userName");
//            String password = request.getParameter("password");
            String password = request.getParameter("password");
            password = HashPassword.encode(password);
            User userService = new UserService().getUser(userName, password);
            if (userService != null) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("userName", userName);
                httpSession.setAttribute("password", password);

                Cookie user_cookie = new Cookie("userName", userName);
                response.addCookie(user_cookie);


                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/dashboard.jsp");
                requestDispatcher.forward(request, response);
            } else {
                pw.println("Either username or password is incorrect");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
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

        if (page.equalsIgnoreCase("UserDetails")) {

            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().getUserRow(id);

            request.setAttribute("user",user);
            request.setAttribute("id",id);
            RequestDispatcher rd = request.getRequestDispatcher("pages/UserDetails.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("userEdit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().getUserRow(id);
            request.setAttribute("user", user);
            request.setAttribute("id", id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/updateUser.jsp");
            requestDispatcher.forward(request, response);

        }
        if (page.equalsIgnoreCase("updateUser")) {
            User user = new User();
            int id = Integer.parseInt(request.getParameter("id"));
            user.setFullName(request.getParameter("fullName"));
            user.setUserName(request.getParameter("userName"));
            user.setPassword(HashPassword.encode(request.getParameter("password")));

            try {
                new UserService().userUpdate(user,id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            List<User> users = null;
            try {
                users = new UserService().getUserList();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("arrayList", users);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/listUser.jsp");
            requestDispatcher.forward(request, response);
        }
        if(page.equalsIgnoreCase("userDelete")){
            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().deleteid(id);

            try {
                List<User> arrayList = new UserService().getUserList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/listUser.jsp");
            requestDispatcher.forward(request,response);
        }

        }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            doPost(request, response);
        }
    }