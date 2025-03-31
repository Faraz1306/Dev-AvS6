<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Annonces</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .action-btn { margin-right: 5px; }
    </style>
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Liste des Annonces</h2>
    <c:if test="${empty annonces}">
        <div class="alert alert-info">Aucune annonce enregistrée.</div>
    </c:if>
    <c:if test="${not empty annonces}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Titre</th>
                <th>Description</th>
                <th>Adresse</th>
                <th>Email</th>
                <th>Date</th>
                <th>Actions</th>
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
                    <td>
                        <a class="btn btn-primary btn-sm action-btn" href="AnnonceUpdate?id=${annonce.id}">Modifier</a>
                        <a class="btn btn-danger btn-sm action-btn" href="AnnonceDelete?id=${annonce.id}"
                           onclick="return confirm('Voulez-vous vraiment supprimer cette annonce ?');">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- Liens de navigation en bas de page -->
    <div class="text-center mt-4">
        <a href="index.jsp" class="btn btn-link">Retour a l'accueil</a>
        <a href="AnnonceAdd" class="btn btn-link">Ajouter une annonce</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
