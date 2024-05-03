package org.khiemtran.exception.error_handling;

class CustomCheckedException extends Exception {
  CustomCheckedException() {
    super();
  }

  CustomCheckedException(String message) {
    super(message);
  }
}