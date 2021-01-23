package com.youland.WebCrawler;

public class webCrawlerUrlList {
    private String rank;

    private String URL;

    private String Linkingrootdomains;

    private String Externallinks;

    private String mozRank;

    private String mozTrust;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getLinkingrootdomains() {
        return Linkingrootdomains;
    }

    public void setLinkingrootdomains(String linkingrootdomains) {
        Linkingrootdomains = linkingrootdomains;
    }

    public String getExternallinks() {
        return Externallinks;
    }

    public void setExternallinks(String externallinks) {
        Externallinks = externallinks;
    }

    public String getMozRank() {
        return mozRank;
    }

    public void setMozRank(String mozRank) {
        this.mozRank = mozRank;
    }

    public String getMozTrust() {
        return mozTrust;
    }

    public void setMozTrust(String mozTrust) {
        this.mozTrust = mozTrust;
    }

    public webCrawlerUrlList(String rank, String URL, String linkingrootdomains, String externallinks, String mozRank, String mozTrust) {
        this.rank = rank;
        this.URL = URL;
        this.Linkingrootdomains = linkingrootdomains;
        this.Externallinks = externallinks;
        this.mozRank = mozRank;
        this.mozTrust = mozTrust;
    }

}
