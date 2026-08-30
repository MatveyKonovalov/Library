# Library Management System

A Kotlin/JVM console application for managing books, users, and book borrowing.

The project uses a **layered architecture** inspired by Clean Architecture principles, with clear separation between presentation, domain, and data layers.

<div align="start">
  <table>
    <tr>
      <td><img src="https://github.com/user-attachments/assets/60316197-c219-4a01-bb36-56ac9a6d4f25" width="300"></td>
      <td><img src="https://github.com/user-attachments/assets/3b8752ae-85f5-4e9b-852b-973598afcea6" width="300"></td>
    </tr>
    <tr>
      <td><img src="https://github.com/user-attachments/assets/0fd2247a-75ad-4386-98f7-01bfc5482719" width="300"></td>
      <td><img src="https://github.com/user-attachments/assets/0644e63d-c8dd-4c38-abc5-36e705fa0230" width="300"></td>
    </tr>
  </table>
</div>


---

##  Quick Start (Linux)

### 1. Install Java 21
#### Ubuntu / Debian
```bash
sudo apt update && sudo apt install openjdk-21-jdk
```
#### Fedora / RHEL
```bash
sudo dnf install java-21-openjdk
```

### Verify
```bash
java -version
```

### 2. Run the app
```bash
git clone https://github.com/MatveyKonovalov/Library.git
cd Library
java -jar library-system.jar
```

> **Note:** If `library-system.jar` is missing, run `./gradlew shadowJar` first.

### ❌ Troubleshooting
| Issue | Fix |
|-------|-----|
| `java: command not found` | Install Java 21 (see above) |
| `no main manifest attribute` | Run `./gradlew shadowJar` |
| `Permission denied` | `chmod +x gradlew` |

---

## Architecture

The application is divided into three main layers:

```text
┌─────────────────────────────┐
│ Presentation                │
│ ----------------------------|
│ UserConsoleUI               │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│ Domain                      │
│ ----------------------------|
│ LibraryOperations           │
│ Models                      │
│ Repository Interfaces       │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│ Data                        │
│ ----------------------------|
│ Library                     │
│ Services                    │
│ DAOs                        │
│ Entities / Mappers          │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│ File Persistence            │
│ ----------------------------│
│ books.txt                   │
│ users.txt                   │
│ borrowing_records.txt       │
└─────────────────────────────┘
```

The project is a **single Gradle module** with architectural separation implemented through packages.

---

## Project Structure

```text
src/main/kotlin/
│
├── Main.kt
│
├── domain/
│ ├── LibraryOperations.kt
│ ├── models/
│ │ ├── Book.kt
│ │ ├── User.kt
│ │ ├── Guest.kt
│ │ ├── Student.kt
│ │ ├── Faculty.kt
│ │ ├── UserType.kt
│ │ └── BorrowingRecord.kt
│ │
│ └── repositories/
│ ├── BookOperations.kt
│ ├── UserOperations.kt
│ └── BorrowingRecordOperations.kt
│
├── data/
│ ├── Library.kt
│ ├── daos/
│ │ ├── BookDao.kt
│ │ ├── UserDao.kt
│ │ └── BorrowingRecordDao.kt
│ ├── services/
│ │ ├── BookService.kt
│ │ ├── UserService.kt
│ │ └── BorrowingRecordService.kt
│ ├── entities/
│ │ ├── UserEntity.kt
│ │ └── BorrowingRecordEntity.kt
│ ├── mappers/
│ │ ├── UserMapper.kt
│ │ └── BorrowingRecordMapper.kt
│ └── di/
│ ├── LibraryComponent.kt
│ ├── LibraryModule.kt
│ ├── BookModule.kt
│ ├── UserModule.kt
│ └── BorrowingRecordModule.kt
│
└── presentation/
    ├── UserConsoleUI.kt
    └── Colors.kt
```

---

# Domain Layer

The domain contains the core models and abstractions of the application.

```text
domain/
│
├── LibraryOperations
│
├── models
│ ├── Book
│ ├── User
│ │ ├── Guest
│ │ ├── Student
│ │ └── Faculty
│ ├── UserType
│ └── BorrowingRecord
│
└── repositories
    ├── BookOperations
    ├── UserOperations
    └── BorrowingRecordOperations
```

The domain layer does not depend on the console UI or file storage.

---

# Data Layer

The data layer contains implementations of domain abstractions.

```text
              Domain Interfaces
                     │
        ┌────────────┼────────────┐
        ▼            ▼            ▼
   BookService UserService   BorrowingRecordService
        │            │            │
        ▼            ▼            ▼
    BookDao       UserDao    BorrowingRecordDao
```

### Library

`Library` is the main application facade.

It implements:

```text
LibraryOperations
```
```kotlin
interface LibraryOperations {
    // Book management
    fun addBooks(title: String, author: String, isbn: String, genre: String, amount: Int): Pair<Boolean, Book>
    fun removeAllBook(isbn: String)
    fun findBookByIsbn(isbn: String): Book
    fun reduceAmountBook(isbn: String, amount: Int): Pair<Boolean, Int>
    fun getAllBooks(): List<Book>
    fun findBookByAuthor(author: String): List<Book>
    fun findBookByTitle(title: String): List<Book>

    // User Management
    fun registerUser(name: String, email: String, userType: UserType): String // return back id
    fun findUser(userId: String): User
    fun getAllUsers(): List<User>

    // Borrowing operations
    fun borrowBook(userId: String, isbn: String)
    fun returnBook(userId: String, isbn: String)
    fun getOverdueBooksWithFine(): List<Pair<BorrowingRecord, Double>>
    fun borrowingRecordsWithThisBook(isbn: String): List<BorrowingRecord>
    fun getAllRecords(): List<BorrowingRecord>

    // File operations
    fun saveInFile()
}
```
and coordinates:

```text
BookOperations
UserOperations
BorrowingRecordOperations
```

This allows the UI to communicate with one main abstraction instead of accessing individual services or DAOs.

---

# Presentation Layer

The presentation layer contains the console interface.

```text
UserConsoleUI
      │
      ▼
LibraryOperations
      │
      ▼
    Library
```

`UserConsoleUI` is responsible for:

* displaying menus;
* reading user input;
* validating input;
* displaying results and errors.

Business logic is delegated to the domain/application layer.

---

# Dependency Injection

The project uses **Dagger**.

```text
                 LibraryComponent
                        │
        ┌───────────────┼────────────────┐
        ▼               ▼                ▼
  BookModule       UserModule   BorrowingRecordModule
        │               │                │
        ▼               ▼                ▼
 BookService       UserService  BorrowingRecordService
        │               │                │
        ▼               ▼                ▼
    BookDao        UserDao      BorrowingRecordDao
```

`LibraryModule` provides the `Library → LibraryOperations` binding.

Dagger creates the complete dependency graph at compile time.

---

# Domain Model

## User Hierarchy

```text
                 User
                  │
        ┌─────────┼─────────┐
        ▼         ▼         ▼
      Guest     Student   Faculty
```

The borrowing policy is defined by `UserType`:

```text
Guest
 ├─ max books: 1
 ├─ borrow period: 7 days
 └─ fine: 1.50/day

Student
 ├─ max books: 3
 ├─ borrow period: 14 days
 └─ fine: 0.50/day

Faculty
 ├─ max books: 10
 ├─ borrow period: 30 days
 └─ fine: 0.30/day
```

---

# Borrowing Flow

Borrowing a book is coordinated by `Library`:

```text
UserConsoleUI
      │
      ▼
borrowBook()
      │
      ├── Find User
      │
      ├── Find Book
      │
      ├── Check User Limit
      │
      ├── Check Book Availability
      │
      ├── Update User
      │
      ├── Decrease Book Copies
      │
      └── Create BorrowingRecord
```

The resulting relationship is:

```text
User
 │
 │ userId
 ▼
BorrowingRecord
 │
 │ isbn
 ▼
Book
```

---

# Return Flow

```text
returnBook()
      │
      ├── Find BorrowingRecord
      ├── Find User
      ├── Find Book
      ├── Delete BorrowingRecord
      ├── Return Book Copy
      └── Remove ISBN from User
```

This keeps the user, book, and borrowing data consistent.

---

# Persistence

The application uses JSON files for local persistence:

```text
┌───────────────┐
│ BookDao       │
└───────┬───────┘
        ▼
    books.txt


┌───────────────┐
│ UserDao       │
└───────┬───────┘
        ▼
    users.txt


┌───────────────────────┐
│ BorrowingRecordDao    │
└───────────┬───────────┘
            ▼
  borrowing_records.txt
```

Data is loaded into memory and saved back to the files explicitly.

`kotlinx.serialization` is used for JSON serialization.

---

# Entities and Mappers

Persistence models are separated from domain models:

```text
Domain Model
     │
     ▼
  Mapper
     │
     ▼
Persistence Entity
     │
     ▼
    JSON
```

For example:

```text
BorrowingRecord
      ↕
BorrowingRecordMapper
      ↕
BorrowingRecordEntity
      ↕
borrowing_records.txt
```

This keeps persistence-specific representations out of the domain layer.

---

# Application Startup

```text
Main.kt
   │
   ▼
DaggerLibraryComponent
   │
   ▼
Library
   │
   ▼
UserConsoleUI
   │
   ▼
libraryDialog()
```

Dagger constructs the dependency graph, after which the console application starts.

---

# Technology Stack

* **Kotlin/JVM**
* **Java 21**
* **Gradle**
* **Dagger 2**
* **kotlinx.serialization**
* **JUnit**
* **JSON file persistence**

---

# Architectural Summary

The overall dependency flow is:

```text
                    ┌───────────────┐
                    │ Main │
                    └───────┬───────┘
                            ▼
                    ┌───────────────┐
                    │ Dagger │
                    └───────┬───────┘
                            ▼
                    ┌───────────────┐
                    │ Library │
                    └───────┬───────┘
                            │
                            ▼
                    ┌───────────────┐
                    │ UserConsoleUI │
                    └───────┬───────┘
                            │
                            ▼
                  LibraryOperations
                            │
             ┌──────────────┼──────────────┐
             ▼              ▼              ▼
       BookService    UserService    BorrowingService
             │              │              │
             ▼              ▼              ▼
          BookDao        UserDao     BorrowingDao
             │              │              │
             ▼              ▼              ▼
        books.txt       users.txt  borrowing_records.txt
```

The main architectural principles are:

* **Separation of concerns**
* **Dependency inversion through interfaces**
* **Constructor dependency injection**
* **Domain/persistence model separation**
* **Centralized application orchestration**
* **Encapsulation of business rules**
* **Local persistence isolated inside the data layer**
