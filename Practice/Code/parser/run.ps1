rm -ErrorAction SilentlyContinue -recurse temp ; javac -d temp -cp .  ./parser/*.java ; java -cp temp parser.Main input.txt
