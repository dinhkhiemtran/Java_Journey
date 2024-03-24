package org.khiemtran.numbers;

public class Darts {
  private static final double BULLSEYE_RADIUS = 1.0;
  private static final double INNER_BULL_RADIUS = 5.0;
  private static final double OUTER_BULL_RADIUS = 10.0;
  private static final int PERFECT_SCORE = 10;
  private static final int GOOD_SCORE = 5;
  private static final int POOR_SCORE = 1;
  private static final int NO_SCORE = 0;

  int score(double xOfDart, double yOfDart) {
    double distanceFromCenter = Math.sqrt(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2));
    if (distanceFromCenter <= BULLSEYE_RADIUS) {
      return PERFECT_SCORE;
    } else if (distanceFromCenter <= INNER_BULL_RADIUS) {
      return GOOD_SCORE;
    } else if (distanceFromCenter <= OUTER_BULL_RADIUS) {
      return POOR_SCORE;
    } else {
      return NO_SCORE;
    }
  }
}
