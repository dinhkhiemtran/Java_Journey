package org.khiemtran.strings;

public class Badge {
  public String print(Integer id, String name, String department) {
    String hasDepartment = department == null ? "OWNER" : department.toUpperCase();
    return id == null ? String.format("%s - %s", name, hasDepartment)
        : String.format("[%d] - %s - %s", id, name, hasDepartment);
  }
}
