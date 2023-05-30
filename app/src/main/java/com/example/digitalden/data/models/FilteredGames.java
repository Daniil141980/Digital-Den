package com.example.digitalden.data.models;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.List;

public class FilteredGames implements Serializable {
  private Integer totalMoviesFound;

  private String totalResults;

  private Integer totalPages;

  private Integer page;

  private Integer totalGamesFound;

  private List<Products> products;

  private Object ts;

  public Integer getTotalMoviesFound() {
    return this.totalMoviesFound;
  }

  public void setTotalMoviesFound(Integer totalMoviesFound) {
    this.totalMoviesFound = totalMoviesFound;
  }

  public String getTotalResults() {
    return this.totalResults;
  }

  public void setTotalResults(String totalResults) {
    this.totalResults = totalResults;
  }

  public Integer getTotalPages() {
    return this.totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public Integer getPage() {
    return this.page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getTotalGamesFound() {
    return this.totalGamesFound;
  }

  public void setTotalGamesFound(Integer totalGamesFound) {
    this.totalGamesFound = totalGamesFound;
  }

  public List<Products> getProducts() {
    return this.products;
  }

  public void setProducts(List<Products> products) {
    this.products = products;
  }

  public Object getTs() {
    return this.ts;
  }

  public void setTs(Object ts) {
    this.ts = ts;
  }

  public static class Products implements Serializable {
    private Boolean buyable;

    private Boolean isDiscounted;

    private List<String> supportedOperatingSystems;

    private SalesVisibility salesVisibility;

    private String supportUrl;

    private Integer rating;

    private Video video;

    private Availability availability;

    private String title;

    private Integer type;

    private Integer ageLimit;

    private Boolean isTBA;

    private Boolean isPriceVisible;

    private List<String> genres;

    private Price price;

    private Boolean isInDevelopment;

    private Integer id;

    private List<String> gallery;

    private String slug;

    private Boolean isGame;

    private String image;

    private Integer releaseDate;

    private WorksOn worksOn;

    private Boolean isWishlistable;

    private String url;

    private Integer globalReleaseDate;

    private Boolean isComingSoon;

    private String publisher;

    private String forumUrl;

    private String developer;

    private String originalCategory;

    private Boolean isMovie;

    private String category;

    public Boolean getBuyable() {
      return this.buyable;
    }

    public void setBuyable(Boolean buyable) {
      this.buyable = buyable;
    }

    public Boolean getIsDiscounted() {
      return this.isDiscounted;
    }

    public void setIsDiscounted(Boolean isDiscounted) {
      this.isDiscounted = isDiscounted;
    }

    public List<String> getSupportedOperatingSystems() {
      return this.supportedOperatingSystems;
    }

    public void setSupportedOperatingSystems(List<String> supportedOperatingSystems) {
      this.supportedOperatingSystems = supportedOperatingSystems;
    }

    public SalesVisibility getSalesVisibility() {
      return this.salesVisibility;
    }

    public void setSalesVisibility(SalesVisibility salesVisibility) {
      this.salesVisibility = salesVisibility;
    }

    public String getSupportUrl() {
      return this.supportUrl;
    }

    public void setSupportUrl(String supportUrl) {
      this.supportUrl = supportUrl;
    }

    public Integer getRating() {
      return this.rating;
    }

    public void setRating(Integer rating) {
      this.rating = rating;
    }

    public Video getVideo() {
      return this.video;
    }

    public void setVideo(Video video) {
      this.video = video;
    }

    public Availability getAvailability() {
      return this.availability;
    }

    public void setAvailability(Availability availability) {
      this.availability = availability;
    }

    public String getTitle() {
      return this.title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public Integer getType() {
      return this.type;
    }

    public void setType(Integer type) {
      this.type = type;
    }

    public Integer getAgeLimit() {
      return this.ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
      this.ageLimit = ageLimit;
    }

    public Boolean getIsTBA() {
      return this.isTBA;
    }

    public void setIsTBA(Boolean isTBA) {
      this.isTBA = isTBA;
    }

    public Boolean getIsPriceVisible() {
      return this.isPriceVisible;
    }

    public void setIsPriceVisible(Boolean isPriceVisible) {
      this.isPriceVisible = isPriceVisible;
    }

    public List<String> getGenres() {
      return this.genres;
    }

    public void setGenres(List<String> genres) {
      this.genres = genres;
    }

    public Price getPrice() {
      return this.price;
    }

    public void setPrice(Price price) {
      this.price = price;
    }

    public Boolean getIsInDevelopment() {
      return this.isInDevelopment;
    }

    public void setIsInDevelopment(Boolean isInDevelopment) {
      this.isInDevelopment = isInDevelopment;
    }

    public Integer getId() {
      return this.id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public List<String> getGallery() {
      return this.gallery;
    }

    public void setGallery(List<String> gallery) {
      this.gallery = gallery;
    }

    public String getSlug() {
      return this.slug;
    }

    public void setSlug(String slug) {
      this.slug = slug;
    }

    public Boolean getIsGame() {
      return this.isGame;
    }

    public void setIsGame(Boolean isGame) {
      this.isGame = isGame;
    }

    public String getImage() {
      return this.image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public Integer getReleaseDate() {
      return this.releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
      this.releaseDate = releaseDate;
    }

    public WorksOn getWorksOn() {
      return this.worksOn;
    }

    public void setWorksOn(WorksOn worksOn) {
      this.worksOn = worksOn;
    }

    public Boolean getIsWishlistable() {
      return this.isWishlistable;
    }

    public void setIsWishlistable(Boolean isWishlistable) {
      this.isWishlistable = isWishlistable;
    }

    public String getUrl() {
      return this.url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public Integer getGlobalReleaseDate() {
      return this.globalReleaseDate;
    }

    public void setGlobalReleaseDate(Integer globalReleaseDate) {
      this.globalReleaseDate = globalReleaseDate;
    }

    public Boolean getIsComingSoon() {
      return this.isComingSoon;
    }

    public void setIsComingSoon(Boolean isComingSoon) {
      this.isComingSoon = isComingSoon;
    }

    public String getPublisher() {
      return this.publisher;
    }

    public void setPublisher(String publisher) {
      this.publisher = publisher;
    }

    public String getForumUrl() {
      return this.forumUrl;
    }

    public void setForumUrl(String forumUrl) {
      this.forumUrl = forumUrl;
    }

    public String getDeveloper() {
      return this.developer;
    }

    public void setDeveloper(String developer) {
      this.developer = developer;
    }

    public String getOriginalCategory() {
      return this.originalCategory;
    }

    public void setOriginalCategory(String originalCategory) {
      this.originalCategory = originalCategory;
    }

    public Boolean getIsMovie() {
      return this.isMovie;
    }

    public void setIsMovie(Boolean isMovie) {
      this.isMovie = isMovie;
    }

    public String getCategory() {
      return this.category;
    }

    public void setCategory(String category) {
      this.category = category;
    }

    public static class SalesVisibility implements Serializable {
      private FromObject fromObject;

      private Integer from;

      private FromObject toObject;

      private Integer to;

      private Boolean isActive;

      public FromObject getFromObject() {
        return this.fromObject;
      }

      public void setFromObject(FromObject fromObject) {
        this.fromObject = fromObject;
      }

      public Integer getFrom() {
        return this.from;
      }

      public void setFrom(Integer from) {
        this.from = from;
      }

      public FromObject getToObject() {
        return this.toObject;
      }

      public void setToObject(FromObject toObject) {
        this.toObject = toObject;
      }

      public Integer getTo() {
        return this.to;
      }

      public void setTo(Integer to) {
        this.to = to;
      }

      public Boolean getIsActive() {
        return this.isActive;
      }

      public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
      }

      public static class FromObject implements Serializable {
        private String date;

        private String timezone;

        private Integer timezone_type;

        public String getDate() {
          return this.date;
        }

        public void setDate(String date) {
          this.date = date;
        }

        public String getTimezone() {
          return this.timezone;
        }

        public void setTimezone(String timezone) {
          this.timezone = timezone;
        }

        public Integer getTimezone_type() {
          return this.timezone_type;
        }

        public void setTimezone_type(Integer timezone_type) {
          this.timezone_type = timezone_type;
        }
      }
    }

    public static class Video implements Serializable {
      private String provider;

      private String id;

      public String getProvider() {
        return this.provider;
      }

      public void setProvider(String provider) {
        this.provider = provider;
      }

      public String getId() {
        return this.id;
      }

      public void setId(String id) {
        this.id = id;
      }
    }

    public static class Availability implements Serializable {
      private Boolean isAvailable;

      private Boolean isAvailableInAccount;

      public Boolean getIsAvailable() {
        return this.isAvailable;
      }

      public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
      }

      public Boolean getIsAvailableInAccount() {
        return this.isAvailableInAccount;
      }

      public void setIsAvailableInAccount(Boolean isAvailableInAccount) {
        this.isAvailableInAccount = isAvailableInAccount;
      }
    }

    public static class Price implements Serializable {
      private Boolean isDiscounted;

      private String symbol;

      private String amount;

      private String bonusStoreCreditAmount;

      private Boolean isBonusStoreCreditIncluded;

      private Integer discount;

      private String baseAmount;

      private Integer discountPercentage;

      private Boolean isFree;

      private String finalAmount;

      private String currency;

      private Object promoId;

      private String discountDifference;

      public Boolean getIsDiscounted() {
        return this.isDiscounted;
      }

      public void setIsDiscounted(Boolean isDiscounted) {
        this.isDiscounted = isDiscounted;
      }

      public String getSymbol() {
        return this.symbol;
      }

      public void setSymbol(String symbol) {
        this.symbol = symbol;
      }

      public String getAmount() {
        return this.amount;
      }

      public void setAmount(String amount) {
        this.amount = amount;
      }

      public String getBonusStoreCreditAmount() {
        return this.bonusStoreCreditAmount;
      }

      public void setBonusStoreCreditAmount(String bonusStoreCreditAmount) {
        this.bonusStoreCreditAmount = bonusStoreCreditAmount;
      }

      public Boolean getIsBonusStoreCreditIncluded() {
        return this.isBonusStoreCreditIncluded;
      }

      public void setIsBonusStoreCreditIncluded(Boolean isBonusStoreCreditIncluded) {
        this.isBonusStoreCreditIncluded = isBonusStoreCreditIncluded;
      }

      public Integer getDiscount() {
        return this.discount;
      }

      public void setDiscount(Integer discount) {
        this.discount = discount;
      }

      public String getBaseAmount() {
        return this.baseAmount;
      }

      public void setBaseAmount(String baseAmount) {
        this.baseAmount = baseAmount;
      }

      public Integer getDiscountPercentage() {
        return this.discountPercentage;
      }

      public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
      }

      public Boolean getIsFree() {
        return this.isFree;
      }

      public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
      }

      public String getFinalAmount() {
        return this.finalAmount;
      }

      public void setFinalAmount(String finalAmount) {
        this.finalAmount = finalAmount;
      }

      public String getCurrency() {
        return this.currency;
      }

      public void setCurrency(String currency) {
        this.currency = currency;
      }

      public Object getPromoId() {
        return this.promoId;
      }

      public void setPromoId(Object promoId) {
        this.promoId = promoId;
      }

      public String getDiscountDifference() {
        return this.discountDifference;
      }

      public void setDiscountDifference(String discountDifference) {
        this.discountDifference = discountDifference;
      }
    }

    public static class WorksOn implements Serializable {
      private Boolean Linux;

      private Boolean Windows;

      private Boolean Mac;

      public Boolean getLinux() {
        return this.Linux;
      }

      public void setLinux(Boolean Linux) {
        this.Linux = Linux;
      }

      public Boolean getWindows() {
        return this.Windows;
      }

      public void setWindows(Boolean Windows) {
        this.Windows = Windows;
      }

      public Boolean getMac() {
        return this.Mac;
      }

      public void setMac(Boolean Mac) {
        this.Mac = Mac;
      }
    }
  }
}
