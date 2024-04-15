package org.khiemtran.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.khiemtran.strings.SqueakyClean;

class SqueakyCleanTest {
  @Test
  @Tag("task:1")
  @DisplayName("The clean method returns empty string when invoked on empty string")
  public void empty() {
    Assertions.assertEquals("", new SqueakyClean().clean(""));
  }

  @Test
  @Tag("task:1")
  public void testReplaceAnySpacesWithUnderscores() {
    Assertions.assertEquals("my___Id", new SqueakyClean().clean("my   Id"));
  }

  @Test
  @Tag("task:2")
  public void testConvertKebabCaseToCamelCase() {
    Assertions.assertEquals("aBc", new SqueakyClean().clean("a-bc"));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The clean method returns the same string when invoked on a single letter string")
  public void single_letter() {
    Assertions.assertEquals("A", new SqueakyClean().clean("A"));
  }

  @Test
  public void test() {
    Assertions.assertEquals("Hello_World", new SqueakyClean().clean("H3ll0 W0rld"));
  }

  @Test
  @Tag("task:3")
  @DisplayName("The clean method converts leetspeak to normal text with spaces and special characters")
  public void leetspeak_to_normal_text_with_spaces_and_special_characters() {
    Assertions.assertEquals("leetspeak_is_fun", new SqueakyClean().clean("¡1337sp34k is fun!"));
  }

  @Test
  @Tag("task:4")
  @DisplayName("The clean method removes all characters that are not letters")
  public void special_characters() {
    Assertions.assertEquals("ab", new SqueakyClean().clean("a$#.b"));
  }

  @Test
  @Tag("task:4")
  @DisplayName("The clean method removes all characters that are not letters and replaces spaces")
  public void special_characters_and_spaces() {
    Assertions.assertEquals("hello_world_", new SqueakyClean().clean("¡hello world!. "));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The clean method returns the same string when invoked on a string of three letters")
  public void string() {
    Assertions.assertEquals("abc", new SqueakyClean().clean("abc"));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The clean method replaces leading and trailing whitespaces with underscores")
  public void leading_and_trailing_spaces() {
    Assertions.assertEquals("_myId_", new SqueakyClean().clean(" myId "));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The clean method returns a string in camel case after removing a dash and replaces a whitespace")
  public void kebab_to_camel_case_and_number() {
    Assertions.assertEquals("aC_", new SqueakyClean().clean("a-C "));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The clean method returns a string in camel case and replaces leading and trailing whitespaces")
  public void kebab_to_camel_case_and_spaces() {
    Assertions.assertEquals("_helloWorld_", new SqueakyClean().clean(" hello-world "));
  }
}