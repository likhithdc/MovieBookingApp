


Movie Booking Application on Spring Boot with Hibernate/JPA

I am a user of one of the movies booking website and can securely access the website and browse all movies, book movie tickets for a particular date and time. I will be able to cancel or change timings of the movie too.
 
Cardinality relationship between entities
One user can book multiple movies for different cinemas with different dates and time. Hence one to many relationships between User and Cinema.
One to many relationships between Cinema and Screen
One to one relationship between Screen and Movie

Managing the Life cycle of Entities
User should be able to login to the Cinema booking system.
User should be able to view all movies and their Screen details available for a Cinema (INOX/PVR/both) and book cinema tickets with screen details
User can see all tickets booked earlier.

Hibernate and Spring module:
The life cycle of entity classes completely managed by Hibernate framework
Named query to be used
Spring Boot to be used to bootstrap the application
![image](https://github.com/user-attachments/assets/316e2c7f-21dd-4cd1-9f0d-124ef898c9de)


Please find complete document : [Document.docx](https://github.com/user-attachments/files/18260648/Document.docx)
