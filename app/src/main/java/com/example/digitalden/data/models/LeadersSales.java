package com.example.digitalden.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class LeadersSales implements Serializable {
  private Specials specials;

  private Specials top_sellers;

  @SerializedName("0")
  private Specials f0;

  @SerializedName("1")
  private Specials f1;

  @SerializedName("2")
  private Specials f2;

  @SerializedName("3")
  private Specials f3;

  @SerializedName("4")
  private Specials f4;

  @SerializedName("5")
  private Specials f5;

  @SerializedName("6")
  private Specials f6;

  private Specials coming_soon;

  private Trailerslideshow trailerslideshow;

  private Trailerslideshow genres;

  private Specials new_releases;

  private Integer status;

  public Specials getSpecials() {
    return this.specials;
  }

  public void setSpecials(Specials specials) {
    this.specials = specials;
  }

  public Specials getTop_sellers() {
    return this.top_sellers;
  }

  public void setTop_sellers(Specials top_sellers) {
    this.top_sellers = top_sellers;
  }

  public Specials getF0() {
    return this.f0;
  }

  public void setF0(Specials f0) {
    this.f0 = f0;
  }

  public Specials getF1() {
    return this.f1;
  }

  public void setF1(Specials f1) {
    this.f1 = f1;
  }

  public Specials getF2() {
    return this.f2;
  }

  public void setF2(Specials f2) {
    this.f2 = f2;
  }

  public Specials getF3() {
    return this.f3;
  }

  public void setF3(Specials f3) {
    this.f3 = f3;
  }

  public Specials getF4() {
    return this.f4;
  }

  public void setF4(Specials f4) {
    this.f4 = f4;
  }

  public Specials getF5() {
    return this.f5;
  }

  public void setF5(Specials f5) {
    this.f5 = f5;
  }

  public Specials getF6() {
    return this.f6;
  }

  public void setF6(Specials f6) {
    this.f6 = f6;
  }

  public Specials getComing_soon() {
    return this.coming_soon;
  }

  public void setComing_soon(Specials coming_soon) {
    this.coming_soon = coming_soon;
  }

  public Trailerslideshow getTrailerslideshow() {
    return this.trailerslideshow;
  }

  public void setTrailerslideshow(Trailerslideshow trailerslideshow) {
    this.trailerslideshow = trailerslideshow;
  }

  public Trailerslideshow getGenres() {
    return this.genres;
  }

  public void setGenres(Trailerslideshow genres) {
    this.genres = genres;
  }

  public Specials getNew_releases() {
    return this.new_releases;
  }

  public void setNew_releases(Specials new_releases) {
    this.new_releases = new_releases;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public static class Specials implements Serializable {
    private String name;

    private String id;

    private List<Items> items;

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getId() {
      return this.id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public List<Items> getItems() {
      return this.items;
    }

    public void setItems(List<Items> items) {
      this.items = items;
    }

    public static class Items implements Serializable {
      private Boolean discounted;

      private String header_image;

      private Integer original_price;

      private Boolean linux_available;

      private Integer type;

      private String controller_support;

      private String large_capsule_image;

      private String small_capsule_image;

      private Boolean mac_available;

      private Integer final_price;

      private Integer discount_expiration;

      private String name;

      private String currency;

      private Boolean windows_available;

      private Integer id;

      private Integer discount_percent;

      private Boolean streamingvideo_available;

      public Boolean getDiscounted() {
        return this.discounted;
      }

      public void setDiscounted(Boolean discounted) {
        this.discounted = discounted;
      }

      public String getHeader_image() {
        return this.header_image;
      }

      public void setHeader_image(String header_image) {
        this.header_image = header_image;
      }

      public Integer getOriginal_price() {
        return this.original_price;
      }

      public void setOriginal_price(Integer original_price) {
        this.original_price = original_price;
      }

      public Boolean getLinux_available() {
        return this.linux_available;
      }

      public void setLinux_available(Boolean linux_available) {
        this.linux_available = linux_available;
      }

      public Integer getType() {
        return this.type;
      }

      public void setType(Integer type) {
        this.type = type;
      }

      public String getController_support() {
        return this.controller_support;
      }

      public void setController_support(String controller_support) {
        this.controller_support = controller_support;
      }

      public String getLarge_capsule_image() {
        return this.large_capsule_image;
      }

      public void setLarge_capsule_image(String large_capsule_image) {
        this.large_capsule_image = large_capsule_image;
      }

      public String getSmall_capsule_image() {
        return this.small_capsule_image;
      }

      public void setSmall_capsule_image(String small_capsule_image) {
        this.small_capsule_image = small_capsule_image;
      }

      public Boolean getMac_available() {
        return this.mac_available;
      }

      public void setMac_available(Boolean mac_available) {
        this.mac_available = mac_available;
      }

      public Integer getFinal_price() {
        return this.final_price;
      }

      public void setFinal_price(Integer final_price) {
        this.final_price = final_price;
      }

      public Integer getDiscount_expiration() {
        return this.discount_expiration;
      }

      public void setDiscount_expiration(Integer discount_expiration) {
        this.discount_expiration = discount_expiration;
      }

      public String getName() {
        return this.name;
      }

      public void setName(String name) {
        this.name = name;
      }

      public String getCurrency() {
        return this.currency;
      }

      public void setCurrency(String currency) {
        this.currency = currency;
      }

      public Boolean getWindows_available() {
        return this.windows_available;
      }

      public void setWindows_available(Boolean windows_available) {
        this.windows_available = windows_available;
      }

      public Integer getId() {
        return this.id;
      }

      public void setId(Integer id) {
        this.id = id;
      }

      public Integer getDiscount_percent() {
        return this.discount_percent;
      }

      public void setDiscount_percent(Integer discount_percent) {
        this.discount_percent = discount_percent;
      }

      public Boolean getStreamingvideo_available() {
        return this.streamingvideo_available;
      }

      public void setStreamingvideo_available(Boolean streamingvideo_available) {
        this.streamingvideo_available = streamingvideo_available;
      }
    }
  }

  public static class Trailerslideshow implements Serializable {
    private String name;

    private String id;

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getId() {
      return this.id;
    }

    public void setId(String id) {
      this.id = id;
    }
  }
}
