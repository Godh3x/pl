rm -ErrorAction SilentlyContinue lexer/TinyLexer.java ; java -cp lexer/jlex.jar JLex.Main lexer/jlexDefinitions.l ; cd lexer ; Rename-Item -Path 'jlexDefinitions.l.java' -NewName 'TinyLexer.java' ; cd ..