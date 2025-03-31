Prérequis:
- Docker installé sur votre machine.
- Docker Compose

Lancer la base de données:
- docker-compose up -d

Pour vérifier que le conteneur fonctionne, utilisez : docker ps


Lorsque vous lancez votre application, Hibernate créera automatiquement les tables dans la base de données MasterAnnonce. 
Votre application se connectera via l'URL jdbc:postgresql://localhost:5432/MasterAnnonce

Arrêter la base de données:
Pour arrêter et supprimer le conteneur (tout en conservant les données dans le volume), exécutez : docker-compose down

Si vous souhaitez également supprimer le volume et effacer toutes les données, utilisez : docker-compose down -v

Redémarrer le conteneur : docker-compose restart

URL pour accéder à l'application: http://localhost:8080/tp-dev-av-bis
