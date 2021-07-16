package module4.mytask;

public class Main {
    public static void main(String[] args) {
        String html = "<p>Hello, <span style=\"color: red\">world!!!</span></p>";
        HtmlParser htmlParser = new HtmlParser(html);
        System.out.println(htmlParser.getText());
        System.out.println(htmlParser.removeTag("span"));
    }
}
