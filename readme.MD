# Swift Playground to App Converter

This script converts a Swift Playground to an iOS App

## Usage

This is the first version of the program so it can only convert simple playgrounds right now that only contain Swift files and image files. First, the playground must be an Xcode playground. It can be made in Swift Playgrounds, but it must use an Xcode Playground template for the conversion to work.

Second, change the opening page in the playground to be named ContentView.

Third, take the playground file out of Swift Playgrounds and make sure it is named Playground.playground.

Forth, after downloading all of this projects files, place Playground.playground into the top level folder. Use `kotlinc main.kt -include-runtime -d main.jar` to compile and `java -jar main.jar`.

Fifth, within the XcodeProject folder should be a new folder called YourProject. YourProject will contain the Xcode project created from your playground. The last thing to do will be to open the project and add all of the Swift files to the projects. The images will automatically be included in the project.

## Screenshots and More Details

How to add the Swift files to Xcode:

Go to File, then to Add Files, then select the files you want and click add to project. 
![Screenshot showing how to add files to Xcode.](xcode1.png)
![Screenshot showing how to add files to Xcode.](xcode2.png)
