package algorithm;

public class algoException extends Exception {
    public algoException(String error_message) {
        super(error_message);
    }
}

class WordLengthNotSameException extends algoException {
    public WordLengthNotSameException() {
        super("Different word length!");
    }
}

class WordNotFoundException extends algoException {
    public WordNotFoundException() {
        super("Word not found in dictionary");
    }
}

