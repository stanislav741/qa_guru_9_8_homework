// структура этого файла была скопирована отсюда:
// https://github.com/elenaAeternanox/qa_quru_eighth_homework/blob/main/src/test/java/com/github/elenaAeternanox/eighthHomeWork/GoodsList.java
// мне непонятно для чего используется именно такая структура? Чтобы сконвертировать все значения enum в String, при выполнении нашего теста?
package tests;

public enum LanguageSwitcher {
    DE("/de/home/", "EN"),
    EN("/en/home/", "DE");

    private String url;
    private String title;

    LanguageSwitcher(String switchUrl, String switchTitle)
    {
        this.url = switchUrl;
        this.title = switchTitle;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
