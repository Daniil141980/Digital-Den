package com.example.digitalden.data.models;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.List;

public class FreeGames implements Serializable {
  private Object extensions;

  private Data data;

  public Object getExtensions() {
    return this.extensions;
  }

  public void setExtensions(Object extensions) {
    this.extensions = extensions;
  }

  public Data getData() {
    return this.data;
  }

  public void setData(Data data) {
    this.data = data;
  }

  public static class Data implements Serializable {
    private Catalog Catalog;

    public Catalog getCatalog() {
      return this.Catalog;
    }

    public void setCatalog(Catalog Catalog) {
      this.Catalog = Catalog;
    }

    public static class Catalog implements Serializable {
      private SearchStore searchStore;

      public SearchStore getSearchStore() {
        return this.searchStore;
      }

      public void setSearchStore(SearchStore searchStore) {
        this.searchStore = searchStore;
      }

      public static class SearchStore implements Serializable {
        private List<Elements> elements;

        private Paging paging;

        public List<Elements> getElements() {
          return this.elements;
        }

        public void setElements(List<Elements> elements) {
          this.elements = elements;
        }

        public Paging getPaging() {
          return this.paging;
        }

        public void setPaging(Paging paging) {
          this.paging = paging;
        }

        public static class Elements implements Serializable {
          private Seller seller;

          private String urlSlug;

          private String viewableDate;

          private String description;

          private String title;

          private String productSlug;

          private Object url;

          private Object expiryDate;

          private String offerType;

          private Promotions promotions;

          private List<KeyImages> keyImages;

          private Price price;

          private String namespace;

          private CatalogNs catalogNs;

          private String id;

          private List<Categories> categories;

          private List<Items> items;

          private String effectiveDate;

          private String status;

          private Boolean isCodeRedemptionOnly;

          private List<CustomAttributes> customAttributes;

          public Seller getSeller() {
            return this.seller;
          }

          public void setSeller(Seller seller) {
            this.seller = seller;
          }

          public String getUrlSlug() {
            return this.urlSlug;
          }

          public void setUrlSlug(String urlSlug) {
            this.urlSlug = urlSlug;
          }

          public String getViewableDate() {
            return this.viewableDate;
          }

          public void setViewableDate(String viewableDate) {
            this.viewableDate = viewableDate;
          }

          public String getDescription() {
            return this.description;
          }

          public void setDescription(String description) {
            this.description = description;
          }

          public String getTitle() {
            return this.title;
          }

          public void setTitle(String title) {
            this.title = title;
          }

          public String getProductSlug() {
            return this.productSlug;
          }

          public void setProductSlug(String productSlug) {
            this.productSlug = productSlug;
          }

          public Object getUrl() {
            return this.url;
          }

          public void setUrl(Object url) {
            this.url = url;
          }

          public Object getExpiryDate() {
            return this.expiryDate;
          }

          public void setExpiryDate(Object expiryDate) {
            this.expiryDate = expiryDate;
          }

          public String getOfferType() {
            return this.offerType;
          }

          public void setOfferType(String offerType) {
            this.offerType = offerType;
          }

          public Promotions getPromotions() {
            return this.promotions;
          }

          public void setPromotions(Promotions promotions) {
            this.promotions = promotions;
          }

          public List<KeyImages> getKeyImages() {
            return this.keyImages;
          }

          public void setKeyImages(List<KeyImages> keyImages) {
            this.keyImages = keyImages;
          }

          public Price getPrice() {
            return this.price;
          }

          public void setPrice(Price price) {
            this.price = price;
          }

          public String getNamespace() {
            return this.namespace;
          }

          public void setNamespace(String namespace) {
            this.namespace = namespace;
          }

          public CatalogNs getCatalogNs() {
            return this.catalogNs;
          }

          public void setCatalogNs(CatalogNs catalogNs) {
            this.catalogNs = catalogNs;
          }

          public String getId() {
            return this.id;
          }

          public void setId(String id) {
            this.id = id;
          }

          public List<Categories> getCategories() {
            return this.categories;
          }

          public void setCategories(List<Categories> categories) {
            this.categories = categories;
          }

          public List<Items> getItems() {
            return this.items;
          }

          public void setItems(List<Items> items) {
            this.items = items;
          }

          public String getEffectiveDate() {
            return this.effectiveDate;
          }

          public void setEffectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
          }

          public String getStatus() {
            return this.status;
          }

          public void setStatus(String status) {
            this.status = status;
          }

          public Boolean getIsCodeRedemptionOnly() {
            return this.isCodeRedemptionOnly;
          }

          public void setIsCodeRedemptionOnly(Boolean isCodeRedemptionOnly) {
            this.isCodeRedemptionOnly = isCodeRedemptionOnly;
          }

          public List<CustomAttributes> getCustomAttributes() {
            return this.customAttributes;
          }

          public void setCustomAttributes(List<CustomAttributes> customAttributes) {
            this.customAttributes = customAttributes;
          }

          public static class Seller implements Serializable {
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

          public static class Promotions implements Serializable {
            private List<UpcomingPromotionalOffers> upcomingPromotionalOffers;

            public List<UpcomingPromotionalOffers> getUpcomingPromotionalOffers() {
              return this.upcomingPromotionalOffers;
            }

            public void setUpcomingPromotionalOffers(List<UpcomingPromotionalOffers> upcomingPromotionalOffers) {
              this.upcomingPromotionalOffers = upcomingPromotionalOffers;
            }

            public static class UpcomingPromotionalOffers implements Serializable {
              private List<PromotionalOffers> promotionalOffers;

              public List<PromotionalOffers> getPromotionalOffers() {
                return this.promotionalOffers;
              }

              public void setPromotionalOffers(List<PromotionalOffers> promotionalOffers) {
                this.promotionalOffers = promotionalOffers;
              }

              public static class PromotionalOffers implements Serializable {
                private DiscountSetting discountSetting;

                private String endDate;

                private String startDate;

                public DiscountSetting getDiscountSetting() {
                  return this.discountSetting;
                }

                public void setDiscountSetting(DiscountSetting discountSetting) {
                  this.discountSetting = discountSetting;
                }

                public String getEndDate() {
                  return this.endDate;
                }

                public void setEndDate(String endDate) {
                  this.endDate = endDate;
                }

                public String getStartDate() {
                  return this.startDate;
                }

                public void setStartDate(String startDate) {
                  this.startDate = startDate;
                }

                public static class DiscountSetting implements Serializable {
                  private Integer discountPercentage;

                  private String discountType;

                  public Integer getDiscountPercentage() {
                    return this.discountPercentage;
                  }

                  public void setDiscountPercentage(Integer discountPercentage) {
                    this.discountPercentage = discountPercentage;
                  }

                  public String getDiscountType() {
                    return this.discountType;
                  }

                  public void setDiscountType(String discountType) {
                    this.discountType = discountType;
                  }
                }
              }
            }
          }

          public static class KeyImages implements Serializable {
            private String type;

            private String url;

            public String getType() {
              return this.type;
            }

            public void setType(String type) {
              this.type = type;
            }

            public String getUrl() {
              return this.url;
            }

            public void setUrl(String url) {
              this.url = url;
            }
          }

          public static class Price implements Serializable {
            private TotalPrice totalPrice;

            private List<LineOffers> lineOffers;

            public TotalPrice getTotalPrice() {
              return this.totalPrice;
            }

            public void setTotalPrice(TotalPrice totalPrice) {
              this.totalPrice = totalPrice;
            }

            public List<LineOffers> getLineOffers() {
              return this.lineOffers;
            }

            public void setLineOffers(List<LineOffers> lineOffers) {
              this.lineOffers = lineOffers;
            }

            public static class TotalPrice implements Serializable {
              private FmtPrice fmtPrice;

              private Integer originalPrice;

              private Integer discountPrice;

              private Integer discount;

              private CurrencyInfo currencyInfo;

              private String currencyCode;

              private Integer voucherDiscount;

              public FmtPrice getFmtPrice() {
                return this.fmtPrice;
              }

              public void setFmtPrice(FmtPrice fmtPrice) {
                this.fmtPrice = fmtPrice;
              }

              public Integer getOriginalPrice() {
                return this.originalPrice;
              }

              public void setOriginalPrice(Integer originalPrice) {
                this.originalPrice = originalPrice;
              }

              public Integer getDiscountPrice() {
                return this.discountPrice;
              }

              public void setDiscountPrice(Integer discountPrice) {
                this.discountPrice = discountPrice;
              }

              public Integer getDiscount() {
                return this.discount;
              }

              public void setDiscount(Integer discount) {
                this.discount = discount;
              }

              public CurrencyInfo getCurrencyInfo() {
                return this.currencyInfo;
              }

              public void setCurrencyInfo(CurrencyInfo currencyInfo) {
                this.currencyInfo = currencyInfo;
              }

              public String getCurrencyCode() {
                return this.currencyCode;
              }

              public void setCurrencyCode(String currencyCode) {
                this.currencyCode = currencyCode;
              }

              public Integer getVoucherDiscount() {
                return this.voucherDiscount;
              }

              public void setVoucherDiscount(Integer voucherDiscount) {
                this.voucherDiscount = voucherDiscount;
              }

              public static class FmtPrice implements Serializable {
                private String originalPrice;

                private String discountPrice;

                private String intermediatePrice;

                public String getOriginalPrice() {
                  return this.originalPrice;
                }

                public void setOriginalPrice(String originalPrice) {
                  this.originalPrice = originalPrice;
                }

                public String getDiscountPrice() {
                  return this.discountPrice;
                }

                public void setDiscountPrice(String discountPrice) {
                  this.discountPrice = discountPrice;
                }

                public String getIntermediatePrice() {
                  return this.intermediatePrice;
                }

                public void setIntermediatePrice(String intermediatePrice) {
                  this.intermediatePrice = intermediatePrice;
                }
              }

              public static class CurrencyInfo implements Serializable {
                private Integer decimals;

                public Integer getDecimals() {
                  return this.decimals;
                }

                public void setDecimals(Integer decimals) {
                  this.decimals = decimals;
                }
              }
            }

            public static class LineOffers implements Serializable {
            }
          }

          public static class CatalogNs implements Serializable {
          }

          public static class Categories implements Serializable {
            private String path;

            public String getPath() {
              return this.path;
            }

            public void setPath(String path) {
              this.path = path;
            }
          }

          public static class Items implements Serializable {
            private String namespace;

            private String id;

            public String getNamespace() {
              return this.namespace;
            }

            public void setNamespace(String namespace) {
              this.namespace = namespace;
            }

            public String getId() {
              return this.id;
            }

            public void setId(String id) {
              this.id = id;
            }
          }

          public static class CustomAttributes implements Serializable {
            private String value;

            private String key;

            public String getValue() {
              return this.value;
            }

            public void setValue(String value) {
              this.value = value;
            }

            public String getKey() {
              return this.key;
            }

            public void setKey(String key) {
              this.key = key;
            }
          }
        }

        public static class Paging implements Serializable {
          private Integer total;

          private Integer count;

          public Integer getTotal() {
            return this.total;
          }

          public void setTotal(Integer total) {
            this.total = total;
          }

          public Integer getCount() {
            return this.count;
          }

          public void setCount(Integer count) {
            this.count = count;
          }
        }
      }
    }
  }
}
