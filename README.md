# AutoCADDrawingChecker
A simple, extendable Java program used to compare vector exports from AutoCAD.

## Project Summary

## How to Use the Application
The application is stored in the JAR file under ```/build/libs/AutoCADDrawingChecker.jar```.
This file is a self-contained application, so you can move it wherever you want on your computer:
it doesn't rely on the other project files to run. Simply double-click the JAR file to run it.
### Steps
* Step 1: Choosing instructor and student files. The first page of the application has you choose at least 2 files: 
the instructor file, and 1 or more student files. The instructor file is what the student files will be graded on: 
The more similar their file is to the instructor file, the higher their grade will be. When selecting student files, you have several options:
    * Choose 1 or more Excel files
    * Choose 1 or more folders. Note that the program locates all Excel files under this folder, so it's OK if it has other files in there, the program will just ignore them.
    * A combination of the above.
* Step 2: Choosing Grading Criteria. You can choose what the program grades students on by toggling these check boxes on or off.
* Step 3: Running the Autograder. Once the program is done grading, it will ask you where you want to save the grading report. 
The program automatically adds an xlsx extension if you don't provide one, so no need to worry about that.

## To Do
* Make AutoCADExcelParser easier to work with and extend. 
  Maybe have an ElementLoader which checks if it has an element type for each element name
* see AutoCADElementMatcher
* Should we match rows for each comparison, or for the export as a whole?

## Helpful Links
* [Excel Library](https://poi.apache.org/apidocs/4.1/)