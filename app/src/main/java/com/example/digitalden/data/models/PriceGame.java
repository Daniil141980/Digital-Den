package com.example.digitalden.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PriceGame implements Serializable {
    int id;
    private Data data;

    private boolean success;

    public PriceGame(int id, Data data, boolean success) {
        this.id = id;
        this.data = data;
        this.success = success;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class Data implements Serializable {
        private Price_overview price_overview;

        public Price_overview getPrice_overview() {
            return this.price_overview;
        }

        public void setPrice_overview(Price_overview price_overview) {
            this.price_overview = price_overview;
        }

        public static class Price_overview implements Serializable {
            @SerializedName("final")
            private Integer finall;

            private String final_formatted;

            private Integer initial;

            private String currency;

            private String initial_formatted;

            private Integer discount_percent;

            public Integer getResult() {
                return this.finall;
            }

            public void setResult(Integer result) {
                this.finall = result;
            }

            public String getFinal_formatted() {
                return this.final_formatted;
            }

            public void setFinal_formatted(String final_formatted) {
                this.final_formatted = final_formatted;
            }

            public Integer getInitial() {
                return this.initial;
            }

            public void setInitial(Integer initial) {
                this.initial = initial;
            }

            public String getCurrency() {
                return this.currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getInitial_formatted() {
                return this.initial_formatted;
            }

            public void setInitial_formatted(String initial_formatted) {
                this.initial_formatted = initial_formatted;
            }

            public Integer getDiscount_percent() {
                return this.discount_percent;
            }

            public void setDiscount_percent(Integer discount_percent) {
                this.discount_percent = discount_percent;
            }
        }
    }
}
