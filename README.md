# LinkedIn Clone - Full Stack Social Media Application

<div align="center">
  
![LinkedIn Clone](https://img.shields.io/badge/LinkedIn-Clone-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)

**A feature-rich social media platform built with Spring Boot and React**

[Demo Video](#-demo) • [Features](#-features) • [Installation](#-installation) • [API Documentation](#-api-documentation)

</div>

---

## 📋 Table of Contents

- [About](#-about)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Architecture](#-architecture)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [API Documentation](#-api-documentation)
- [Database Schema](#-database-schema)
- [Screenshots](#-screenshots)
- [Demo](#-demo)
- [Security Features](#-security-features)
- [Future Enhancements](#-future-enhancements)
- [Contributing](#-contributing)
- [License](#-license)
- [Contact](#-contact)

---

## 🎯 About

LinkedIn Clone is a full-stack social media web application that replicates core LinkedIn functionalities. Users can create accounts, share posts with images, interact through likes and comments, share content, and view user profiles. Built with modern technologies and best practices, this project demonstrates a complete social networking platform implementation.

---

## ✨ Features

### 🔐 Authentication & Authorization
- ✅ User registration with email validation
- ✅ Secure login with JWT tokens
- ✅ Password encryption using BCrypt
- ✅ Protected routes and API endpoints
- ✅ Session management

### 📝 Post Management
- ✅ Create posts with text content
- ✅ Upload images from browser (JPG, PNG, GIF)
- ✅ Image preview before posting
- ✅ Edit your own posts
- ✅ Delete your own posts
- ✅ View all posts in chronological order (latest first)
- ✅ Image validation (type and size)

### 💬 Social Interactions
- ✅ **Like System**: Like/unlike posts with real-time count updates
- ✅ **Comments**: Add, edit, and delete comments on posts
- ✅ **Share**: Share posts with optional additional commentary
- ✅ Real-time interaction counts (likes, comments, shares)
- ✅ User-specific interactions (can only edit/delete own content)

### 👤 User Profiles
- ✅ Dedicated profile pages for each user
- ✅ View user's post history
- ✅ Post count statistics
- ✅ Clickable user avatars and names
- ✅ Profile navigation from posts and navbar
- ✅ Responsive profile layout

### 🎨 User Interface
- ✅ Responsive design for mobile and desktop
- ✅ Modern LinkedIn-inspired UI
- ✅ Smooth animations and transitions
- ✅ Modal dialogs for comments and sharing
- ✅ Image upload with preview
- ✅ Loading states and error handling
- ✅ Empty states for better UX

---

## 🛠️ Tech Stack

### Backend
| Technology | Version | Purpose |
|------------|---------|---------|
| Spring Boot | 3.2.x | Backend framework |
| Spring Security | 6.x | Authentication & Authorization |
| JWT | 0.12.3 | Token-based authentication |
| Spring Data JPA | 3.2.x | ORM and data access |
| MySQL | 8.0+ | Relational database |
| Hibernate | 6.x | JPA implementation |
| Lombok | 1.18.x | Reduce boilerplate code |
| Maven | 3.6+ | Dependency management |

### Frontend
| Technology | Version | Purpose |
|------------|---------|---------|
| React | 18.x | UI library |
| React Router DOM | 6.x | Client-side routing |
| Axios | 1.x | HTTP client |
| CSS3 | - | Styling |
| Create React App | 5.x | Build tool |

### Development Tools
- **IDE**: IntelliJ IDEA / VS Code
- **API Testing**: Postman / Thunder Client
- **Version Control**: Git & GitHub
- **Database Tool**: MySQL Workbench

---

## 🏗️ Architecture

```
linkedin-clone/
├── backend/                          # Spring Boot Application
│   ├── src/main/java/com/linkedin/
│   │   ├── config/
│   │   │   ├── SecurityConfig.java        # Security configuration
│   │   │   ├── JwtAuthenticationFilter.java
│   │   │   └── CorsConfig.java            # CORS settings
│   │   ├── controller/
│   │   │   ├── AuthController.java        # Authentication endpoints
│   │   │   ├── PostController.java        # Post CRUD operations
│   │   │   ├── LikeController.java        # Like functionality
│   │   │   ├── CommentController.java     # Comment operations
│   │   │   ├── FileController.java        # File upload/download
│   │   │   └── UserController.java        # User profile
│   │   ├── dto/
│   │   │   ├── AuthResponse.java
│   │   │   ├── LoginRequest.java
│   │   │   ├── SignupRequest.java
│   │   │   ├── PostRequest.java
│   │   │   ├── PostResponse.java
│   │   │   ├── CommentRequest.java
│   │   │   ├── CommentResponse.java
│   │   │   └── UserProfileResponse.java
│   │   ├── model/
│   │   │   ├── User.java                  # User entity
│   │   │   ├── Post.java                  # Post entity
│   │   │   ├── Like.java                  # Like entity
│   │   │   └── Comment.java               # Comment entity
│   │   ├── repository/
│   │   │   ├── UserRepository.java
│   │   │   ├── PostRepository.java
│   │   │   ├── LikeRepository.java
│   │   │   └── CommentRepository.java
│   │   ├── service/
│   │   │   ├── UserService.java
│   │   │   ├── PostService.java
│   │   │   ├── LikeService.java
│   │   │   ├── CommentService.java
│   │   │   ├── JwtService.java
│   │   │   └── FileStorageService.java
│   │   └── exception/
│   │       └── GlobalExceptionHandler.java
│   ├── src/main/resources/
│   │   └── application.properties         # Configuration
│   └── pom.xml                            # Maven dependencies
│
└── frontend/                              # React Application
    ├── public/
    │   └── index.html
    ├── src/
    │   ├── components/
    │   │   ├── Navbar.js                  # Navigation bar
    │   │   ├── PostCard.js                # Post display component
    │   │   ├── CreatePost.js              # Post creation form
    │   │   ├── PostList.js                # Posts feed
    │   │   ├── CommentSection.js          # Comments modal
    │   │   ├── ShareModal.js              # Share post modal
    │   │   ├── ProtectedRoute.js          # Route protection
    │   │   └── Loader.js                  # Loading spinner
    │   ├── pages/
    │   │   ├── Login.js                   # Login page
    │   │   ├── Signup.js                  # Registration page
    │   │   ├── Home.js                    # Main feed page
    │   │   └── Profile.js                 # User profile page
    │   ├── services/
    │   │   ├── api.js                     # Axios configuration
    │   │   ├── authService.js             # Auth API calls
    │   │   ├── postService.js             # Post API calls
    │   │   ├── fileService.js             # File upload
    │   │   └── userService.js             # User API calls
    │   ├── context/
    │   │   └── AuthContext.js             # Authentication context
    │   ├── utils/
    │   │   └── formatDate.js              # Date formatting
    │   ├── App.js                         # Main component
    │   ├── App.css
    │   └── index.js                       # Entry point
    ├── package.json
    └── .env                               # Environment variables
```

---

## 🚀 Installation

### Prerequisites

Before you begin, ensure you have the following installed:

- ☕ **Java JDK**: 17 or higher ([Download](https://www.oracle.com/java/technologies/downloads/))
- 🟢 **Node.js**: v16 or higher ([Download](https://nodejs.org/))
- 🐬 **MySQL**: v8.0 or higher ([Download](https://dev.mysql.com/downloads/))
- 📦 **Maven**: v3.6 or higher ([Download](https://maven.apache.org/download.cgi))
- 🔧 **Git**: Latest version ([Download](https://git-scm.com/downloads))

### Step-by-Step Setup

#### 1️⃣ Clone the Repository

```bash
git clone https://github.com/yourusername/linkedin-clone.git
cd linkedin-clone
```

#### 2️⃣ Database Setup

Open MySQL and create a new database:

```sql
CREATE DATABASE linkedin_clone;
```

Verify the database was created:

```sql
SHOW DATABASES;
```

#### 3️⃣ Backend Setup

Navigate to the backend directory:

```bash
cd backend
```

**Configure application.properties**

Open `src/main/resources/application.properties` and update:

```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/linkedin_clone
spring.datasource.username=root
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# JWT Configuration (IMPORTANT: Change this secret key!)
jwt.secret=mySecretKeyForJWTTokenGenerationThatIsAtLeast256BitsLongToEnsureSecurityHS256
jwt.expiration=86400000

# File Upload Configuration
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
file.upload-dir=./uploads/images
```

⚠️ **Important**: Change the `jwt.secret` to your own secure key (at least 32 characters)

**Build and Run**

```bash
# Clean install dependencies
mvn clean install

# Run the application
mvn spring-boot:run
```

✅ Backend will start on: `http://localhost:8080`

You should see output like:
```
Tomcat started on port(s): 8080 (http)
Started LinkedInCloneApplication in X.XXX seconds
```

#### 4️⃣ Frontend Setup

Open a new terminal and navigate to the frontend directory:

```bash
cd frontend
```

**Install Dependencies**

```bash
npm install
```

**Create Environment File**

Create a `.env` file in the frontend directory:

```env
REACT_APP_API_URL=http://localhost:8080/api
```

**Start Development Server**

```bash
npm start
```

✅ Frontend will start on: `http://localhost:3000`

Your browser should automatically open to the login page.

---

## ⚙️ Configuration

### Backend Configuration Options

| Property | Description | Default | Required |
|----------|-------------|---------|----------|
| `server.port` | Backend server port | 8080 | No |
| `spring.datasource.url` | MySQL database URL | - | Yes |
| `spring.datasource.username` | Database username | root | Yes |
| `spring.datasource.password` | Database password | - | Yes |
| `jwt.secret` | JWT signing secret (min 256 bits) | - | Yes |
| `jwt.expiration` | Token expiration time (milliseconds) | 86400000 | No |
| `file.upload-dir` | Directory for uploaded images | ./uploads/images | No |
| `spring.servlet.multipart.max-file-size` | Maximum file size | 10MB | No |

### Frontend Configuration Options

| Variable | Description | Default | Required |
|----------|-------------|---------|----------|
| `REACT_APP_API_URL` | Backend API base URL | http://localhost:8080/api | Yes |

### Common Configuration Issues

**Problem**: `Access denied for user 'root'@'localhost'`
- **Solution**: Check MySQL username and password in `application.properties`

**Problem**: `Cannot connect to MySQL server`
- **Solution**: Ensure MySQL is running: `sudo systemctl status mysql` (Linux) or check MySQL services (Windows)

**Problem**: JWT authentication fails
- **Solution**: Ensure `jwt.secret` is at least 32 characters long

---

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Authentication

All protected endpoints require JWT token in the header:
```
Authorization: Bearer {your_jwt_token}
```

---





## 🗂️ Database Schema

### Entity Relationship Diagram

```
┌─────────────┐         ┌─────────────┐         ┌─────────────┐
│    Users    │────────<│    Posts    │>────────│    Likes    │
└─────────────┘         └─────────────┘         └─────────────┘
       │                       │                        
       │                       │                        
       │                       │                        
       └───────────────────────┴────────────────────>┌─────────────┐
                                                      │  Comments   │
                                                      └─────────────┘
```



### Demo Highlights

#### 1. User Registration & Login
- Creating a new account
- Email validation
- Secure password handling
- JWT token generation

#### 2. Creating Posts
- Writing post content
- Uploading images from browser
- Image preview functionality
- Real-time post creation

#### 3. Social Interactions
- Liking posts
- Adding comments
- Editing and deleting comments
- Sharing posts with commentary

#### 4. User Profile Navigation
- Viewing own profile
- Viewing other users' profiles
- Navigating through clickable names
- Profile statistics

#### 5. Post Management
- Editing own posts
- Deleting posts
- Viewing post details
- Image handling

---

## 🔒 Security Features

### Authentication & Authorization
- ✅ **JWT Token-based Authentication**: Stateless authentication mechanism
- ✅ **Password Encryption**: BCrypt hashing with salt
- ✅ **Token Expiration**: Configurable token lifetime (default: 24 hours)
- ✅ **Protected Routes**: Authorization required for all sensitive operations
- ✅ **User-specific Actions**: Users can only modify their own content

### Data Security
- ✅ **SQL Injection Prevention**: JPA parameterized queries
- ✅ **XSS Protection**: Input validation and sanitization
- ✅ **CORS Configuration**: Controlled cross-origin requests
- ✅ **Input Validation**: Server-side validation for all inputs
- ✅ **Error Handling**: Generic error messages to prevent information leakage

### File Upload Security
- ✅ **File Type Validation**: Only images allowed (JPG, PNG, GIF)
- ✅ **File Size Limits**: Maximum 10MB per file
- ✅ **Unique Filenames**: UUID-based naming to prevent collisions
- ✅ **Path Traversal Prevention**: Filename sanitization

