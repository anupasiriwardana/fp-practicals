import scala.io.StdIn._

object StudentRecords{

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    val (name, marks, totalMarks) = getStudentInfoWithRetry();
    val percentage = calculatePercentage(marks, totalMarks);
    val grade = assignGrade(percentage);
    return (name, marks, totalMarks, percentage, grade);
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println("Name: "+name)
    println("Marks: "+marks)
    println("Total Marks: "+totalMarks)
    println("Percentage: "+percentage+"%")
    println("Grade: "+grade)
  }

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, String) = {
    if (name.isEmpty) {
      return (false, "Name cannot be empty");
    } else if (marks < 0 || marks > totalMarks) {
      (false, "Marks must be a positive integer and can not exceed total possible marks")
    } else {
      (true, "")
    }
  }

  def getStudentInfoWithRetry(): (String, Int, Int) = {
    var isValid = false
    var name = ""
    var marks = 0
    var totalMarks = 0

    while (!isValid) {
      print("Enter student name: ")
      name = readLine()
      print("Enter marks obtained: ")
      marks = readInt()
      print("Enter total possible marks: ")
      totalMarks = readInt()

      val (valid, errorMessage) = validateInput(name, marks, totalMarks)
      if (valid) {
        isValid = true;
      } else {
        println("Invalid input: "+errorMessage);
      }
    }
    return (name, marks, totalMarks)
  }

  def calculatePercentage(marks: Int, totalMarks: Int): Double = {
    (marks.toDouble / totalMarks) * 100
  }

  def assignGrade(percentage: Double): Char = {
    percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
  }

  def main(args:Array[String]) : Unit = {
    val studentRecord = getStudentInfo()
    printStudentRecord(studentRecord)
  }
}