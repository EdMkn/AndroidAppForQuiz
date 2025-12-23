package com.javaguiz.app.data

/**
 * Repository class containing all quiz questions
 * Think of this as your data source (like a database or API in web dev)
 */
object QuestionBank {
    
    fun getAllQuestions(): List<Question> {
        return listOf(
            // Java 17 Questions
            Question(
                id = 1,
                questionText = "What is a sealed class in Java 17?",
                options = listOf(
                    "A class that cannot be instantiated",
                    "A class that restricts which classes can extend it",
                    "A class that is automatically serializable",
                    "A class that can only be used in interfaces"
                ),
                correctAnswerIndex = 1,
                explanation = "Sealed classes (and interfaces) restrict which other classes or interfaces may extend or implement them. This is a preview feature in Java 15 and became a standard feature in Java 17.",
                javaVersion = "17"
            ),
            Question(
                id = 2,
                questionText = "Which feature was finalized in Java 17?",
                options = listOf(
                    "Pattern matching for switch",
                    "Records",
                    "Text blocks",
                    "All of the above"
                ),
                correctAnswerIndex = 3,
                explanation = "Java 17 (LTS) finalized several features including Records, Pattern matching for switch, and Text blocks that were previously in preview.",
                javaVersion = "17"
            ),
            Question(
                id = 3,
                questionText = "What is the purpose of a record in Java 17?",
                options = listOf(
                    "To store database records",
                    "To create immutable data carriers with less boilerplate",
                    "To record method calls",
                    "To create audio recordings"
                ),
                correctAnswerIndex = 1,
                explanation = "Records are a special kind of class in Java that are designed to be transparent carriers for immutable data. They automatically generate constructors, getters, equals(), hashCode(), and toString().",
                javaVersion = "17"
            ),
            
            // Java 18 Questions
            Question(
                id = 4,
                questionText = "What is the Simple Web Server introduced in Java 18?",
                options = listOf(
                    "A full-featured web server like Tomcat",
                    "A minimal HTTP server for prototyping and testing",
                    "A web server for production use",
                    "A replacement for Apache HTTP Server"
                ),
                correctAnswerIndex = 1,
                explanation = "Java 18 introduced jwebserver, a simple command-line tool to start a minimal web server that serves static files. It's intended for prototyping, testing, and ad-hoc coding.",
                javaVersion = "18"
            ),
            Question(
                id = 5,
                questionText = "What does UTF-8 by default mean in Java 18?",
                options = listOf(
                    "All strings are UTF-8 encoded",
                    "The default charset for the standard Java APIs is UTF-8",
                    "Files are automatically saved as UTF-8",
                    "Network protocols use UTF-8"
                ),
                correctAnswerIndex = 1,
                explanation = "Java 18 changed the default charset for the standard Java APIs from the platform default to UTF-8, ensuring consistent behavior across different platforms.",
                javaVersion = "18"
            ),
            
            // Java 19 Questions
            Question(
                id = 6,
                questionText = "What are Virtual Threads (Project Loom) in Java 19?",
                options = listOf(
                    "Threads that run in virtual machines",
                    "Lightweight threads managed by the JVM",
                    "Threads that can only run virtual methods",
                    "Threads for virtual reality applications"
                ),
                correctAnswerIndex = 1,
                explanation = "Virtual threads are lightweight threads that are scheduled by the Java virtual machine rather than the operating system. They dramatically reduce the effort of writing, maintaining, and observing high-throughput concurrent applications.",
                javaVersion = "19"
            ),
            Question(
                id = 7,
                questionText = "What is Pattern Matching for switch expressions in Java 19?",
                options = listOf(
                    "Using regex patterns in switch",
                    "Matching patterns and extracting components in switch statements",
                    "Switching between design patterns",
                    "Pattern matching for file paths"
                ),
                correctAnswerIndex = 1,
                explanation = "Pattern matching for switch allows you to match patterns and extract components from objects directly in switch expressions and statements, making code more concise and readable.",
                javaVersion = "19"
            ),
            
            // Java 20 Questions
            Question(
                id = 8,
                questionText = "What is Scoped Values in Java 20?",
                options = listOf(
                    "Values scoped to a method",
                    "Immutable data that can be shared within and across threads",
                    "Values with limited visibility",
                    "Database scoped values"
                ),
                correctAnswerIndex = 1,
                explanation = "Scoped Values (preview) enable the sharing of immutable data within and across threads. They are preferred to thread-local variables, especially when using virtual threads.",
                javaVersion = "20"
            ),
            Question(
                id = 9,
                questionText = "What does Record Patterns allow in Java 20?",
                options = listOf(
                    "Pattern matching on record components",
                    "Recording method patterns",
                    "Patterns for database records",
                    "Recording design patterns"
                ),
                correctAnswerIndex = 0,
                explanation = "Record Patterns (preview) extend pattern matching to deconstruct record values, allowing you to match patterns and extract components from records directly.",
                javaVersion = "20"
            ),
            
            // Java 21 Questions
            Question(
                id = 10,
                questionText = "What is the main feature of Java 21 (LTS)?",
                options = listOf(
                    "Virtual threads are finalized",
                    "Pattern matching is finalized",
                    "Sequenced Collections are introduced",
                    "All of the above"
                ),
                correctAnswerIndex = 3,
                explanation = "Java 21 is an LTS release that finalizes Virtual Threads, Pattern Matching for switch, and introduces Sequenced Collections, among other features.",
                javaVersion = "21"
            ),
            Question(
                id = 11,
                questionText = "What are Sequenced Collections in Java 21?",
                options = listOf(
                    "Collections that can only store sequences",
                    "New interfaces for collections with a defined encounter order",
                    "Collections for DNA sequences",
                    "Collections that sequence operations"
                ),
                correctAnswerIndex = 1,
                explanation = "Sequenced Collections introduce new interfaces (SequencedSet, SequencedCollection, SequencedMap) that define collections with a well-defined encounter order, supporting operations at both ends.",
                javaVersion = "21"
            ),
            Question(
                id = 12,
                questionText = "What does String Templates (Preview) allow in Java 21?",
                options = listOf(
                    "Templating strings with placeholders",
                    "String interpolation with embedded expressions",
                    "Creating string templates from files",
                    "Template method pattern for strings"
                ),
                correctAnswerIndex = 1,
                explanation = "String Templates (preview) enable string interpolation by embedding expressions in template strings, making it easier to create strings that include computed values.",
                javaVersion = "21"
            ),
            
            // More Java 17-21 Questions
            Question(
                id = 13,
                questionText = "What is the instanceof pattern matching introduced in Java 17?",
                options = listOf(
                    "Using instanceof with type casting",
                    "Combining instanceof checks with variable binding",
                    "Pattern matching for instance variables",
                    "Matching instance methods"
                ),
                correctAnswerIndex = 1,
                explanation = "Pattern matching for instanceof allows you to combine type checking and variable binding in a single expression, eliminating the need for explicit casting after instanceof checks.",
                javaVersion = "17"
            ),
            Question(
                id = 14,
                questionText = "What is the Foreign Function & Memory API in Java 19?",
                options = listOf(
                    "API for foreign key constraints",
                    "API for calling native code and managing off-heap memory",
                    "API for foreign exchange rates",
                    "API for internationalization"
                ),
                correctAnswerIndex = 1,
                explanation = "The Foreign Function & Memory API (preview) enables Java programs to interoperate with code and data outside of the Java runtime, allowing calls to native libraries and management of native memory.",
                javaVersion = "19"
            ),
            Question(
                id = 15,
                questionText = "What does Structured Concurrency (Preview) provide in Java 19?",
                options = listOf(
                    "Structured programming for concurrency",
                    "A structured approach to managing multiple tasks running in different threads",
                    "Concurrency with data structures",
                    "Structured error handling for threads"
                ),
                correctAnswerIndex = 1,
                explanation = "Structured Concurrency (preview) provides a structured approach to managing multiple tasks running in different threads, treating groups of related tasks as a single unit of work.",
                javaVersion = "19"
            ),
            
            // Basics and Syntax
            Question(
                id = 16,
                questionText = "What is Java?",
                options = listOf(
                    "A low-level programming language",
                    "A high-level, object-oriented programming language designed to run on any platform",
                    "A database management system",
                    "A web browser"
                ),
                correctAnswerIndex = 1,
                explanation = "Java is a high-level, class-based, object-oriented programming language designed to have as few implementation dependencies as possible. It follows the 'write once, run anywhere' (WORA) principle.",
                javaVersion = "Core"
            ),
            Question(
                id = 17,
                questionText = "Explain the JDK, JRE, and JVM.",
                options = listOf(
                    "They are all the same thing",
                    "JDK contains JRE, JRE contains JVM. JDK is for development, JRE is for running applications, JVM executes bytecode",
                    "JVM is the largest, containing both JDK and JRE",
                    "They are unrelated components"
                ),
                correctAnswerIndex = 1,
                explanation = "JVM (Java Virtual Machine) executes Java bytecode. JRE (Java Runtime Environment) contains JVM plus libraries needed to run Java applications. JDK (Java Development Kit) contains JRE plus development tools like compiler and debugger.",
                javaVersion = "Core"
            ),
            Question(
                id = 18,
                questionText = "What are variables in Java?",
                options = listOf(
                    "Methods that store data",
                    "Containers for storing data values with a specific type",
                    "Classes that hold multiple values",
                    "Functions that return values"
                ),
                correctAnswerIndex = 1,
                explanation = "Variables are containers for storing data values. In Java, each variable must be declared with a data type that designates the type and quantity of value it can hold. Java is statically typed.",
                javaVersion = "Core"
            ),
            Question(
                id = 19,
                questionText = "What is typecasting in Java?",
                options = listOf(
                    "Converting a variable from one type to another",
                    "Creating new types",
                    "Type checking at runtime",
                    "Type erasure"
                ),
                correctAnswerIndex = 0,
                explanation = "Typecasting is the process of converting a variable from one type to another. Widening casting (implicit) converts smaller to larger types automatically. Narrowing casting (explicit) requires explicit conversion from larger to smaller types.",
                javaVersion = "Core"
            ),
            Question(
                id = 20,
                questionText = "How do you declare an array in Java?",
                options = listOf(
                    "array int[] = new int[10]",
                    "int[] myArray = new int[10]",
                    "int myArray = array[10]",
                    "new array int[10]"
                ),
                correctAnswerIndex = 1,
                explanation = "An array is declared using: type[] arrayName = new type[size]. For example: int[] myIntArray = new int[10] declares an array of integers with 10 elements.",
                javaVersion = "Core"
            ),
            Question(
                id = 21,
                questionText = "What is the signature of the main method in Java?",
                options = listOf(
                    "public void main(String[] args)",
                    "public static void main(String[] args)",
                    "static void main(String args)",
                    "public static main(String[] args)"
                ),
                correctAnswerIndex = 1,
                explanation = "The main method is the entry point for any Java program. It must be public (accessible), static (can be called without creating an object), void (returns nothing), and accept a String array as parameter.",
                javaVersion = "Core"
            ),
            Question(
                id = 22,
                questionText = "What are literals in Java?",
                options = listOf(
                    "Variables that cannot be changed",
                    "Fixed values assigned to variables, like 100, 'A', or \"Hello\"",
                    "Methods that return constant values",
                    "Classes that represent constants"
                ),
                correctAnswerIndex = 1,
                explanation = "Literals refer to the fixed values assigned to variables in Java. Examples include: 100 (integer), -90 (integer), 3.14F (float), 'A' (character), and \"Hello\" (string).",
                javaVersion = "Core"
            ),
            Question(
                id = 23,
                questionText = "What is a constructor in Java?",
                options = listOf(
                    "A method that returns a value",
                    "A block of code called when an instance of an object is created, with the same name as the class",
                    "A static method that initializes the class",
                    "A method that destroys objects"
                ),
                correctAnswerIndex = 1,
                explanation = "A constructor in Java is a block of code similar to a method that's called when an instance of an object is created. Unlike methods, constructors have no explicit return type and have the same name as the class itself.",
                javaVersion = "Core"
            ),
            Question(
                id = 24,
                questionText = "What is a package in Java?",
                options = listOf(
                    "A compressed file format",
                    "A namespace that organizes related classes and interfaces",
                    "A method for packaging applications",
                    "A deployment unit"
                ),
                correctAnswerIndex = 1,
                explanation = "A package in Java is a namespace that organizes a set of related classes and interfaces. Conceptually, you can think of packages as being similar to different folders on your computer.",
                javaVersion = "Core"
            ),
            
            // Object-Oriented Programming (OOP)
            Question(
                id = 25,
                questionText = "What is Object-Oriented Programming?",
                options = listOf(
                    "Programming with objects only",
                    "A programming paradigm based on objects containing data (fields) and code (methods)",
                    "Programming without classes",
                    "A database programming model"
                ),
                correctAnswerIndex = 1,
                explanation = "Object-oriented programming (OOP) is a programming paradigm based on the concept of 'objects', which can contain data in the form of fields (attributes or properties) and code in the form of procedures (methods).",
                javaVersion = "Core"
            ),
            Question(
                id = 26,
                questionText = "What are the main principles of OOP?",
                options = listOf(
                    "Variables, Methods, Classes, Objects",
                    "Encapsulation, Abstraction, Inheritance, Polymorphism",
                    "Public, Private, Protected, Static",
                    "Compile, Run, Debug, Deploy"
                ),
                correctAnswerIndex = 1,
                explanation = "The four main principles of OOP are: Encapsulation (binding data and methods, hiding implementation), Abstraction (hiding complexity, exposing simple interface), Inheritance (acquiring properties from parent class), and Polymorphism (one interface, multiple implementations).",
                javaVersion = "Core"
            ),
            Question(
                id = 27,
                questionText = "What is inheritance in Java?",
                options = listOf(
                    "Copying code from one class to another",
                    "A mechanism where one object acquires all properties and behaviors of a parent object",
                    "Sharing variables between classes",
                    "Importing classes from other packages"
                ),
                correctAnswerIndex = 1,
                explanation = "Inheritance in Java is a mechanism where one object acquires all the properties and behaviors of a parent object. It is an important part of OOPs (Object-Oriented programming systems) and promotes code reusability.",
                javaVersion = "Core"
            ),
            Question(
                id = 28,
                questionText = "What is an interface in Java?",
                options = listOf(
                    "A class that cannot be instantiated",
                    "A reference type similar to a class that contains only constants, method signatures, default methods, and static methods",
                    "A graphical user interface",
                    "A connection between two classes"
                ),
                correctAnswerIndex = 1,
                explanation = "An interface in Java is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. Interfaces cannot contain instance fields. Methods in interfaces are abstract by default.",
                javaVersion = "Core"
            ),
            Question(
                id = 29,
                questionText = "What is the difference between abstract classes and interfaces?",
                options = listOf(
                    "There is no difference",
                    "Abstract classes can have both abstract and non-abstract methods; interfaces typically contain abstract methods only (plus default/static from Java 8+)",
                    "Interfaces can be instantiated; abstract classes cannot",
                    "Abstract classes are faster than interfaces"
                ),
                correctAnswerIndex = 1,
                explanation = "Abstract classes can have both abstract and non-abstract methods and are used to provide a base for subclasses. Interfaces typically contain abstract methods only (though Java 8+ allows default and static methods). A class can implement multiple interfaces but extend only one class.",
                javaVersion = "Core"
            ),
            Question(
                id = 30,
                questionText = "What is polymorphism in Java?",
                options = listOf(
                    "Having multiple variables with the same name",
                    "The ability of an object to take on many forms, often when a parent class reference refers to a child class object",
                    "Having multiple classes with the same name",
                    "Using multiple inheritance"
                ),
                correctAnswerIndex = 1,
                explanation = "Polymorphism in Java is the ability of an object to take on many forms. Most commonly, it is when a parent class reference is used to refer to a child class object. This allows one interface to be used for a general class of actions.",
                javaVersion = "Core"
            ),
            Question(
                id = 31,
                questionText = "What is method overriding?",
                options = listOf(
                    "Having multiple methods with the same name but different parameters",
                    "A subclass providing a specific implementation of a method already provided by its superclass",
                    "Calling a method multiple times",
                    "Overloading a method with too many parameters"
                ),
                correctAnswerIndex = 1,
                explanation = "Method overriding, in object-oriented programming, is a language feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its superclasses or parent classes.",
                javaVersion = "Core"
            ),
            Question(
                id = 32,
                questionText = "What is method overloading?",
                options = listOf(
                    "A subclass providing a different implementation of a method",
                    "A feature allowing a class to have multiple methods with the same name but different parameter lists",
                    "Calling a method recursively",
                    "Making a method too complex"
                ),
                correctAnswerIndex = 1,
                explanation = "Method overloading is a feature that allows a class to have more than one method having the same name, if their parameter lists are different. It is related to compile-time (or static) polymorphism.",
                javaVersion = "Core"
            ),
            
            // String, StringBuilder, StringBuffer
            Question(
                id = 33,
                questionText = "What is the difference between String, StringBuilder, and StringBuffer?",
                options = listOf(
                    "They are all the same",
                    "String is immutable; StringBuilder is mutable and not thread-safe; StringBuffer is mutable and thread-safe",
                    "StringBuffer is immutable; StringBuilder is thread-safe",
                    "String is mutable; StringBuilder and StringBuffer are immutable"
                ),
                correctAnswerIndex = 1,
                explanation = "String is immutable - once created, its value cannot be changed. StringBuilder is mutable and not thread-safe, making it faster for single-threaded operations. StringBuffer is mutable and thread-safe due to synchronized methods, but slower than StringBuilder.",
                javaVersion = "Core"
            ),
            Question(
                id = 34,
                questionText = "What is the difference between == and .equals() in Java?",
                options = listOf(
                    "They are the same",
                    "== compares references; .equals() compares content/values (when overridden)",
                    "== compares values; .equals() compares references",
                    "== is for primitives; .equals() is for objects"
                ),
                correctAnswerIndex = 1,
                explanation = "The == operator compares references, checking if two references point to the same object. The .equals() method compares the content of objects for equality. The default implementation compares references, but many classes override it to compare values.",
                javaVersion = "Core"
            ),
            Question(
                id = 35,
                questionText = "What is the purpose of the final keyword in Java?",
                options = listOf(
                    "To mark the last element in a collection",
                    "final variable: cannot be changed; final method: cannot be overridden; final class: cannot be subclassed",
                    "To indicate the end of a program",
                    "To make variables public"
                ),
                correctAnswerIndex = 1,
                explanation = "The final keyword has different meanings: final variable - value cannot be changed once assigned; final method - cannot be overridden by subclasses; final class - cannot be subclassed (extended).",
                javaVersion = "Core"
            ),
            
            // Exception Handling
            Question(
                id = 36,
                questionText = "What is an exception in Java?",
                options = listOf(
                    "A compile-time error",
                    "An event that disrupts the normal flow of the program's instructions",
                    "A warning message",
                    "A syntax error"
                ),
                correctAnswerIndex = 1,
                explanation = "An exception is an event that disrupts the normal flow of the program's instructions. When an exception occurs, an exception object is created and thrown in the method that caused it.",
                javaVersion = "Core"
            ),
            Question(
                id = 37,
                questionText = "What is the difference between checked and unchecked exceptions?",
                options = listOf(
                    "There is no difference",
                    "Checked exceptions must be handled at compile time; unchecked exceptions (RuntimeException) don't need to be declared",
                    "Unchecked exceptions must be handled; checked exceptions don't",
                    "Checked exceptions are errors; unchecked are warnings"
                ),
                correctAnswerIndex = 1,
                explanation = "Checked exceptions must be caught or declared in the method signature using throws. They are checked at compile time. Unchecked exceptions (RuntimeException and its subclasses) don't need to be declared and are checked at runtime.",
                javaVersion = "Core"
            ),
            Question(
                id = 38,
                questionText = "What is the try-catch-finally block?",
                options = listOf(
                    "A loop structure",
                    "A mechanism to handle exceptions: try (code that may throw), catch (handle exception), finally (always executes)",
                    "A conditional statement",
                    "A method declaration"
                ),
                correctAnswerIndex = 1,
                explanation = "The try-catch-finally block is used for exception handling. The try block contains code that might throw an exception. The catch block handles the exception. The finally block always executes, whether an exception occurs or not.",
                javaVersion = "Core"
            ),
            Question(
                id = 39,
                questionText = "What is the throw keyword used for?",
                options = listOf(
                    "To throw away code",
                    "To explicitly throw an exception",
                    "To catch exceptions",
                    "To ignore exceptions"
                ),
                correctAnswerIndex = 1,
                explanation = "The throw keyword is used to explicitly throw an exception. You can throw either checked or unchecked exceptions. The throw statement requires a single argument: a throwable object.",
                javaVersion = "Core"
            ),
            Question(
                id = 40,
                questionText = "What is the throws keyword used for?",
                options = listOf(
                    "To throw an exception",
                    "To declare that a method might throw an exception",
                    "To catch an exception",
                    "To ignore exceptions"
                ),
                correctAnswerIndex = 1,
                explanation = "The throws keyword is used in a method signature to declare that the method might throw one or more exceptions. It's used for checked exceptions that the method doesn't handle itself.",
                javaVersion = "Core"
            ),
            
            // Collections - List
            Question(
                id = 41,
                questionText = "What is the List interface in Java?",
                options = listOf(
                    "A class for storing arrays",
                    "Part of the Collections Framework representing an ordered collection (sequence) with index-based access",
                    "A method for listing files",
                    "A database table"
                ),
                correctAnswerIndex = 1,
                explanation = "The List interface is part of the Java Collections Framework and represents an ordered collection (also known as a sequence). The user can access elements by their integer index (position in the list), and search for elements in the list.",
                javaVersion = "Core"
            ),
            Question(
                id = 42,
                questionText = "What is the difference between ArrayList and LinkedList?",
                options = listOf(
                    "They are the same",
                    "ArrayList uses dynamic array (fast random access, slow insertions/deletions); LinkedList uses doubly-linked list (fast insertions/deletions, slow random access)",
                    "LinkedList is faster for all operations",
                    "ArrayList cannot store objects"
                ),
                correctAnswerIndex = 1,
                explanation = "ArrayList is a resizable-array implementation best for storing and accessing data. LinkedList is a doubly-linked list implementation better for operations that require frequent addition and removal of elements from any part of the list.",
                javaVersion = "Core"
            ),
            Question(
                id = 43,
                questionText = "What are Vector and Stack classes?",
                options = listOf(
                    "They don't exist in Java",
                    "Vector is similar to ArrayList but synchronized; Stack extends Vector with stack operations",
                    "They are the same as ArrayList",
                    "Vector is for graphics; Stack is for networking"
                ),
                correctAnswerIndex = 1,
                explanation = "Vector is similar to ArrayList, but it is synchronized (thread-safe). Stack extends Vector with five operations that allow a vector to be treated as a stack (LIFO - Last In First Out).",
                javaVersion = "Core"
            ),
            Question(
                id = 44,
                questionText = "What is the difference between Iterator and ListIterator?",
                options = listOf(
                    "They are the same",
                    "Iterator traverses forward only; ListIterator can traverse both directions, modify list, and get current position",
                    "ListIterator is only for arrays",
                    "Iterator is faster than ListIterator"
                ),
                correctAnswerIndex = 1,
                explanation = "Iterator can traverse the list in the forward direction only. ListIterator can traverse the list in either direction, modify the list during iteration, and obtain the iterator's current position in the list.",
                javaVersion = "Core"
            ),
            
            // Concurrency
            Question(
                id = 45,
                questionText = "What is a thread in Java?",
                options = listOf(
                    "A type of variable",
                    "A lightweight process that allows concurrent execution of multiple parts of a program",
                    "A collection class",
                    "A method modifier"
                ),
                correctAnswerIndex = 1,
                explanation = "A thread is a lightweight process that allows concurrent execution of multiple parts of a program. Threads share the same memory space, making communication between threads easier than between processes.",
                javaVersion = "Core"
            ),
            Question(
                id = 46,
                questionText = "What is the difference between Thread and Runnable?",
                options = listOf(
                    "They are the same",
                    "Thread is a class; Runnable is an interface. Runnable is preferred as Java doesn't support multiple inheritance",
                    "Runnable is a class; Thread is an interface",
                    "Thread is faster than Runnable"
                ),
                correctAnswerIndex = 1,
                explanation = "Thread is a class that implements Runnable. Runnable is an interface with a single run() method. Using Runnable is preferred because Java doesn't support multiple inheritance, so if you extend Thread, you can't extend another class.",
                javaVersion = "Core"
            ),
            Question(
                id = 47,
                questionText = "What is synchronization in Java?",
                options = listOf(
                    "Making code run faster",
                    "A mechanism that ensures only one thread can access a shared resource at a time",
                    "Synchronizing with a database",
                    "Making methods static"
                ),
                correctAnswerIndex = 1,
                explanation = "Synchronization is a mechanism that ensures only one thread can access a shared resource at a time. It prevents thread interference and consistency problems. It can be achieved using synchronized methods or synchronized blocks.",
                javaVersion = "Core"
            ),
            Question(
                id = 48,
                questionText = "What is the difference between wait() and sleep()?",
                options = listOf(
                    "They are the same",
                    "wait() releases the lock and is called on an object; sleep() doesn't release the lock and is called on Thread",
                    "sleep() releases the lock; wait() doesn't",
                    "wait() is for threads; sleep() is for processes"
                ),
                correctAnswerIndex = 1,
                explanation = "wait() is called on an object and releases the lock, allowing other threads to acquire it. sleep() is called on Thread and doesn't release any locks. wait() must be called from a synchronized context.",
                javaVersion = "Core"
            ),
            
            // Stream API
            Question(
                id = 49,
                questionText = "What is the Stream API in Java 8?",
                options = listOf(
                    "A way to read files",
                    "A sequence of elements supporting sequential and parallel aggregate operations",
                    "A networking API",
                    "A database streaming API"
                ),
                correctAnswerIndex = 1,
                explanation = "The Stream API in Java 8 provides a functional approach to processing collections of objects. It allows you to perform operations like filter, map, reduce, etc., on collections in a declarative way.",
                javaVersion = "8"
            ),
            Question(
                id = 50,
                questionText = "What is the difference between intermediate and terminal operations in Stream API?",
                options = listOf(
                    "They are the same",
                    "Intermediate operations return streams and are lazy; terminal operations produce results and trigger execution",
                    "Terminal operations return streams; intermediate operations produce results",
                    "Intermediate operations are faster"
                ),
                correctAnswerIndex = 1,
                explanation = "Intermediate operations (like filter, map) return a stream and are lazy - they don't execute until a terminal operation is called. Terminal operations (like collect, forEach) produce a result and trigger the execution of the stream pipeline.",
                javaVersion = "8"
            ),
            Question(
                id = 51,
                questionText = "What is the reduce operation in Stream API?",
                options = listOf(
                    "Reducing the size of a collection",
                    "Combining all elements of a stream into a single result using a binary operator",
                    "Removing elements from a stream",
                    "Reducing memory usage"
                ),
                correctAnswerIndex = 1,
                explanation = "The reduce operation combines all elements of the stream into a single result by applying a binary operator. This operation takes two parameters: an initial value (optional), and a binary operator function.",
                javaVersion = "8"
            ),
            
            // JDBC
            Question(
                id = 52,
                questionText = "What is JDBC?",
                options = listOf(
                    "A Java database",
                    "Java Database Connectivity - an API that enables Java programs to execute SQL statements",
                    "A Java development tool",
                    "A Java compiler"
                ),
                correctAnswerIndex = 1,
                explanation = "JDBC (Java Database Connectivity) is an API that enables Java programs to execute SQL statements. This allows Java applications to interact with any SQL-compliant database.",
                javaVersion = "Core"
            ),
            Question(
                id = 53,
                questionText = "What are the core components of JDBC?",
                options = listOf(
                    "Classes and methods only",
                    "DriverManager, Driver, Connection, Statement, ResultSet, and SQLException",
                    "Only Connection and Statement",
                    "Database and tables"
                ),
                correctAnswerIndex = 1,
                explanation = "The core components of JDBC include DriverManager (manages database drivers), Driver (interface for database drivers), Connection (represents a connection to a database), Statement (executes SQL queries), ResultSet (represents query results), and SQLException (handles database errors).",
                javaVersion = "Core"
            ),
            Question(
                id = 54,
                questionText = "What is the difference between Statement and PreparedStatement?",
                options = listOf(
                    "They are the same",
                    "Statement is for simple queries with no parameters; PreparedStatement is for parameterized queries and better performance",
                    "PreparedStatement is simpler than Statement",
                    "Statement is only for SELECT queries"
                ),
                correctAnswerIndex = 1,
                explanation = "Statement is used to execute a simple SQL query with no parameters. PreparedStatement is used for executing SQL statements multiple times or when you need to bind parameters to the query. PreparedStatement is precompiled and offers better performance and security.",
                javaVersion = "Core"
            ),
            Question(
                id = 55,
                questionText = "What is ResultSet in JDBC?",
                options = listOf(
                    "A database table",
                    "A table of data representing a database result set generated by executing a query",
                    "A SQL statement",
                    "A database connection"
                ),
                correctAnswerIndex = 1,
                explanation = "ResultSet is a table of data representing a database result set, which is generated by executing a statement that queries the database. It provides methods to navigate through the rows and retrieve column values.",
                javaVersion = "Core"
            ),
            Question(
                id = 56,
                questionText = "What is Connection Pooling?",
                options = listOf(
                    "A pool of database tables",
                    "A technique to improve performance by reusing database connections instead of creating new ones",
                    "A way to store connections in a pool",
                    "A database backup method"
                ),
                correctAnswerIndex = 1,
                explanation = "Connection pooling is a technique used to improve performance in applications that need to make calls to a database by reusing the connections instead of creating a new one each time. This reduces overhead and improves response time.",
                javaVersion = "Core"
            ),
            
            // Additional Core Java Questions
            Question(
                id = 57,
                questionText = "What are primitive data types in Java?",
                options = listOf(
                    "int, float, String, Object",
                    "byte, short, int, long, float, double, char, boolean - basic types that store actual values",
                    "ArrayList, HashMap, String",
                    "Classes and interfaces"
                ),
                correctAnswerIndex = 1,
                explanation = "Primitive data types are the basic types: byte, short, int, long, float, double, char, and boolean. They store actual values (not references) and use less memory than objects. They cannot be null.",
                javaVersion = "Core"
            ),
            Question(
                id = 58,
                questionText = "What is the difference between primitives and objects in Java?",
                options = listOf(
                    "There is no difference",
                    "Primitives store values and use less memory; objects store references, use more memory, can be null, and have methods",
                    "Objects are faster than primitives",
                    "Primitives can have methods"
                ),
                correctAnswerIndex = 1,
                explanation = "Primitives store actual values and use less memory. Objects store references to memory locations, use more memory, can be null, and have methods. Primitives are generally faster to access and manipulate.",
                javaVersion = "Core"
            ),
            Question(
                id = 59,
                questionText = "What is garbage collection in Java?",
                options = listOf(
                    "Manual memory management",
                    "Automatic memory management that reclaims memory occupied by objects that are no longer in use",
                    "Collecting unused code",
                    "A database operation"
                ),
                correctAnswerIndex = 1,
                explanation = "Garbage collection is the automatic memory management process in Java. The JVM automatically identifies and removes objects that are no longer referenced, freeing up memory. Developers don't need to manually deallocate memory.",
                javaVersion = "Core"
            ),
            Question(
                id = 60,
                questionText = "What is the static keyword in Java?",
                options = listOf(
                    "A method that cannot be changed",
                    "A keyword that makes a member belong to the class rather than instances, shared across all instances",
                    "A constant value",
                    "A method modifier for speed"
                ),
                correctAnswerIndex = 1,
                explanation = "The static keyword makes a member (variable or method) belong to the class rather than to instances of the class. Static members are shared across all instances and can be accessed without creating an object.",
                javaVersion = "Core"
            ),
            Question(
                id = 61,
                questionText = "What is the this keyword in Java?",
                options = listOf(
                    "A reference to another object",
                    "A reference to the current object instance",
                    "A method name",
                    "A class name"
                ),
                correctAnswerIndex = 1,
                explanation = "The 'this' keyword is a reference to the current object instance. It can be used to refer to instance variables, call other constructors, or pass the current object as a parameter.",
                javaVersion = "Core"
            ),
            Question(
                id = 62,
                questionText = "What are access modifiers in Java?",
                options = listOf(
                    "public, private, protected, default - they control the visibility and accessibility of classes, methods, and variables",
                    "static, final, abstract",
                    "int, String, boolean",
                    "try, catch, finally"
                ),
                correctAnswerIndex = 0,
                explanation = "Access modifiers control the visibility and accessibility of classes, methods, and variables. public (accessible everywhere), private (only within the class), protected (within package and subclasses), and default/package-private (within the same package).",
                javaVersion = "Core"
            ),
            Question(
                id = 63,
                questionText = "What is the super keyword in Java?",
                options = listOf(
                    "A method that is superior",
                    "A reference to the parent class, used to access parent class members and call parent class constructors",
                    "A class modifier",
                    "A variable type"
                ),
                correctAnswerIndex = 1,
                explanation = "The 'super' keyword is a reference to the parent class. It can be used to access parent class members (variables and methods), call parent class constructors, and distinguish between parent and child class members with the same name.",
                javaVersion = "Core"
            ),
            Question(
                id = 64,
                questionText = "What is autoboxing and unboxing in Java?",
                options = listOf(
                    "Packing and unpacking boxes",
                    "Automatic conversion between primitive types and their corresponding wrapper classes",
                    "Converting between different number types",
                    "A database operation"
                ),
                correctAnswerIndex = 1,
                explanation = "Autoboxing is the automatic conversion of primitive types to their corresponding wrapper class objects (e.g., int to Integer). Unboxing is the automatic conversion of wrapper class objects to their primitive types (e.g., Integer to int).",
                javaVersion = "Core"
            ),
            Question(
                id = 65,
                questionText = "What is a wrapper class in Java?",
                options = listOf(
                    "A class that wraps other classes",
                    "A class that wraps a primitive type in an object (e.g., Integer, Double, Boolean)",
                    "A class for packaging",
                    "A container class"
                ),
                correctAnswerIndex = 1,
                explanation = "Wrapper classes are classes that wrap primitive types in objects. Examples include Integer (for int), Double (for double), Boolean (for boolean), Character (for char), etc. They allow primitives to be used in contexts that require objects.",
                javaVersion = "Core"
            )
        )
    }
    
    /**
     * Get a random subset of questions for a quiz
     */
    fun getRandomQuestions(count: Int): List<Question> {
        val allQuestions = getAllQuestions()
        return allQuestions.shuffled().take(count)
    }
}

