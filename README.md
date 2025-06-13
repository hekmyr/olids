# README du Projet Holidays

Ce document décrit comment configurer et lancer le projet Holidays.

## Prérequis

*   Docker & Docker Compose
*   Java 17
*   Node.js et npm

## Configuration

Avant de lancer l'application, vous devez configurer les variables d'environnement. Copiez les fichiers `.example` et remplissez les valeurs appropriées.

### 1. Configuration Docker (`olids/.env`)

Ce fichier est utilisé par `docker-compose.yml` pour configurer les services externes comme la base de données PostgreSQL et Odoo.

Copiez `olids/.env.example` vers `olids/.env`:

```
POSTGRES_DB=postgres          # Nom de la base de données PostgreSQL
POSTGRES_USER=postgres        # Utilisateur pour la base de données PostgreSQL
POSTGRES_PASSWORD=example     # Mot de passe pour l'utilisateur PostgreSQL
ODOO_USER=odoo                # Utilisateur administrateur pour Odoo
ODOO_PASSWORD=odoo            # Mot de passe pour l'administrateur Odoo
BACKEND_USER=backend          # Utilisateur pour la base de données de l'API backend
BACKEND_PASSWORD=example      # Mot de passe pour l'utilisateur de la base de données de l'API backend
BACKEND_DB=backend_db         # Nom de la base de données pour l'API backend
```

### 2. Configuration API Backend (`olids/api/.env`)

Ce fichier configure les variables d'environnement pour l'application Spring Boot (API).

Copiez `olids/api/.env.example` vers `olids/api/.env`:

```bash
# olids/api/.env
export DB_PASSWORD=example                 # Mot de passe pour la base de données de l'API (doit correspondre à BACKEND_PASSWORD dans olids/.env)
export DB_USER=postgres                    # Utilisateur pour la base de données de l'API (doit correspondre à BACKEND_USER dans olids/.env)
export DB_CONNECTION=postgresql://localhost:5432/backend_db # URL de connexion à la base de données (le nom de la BD doit correspondre à BACKEND_DB)
export ODOO_DB=odoo                        # Nom de la base de données Odoo (généralement 'odoo' ou le nom de votre instance)
export ODOO_URL=http://localhost:8069/jsonrpc # URL de l'API JSON-RPC d'Odoo
export ODOO_ADMIN_PASSWORD=password        # Mot de passe administrateur Odoo (doit correspondre à ODOO_PASSWORD dans olids/.env)
export STRIPE_API_KEY=sk...                # Clé API secrète de Stripe pour les paiements
export STRIPE_CURRENCY=eur                 # Devise par défaut pour Stripe (ex: eur, usd)
export PAYMENT_SUCCESS_ENDPOINT="/payment/success" # Endpoint de redirection après un paiement réussi
export PAYMENT_CANCEL_ENDPOINT="/payment/cancel"   # Endpoint de redirection après un paiement annulé
export CLIENT_URL="http://localhost:4200"    # URL de base de l'application frontend
export RESEND_API_KEY=re...                # Clé API pour le service d'envoi d'emails Resend
export CONTACT_EMAIL="example@email.com"   # Adresse email de contact affichée ou utilisée par l'application
export SUPPORT_DOMAIN_EMAIL="system@resend.dev" # Email expéditeur pour les notifications système via Resend
```
**Important:** Pour que l'API Gradle puisse lire ces variables, vous devez "sourcer" ce fichier avant de lancer l'application (voir section Lancement).

### 3. Configuration Frontend (`olids/web/src/environments/environment.ts`)

Ce fichier configure les variables d'environnement pour l'application Angular (Frontend).

Copiez `olids/web/src/environments/environment.example.ts` vers `olids/web/src/environments/environment.ts` et `olids/web/src/environments/environment.prod.ts` (si nécessaire pour la production).

Pour le développement (`environment.ts`):
```typescript
// olids/web/src/environments/environment.ts
export const environment = {
  production: false, // Mettre à false pour le développement
  apiUrl: 'http://localhost:8080/api', // URL de votre API backend (typiquement où tourne Spring Boot)
  stripeApiKey: 'YOUR_DEVELOPMENT_STRIPE_API_KEY' // Clé API publique Stripe pour le développement
};
```

Pour la production (`environment.prod.ts`), le fichier `environment.example.ts` sert de modèle:
```typescript
// olids/web/src/environments/environment.example.ts (à copier vers environment.prod.ts et adapter)
export const environment = {
  production: true, // Mettre à true pour la production
  apiUrl: 'YOUR_PRODUCTION_API_URL', // URL de votre API backend en production
  stripeApiKey: 'YOUR_PRODUCTION_STRIPE_API_KEY' // Clé API publique Stripe pour la production
};
```

## Lancement du Projet

Suivez ces étapes dans l'ordre :

1.  **Lancer les services Docker (Base de données et Odoo)**:
    *   Assurez-vous que Docker est en cours d'exécution.
    *   À la racine du projet (`olids/`):
        ```bash
        docker-compose up
        ```
    *   Cela démarrera PostgreSQL et Odoo en arrière-plan.

2.  **Lancer l'API Backend (Spring Boot / Gradle)**:
    *   Ouvrez un nouveau terminal.
    *   Naviguez vers le dossier de l'API:
        ```bash
        cd api
        ```
    *   Sourcez les variables d'environnement:
        ```bash
        source .env
        ```
    *   Lancez l'application API:
        ```bash
        ./gradlew bootRun
        ```
    *   L'API devrait être accessible sur `http://localhost:8080`.

3.  **Lancer l'application Frontend (Angular)**:
    *   Ouvrez un nouveau terminal.
    *   Naviguez vers le dossier web:
        ```bash
        cd web
        ```
    *   Installez les dépendances (uniquement la première fois ou après des modifications de `package.json`):
        ```bash
        npm install
        ```
    *   Lancez le serveur de développement Angular:
        ```bash
        npm run start
        ```
    *   L'application frontend devrait être accessible sur `http://localhost:4200`.
