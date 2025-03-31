<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Annonce</title>
</head>
<body>
<h1>Ajouter une Annonce</h1>

<!-- Affichage d'un message d'erreur éventuel -->
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<!-- Formulaire pour saisir une annonce -->
<form action="AnnonceAdd" method="post">
    <label for="title">Titre :</label>
    <input type="text" id="title" name="title" required /><br/>

    <label for="description">Description :</label>
    <textarea id="description" name="description" required></textarea><br/>

    <label for="adress">Adresse :</label>
    <input type="text" id="adress" name="adress" required /><br/>

    <label for="mail">Email :</label>
    <input type="email" id="mail" name="mail" required /><br/>

    <input type="submit" value="Ajouter l'annonce" />
</form>

<br/>
<a href="index.jsp">Retour à l'accueil</a>
</body>
</html>
