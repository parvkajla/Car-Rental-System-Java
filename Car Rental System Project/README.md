
Object Oriented Programming

**Guvi Project**
Galgotias University
**2025**

**Submitted by:**
Team - RCB
(Parv Kajla, 
Aarush Pratap Singh, 
Anshul Pandey,  
Bhuvan Gandhi) 

Section- 34

**Submitted to:**

Mukesh Kumar Jha



# Java GUI-Based Management System

## 📌 Project Overview
This project is a Java Swing-based GUI application designed to manage records through a visually interactive interface and secure backend integration using JDBC with MySQL. The application ensures efficient functionality, intuitive navigation, and clean architectural design using the Model-DAO-UI approach.

## 🧠 Key Features
- Secure Admin Login
- Add, Update, Delete, and View records (CRUD Operations)
- Form input validation and error handling
- JDBC-based MySQL connectivity
- Clean and modular project structure
- Aesthetic and aligned GUI design
- Responsive and user-friendly interface

## 🛠️ Technologies Used
- Java (JDK 17+)
- Swing (GUI)
- JDBC (Database Connectivity)
- MySQL (Database)
- IntelliJ IDEA / Eclipse / NetBeans (IDE)

## 🗂️ Project Structure

Java-GUI-Project/
├── src/
│ ├── ui/ # All user interface files
│ ├── dao/ # Database access and operations
│ ├── model/ # Data model classes (POJOs)
│ └── Main.java # Entry point
├── database/
│ └── car_rental_system.sql # MySQL table creation script
├── Car Rental System.pdf
├── README.md

## Database Setup

1. Open MySQL Workbench.
2. Go to `Server > Data Import`.
3. Choose "Import from Self-Contained File".
4. Select `database/car_rental_system.sql` from this repo.
5. Choose the database `car_rental_system` or create a new one.
6. Click "Start Import".

Your database will now be set up with all required tables and sample data.


## 📥 How to Set Up the Project

1. **Clone the Repository**
   ```bash
   git clone https://github.com/parvkajla/Car-Rental-System-Java
2. Set Up MySQL Database

     Open MySQL client.

     Execute the schema.sql script from the database/ folder to create necessary tables.

3. Import Project in IDE

   Open IntelliJ IDEA / Eclipse / NetBeans.

   Import the cloned project.

   Add JDBC driver to project libraries.

4. Run the Application

   Run Main.java.

   Use admin login or create a new user to access functionalities.
