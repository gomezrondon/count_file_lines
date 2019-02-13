import java.io.File

fun main(args : Array<String>) {
    val measureTimeMillis = kotlin.system.measureTimeMillis {
        var stashName = args[0].toLowerCase()
    //Calculation
      val fileCounts = File(stashName).walk()
                .filter { it.isFile }
                .map { Pair(it.name, it.readLines().count()) }

    //Presentation
        val size = fileCounts.map { it.first.length }.max()

        var repeatNum = size;
        println("File"+ repeatNum?.let { " ".repeat(it) } +"count")
        println("===="+ repeatNum?.let { "=".repeat(it) } +"=====")

        for ((name, count) in fileCounts) {
            repeatNum = size?.minus(name.length);
            System.out.printf("%s " + repeatNum?.let { " ".repeat(it) } + " %5d\n", name, count)
        }
    }
    println("\n total time:$measureTimeMillis milliseconds")
}

// java -jar count_file_lines.jar "C:\temp\compose\java"