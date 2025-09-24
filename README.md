# Course and Curriculum Management Project (Course and Curriculum Management)

## 📖 Overview
Course and Curriculum Management is a **console-based Java SE application** that simulates a campus course and student records management system.  
It demonstrates key Java concepts such as **OOP (Encapsulation, Inheritance, Abstraction, Polymorphism)**,  
exception handling, enums, streams, lambdas, recursion, Singleton & Builder patterns, and file I/O with NIO.2.

---

## ✨ Features
- **Student Management**: add, update, deactivate, list, and print student profiles.
- **Course Management**: add, update, deactivate, search, and filter courses.
- **Enrollment & Grading**: enroll students, record grades, compute GPA, and generate transcripts.
- **File Utilities**: import/export CSV data, backup files with timestamps, recursive file utilities.
- **Menu-driven CLI**: simple console interface to navigate operations.

---

## 📂 Project Structure
```
Course and Curriculum ManagementProject_Full/
 ├─ src/edu/ccrm/
 │   ├─ cli/            # CLI menu and Main class
 │   ├─ config/         # Singleton AppConfig
 │   ├─ domain/         # Core entities: Student, Course, Enrollment, Enums
 │   ├─ service/        # Service layer for business logic
 │   ├─ io/             # Import/Export and Backup utilities
 │   ├─ util/           # Validators, Comparators, Recursion utils
 │   └─ exception/      # Custom exceptions
 ├─ test-data/          # Example CSV files for import/export
 ├─ README.md           # Project documentation
 ├─ USAGE.md            # How to run and example usage
 ├─ CONTRIBUTING.md     # Contribution guidelines
 ├─ LICENSE             # Open-source license (MIT)
 └─ run.bat         # Windows helper script (compile & run)
```

---

## 🚀 Getting Started

### Requirements
- **Java JDK 17+** (check with `java -version`)
- (Optional) Eclipse IDE or IntelliJ IDEA

### Compile & Run (Windows)
```cmd
cd Course and Curriculum ManagementProject_Full
runCourse and Curriculum Management.bat
```

### Compile & Run (Linux/Mac)
```bash
cd Course and Curriculum ManagementProject_Full
mkdir -p bin
javac -d bin src/edu/ccrm/**/*.java src/edu/ccrm/**/**/*.java
java -cp bin edu.ccrm.cli.MainCLI
```

---

## 📚 Java Concepts Demonstrated
| Concept                | Where Implemented |
|-------------------------|-------------------|
| Encapsulation          | `Student.java`, `Course.java` |
| Inheritance            | `Person.java` → `Student.java` |
| Abstraction            | `Person.java` (abstract class) |
| Polymorphism           | `TranscriptService.java` |
| Immutability           | `CourseCode.java` |
| Nested Classes         | `Course.Builder` |
| Interfaces & Lambdas   | Comparator lambdas in utilities |
| Singleton Pattern      | `AppConfig.java` |
| Builder Pattern        | `Course.java` |
| Exception Handling     | `DuplicateEnrollmentException.java`, `MaxCreditLimitExceededException.java` |
| Streams API            | Planned in reports & filtering |
| Date/Time API          | Used in enrollments, backups |

---

## 📊 Demo Flow
1. Start the CLI → `MainCLI.java`.
2. Menu options:
   - Manage Students
   - Manage Courses
   - Enroll Student
   - Record Grades
   - Import/Export Data
   - Backup Data
   - Reports (GPA distribution)
   - Exit
3. Perform operations and view data interactively.

---

## 📜 License
This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Contributions
Pull requests are welcome. For major changes, open an issue first to discuss what you’d like to change.  
See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

