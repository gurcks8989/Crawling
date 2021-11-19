package com.spring.crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.openqa.selenium.Alert;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import io.github.bonigarcia.wdm.WebDriverManager;

@Component
public class Selenium {
//	@Value("${hisnet.id}")
//    public static String login_id ;
//	
//	@Value("${hisnet.password}")
//    public static String login_pw ;
	private Map<String, String> crawling_urls = Stream.of(new String[][] { 
					{ "일반공지", "https://hisnet.handong.edu/myboard/list.php?Board=NB0001" },
					{ "글로벌리더쉽", "https://hisnet.handong.edu/myboard/list.php?Board=B0020" },
					{ "국제어문", "https://hisnet.handong.edu/myboard/list.php?Board=B0021" },
					{ "경영경제", "https://hisnet.handong.edu/myboard/list.php?Board=B0022" },
					{ "법학부", "https://hisnet.handong.edu/myboard/list.php?Board=B0023" },
					{ "커뮤니케이션", "https://hisnet.handong.edu/myboard/list.php?Board=B0024" },
					{ "상담복지", "https://hisnet.handong.edu/myboard/list.php?Board=B0102" },
					{ "생명과학", "https://hisnet.handong.edu/myboard/list.php?Board=B0028" },
					{ "공간환경시스템", "https://hisnet.handong.edu/myboard/list.php?Board=B0025" },
					{ "전산전자", "https://hisnet.handong.edu/myboard/list.php?Board=B0029" },
					{ "콘텐츠융합디자인", "https://hisnet.handong.edu/myboard/list.php?Board=B0027" },
					{ "기계제어", "https://hisnet.handong.edu/myboard/list.php?Board=B0026" },
					{ "ICT창업학부", "https://hisnet.handong.edu/myboard/list.php?Board=B0419" },
					{ "창의융합교육원", "https://hisnet.handong.edu/myboard/list.php?Board=B0427" },
					{ "AI융합교육원", "https://hisnet.handong.edu/myboard/list.php?Board=B0431" },
					{ "대학원공지", "https://hisnet.handong.edu/myboard/list.php?Board=B0113" },
					{ "장학공지", "https://hisnet.handong.edu/myboard/list.php?Board=JANG_NOTICE" },
					{ "취업공지", "https://hisnet.handong.edu/myboard/list.php?Board=B0364" } })
			.collect(Collectors.toMap(data -> data[0], data -> data[1]));

	private WebDriver driver;

	public static String TEST_URL = "https://hisnet.handong.edu";

//	@Scheduled(cron = "* */5 * * * *")
	@Scheduled(cron = "*/30 * * * * *")
	public void testing() {
		login();
		for (Map.Entry<String, String> entry : crawling_urls.entrySet()) {
			crawling(entry);
		}
		driver_closing();
	}

	public void login() {
		WebDriverManager.chromedriver().setup();

		// WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // 최대크기로
		options.addArguments("--headless"); // Browser를 띄우지 않음
		options.addArguments("--disable-gpu"); // GPU를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
		options.addArguments("--no-sandbox"); // Sandbox 프로세스를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.

		// WebDriver 객체 생성
		driver = new ChromeDriver(options);

		System.out.println("[Debug] Start-login");
		try {
			driver.get(TEST_URL);

			// switch Frame to MainFrame
			driver.switchTo().frame("MainFrame");

			driver.findElement(By.name("id")).sendKeys("gurcks8989");
			Thread.sleep(500);
			driver.findElement(By.name("password")).sendKeys("zxc123");
			Thread.sleep(500);

			driver.findElement(By.xpath(
					"//*[@id='loginBoxBg']/table[2]/tbody/tr/td[5]/form/table/tbody/tr[3]/td/table/tbody/tr/td[2]/input"))
					.click();

			Thread.sleep(10000);
			try {
				if (driver.findElement(By.xpath("/html/body/div[3]/div/button")) != null) {
					System.out.println("found this button");
					driver.findElement(By.xpath("/html/body/div[3]/div/button")).click();
					Alert alert_box = driver.switchTo().alert();
					Thread.sleep(700L);
					alert_box.accept();
				} else
					System.out.println("not found trying new button ");
			} catch (Exception e) {
				System.out.println("ERROR MESSAGE: NO ELEMENT FOUND");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[Debug] End-login");
	}

	private void crawling(Map.Entry<String, String> entry) {
		System.out.println("[Debug] Start-crawling");
		try {
			driver.get(entry.getValue());
			List<WebElement> lines = driver.findElements(By.xpath("/html/body/table[1]/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr"));
			for (WebElement el : lines) {
				String no = el.findElement(By.xpath("td[1]")).getText().trim();
				if (no.equals("No") || no.equals("공지") || no.equals("") || no.isEmpty())
					continue;
				String title = el.findElement(By.xpath("td[2]")).getText().trim();

				System.out.println(entry.getKey() + " " + no + "번 " + title);
				System.out.println(el.findElement(By.xpath("td[2]/a")).getAttribute("href"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[Debug] End-crawling");
	}

	private void driver_closing() {
		driver.close();
	}
}
