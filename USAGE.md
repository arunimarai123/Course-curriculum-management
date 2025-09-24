# Usage Guide

## Running the Application

### Windows (with batch file)
```cmd
cd CourseAndCurriculumManagementProject
run.bat
```

### Linux/Mac (manual)
```bash
cd CourseAndCurriculumManagementProject
mkdir -p bin
javac -d bin src/edu/ccrm/**/*.java src/edu/ccrm/**/**/*.java
java -cp bin edu.ccrm.cli.MainCLI
```

---

## Sample CLI Flow
```
--- Course and Curriculum Management ---
1) Manage Students
2) Manage Courses
3) Enroll Student to Course
4) List Students & Courses
0) Exit
```

- Press `1` → Add a student (enter ID, RegNo, name, email)
- Press `2` → Add a course (enter code, title, credits, instructor, semester)
- Press `3` → Enroll a student into a course
- Press `4` → View all students & courses
- Press `0` → Exit program

---

## Example Data
Located in `test-data/`:
- **students.csv**
- **courses.csv**
