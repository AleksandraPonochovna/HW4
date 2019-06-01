
public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private Label label = Label.SPAM;
    private String[] spamKeywords = {"spam", "empty"};

    @Override
    public String[] getKeywords() {
        return spamKeywords;
    }

    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public Label processText(String text) {
        for (String spamKeyword : spamKeywords) {
            if (text.contains(spamKeyword)) {
                return Label.SPAM;
            }
        }
        return Label.OK;
    }
}
