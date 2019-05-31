package com.company;

public abstract class AnalyzerApp implements TextAnalyzer {

    public static void main(String[] args) {

        String[] texts = new String[5];
        StringBuilder builder = new StringBuilder();
        texts[0] = "HI! It's some comment. With spam.";
        texts[1] = "HI! It's some comment. Bad comment";
        texts[2] = "HI! It's some comment. It's sad comment :(";
        texts[3] = "HI! It's some loooooooooooooooooooooooooooooooooooooooooooong comment.";
        texts[4] = "HI! It's some good comment.";

        TextAnalyzer[] textAnalyzer = {
                new SpamAnalyzer(),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer()
        };

        int numberOfTest = 1;
        for (String text : texts) {
            builder.append("Test №").append(numberOfTest).append(": ").append(text).append(checkLabels(textAnalyzer, text));
            numberOfTest++;
        }
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            if (analyzer.processText(text) != Label.OK) {
                return analyzer.processText(text);
            }
        }
        return Label.OK;
    }
}

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

public class TooLongTextAnalyzer implements TextAnalyzer {

    private int commentMaxLength = 50;

    @Override
    public Label processText(String text) {
        return text.length() > commentMaxLength ? Label.TOO_LONG : Label.OK;
    }
}

public abstract class KeywordAnalyzer implements TextAnalyzer{
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();
}

public interface TextAnalyzer {
    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    public Label processText(String text);
}
