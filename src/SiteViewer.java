import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SiteViewer {

    // 1. СПИСОК ТВОИХ ПРОКСИ (Замени эти цифры на адреса своих реальных купленных прокси!)
    private static final List<String> PROXY_LIST = Arrays.asList(
           // "102.244.78.61:8090",
            //"185.162.130.4:3128"
           "45.194.3.132:8080"
            //"85.237.39.139:8080"

    );

    public static void main(String[] args) {
        // Выбираем случайный IP из списка для маскировки перед Яндекс.Метрикой
        String randomProxy = PROXY_LIST.get(new Random().nextInt(PROXY_LIST.size()));
        System.out.println("Запуск скрытного просмотра через случайный IP: " + randomProxy);

        // 2. Настраиваем прокси-сервер для Java
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(randomProxy);
        proxy.setSslProxy(randomProxy);

        // 3. Автоматически подготавливаем чистый драйвер Chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Внедряем прокси в настройки браузера
        options.setCapability("proxy", proxy);

        // Включаем приватный режим инкогнито и открываем во весь экран
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        // Блок невидимости для систем аналитики (Stealth)
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36");

        // 4. Запускаем изолированное окно с НОВЫМ IP-адресом
        WebDriver driver = new ChromeDriver(options);

        try {
            // 1 ЭТАП: Заходим сразу на страницу портфолио
            String portfolioUrl = "https://haycaptaintattoo.com";
            System.out.println("Открываем адрес: " + portfolioUrl);
            driver.get(portfolioUrl);

            // Через прокси интернет может быть чуть медленнее, даем сайту 8 секунд прогрузиться
            Thread.sleep(7000);
            {
                int totalSteps = 12;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        System.out.println("Задержка: " + viewSeconds + " сек...");
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }

            Thread.sleep(8000);

            // 2 ЭТАП: Переход на Главную
            System.out.println("Ищем кнопку 'ГЛАВНАЯ'...");
            WebElement rlioLink = driver.findElement(By.linkText("ГЛАВНАЯ"));
            rlioLink.click();
            System.out.println("Успешно перешли в раздел ГЛАВНАЯ!");
            Thread.sleep(9000);
            {
                int totalSteps = 8;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }
            System.out.println("Ищем кнопку 'О НАС'...");
            WebElement olioLink = driver.findElement(By.linkText("О НАС"));
            olioLink.click();
            System.out.println("Успешно перешли в раздел О НАС!");
            Thread.sleep(6000);
            {
                int totalSteps = 6;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }

            // 3 ЭТАП: Переход в Портфолио
            System.out.println("Ищем кнопку 'ПОРТФОЛИО'...");
            WebElement portfolioLink = driver.findElement(By.linkText("ПОРТФОЛИО"));
            portfolioLink.click();
            System.out.println("Успешно перешли в раздел ПОРТФОЛИО!");
            Thread.sleep(6000);
            {
                int totalSteps = 23;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }

            // 4 ЭТАП: Переход в Отзывы
            System.out.println("Ищем кнопку 'ОТЗЫВЫ'...");
            WebElement otzlioLink = driver.findElement(By.linkText("ОТЗЫВЫ"));
            otzlioLink.click();
            System.out.println("Успешно перешли в раздел ОТЗЫВЫ!");
            Thread.sleep(5000);
            {
                int totalSteps = 4;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }
            System.out.println("Ищем кнопку 'ПОРТФОЛИО'...");
            WebElement golioLink = driver.findElement(By.linkText("ПОРТФОЛИО"));
            golioLink.click();
            System.out.println("Успешно перешли в раздел ПОРТФОЛИО!");
            Thread.sleep(9000);
            {
                int totalSteps = 6;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }

            // 5 ЭТАП: Переход в Контакты
            System.out.println("Ищем кнопку 'КОНТАКТЫ'...");
            WebElement qLink = driver.findElement(By.linkText("КОНТАКТЫ"));
            qLink.click();
            System.out.println("Успешно перешли в раздел КОНТАКТЫ!");
            Thread.sleep(5000);
            {
                int totalSteps = 3;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }

            // 3 ЭТАП: Переход в Портфолио
            System.out.println("Ищем кнопку 'ПОРТФОЛИО'...");
            WebElement aportfolioLink = driver.findElement(By.linkText("ПОРТФОЛИО"));
            aportfolioLink.click();
            System.out.println("Успешно перешли в раздел ПОРТФОЛИО!");
            Thread.sleep(6000);
            {
                int totalSteps = 11;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }

            // 4 ЭТАП: Переход в НАШИ УСЛУГИ И ЦЕНЫ
            System.out.println("Ищем кнопку 'НАШИ УСЛУГИ И ЦЕНЫ'...");
            WebElement ostzlioLink = driver.findElement(By.linkText("НАШИ УСЛУГИ И ЦЕНЫ"));
            ostzlioLink.click();
            System.out.println("Успешно перешли в раздел НАШИ УСЛУГИ И ЦЕНЫ!");
            Thread.sleep(8000);
            {
                int totalSteps = 4;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }

            // 5 ЭТАП: Переход в Контакты
            System.out.println("Ищем кнопку 'КОНТАКТЫ'...");
            WebElement qdLink = driver.findElement(By.linkText("КОНТАКТЫ"));
            qdLink.click();
            System.out.println("Успешно перешли в раздел КОНТАКТЫ!");
            Thread.sleep(5000);
            {
                int totalSteps = 3;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }

            // ФИНАЛЬНЫЙ ЭТАП: Возвращаемся в Портфолио
            System.out.println("Ищем кнопку 'ПОРТФОЛИО'...");
            WebElement wLink = driver.findElement(By.linkText("ПОРТФОЛИО"));
            wLink.click();
            System.out.println("Успешно вернулись в раздел ПОРТФОЛИО!");
            Thread.sleep(4000);
            {
                int totalSteps = 10;
                for (int step = 1; step <= totalSteps; step++) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 450, behavior: 'smooth'});");
                        System.out.println("Прокрутка страницы. Шаг №" + step + " из " + totalSteps);
                        int viewSeconds = 5 + new Random().nextInt(6);
                        Thread.sleep(viewSeconds * 1000);
                    } catch (Exception scrollError) {
                        System.err.println("Ошибка прокрутки: " + scrollError.getMessage());
                    }
                }
            }

            System.out.println("Весь сценарий обхода под уникальным IP успешно выполнен!");

        } catch (Exception e) {
            System.err.println("Произошла критическая ошибка: " + e.getMessage());
        } finally {
            // Закрываем окно браузера
            System.out.println("Закрываем тестовое окно Chrome.");
            driver.quit();
        }
    }
}