import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SolveEquationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));

        double discriminant = b * b - 4 * a * c;
        String result;

        if (discriminant < 0) {
            result = "<span style='color:red'>Pas de racines réelles</span>";
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            result = "<span style='color:blue'>Racine double : x = " + x + "</span>";
        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            result = "<span style='color:green'>Racines réelles : x1 = " + x1 + ", x2 = " + x2 + "</span>";
        }

        request.setAttribute("result", result);
        this.getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
    }
}
