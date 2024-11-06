<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Matrice 10x10</title>
</head>
<body>
<h2>Matrice 10x10</h2>

<!-- Lien pour afficher la matrice dans MatriceServlet -->
<a href="MatriceServlet">Voir la matrice</a>
<br><br>

<!-- Formulaire pour afficher une cellule -->
<form action="MatriceServlet" method="get">
    <label for="xUpdate">Coordonnée X :</label>
    <input type="number" name="x" id="x" min="0" max="9" required>

    <label for="yUpdate">Coordonnée Y :</label>
    <input type="number" name="y" id="y" min="0" max="9" required>

    <button type="submit">Voir la cellule</button>
</form>

<br>

<!-- Formulaire pour mettre à jour la valeur d'une cellule -->
<form action="MatriceServlet" method="post">
    <label for="xUpdate">Coordonnée X :</label>
    <input type="number" name="x" id="xUpdate" min="0" max="9" required>

    <label for="yUpdate">Coordonnée Y :</label>
    <input type="number" name="y" id="yUpdate" min="0" max="9" required>

    <label for="newValue">Nouvelle Valeur :</label>
    <input type="number" name="newValue" id="newValue" required>

    <button type="submit">Mettre à jour la cellule</button>
</form>

<br>

<!-- Formulaire pour réinitialiser la matrice -->
<form action="MatriceServlet" method="post">
    <button type="submit">Réinitialiser la Matrice</button>
</form>
</body>
</html>
