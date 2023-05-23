package com.example.digitalden.data.models;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class AllGamesFromSteam implements Serializable {
  private Applist applist;

  public Applist getApplist() {
    return this.applist;
  }

  public void setApplist(Applist applist) {
    this.applist = applist;
  }

  public static class Applist implements Serializable {
    private List<Apps> apps;

    public List<Apps> getApps() {
      return this.apps;
    }

    public void setApps(List<Apps> apps) {
      this.apps = apps;
    }

    public static class Apps implements Serializable {
      private Integer appid;

      private String name;

      public Integer getAppid() {
        return this.appid;
      }

      public void setAppid(Integer appid) {
        this.appid = appid;
      }

      public String getName() {
        return this.name;
      }

      public void setName(String name) {
        this.name = name;
      }
    }
  }
}
