javac -d ./bin -sourcepath ./src src/IceCreamShopV1/IceCreamShopV1.java
java -cp ./bin IceCreamShopV1.IceCreamShopV1

javac -d ./bin -sourcepath ./src src/TestSorter/TestSorter.java
java -cp ./bin TestSorter.TestSorter

javac -d ./bin -sourcepath ./src src/LetsEat/LetsEat.java
java -cp ./bin LetsEat.LetsEat

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/IceCreamShopV1/*.java
dot -Tpng -ograph.png graph.dot
