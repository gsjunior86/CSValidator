# Task2

Before run, make sure that you have JDK 1.8 and Maven installed.

checkout with:
```
git checkout https://github.com/gsjunior86/Task2
cd Task2
```

and compile with:
```
mvn clean install
```

Before running, make sure that you have a file headers.txt in the same folder of the JAR file.
In this file, all the expected headers should be included, each one in a new line. Check src/main/resources/headers.txt as an example.

Finally, you can run the file with:

```
java -jar CsvChecker-1.0.jar <your_csv_file>
```

