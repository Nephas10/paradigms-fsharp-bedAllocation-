package dee;

import com.github.javaparser.JavaParser;
import com.github.javaparser.JavaToken;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Tokencount {

    public static void main(String[] args) {

        String sourceDirectory = "C:\\Users\\Gomezyani Kango\\Desktop\\nephas\\nephas\\src\\main\\java\\dee\\BedAllocation.java";
        File projectDir = new File(sourceDirectory);

        try{
            // create a java parser object
            JavaParser javaParser = new JavaParser();

            // parse the file
            ParseResult<CompilationUnit> parseResult = javaParser.parse(projectDir);

            // Check if parsing was successful
            if (parseResult.isSuccessful()) {
                // Get the CompilationUnit from the ParseResult
                CompilationUnit cu = parseResult.getResult().get();

                // initialize variable to count tokens
                AtomicInteger tokenCount = new AtomicInteger(0);

                // Now you can work with the CompilationUnit
                cu.getTokenRange().ifPresent(tokenRange -> {
                    // For each token, print it and increment the count
                    for (JavaToken token : tokenRange) {
                        System.out.print(token.getText() + " ");
                        tokenCount.incrementAndGet();
                    }
                });

                // Print the total number of tokens
                System.out.println("Total number of tokens: " + tokenCount.get());
            } else {
                // If parsing failed, print the parse error
                System.err.println("Parsing failed: " + parseResult.getProblems());
            }
        } catch (IOException e) {
            e.printStackTrace();
        
        }

    }
}
