

Περιγραφή Εργασίας
Αυτή η εργασία υλοποιεί ένα σύστημα διαχείρισης δωματίων/καταλυμάτων με τη δυνατότητα διαχείρισης χρηστών (πάροχοι και επισκέπτες). Οι επισκέπτες μπορούν να αναζητούν καταλύματα, να αφήνουν κριτικές και να βλέπουν τις κριτικές τους, ενώ οι πάροχοι μπορούν να διαχειρίζονται τα καταλύματά τους.

Το πρόγραμμα περιλαμβάνει διεπαφή χρήστη (GUI) για εύκολη χρήση και διαδραστικότητα.

Βασικές Λειτουργίες
Διαχείριση Χρηστών:

Εγγραφή επισκέπτη ή παρόχου.
Σύνδεση χρήστη (επισκέπτης ή πάροχος).
Λειτουργίες Επισκέπτη:

Αναζήτηση καταλυμάτων με βάση κριτήρια (όνομα, τοποθεσία, παροχές).
Προσθήκη, αλλαγή και διαγραφή κριτικής.
Προβολή όλων των κριτικών που έχουν αφήσει.
Λειτουργίες Παρόχου:

Προσθήκη, αλλαγή και διαγραφή καταλυμάτων.
Προβολή των καταλυμάτων και των κριτικών τους.

Περιγραφή Κλάσεων
API
User: Βασική κλάση που αναπαριστά έναν χρήστη με πεδία όπως όνομα, επώνυμο, όνομα χρήστη και κωδικός πρόσβασης.
Guest: Επέκταση της User για επισκέπτες. Περιέχει κριτικές, βαθμολογίες και ημερομηνίες.
Provider: Επέκταση της User για παρόχους. Περιέχει τη λίστα των δωματίων που διαχειρίζεται.
Room: Κλάση για καταλύματα, με πεδία όπως όνομα, τύπος, τοποθεσία, παροχές, κριτικές και βαθμολογίες.

GUI
Start: Η αρχική οθόνη με επιλογές "Sign In" και "Sign Up".
SignIn: Φόρμα σύνδεσης χρηστών.
SignUp: Φόρμα εγγραφής χρηστών.
GuestMenu: Μενού λειτουργιών για επισκέπτες.
ProviderMenu: Μενού λειτουργιών για παρόχους.
AddRoom: Φόρμα προσθήκης δωματίου από πάροχο.
ChangeRoom: Φόρμα αλλαγής δωματίου.
YourRooms: Λίστα δωματίων που ανήκουν στον πάροχο.
ShowRoom: Εμφάνιση λεπτομερειών ενός δωματίου.
ShowReviews: Εμφάνιση όλων των κριτικών ενός δωματίου.
FindRoomGuest: Αναζήτηση δωματίων από επισκέπτες με κριτήρια.
ShowSearchRooms: Εμφάνιση δωματίων που πληρούν τα κριτήρια αναζήτησης.
AddReview: Φόρμα προσθήκης κριτικής.
ChangeorDeleteReview: Φόρμα αλλαγής ή διαγραφής κριτικής.
ShowGuestReviews: Εμφάνιση όλων των κριτικών του επισκέπτη.
NoRoom: Μήνυμα σε περίπτωση που δεν βρεθεί κατάλυμα.
NoReview: Μήνυμα σε περίπτωση που δεν βρεθεί κριτική.
Success: Μήνυμα επιτυχούς ολοκλήρωσης ενέργειας.
WrongInput: Μήνυμα για εσφαλμένη είσοδο.

Main
Περιλαμβάνει την αρχικοποίηση των δεδομένων (πάροχοι, επισκέπτες, καταλύματα) και την έναρξη της εφαρμογής.

Τεχνολογίες που Χρησιμοποιούνται
Γλώσσα Προγραμματισμού: Java
Διεπαφή Χρήστη: Swing για τη δημιουργία γραφικών στοιχείων.
Αρχεία: Χρήση σειριοποίησης για αποθήκευση και φόρτωση δεδομένων (π.χ. αρχεία .bin).



Project Description
This project implements a room/property management system with user management capabilities (providers and guests). Guests can search for properties, leave reviews, and view their reviews, while providers can manage their properties.

The program includes a graphical user interface (GUI) for easy usage and interactivity.

Core Features
User Management:

User registration (guest or provider).
User login (guest or provider).
Guest Features:

Search for properties using criteria (name, location, amenities).
Add, modify, and delete reviews.
View all reviews they have submitted.
Provider Features:

Add, modify, and delete properties.
View properties and their reviews.
Class Descriptions

API
User: A base class representing a user with fields like name, surname, username, and password.
Guest: An extension of User for guests. Contains reviews, ratings, and dates.
Provider: An extension of User for providers. Manages the list of rooms they offer.
Room: A class representing properties, with fields like name, type, location, amenities, reviews, and ratings.

GUI
Start: The initial screen with "Sign In" and "Sign Up" options.
SignIn: Login form for users.
SignUp: Registration form for users.
GuestMenu: Menu of features available to guests.
ProviderMenu: Menu of features available to providers.
AddRoom: Form for providers to add rooms.
ChangeRoom: Form to modify room details.
YourRooms: Displays a list of rooms belonging to a provider.
ShowRoom: Displays detailed information about a room.
ShowReviews: Displays all reviews of a room.
FindRoomGuest: Allows guests to search for rooms using specific criteria.
ShowSearchRooms: Displays rooms that match the search criteria.
AddReview: Form to add a review.
ChangeorDeleteReview: Form to modify or delete a review.
ShowGuestReviews: Displays all reviews submitted by a guest.
NoRoom: Message displayed when no properties are found.
NoReview: Message displayed when no reviews are found.
Success: Message displayed when an action is successfully completed.
WrongInput: Message displayed for invalid input.

Main
Initializes data (providers, guests, properties) and starts the application.

Technologies Used
Programming Language: Java
User Interface: Swing for creating graphical components.
File Management: Serialization is used for saving and loading data (e.g., .bin files).
