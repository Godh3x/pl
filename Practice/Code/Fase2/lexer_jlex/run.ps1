rm -ErrorAction SilentlyContinue lexer_jlex/TinyLexer.java ; java -cp lexer_jlex/jlex.jar JLex.Main lexer_jlex/jlexDefinitions.l ; cd lexer_jlex ; Rename-Item -Path 'jlexDefinitions.l.java' -NewName 'TinyLexer.java' ; cd ..
rm -ErrorAction SilentlyContinue -recurse temp ; javac -d temp -cp . ./lexer_jlex/*.java ; java -cp temp lexer_jlex.Main