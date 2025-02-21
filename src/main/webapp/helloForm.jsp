<!-- helloForm.jsp -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saisir votre nom</title>
</head>
<body>
<h1>Entrez votre nom</h1>
<form action="helloName" method="post">
    <label for="name">Nom :</label>
    <!-- Validation côté client grâce à HTML5 -->
    <input type="text" id="name" name="name" required>
    <input type="submit" value="Envoyer">
</form>
</body>
</html>
