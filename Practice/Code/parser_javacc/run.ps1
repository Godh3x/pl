rm -ErrorAction SilentlyContinue TinyParser*.java ; java -cp javacc.jar javacc Tiny.jj
rm -ErrorAction SilentlyContinue -recurse temp ; javac -d temp -cp .  ./*.java ; java -cp temp parser_javacc.Main input.txt
