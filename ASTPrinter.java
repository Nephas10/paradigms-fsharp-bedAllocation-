package dee;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;

import java.io.File;
import java.io.IOException;

public class ASTPrinter {
    public static void main(String[] args) {
        try {
            CompilationUnit cu = StaticJavaParser.parse(new File("C:\\Users\\Gomezyani Kango\\Desktop\\nephas\\nephas\\src\\main\\java\\dee\\BedAllocation.java"));
            // Now you can explore the AST!
            printAST(cu, "", "  ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAST(Node node, String prefix, String childrenPrefix) {
        System.out.println(prefix + node.getClass().getSimpleName() + ": " + node.toString().substring(0, Math.min(node.toString().length(), 50)) + "...");
        for (Node child : node.getChildNodes()) {
            printAST(child, childrenPrefix + "├── ", childrenPrefix + "│   ");
        }
    }
}
