# Sorting Application

This project is a Java-based application that implements various sorting algorithms with binary search functionality. The application allows users to interactively fill an array of custom objects, sort the array using different algorithms, and search for elements in the sorted array. The project is structured for collaboration, adhering to Java conventions, and following clean architecture and design patterns.
## Features

* Interactive CLI: The program runs in a loop, where the user can:
    * Choose how to fill the array (from a file, randomly, or manually).
    - Set the length of the array.
    - Perform sorting and binary search on the array.
* Sorting Algorithms: Sorting is implemented using generic types to support custom classes. The following features are included:
    * Standard sorting algorithms (e.g., QuickSort, MergeSort).
    * Extended sorting with a custom rule for numeric fields: objects with even numbers are sorted in natural order, while those with odd numbers stay in place.
* Binary Search: After sorting, the user can search for elements using binary search implemented for generic classes.

* Custom Objects: Sorting is performed on custom objects, which:
    * Implement the Builder pattern.
    * Use generic types for flexibility.
* Strategy Pattern: The application leverages the Strategy design pattern to enable flexible sorting algorithm selection.
* Data Validation: Input data, including manual inputs and file data, are validated before processing.
