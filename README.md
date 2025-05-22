# veambe 

This is the **Spring Boot backend** for the **veambe** project, a platform dedicated to showcasing the visual art of **Beatriz Oliver**, known professionally as *veambe*. This backend provides a RESTful API to manage artworks, categories, images, and admin access.

---

##  Features

### Public API
- 🔍 Get all artworks
- 🔍 Get artworks by category
- 🔍 Get artwork details by ID
- 🖼️ Get all images for an artwork

### Admin-only (used by the hidden management route)
- ✅ Create new artworks (linked to an admin and category)
- 🖼️ Upload images (JSON or file-based)
- 🧹 Delete an artwork and its associated images
- ✏️ Update an artwork (title, description, category, and optionally images)

---

## Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **H2 (development) or MySQL/PostgreSQL (production-ready)**
- **Maven** or **Gradle**

---

---

##  Setup Instructions

1. **Clone the repository**:

  ```bash
   git clone https://github.com/your-username/veambe-backend.git
   cd veambe-backend
`````

2. Run the application (default on port 8080):

Using Maven:
  ```bash
 ./mvnw spring-boot:run
`````
Access the API at:
  ```bash
http://localhost:8080/api/v1/
`````

#  Endpoints Overview
## 🎨 Artworks
Method	Endpoint	Description
POST	/trabajo/{adminId}	Create new artwork
GET	/trabajo	Get all artworks
GET	/trabajo/obra/{artworkId}	Get artwork by ID
GET	/trabajo/categoria/{categoryName}	Get artworks by category
PUT	/trabajo/obra/{artworkId}	Update artwork
DELETE	/trabajo/obra/{artworkId}	Delete artwork + images

## 🖼️ Images
Method	Endpoint	Description
POST	/images/{artworkId}	Upload image as JSON
POST	/images/upload/{artworkId}	Upload image file (multipart)
GET	/images/obra/{artworkId}	Get all images for an artwork

## Database Notes
Supports in-memory H2 for development.

Relational mapping:

One Artwork has one Category

One Artwork has many Images

One Admin can create many Artworks

You can easily switch to a persistent DB (e.g., PostgreSQL) by updating application.properties.
## Future Improvements
🔐 Add authentication (JWT or session-based)

📤 S3 or cloud storage for image hosting

🧪 Unit and integration tests

🌍 Deploy to cloud (Heroku, Render, Fly.io, etc.)

## Credits
This API was built to support the website of Beatriz Oliver (veambe), a multidisciplinary artist.

## 📬 Contact
marta.ibarrac@gmail.com
