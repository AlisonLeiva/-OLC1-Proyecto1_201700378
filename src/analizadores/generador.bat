javac JLex/Main.java
java JLex.Main LexicoCSS
java -jar Cup/java-cup-11b.jar -parser parserCSS -symbols sym2 SintacticoCSS
pause


javac JLex/Main.java
java JLex.Main LexicoHTML
java -jar Cup/java-cup-11b.jar -parser parserHTML -symbols sym1 SintacticoHTML
pause


javac JLex/Main.java
java JLex.Main LexicoUFE
java -jar Cup/java-cup-11b.jar -parser parserUFE -symbols sym3 SintacticoUFE
pause

