package module11;

import java.io.IOException;
import java.util.LinkedList;

public class Exceptions {

    public static void main(String[] args) throws IOException {
        // testFinalClause();
        System.out.println(testFinalClauseTwo());
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(null);

        try {
            saveParam("");
        } catch (WrongParamException e) {
            e.printStackTrace();
        }
    }

    public static void saveParam(String param) throws WrongParamException {
        if (param.isEmpty()) {
            throw new WrongParamException();
        }
        // saving param
    }

    public static void testFinalClause() throws IOException {
        try {
            // some exceptions
            int a = 1, b = 0;
            System.out.println(a / b);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IOException();
        }
        finally {
            System.out.println("FINALLY CLAUSE!");
        }
        System.out.println("AFTER TRY CATCH FINAL");
    }

    public static String testFinalClauseTwo() {
        try {
            // System.exit(0);
            return "try";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "catch";
        }
        finally {
            return "Final";
        }
    }
}
