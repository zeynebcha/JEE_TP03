<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Résultat</title>
</head>
<body>
<h2><%= request.getAttribute("message") != null ? request.getAttribute("message") : request.getAttribute("result") %></h2>
</body>
</html>
