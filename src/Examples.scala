/**
 *
 */
/**
 * @author malte
 *
 */
import java.io.PrintWriter
import java.io.File

object Examples {
  
  def withPrintWriter(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close
    }
  }
  // call 
  // val file = new File("Date.txt")
  // withPrintWriter(file) {writer => writer.println(new java.util.Date)}

}