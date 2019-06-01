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
