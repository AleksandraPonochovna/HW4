public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private Label label = Label.NEGATIVE_TEXT;
    private String[] negativeKeywords =  {":(", "=(", ":|", ":/"};

    @Override
    public String[] getKeywords() {
        return negativeKeywords;
    }

    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public Label processText(String text) {
        for (String negativeKeyword : negativeKeywords) {
            if (text.contains(negativeKeyword)) {
                return Label.NEGATIVE_TEXT;
            }
        }
        return Label.OK;
    }
}
