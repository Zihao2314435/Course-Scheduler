# Course Scheduler

A Java desktop application for managing students, courses, semesters, and class schedules, developed using Java Swing, JDBC, SQL, and Apache Derby.

## Overview

Course Scheduler provides a graphical interface for managing academic course offerings and student enrollment. The application connects to a relational database through JDBC to support scheduling, seat availability checks, waitlist management, and enrollment updates.

Developed as part of Penn State's CMPSC 221 coursework, the project applies object-oriented programming, desktop GUI development, and relational database integration.

## Features

- Student management
- Course and class management
- Semester management
- Student course scheduling
- Seat availability checking
- Course waitlists
- Student enrollment and course dropping
- Automatic promotion of waitlisted students when seats become available
- Database-backed data management
- Graphical user interface built with Java Swing

## Technologies

- Java
- Java Swing and AWT
- JDBC
- SQL
- Apache Derby
- Object-oriented programming
- NetBeans IDE

## Database

The application uses an Apache Derby relational database accessed through JDBC.

The database includes tables for managing:

- Students
- Courses
- Classes
- Semesters
- Schedules

Database operations are organized into query classes, while the connection logic is handled separately by `DBConnection`.

## Application Structure

- **`MainFrame`** - Provides the graphical user interface and handles user interactions.
- **`Query classes`** - Execute database operations for students, courses, classes, semesters, and schedules.
- **`Entry classes`** - Represent application data and database records.
- **`DBConnection`** - Establishes the JDBC connection to the Apache Derby database.

This organization separates GUI behavior, database operations, and data representation into distinct parts of the application.

## Running the Application

The project requires a compatible Java environment, an Apache Derby database setup, and the appropriate JDBC connection configuration.

- Open the project in NetBeans.
- Configure and start the database connection.
- Run the application.

The database must be available and configured for the application to access its data.

## Academic Context

This project was completed as part of Penn State's CMPSC 221 coursework.


