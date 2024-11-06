<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Formulaire Équation</title>
</head>
<body>
<h2>Résolution d'une Équation du Second Degré</h2>
<form action="SolveEquationServlet" method="post">
    Coefficient a: <input type="number" name="a" required><br><br>
    Coefficient b: <input type="number" name="b" required><br><br>
    Coefficient c: <input type="number" name="c" required><br><br>
    <button type="submit">Résoudre</button>
</form>
</body>
</html>
