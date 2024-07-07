object FormatName{
    
    def toUpper(name: String): String = {
        return name.toUpperCase
    }

    def toLower(name: String): String = {
        return name.toLowerCase
    }

    def formatNames(name: String)(format: String => String): String = {
        format(name)
    }

    def main(args: Array[String]): Unit = {
        println(formatNames("Benny")(toUpper));
        
        println(formatNames("Niroshan")(name => {
            name.substring(0, 2).toUpperCase + name.substring(2);
        })
        );
        println(formatNames("Saman")(toLower));
        
        println(formatNames("Kumara")(name => {
            name.substring(0, 1).toUpperCase + name.substring(1, 5) + name.substring(5).toUpperCase;
        })
        );
    }
}
