<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil - TP1 Dev Av S6</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #f8f9fa, #e9ecef);
        }
        .welcome-card {
            margin-top: 50px;
            padding: 30px;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .link-btn {
            margin: 10px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="welcome-card text-center">
        <h1>Bienvenue sur TP1 Dev Av S6</h1>
        <p>Utilisez les liens ci-dessous pour accéder aux différentes fonctionnalités de l'application.</p>
        <div class="d-grid gap-2 col-6 mx-auto">
            <a href="hello" class="btn btn-outline-primary btn-lg link-btn">HelloWorld Servlet</a>
            <a href="helloName" class="btn btn-outline-primary btn-lg link-btn">HelloName Servlet</a>
            <a href="AnnonceAdd" class="btn btn-outline-success btn-lg link-btn">Ajouter une annonce</a>
            <a href="AnnonceList" class="btn btn-outline-info btn-lg link-btn">Liste des annonces</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
