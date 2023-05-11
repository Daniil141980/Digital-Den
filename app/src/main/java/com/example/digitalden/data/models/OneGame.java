package com.example.digitalden.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OneGame implements Serializable {
    private int id;
    private Data data;
    private boolean success;

    public OneGame(int id, Data data, boolean success) {
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
        private String header_image;

        private String short_description;

        private String supported_languages;

        private String website;

        private String legal_notice;

        private Integer steam_appid;

        private Pc_requirements pc_requirements;

        private Price_overview price_overview;

        private String type;

        private String controller_support;

        private String about_the_game;

        private String required_age;

        private String detailed_description;

        private boolean is_free;

        private String name;

        private String drm_notice;

        private List<Integer> dlc;

        public String getHeader_image() {
            return this.header_image;
        }

        public void setHeader_image(String header_image) {
            this.header_image = header_image;
        }

        public String getShort_description() {
            return this.short_description;
        }

        public void setShort_description(String short_description) {
            this.short_description = short_description;
        }

        public String getSupported_languages() {
            return this.supported_languages;
        }

        public void setSupported_languages(String supported_languages) {
            this.supported_languages = supported_languages;
        }

        public String getWebsite() {
            return this.website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getLegal_notice() {
            return this.legal_notice;
        }

        public void setLegal_notice(String legal_notice) {
            this.legal_notice = legal_notice;
        }

        public Integer getSteam_appid() {
            return this.steam_appid;
        }

        public void setSteam_appid(Integer steam_appid) {
            this.steam_appid = steam_appid;
        }

        public Pc_requirements getPc_requirements() {
            return this.pc_requirements;
        }

        public void setPc_requirements(Pc_requirements pc_requirements) {
            this.pc_requirements = pc_requirements;
        }

        public Price_overview getPrice_overview() {
            return this.price_overview;
        }

        public void setPrice_overview(Price_overview price_overview) {
            this.price_overview = price_overview;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getController_support() {
            return this.controller_support;
        }

        public void setController_support(String controller_support) {
            this.controller_support = controller_support;
        }

        public String getAbout_the_game() {
            return this.about_the_game;
        }

        public void setAbout_the_game(String about_the_game) {
            this.about_the_game = about_the_game;
        }

        public String getRequired_age() {
            return this.required_age;
        }

        public void setRequired_age(String required_age) {
            this.required_age = required_age;
        }

        public String getDetailed_description() {
            return this.detailed_description;
        }

        public void setDetailed_description(String detailed_description) {
            this.detailed_description = detailed_description;
        }

        public boolean getIs_free() {
            return this.is_free;
        }

        public void setIs_free(boolean is_free) {
            this.is_free = is_free;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDrm_notice() {
            return this.drm_notice;
        }

        public void setDrm_notice(String drm_notice) {
            this.drm_notice = drm_notice;
        }

        public List<Integer> getDlc() {
            return this.dlc;
        }

        public void setDlc(List<Integer> dlc) {
            this.dlc = dlc;
        }

        public static class Pc_requirements implements Serializable {
            private String minimum;

            private String recommended;

            public String getMinimum() {
                return this.minimum;
            }

            public void setMinimum(String minimum) {
                this.minimum = minimum;
            }

            public String getRecommended() {
                return this.recommended;
            }

            public void setRecommended(String recommended) {
                this.recommended = recommended;
            }
        }

        public static class Price_overview implements Serializable {
            private String final_formatted;

            private Integer initial;

            private String currency;

            private String initial_formatted;

            private Integer discount_percent;

            @SerializedName("final")
            private Integer ffinal;

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

            public Integer getFfinal() {
                return this.ffinal;
            }

            public void setFfinal(Integer ffinal) {
                this.ffinal = ffinal;
            }
        }
    }

}
