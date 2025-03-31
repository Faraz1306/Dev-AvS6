<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier l'annonce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Modifier l'annonce</h2>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <form action="AnnonceUpdate" method="post">
        <input type="hidden" name="id" value="${annonce.id}" />
        <div class="mb-3">
            <label for="title" class="form-label">Titre :</label>
            <input type="text" id="title" name="title" class="form-control" value="${annonce.title}" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description :</label>
            <textarea id="description" name="description" class="form-control" rows="4" required>${annonce.description}</textarea>
        </div>
        <div class="mb-3">
            <label for="adress" class="form-label">Adresse :</label>
            <input type="text" id="adress" name="adress" class="form-control" value="${annonce.adress}" required>
        </div>
        <div class="mb-3">
            <label for="mail" class="form-label">Email :</label>
            <input type="email" id="mail" name="mail" class="form-control" value="${annonce.mail}" required>
        </div>
        <button type="submit" class="btn btn-primary">Mettre à jour</button>
    </form>

    <!-- Liens de navigation en bas de page -->
    <div class="text-center mt-4">
        <a href="index.jsp" class="btn btn-link">Retour à l'accueil</a>
        <a href="AnnonceList" class="btn btn-link">Liste des annonces</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
