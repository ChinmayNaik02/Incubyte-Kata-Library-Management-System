# Kata: Library Management System
This project is a simple Library Management System developed as part of an assessment for Incubyte. The system allows users to perform basic library operations such as adding books, borrowing books, returning books, and viewing available books. The project follows Test-Driven Development (TDD) practices, focusing on writing clean, maintainable code.

## Table of Contents
- [Objective](#objective)
- [Requirements](#requirements)
- [Instructions](#instructions)
- [Setup Instructions](#setup-instructions)
  - [Prerequisites](#prerequisites)
  - [Steps to setup project on your device](#steps-to-setup-project-on-your-device)
- [Test Coverage](#test-coverage)
- [References](#references)
- [Acknowledgments](#acknowledgments)

## Objective
Create a simple library management system that allows users to perform basic operations such as adding books, borrowing books, returning books, and viewing available books.

## Requirements
- **Add Books**:
  - Users should be able to add new books to the library.
  - Each book should have a unique identifier (e.g., ISBN), title, author, and publication year.

- **Borrow Books**:
  - Users should be able to borrow a book from the library.
  - The system should ensure that the book is available before allowing it to be borrowed.
  - If the book is not available, the system should raise an appropriate error.

- **Return Books**:
  - Users should be able to return a borrowed book.
  - The system should update the availability of the book accordingly.

- **View Available Books**:
  - Users should be able to view a list of all available books in the library.
 
## Instructions
- **Code Only**:
  - This is a code-only kata. Focus on writing clean, maintainable code and implementing the required features. Do not spend time creating any user interface.

- **Test-Driven Development (TDD)**:
  - Write tests before implementing the functionality. Follow the three laws of TDD
  - Ensure that all tests pass before considering the implementation complete.
  - Aim for high test coverage and meaningful test cases.
  - Clean Coding Practices:
  - Write clean, readable, and maintainable code.
  - Follow SOLID principles and other best practices in software design.
  - Ensure the code is well-documented with meaningful comments and clear variable/method names.
 
- **Clean Coding Practices**:
  - Write clean, readable, and maintainable code.
  - Follow SOLID principles and other best practices in software design.
  - Ensure the code is well-documented with meaningful comments and clear variable/method names.

- **Git Usage**:
  - Use Git for version control.
  - Create a Git repository for your project.
  - Commit your changes frequently with meaningful commit messages to show your TDD journey.
  - Push your code to a remote repository (e.g., GitHub, GitLab, Bitbucket) and share the repository link.

## Setup Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 11 or later is installed on your machine.
- **Maven**: Ensure Maven is installed for managing dependencies and building the project.

### Steps to setup project on your device

1. Open your terminal or command prompt.
2. Run the following command to clone the repository:

    ```bash
    git clone https://github.com/ChinmayNaik02/Incubyte-Kata-Library-Management-System.git
    ```

3. Navigate into the project directory:

    ```bash
    cd Incubyte-Kata-Library-Management-System
    ```

4. Launch IntelliJ IDEA on your machine.
    - Click on `Open` from the IntelliJ IDEA welcome screen.
    - Navigate to the directory where you cloned the project.
    - Select the root folder of the project (e.g., `library-management-system`) and click `OK`.

5. **Import as Maven Project:**
   - If IntelliJ IDEA detects a Maven project, it will prompt you to import it. Make sure to select `Import as Maven Project`.
   - If not prompted, right-click on the `pom.xml` file and select `Add as Maven Project`.

6. **Build the Project:**
   - Once the project is imported, IntelliJ IDEA will automatically start downloading the necessary dependencies.
   - Wait for the process to complete, and then go to `Build` > `Build Project` to ensure that everything is set up correctly.

7. **Run All Tests:**
   - Navigate to the `src/test/java` directory in the Project Explorer.
   - Right-click on the `com.chinmay.library` package and select `Run 'All Tests'` to run all the test cases.
   - Alternatively, you can run the tests by navigating to `Run` > `Run...` and selecting the test configuration.
  
8. **Run with Test Coverage:**
   - To see how much of your code is covered by the tests, you can run the tests with coverage.
   - Right-click on the `com.chinmay.library` package or individual test classes and select `Run 'All Tests' with Coverage`.

9. **View Coverage Results:**
   - The coverage results will be displayed in the Coverage tab, highlighting which parts of your code are covered by tests.

## Test Coverage

The test coverage of this project is **100%** currently.

![Test Coverage Screenshot](https://github.com/ChinmayNaik02/Incubyte-Kata-Library-Management-System/blob/main/assets/Test-Coverage-Report.png)

## References
- [The Three Laws of TDD - Uncle Bob](https://www.youtube.com/watch?v=qkblc5WRn-U)
- [The Librarian: Introduction to Test-Driven Development](https://tedvinke.wordpress.com/2016/06/25/the-librarian-introduction-to-test-driven-development/)

## Acknowledgments
I would like to express my gratitude to **Incubyte** for providing this opportunity and for the chance to showcase my skills through this assessment. This project was a valuable experience, and I sincerely appreciate the guidance and support throughout the process.

Thank you, Incubyte!
