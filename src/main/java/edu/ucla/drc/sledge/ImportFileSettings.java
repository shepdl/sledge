package edu.ucla.drc.sledge;

import java.util.List;
import java.util.regex.Pattern;

public class ImportFileSettings {

    private boolean preserveCase = true;

    private Pattern tokenRegexPattern;
    private boolean keepSequenceBigrams;

    private List<String> stopwordFilenames;

    public static final Pattern defaultRegex = Pattern.compile("\\p{L}[\\p{L}\\p{P}]+\\p{L}");
    public static final Pattern nonEnglishRegex = Pattern.compile("[\\p{L}\\p{M}]+");

    public ImportFileSettings (boolean preserveCase, Pattern tokenRegexPattern) {
        this.preserveCase = preserveCase;
        this.tokenRegexPattern = tokenRegexPattern;
    }

    public static ImportFileSettings withDefaults () {
        return new ImportFileSettings(
            false,
            defaultRegex
        );
    }

    public boolean preserveCase() {
        return preserveCase;
    }

    public Pattern getTokenRegexPattern() {
        return tokenRegexPattern;
    }

    public String toString () {
        return defaultRegex.toString() + "/" + (preserveCase ? "preserve case" : "insensitive");
    }

    public void updateFrom (ImportFileSettings settings) {
        preserveCase = settings.preserveCase;
        tokenRegexPattern = settings.tokenRegexPattern;
    }

}