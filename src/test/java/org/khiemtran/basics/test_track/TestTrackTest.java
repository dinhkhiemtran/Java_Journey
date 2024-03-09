package org.khiemtran.basics.test_track;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TestTrackTest {
  @Test
  @Tag("task:1")
  @DisplayName("The ProductionRemoteControlCar is an instance of the RemoteControlCar interface")
  public void productionRccIsRemoteControlCar() {
    var productionCar = new ProductionRemoteControlCar();
    Assertions.assertTrue(productionCar instanceof RemoteControlCar);
  }

  @Test
  @Tag("task:1")
  @DisplayName("The ExperimentalRemoteControlCar is an instance of the RemoteControlCar interface")
  public void experimentalRccIsRemoteControlCar() {
    var experimentalCar = new ExperimentalRemoteControlCar();
    Assertions.assertTrue(experimentalCar instanceof RemoteControlCar);
  }

  @Test
  @Tag("task:2")
  @DisplayName("The getDistanceTravelled method of the ProductionRemoteControlCar returns 10 after driving once")
  public void productionCarTravels10UnitsPerDrive() {
    var car = new ProductionRemoteControlCar();
    Assertions.assertEquals(0, car.getDistanceTravelled());
    car.drive();
    Assertions.assertEquals(10, car.getDistanceTravelled());
  }

  @Test
  @Tag("task:2")
  @DisplayName("The getDistanceTravelled method of the ExperimentalRemoteControlCar returns 20 after driving once")
  public void experimentalCarTravels20UnitsPerDrive() {
    ExperimentalRemoteControlCar car = new ExperimentalRemoteControlCar();
    Assertions.assertEquals(0, car.getDistanceTravelled());
    car.drive();
    Assertions.assertEquals(20, car.getDistanceTravelled());
  }

  @Test
  @Tag("task:3")
  @DisplayName("The TestTrack.race method uses the drive method on the remote control car")
  public void race() {
    ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
    ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
    TestTrack.race(productionCar);
    TestTrack.race(productionCar);
    TestTrack.race(experimentalCar);
    TestTrack.race(experimentalCar);
    Assertions.assertEquals(20, experimentalCar.getDistanceTravelled() - productionCar.getDistanceTravelled());
  }

  @Test
  @Tag("task:4")
  @DisplayName("The ProductionRemoteControlCar implements the Comparable interface")
  public void ensureCarsAreComparable() {
    assertThat(Comparable.class).isAssignableFrom(ProductionRemoteControlCar.class);
  }

  @Test
  @Tag("task:4")
  @DisplayName("The getRankedCars returns a list of multiple cars sorted by number of victories")
  public void rankManyCars() {
    var car2 = new ProductionRemoteControlCar();
    car2.setNumberOfVictories(3);
    var car3 = new ProductionRemoteControlCar();
    car3.setNumberOfVictories(5);
    var car4 = new ProductionRemoteControlCar();
    car4.setNumberOfVictories(7);
    var car5 = new ProductionRemoteControlCar();
    car5.setNumberOfVictories(2);
    var car6 = new ProductionRemoteControlCar();
    car6.setNumberOfVictories(1);
    List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>() {
      {
        add(car2);
        add(car3);
        add(car4);
        add(car5);
        add(car6);
      }
    };
    List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);
    Assertions.assertEquals(7, rankings.get(0).getNumberOfVictories());
    Assertions.assertEquals(5, rankings.get(1).getNumberOfVictories());
    Assertions.assertEquals(3, rankings.get(2).getNumberOfVictories());
    Assertions.assertEquals(2, rankings.get(3).getNumberOfVictories());
    Assertions.assertEquals(1, rankings.get(4).getNumberOfVictories());
  }
}