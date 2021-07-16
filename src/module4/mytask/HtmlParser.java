package module4.mytask;

public class HtmlParser {

    private String html;

    public HtmlParser(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getText() {
        String text = html.replaceAll("<[a-z]+[^>]*>", ""); // <span style="color: green">, <p>, <span>, ...
        text = text.replaceAll("</[a-z]+>", "");  // </span>, </a>, </p>, ...
        text = text.replaceAll("<[a-z]+\\s*/>", "");  // <br />
        return text;
    }

    public String removeTag(String tag) {
        html = html.replaceAll("<" + tag + "[^>]*>", ""); // <tag ...>
        html = html.replaceAll("</" + tag + ">", "");  // </tag>
        html = html.replaceAll("<" + tag + "\\s*/>", "");  // <tag />
        return html;
    }
}