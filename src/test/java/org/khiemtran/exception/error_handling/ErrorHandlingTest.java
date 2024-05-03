package org.khiemtran.exception.error_handling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class ErrorHandlingTest {
  private ErrorHandling errorHandling = new ErrorHandling();

  @Test
  public void testThrowIllegalArgumentException() {
    Assertions.assertThrows(Exception.class,
        () -> errorHandling.handleErrorByThrowingIllegalArgumentException());
  }

  @Test
  public void testThrowIllegalArgumentExceptionWithDetailMessage() {
    Assertions.assertThrows(IllegalArgumentException.class, () ->
        errorHandling.handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(
            "This is the detail message."), "This is the detail message.");
  }

  @Test
  public void testThrowAnyCheckedException() {
    assertThatExceptionOfType(Exception.class)
        .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyCheckedException())
        .isNotInstanceOf(RuntimeException.class);
  }

  @Test
  public void testThrowAnyCheckedExceptionWithDetailMessage() {
    assertThatExceptionOfType(Exception.class)
        .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(
            "This is the detail message."))
        .isNotInstanceOf(RuntimeException.class)
        .withMessage("This is the detail message.");
  }

  @Test
  public void testThrowAnyUncheckedException() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyUncheckedException());
  }

  @Test
  public void testThrowAnyUncheckedExceptionWithDetailMessage() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(
            "This is the detail message."))
        .withMessage("This is the detail message.");
  }

  @Test
  public void testThrowCustomCheckedException() {
    assertThatExceptionOfType(CustomCheckedException.class)
        .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomCheckedException());
  }

  @Test
  public void testThrowCustomCheckedExceptionWithDetailMessage() {
    assertThatExceptionOfType(CustomCheckedException.class)
        .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(
            "This is the detail message."))
        .withMessage("This is the detail message.");
  }

  @Test
  public void testThrowCustomUncheckedException() {
    assertThatExceptionOfType(CustomUncheckedException.class)
        .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomUncheckedException());
  }

  @Test
  public void testThrowCustomUncheckedExceptionWithDetailMessage() {
    assertThatExceptionOfType(CustomUncheckedException.class)
        .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(
            "This is the detail message."))
        .withMessage("This is the detail message.");
  }

  @Test
  public void testReturnOptionalInstance() {
    Optional<Integer> successfulResult = errorHandling.handleErrorByReturningOptionalInstance("1");
    assertThat(successfulResult).isPresent().hasValue(1);
    Optional<Integer> failureResult = errorHandling.handleErrorByReturningOptionalInstance("a");
    assertThat(failureResult).isNotPresent();
  }
}