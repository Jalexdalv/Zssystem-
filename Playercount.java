package zssystem;

import java.util.ArrayList;
import java.util.List;

public class Playercount
{
  public static List<Playercount> classes = new ArrayList();
  static int count;
  String playername;
  
  public Playercount() {}
  
  public Playercount(String name, int counts)
  {
    this.playername = name;
    count = counts;
  }
  
  public static void setcount(int set)
  {
    count = set;
  }
  
  public static int getcount()
  {
    return count;
  }
}
