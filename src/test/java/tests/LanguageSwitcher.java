package tests;

public enum LanguageSwitcher {
    DE("/de/home/", "EN"),
    EN("/en/home/", "DE");

    private String url;
    private String title;

    LanguageSwitcher(String switcherUrl, String switcherTitle)
    {
        url = switcherUrl;
        title = switcherTitle;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
