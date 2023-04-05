package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    @Test
    public void OneIncorrectLetter()
    {
        var word = new Word("A");
        var score = word.guess("z");

        var result = score.letter(0);
        assertThat(result).isEqualTo(INCORRECT);
    }
}
