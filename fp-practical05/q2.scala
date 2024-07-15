case class Book(
    title: String, 
    author: String, 
    ISBN: String,
);

object libraryManagement {
    var library : Set[Book] = Set(
        Book("Harry Potter", "Peter", "ISBN1"),
        Book("Hardy Boys", "Jane", "ISBN2"),
        Book("Secret seven", "Marry", "ISBN3"),
        Book("Famous five", "Bruce", "ISBN4"),
    );

    def addBook(book: Book) : Unit = {
        library += book;
        println(" Book added successfully");
    }

    def removeBook(ISBN : String) : Unit = {
        library.find(_.ISBN == ISBN) match {
            case Some(book) => {
                library -= book;
                println(book.ISBN + " Book removed successfully");
            }
            case None => println("Book is not available");
        }
    }

    def isbookPresent(ISBN : String) : Unit = {
        library.find(_.ISBN == ISBN) match {
            case Some(book) => println(book.title + "(" + book.ISBN + ")" + " Book found in the library");
            case None => println("Book is not available in the library");
        }
    }

    def displayLibrary() : Unit = {
        println("-----Books in the library------");
        library.foreach(book => println("Title : " + book.title + ", Author : " + book.author + ", ISBN : " + book.ISBN));
    }

    def searchByTitle(title : String) : Unit = {
        library.find(_.title == title) match {
            case Some(book) => println("Title : " + book.title + ", Author : " + book.author + ", ISBN : " + book.ISBN);
            case None => println("Book is not available in the library");
        }
    }

    def displayBokksByAuthor(author : String) : Unit = {
        val booksByAuthor = library.filter(_.author == author);
        if(booksByAuthor.isEmpty){
            println("No books found by the author : " + author);
        }
        else{
            println("Books by author : " + author);
            booksByAuthor.foreach(book => println("Title : " + book.title + ", Author : " + book.author + ", ISBN : " + book.ISBN));
        }
    }

    def main(args: Array[String]) : Unit = {
        addBook(Book("wuthering heights", "Emily Bronte", "ISBN5"));
        displayLibrary();
        removeBook("ISBN3");
        isbookPresent("ISBN5");
        searchByTitle("Famous five");
        displayBokksByAuthor("Emily Bronte");
    }
}