package org.khiemtran.objects.wizards_and_warriors_2;

public enum TravelMethod {
  WALKING("walking"),
  HORSEBACK("horseback");
  private String value;

  TravelMethod(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
