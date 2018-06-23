cd javacc ; rm -ErrorAction SilentlyContinue Eval*.java ; java -cp javacc.jar javacc EvalSpec.jj ; cd ..
rm -ErrorAction SilentlyContinue -recurse temp ; javac -d temp -cp .  ./javacc/*.java ; java -cp temp javacc.Main ../input.txt
