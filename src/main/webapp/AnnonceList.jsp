<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Annonces</title>
</head>
<body>
<h1>Liste des Annonces</h1>
<c:if test="${empty annonces}">
    <p>Aucune annonce enregistrée.</p>
</c:if>
<c:if test="${not empty annonces}">
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Description</th>
            <th>Adresse</th>
            <th>Email</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="annonce" items="${annonces}">
            <tr>
                <td>${annonce.id}</td>
                <td>${annonce.title}</td>
                <td>${annonce.description}</td>
                <td>${annonce.adress}</td>
                <td>${annonce.mail}</td>
                <td>${annonce.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<br/>
<a href="index.jsp">Retour à l'accueil</a>
</body>
</html>
