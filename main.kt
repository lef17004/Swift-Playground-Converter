package com.zetcode
import java.io.File

fun main() {

  /***************************************
  * If Xcode project already exists, delete it.
  * Copies an empty SwiftUI project. */

  if (File("XcodeProject").exists()) {
    File("XcodeProject").deleteRecursively()
  }

  File("YourProject").walk().forEach {
    it.copyTo(File("XcodeProject/$it"), true)
  }
  //*****************************************


  //Copies and names all of the swift files from the playground
    File("Playground.playground").walk().forEach {
        if (it.extension == "swift") {
          var path: String = it.path
          path = path.replace("Playground.playground/Pages/", "")
          path = path.replace(".xcplaygroundpage/Contents.swift", "")
          it.copyTo(File("XcodeProject/YourProject/YourProject/$path.swift"), true)
        }

    }

    //Modifies the ContentView Class to work with Xcode.
    var contentView = File("XcodeProject/YourProject/YourProject/ContentView.swift").readText()
    contentView = contentView.replace("import PlaygroundSupport", "")
    contentView = contentView.replace("PlaygroundPage.current.setLiveView(ContentView())", "")
    contentView = contentView + "struct ContentView_Previews: PreviewProvider {\n\tstatic var previews: some View {\n\t\tContentView()\n\t}\n}"
    File("XcodeProject/YourProject/YourProject/ContentView.swift").writeText(contentView)

    //Copies images into Xcode project
    File("Playground.playground/Resources/").walk().forEach {
      if (File("Playground.playground/Resources/") != it) {

        val fileName = it.name

        val folderName = it.nameWithoutExtension + ".imageset"
        it.copyTo(File("XcodeProject/YourProject/YourProject/Assets.xcassets/$folderName/$fileName"))
        File("XcodeProject/YourProject/YourProject/Assets.xcassets/$folderName/Contents.json").createNewFile()
        File("XcodeProject/YourProject/YourProject/Assets.xcassets/$folderName/Contents.json").writeText("{\"images\" : [{\"filename\" : \"$fileName\",\"idiom\" : \"universal\",\"scale\" : \"1x\"},{\"idiom\" : \"universal\",\"scale\" : \"2x\"},{\"idiom\" : \"universal\",\"scale\" : \"3x\"}],\"info\" : {\"author\" : \"xcode\",\"version\" : 1}}")

      }

    }
    println("Convertion Complete.")




}
