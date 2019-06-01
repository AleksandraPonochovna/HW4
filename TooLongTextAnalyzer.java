public class TooLongTextAnalyzer implements TextAnalyzer {

    private int commentMaxLength = 50;

    @Override
    public Label processText(String text) {
        return text.length() > commentMaxLength ? Label.TOO_LONG : Label.OK;
    }
}
