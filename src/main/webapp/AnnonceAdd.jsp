<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Annonce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #74ebd5, #ACB6E5);
        }
        .card {
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        }
        .header-image {
            width: 100%;
            height: 35px; /* Hauteur réduite pour diminuer l'espace */
            background-image: url('https://source.unsplash.com/1600x900/?nature,water');
            background-size: cover;
            background-position: center;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="card mx-auto" style="max-width: 600px;">
        <div class="header-image"></div>
        <div class="card-body">
            <!-- Réduction de la marge inférieure du titre -->
            <h2 class="card-title text-center mb-2">Ajouter une Annonce</h2>
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>
            <form action="AnnonceAdd" method="post">
                <div class="mb-3">
                    <label for="title" class="form-label">Titre :</label>
                    <input type="text" id="title" name="title" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Description :</label>
                    <textarea id="description" name="description" class="form-control" rows="4" required></textarea>
                </div>
                <div class="mb-3">
                    <label for="adress" class="form-label">Adresse :</label>
                    <input type="text" id="adress" name="adress" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="mail" class="form-label">Email :</label>
                    <input type="email" id="mail" name="mail" class="form-control" required>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Ajouter l'annonce</button>
                </div>
            </form>
        </div>
        <div class="card-footer text-center">
            <a href="index.jsp" class="btn btn-secondary">Retour à l'accueil</a>
            <a href="AnnonceList" class="btn btn-info">Voir la liste des annonces</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
