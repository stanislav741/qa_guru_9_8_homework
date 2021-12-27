package tests;

public enum LanguageSwitcher {
    DE("/de/home/", "EN"),
    EN("/en/home/", "DE");

    private String url;
    private String title;

    LanguageSwitcher(String switchUrl, String switchTitle)
    {
        url = switchUrl;
        title = switchTitle;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
