cd parser_javacc ; rm -ErrorAction SilentlyContinue TinyParser*.java ; java -cp javacc.jar javacc Tiny.jj ; cd ..
rm -ErrorAction SilentlyContinue -recurse temp ; javac -d temp -cp .  ./parser_javacc/*.java ; java -cp temp parser_javacc.Main ../input.txt
