Rendu TP03 JEE par CHAABANE Zeineb, THOMAS Meven, PILLOT Pierren et GADELLE Ella 
# JEE_TP03

## Aperçu du projet

Ce TP consiste à développer une application web avec JSP et des servlets pour trois fonctionnalités principales :
1. Une page de login pour vérifier l'identité d'un utilisateur.
2. La résolution d'une équation du second degré avec affichage du résultat.
3. La gestion d'une matrice 10x10 avec modification des cellules et réinitialisation.

Chaque partie repose sur l'interaction entre une servlet et des pages JSP pour la collecte des données et l'affichage des résultats.

---

## Exercice 1 : Page de Login

### Objectif
Créer une page `Login.jsp` pour que l'utilisateur puisse saisir un nom d'utilisateur et un mot de passe. Les informations sont transmises à une servlet `Servlet_Login` qui vérifie les identifiants.

### Fonctionnement

1. **Login.jsp** : Contient un formulaire de login avec des champs pour le nom d'utilisateur et le mot de passe, qui envoie les données en méthode POST vers `Servlet_Login`.
2. **Servlet_Login** : Récupère les informations saisies. Si les identifiants sont corrects (par exemple, nom et mot de passe définis comme "J2EE"), la servlet prépare un message de bienvenue. Sinon, elle affiche un message d'échec de l'authentification.
3. **resultat.jsp** : Cette page JSP affiche le message transmis par `Servlet_Login` (soit un message de bienvenue, soit une notification d'échec).

---

## Exercice 2 : Résolution d'une Équation du Second Degré

### Objectif
Permettre la saisie des coefficients `a`, `b`, et `c` d'une équation du second degré et résoudre l'équation via une servlet `SolveEquationServlet`.

### Fonctionnement

1. **Formulaire.jsp** : Contient un formulaire permettant de saisir les coefficients `a`, `b`, et `c`. Les données sont envoyées à la servlet `SolveEquationServlet` en POST.
2. **SolveEquationServlet** : Cette servlet calcule les racines de l'équation en fonction du discriminant. Trois cas sont possibles :
    - Discriminant positif : l'équation a deux solutions réelles.
    - Discriminant nul : l'équation a une solution double.
    - Discriminant négatif : pas de solution réelle.
      La servlet stocke le résultat sous forme de message.
3. **equationResultat.jsp** : Affiche le message contenant le résultat de l'équation, transmis par `SolveEquationServlet`. 
   - Deux racines réelles en vert si le discriminant est positif.
   - Une racine réelle double en bleu si le discriminant est nul.
   - "Pas de racines réelles" en rouge si le discriminant est négatif.

---

## Exercice 3 : Gestion d'une Matrice 10x10

### Objectif
Créer une matrice 10x10 que l'on peut afficher, mettre à jour, et réinitialiser. La mise à jour de chaque cellule se fait via une interface `Matrice.jsp` et les actions sont gérées par une servlet `MatriceServlet`.

### Fonctionnement

1. **Matrice.jsp** : Cette page contient :
    - Un lien pour afficher la matrice.
    - Un formulaire permettant de saisir les coordonnées `x` et `y` de la cellule à modifier, ainsi que la nouvelle valeur. Les informations sont envoyées à `MatriceServlet`.
    - Un bouton pour réinitialiser la matrice.
2. **MatriceServlet** : Cette servlet gère les actions suivantes :
    - En méthode GET et sans paramètre, elle affiche la matrice 10x10 sous forme de table. Chaque cellule est initialisée à `0`.
    - En méthode GET avec des paramètres x et y, elle affiche la valeur de la cellule si celle-ci a été initialisée.
    - En méthode POST, elle met à jour la cellule aux coordonnées données ou réinitialise toute la matrice si aucun paramètre n'est fourni.
    - Après chaque action, la servlet redirige vers l'affichage de la matrice actualisée.
3. **Affichage** : La matrice est affichée sous forme de table HTML dans la réponse de la servlet, permettant de voir les modifications en temps réel.


L’utilisateur peut voir la matrice, mettre à jour les cellules de manière ciblée, et réinitialiser la matrice si nécessaire.

---

## Conclusion

Ce TP introduit des concepts de base pour le développement d'applications web interactives avec JSP et des servlets. Il démontre comment utiliser les formulaires HTML et les servlets pour traiter des données côté serveur et afficher dynamiquement les résultats via des JSP. Ces trois exercices permettent de comprendre comment structurer une application web, en séparant la logique de traitement (servlets) de la logique de présentation (JSP).
