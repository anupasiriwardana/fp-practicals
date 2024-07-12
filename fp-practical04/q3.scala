object FormatName{
    
    def toUpper(name: String): String = {
        var upperName:String = "";
        for(i <- 0 until name.length){
            if(name(i) >= 'a' && name(i) <= 'z'){
                upperName+= (name(i).toInt - 32).toChar;
            }else{
                upperName+= name(i);
            }
        }
        return upperName;
    }

    def toLower(name: String): String = {
        var lowerName:String = "";
        for(i <- 0 until name.length){
            if(name(i) >= 'A' && name(i) <= 'Z'){
                lowerName += (name(i).toInt + 32).toChar;
            }else{
                lowerName += name(i);
            }
        }
        return lowerName;
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
