# 🏨 Room / Property Management System

This project implements a **room/property management system** with user management capabilities (providers and guests).  
Guests can search for properties, leave reviews, and view their reviews, while providers can manage their properties.  

The program includes a **graphical user interface (GUI)** for easy usage and interactivity.

---

## ✨ Core Features

### 👥 User Management
- User registration (guest or provider)  
- User login (guest or provider)  

### 🙋‍♂️ Guest Features
- Search for properties using criteria (name, location, amenities)  
- Add, modify, and delete reviews  
- View all reviews they have submitted  

### 🏠 Provider Features
- Add, modify, and delete properties  
- View properties and their reviews  

---

## 🛠️ Class Descriptions

### 📌 API
- **User**: A base class representing a user with fields like name, surname, username, and password.  
- **Guest**: An extension of `User` for guests. Contains reviews, ratings, and dates.  
- **Provider**: An extension of `User` for providers. Manages the list of rooms they offer.  
- **Room**: A class representing properties, with fields like name, type, location, amenities, reviews, and ratings.  

### 🖥️ GUI
- **Start**: Initial screen with "Sign In" and "Sign Up" options  
- **SignIn**: Login form for users  
- **SignUp**: Registration form for users  
- **GuestMenu**: Menu of features available to guests  
- **ProviderMenu**: Menu of features available to providers  
- **AddRoom**: Form for providers to add rooms  
- **ChangeRoom**: Form to modify room details  
- **YourRooms**: Displays a list of rooms belonging to a provider  
- **ShowRoom**: Displays detailed information about a room  
- **ShowReviews**: Displays all reviews of a room  
- **FindRoomGuest**: Allows guests to search for rooms using specific criteria  
- **ShowSearchRooms**: Displays rooms that match the search criteria  
- **AddReview**: Form to add a review  
- **ChangeorDeleteReview**: Form to modify or delete a review  
- **ShowGuestReviews**: Displays all reviews submitted by a guest  
- **NoRoom**: Message displayed when no properties are found  
- **NoReview**: Message displayed when no reviews are found  
- **Success**: Message displayed when an action is successfully completed  
- **WrongInput**: Message displayed for invalid input  

### ▶️ Main
- Initializes data (providers, guests, properties) and starts the application  

---

## 💻 Technologies Used
- **Programming Language**: Java  
- **User Interface**: Swing for creating graphical components  
- **File Management**: Serialization is used for saving and loading data (e.g., `.bin` files)  

---
