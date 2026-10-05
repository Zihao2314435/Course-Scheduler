# Course Scheduler

A desktop course scheduling application developed in Java using Swing, JDBC, SQL, and Apache Derb.

## Overview

The application provides a graphical interface for managing students, courses, semesters, and class schedules.

It connects to an Apache Derby relational database through JDBC and supports course enrollment, seat availability, waitlists, and schedule management.

## Features

- Student management
- Course and class management
- Semester management
- Student course scheduling
- Seat availability checking
- Course waitlists
- Student enrollment and course dropping
- Automatic promotion from waitlists when seats become available
- Database-backed data management
- Graphical user interface built with Java Swing

## Technologies

- Java
- Java Swing
- JDBC
- SQL
- Apache Derby
- Object-Oriented Programming
- NetBeans

## Database

The application uses an Apache Derby relational database accessed through JDBC.

The database contains tables for managing:

- Students
- Courses
- Classes
- Semesters
- Schedules

The database is managed separately from the Java source code through the NetBeans database tools.

## Application Structure

The application is organized into several groups of classes:

- **MainFrame** — provides the graphical user interface and handles user interactions.
- **Query classes** — perform database operations for students, courses, schedules, semesters, and classes.
- **Entry classes** — represent data used by the application.
- **DBConnection** — manages the JDBC connection to the Derby database.

## Academic Context

This project was completed as part of Penn State's CMPSC 221 coursework.

