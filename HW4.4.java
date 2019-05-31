package com.company;

public abstract class AnalyzerApp implements TextAnalyzer {

    static final int commentMaxLength = 50;
    static int sizeOfArray = 5;
    static String[] spamKeywords = {"spam", "empty"};
    static String[] negativeKeywords = {":(", "=(", ":|", ":/"};

    public static void main(String[] args) {

        String[] texts = new String[sizeOfArray];
        texts[0] = "HI! It's some comment. With spam.";
        texts[1] = "HI! It's some comment. Bad comment";
        texts[2] = "HI! It's some comment. It's sad comment :(";
        texts[3] = "HI! It's some loooooooooooooooooooooooooooooooooooooooooooong comment.";
        texts[4] = "HI! It's some good comment.";
        
        TextAnalyzer[] textAnalyzer1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(negativeKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };

        TextAnalyzer[] textAnalyzer2 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(negativeKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };

        TextAnalyzer[] textAnalyzer3 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(negativeKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };

        TextAnalyzer[][] textAnalyzers = {textAnalyzer1, textAnalyzer2, textAnalyzer3};

        int numberOfTest = 1;
        for (String test : texts) {
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] textAnalyzer : textAnalyzers) {
                System.out.println(checkLabels(textAnalyzer, test));
            }
        }
    }
    
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            if (analyzer.processText(text).equals(Label.OK)) {
                return Label.OK;
            } else {
                return analyzer.processText(text);
            }
        }
        return Label.OK;
    }
}

public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private Label label = Label.SPAM;
    private String[] spamKeywords;

    public SpamAnalyzer(String[] spamKeywords) {
        this.spamKeywords = spamKeywords;
    }

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
            if (text.indexOf(spamKeyword) != -1) {
                return Label.SPAM;
            }
        }
        return Label.OK;
    }
}

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private Label label = Label.NEGATIVE_TEXT;
    private String[] negativeKeywords;


    public NegativeTextAnalyzer(String[] negativeKeywords) {
        this.negativeKeywords = negativeKeywords;
    }

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
            if (text.indexOf(negativeKeyword) != -1) {
                return Label.NEGATIVE_TEXT;
            }
        }
        return Label.NEGATIVE_TEXT;
    }
}

public class TooLongTextAnalyzer implements TextAnalyzer {

    private int commentMaxLength;

    public TooLongTextAnalyzer(int commentMaxLength) {
        this.commentMaxLength = commentMaxLength;
    }

    public int getMaxLength() {
        return commentMaxLength;
    }

    @Override
    public Label processText(String text) {
        return text.length() > commentMaxLength ? Label.TOO_LONG : Label.OK;
    }
}


