package org.khiemtran.arraylist;

import org.junit.jupiter.api.*;
import org.khiemtran.arraylist.LanguageList;

class LanguageListTest {
  private LanguageList languageList;

  @BeforeEach
  public void setup() {
    languageList = new LanguageList();
  }

  @Test
  @Tag("task:1")
  @DisplayName("The isEmpty method returns true when the list contains no languages")
  public void empty() {
    Assertions.assertTrue(languageList.isEmpty());
  }

  @Test
  @Tag("task:2")
  @DisplayName("The isEmpty method returns false after adding a language to the list")
  public void nonEmpty() {
    languageList.addLanguage("Java");
    Assertions.assertFalse(languageList.isEmpty());
  }

  @Test
  @Tag("task:3")
  @DisplayName("The removeLanguage method correctly removes a language from the list")
  public void removeLanguage() {
    languageList.addLanguage("Java");
    languageList.removeLanguage("Java");
    Assertions.assertTrue(languageList.isEmpty());
  }

  @Test
  @Tag("task:4")
  @DisplayName("The firstLanguage method returns the first language that was added to the list")
  public void firstLanguage() {
    languageList.addLanguage("Java");
    languageList.addLanguage("Python");
    languageList.addLanguage("Ruby");
    Assertions.assertEquals("Java", languageList.firstLanguage());
  }

  @Test
  @Tag("task:5")
  @DisplayName("The count method returns the number of languages in the list")
  public void countThree() {
    languageList.addLanguage("Java");
    languageList.addLanguage("Python");
    languageList.addLanguage("Ruby");
    Assertions.assertEquals(3, languageList.count());
  }

  @Test
  @Tag("task:5")
  @DisplayName("The count method returns 0 when the list is empty")
  public void countEmpty() {
    Assertions.assertEquals(0, languageList.count());
  }

  @Test
  @Tag("task:6")
  @DisplayName("The containsLanguage method returns true when the language is in the list")
  public void containsLanguage() {
    languageList.addLanguage("Java");
    Assertions.assertTrue(languageList.containsLanguage("Java"));
  }

  @Test
  @Tag("task:6")
  @DisplayName("The containsLanguage method returns false when the language is not in the list")
  public void doesNotContainLanguage() {
    languageList.addLanguage("Kotlin");
    Assertions.assertFalse(languageList.containsLanguage("Java"));
  }

  @Test
  @Tag("task:7")
  @DisplayName("The isExciting method returns true when the list contains Java")
  public void excitingLanguageListWithJava() {
    languageList.addLanguage("Java");
    Assertions.assertTrue(languageList.isExciting());
  }

  @Test
  @Tag("task:7")
  @DisplayName("The isExciting method returns true when the list contains Kotlin")
  public void excitingLanguageListWithKotlin() {
    languageList.addLanguage("Python");
    languageList.addLanguage("Kotlin");
    Assertions.assertTrue(languageList.isExciting());
  }

  @Test
  @Tag("task:7")
  @DisplayName("The isExciting method returns false when the list contains neither Java nor Kotlin")
  public void boringLanguageList() {
    languageList.addLanguage("Python");
    languageList.addLanguage("Ruby");
    languageList.addLanguage("C++");
    Assertions.assertFalse(languageList.isExciting());
  }
}
