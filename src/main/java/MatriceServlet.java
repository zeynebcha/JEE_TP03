import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MatriceServlet extends HttpServlet {
    private int[][] matrice = new int[10][10]; // Matrice 10x10
    private boolean[][] initialise = new boolean[10][10]; //la cellule a été initialisé ou non

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String xParam = request.getParameter("x");
        String yParam = request.getParameter("y");


        if ((xParam != null)&&(yParam!=null)) {
            int x = Integer.parseInt(xParam);
            int y = Integer.parseInt(yParam);

            if(initialise[x][y]==false) {
                out.println("La valeur de la cellule ("+x+";"+y+") n'a pas été initialisée.");
            }else{
                out.println("Valeur de la cellule ("+x+";"+y+") => "+matrice[x][y]);
            }

        }else {
            // Commence la sortie HTML avec un style CSS pour le tableau
            out.println("<html><head><style>");
            out.println("table { width: 50%; border-collapse: collapse; margin: 20px auto; text-align: center; }");
            out.println("h2 { text-align: center; }");
            out.println("</style></head><body>");
            // Affiche la matrice sous forme de table HTML
            out.println("<html><body>");
            out.println("<h2>Matrice 10x10</h2>");
            out.println("<table border='1'>");
            for (int i = 0; i < 10; i++) {
                out.println("<tr>");
                for (int j = 0; j < 10; j++) {
                    out.println("<td>" + matrice[i][j] + "</td>");
                }
                out.println("</tr>");
            }

            out.println("</table>");
        }


        // Ajoute un bouton pour revenir à la page de réglages de la matrice
        out.println("<br><br>");
        out.println("<div style='text-align:center;'>");
        out.println("<form action='Matrice.jsp' method='get'>");
        out.println("<button type='submit'>Retour aux réglages de la matrice</button>");
        out.println("</form>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xParam = request.getParameter("x");
        String yParam = request.getParameter("y");
        String newValueParam = request.getParameter("newValue");

        // Vérifie que les paramètres sont valides
        if (xParam != null && yParam != null && newValueParam != null) {
            try {
                int x = Integer.parseInt(xParam);
                int y = Integer.parseInt(yParam);
                int newValue = Integer.parseInt(newValueParam);

                // Vérifie que les coordonnées sont dans les limites de la matrice
                if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                    matrice[x][y] = newValue; // Met à jour la cellule spécifiée
                    initialise[x][y] = true;
                } else {
                    System.out.println("Erreur : Coordonnées en dehors des limites.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur de format : " + e.getMessage());
            }
        } else {
            // Si aucun paramètre n'est fourni, réinitialise la matrice à null
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    matrice[i][j] = 0;
                    initialise[i][j] = false;
                }
            }
        }
        response.sendRedirect("MatriceServlet"); // Recharge la servlet pour afficher la matrice mise à jour
    }
}
