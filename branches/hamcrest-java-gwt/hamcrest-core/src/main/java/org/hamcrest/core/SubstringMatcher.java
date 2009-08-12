package org.hamcrest.core;

import org.hamcrest.Description;

public abstract class SubstringMatcher extends StringMatcher {

    // TODO: Replace String with CharSequence to allow for easy interopability between
    //       String, StringBuffer, StringBuilder, CharBuffer, etc (joe).

    protected final String substring;

    protected SubstringMatcher(final String substring) {
        this.substring = substring;
    }

    @Override
    public boolean matchesSafely(String item, Description mismatchDescription) {
        if (!evalSubstringOf(item)) {
            mismatchDescription.appendText("was \"").appendText(item).appendText("\"");
            return false;
        }
        return true;
    }

    public void describeTo(Description description) {
        description.appendText("a string ")
                .appendText(relationship())
                .appendText(" ")
                .appendValue(substring);
    }

    protected abstract boolean evalSubstringOf(String string);

    protected abstract String relationship();
}