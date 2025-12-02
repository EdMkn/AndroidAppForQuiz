package com.javaguiz.app

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

