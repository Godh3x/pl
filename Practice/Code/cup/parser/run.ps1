rm -ErrorAction SilentlyContinue lexer/TinyLexer.java ; java -cp parser/cup.jar java_cup.Main -parser TinyParser -symbols Lexicon -nopositions parser/Tiny.cup
rm -ErrorAction SilentlyContinue -recurse temp ; javac -d temp -cp . ./cup/parser/Lexicon.java ; javac -d temp -cp . ./cup/lexer/*.java ; javac -d temp -cp . ./cup/parser/*.java ; java -cp temp cup.parser.Main