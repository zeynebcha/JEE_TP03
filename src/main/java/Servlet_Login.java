import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet_Login extends HttpServlet {
    private static final String VALID_USERNAME = "J2EE";
    private static final String VALID_PASSWORD = "J2EE";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String message;
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            message = "Welcome to your First JSP page";
        } else {
            message = "Identification Failure";
        }

        request.setAttribute("message", message);
        this.getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
    }
}
