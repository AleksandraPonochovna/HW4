public interface TextAnalyzer {
    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    public Label processText(String text);
}
