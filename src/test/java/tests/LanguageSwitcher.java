// структура этого файла была скопирована отсюда:
// https://github.com/elenaAeternanox/qa_quru_eighth_homework/blob/main/src/test/java/com/github/elenaAeternanox/eighthHomeWork/GoodsList.java
// мне непонятно для чего используется именно такая структура? Чтобы сконвертировать все значения enum в String, при выполнении нашего теста?
package tests;

public enum LanguageSwitcher {
    DE("/de/home/", "EN"), //непонятно почему именно так, в скобках, устроено перечисление параметров. На уроке про это не было рассказано
    EN("/en/home/", "DE");

    private String url;             //Здесь объявляются переменные, это вроде понятно
    private String title;

    LanguageSwitcher(String url, String title)      //Для чего нужен этот метод? Чтобы связать переменные со значениями из enum? Почему он объявлен именно таким образом, без void?
    {
        this.url = url;                             //Для чего здесь кейворд this?
        this.title = title;
    }

    public String getUrl() {                        //Эти методы будут испоьзованы для передачи значений наших параметров в формате String. Это вроде понятно
        return url;
    }

    public String getTitle() {
        return title;
    }
}
