object LetterCounter {
  def countLetterOccurrences(words: List[String]): Int = {
    val wordLengths = words.map(_.length)
    val totalLetterCount = wordLengths.reduce(_ + _)
    return totalLetterCount
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val total = countLetterOccurrences(words)
    println("Total count of letter occurrences: "+total)
  }
}
