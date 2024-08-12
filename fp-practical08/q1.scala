object CaesarCipher {
    def encryptCaesarCipher(text:String, shift:Int) : String = {
        text.map{ char => 
            if(char.isLetter){
                if(char.isUpper){
                    //Ascii val of A = 65
                    ((char - 65 + shift) % 26 + 65).toChar;
                }
                else{
                    //Ascii val of a = 97
                    ((char - 97 + shift) % 26 + 97).toChar;
                }
            }else{ 
                char;
            }
        }
    }

    def decryptCaesarCipher(text:String, shift:Int) : String = {
        text.map{ char => 
            if(char.isLetter){
                if(char.isUpper){
                    //Ascii val of A = 65
                    ((char - 65 - shift) % 26 + 65).toChar;
                }
                else{
                    //Ascii val of a = 97
                    ((char - 97 - shift) % 26 + 97).toChar;
                }
            }else{ 
                char;
            }
        }
    }

    def cipher(text: String, shift: Int, operation: (String, Int) => String): String = {
        operation(text, shift)
    }

    def main(args: Array[String]): Unit = {
        val plainText = "Password";
        val encryptedText = "Dqxsd";
        val shift = 3;

        println("Encrypted text : "+ cipher(plainText,shift,encryptCaesarCipher));
        println("Decrypted text : "+ cipher(encryptedText,shift,decryptCaesarCipher));
    }

}
