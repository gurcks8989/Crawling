package com.spring.crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Alert;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium {	    
//	@Value("${hisnet.id}")
//    public static String login_id ;
//	
//	@Value("${hisnet.password}")
//    public static String login_pw ;
    
	public static void main(String[] args) {
		//WebDriver 설정
		WebDriverManager.chromedriver().setup() ;
		Selenium selTest = new Selenium();
		selTest.login();
		selTest.crawling();
	}
	private WebDriver driver  ;
	private String url;

	public static String TEST_URL = "https://hisnet.handong.edu" ;

	public Selenium() {
		// WebDriver 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");          // 최대크기로
        options.addArguments("--headless");                 // Browser를 띄우지 않음
        options.addArguments("--disable-gpu");              // GPU를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
        options.addArguments("--no-sandbox");               // Sandbox 프로세스를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
        
        // WebDriver 객체 생성
        driver = new ChromeDriver(options);
	}
	
	public void login(){
		System.out.println("[Debug] Start-login") ;
		try {
			driver.get(TEST_URL);

			// switch Frame to MainFrame
			driver.switchTo().frame("MainFrame") ; 

			driver.findElement(By.name("id")).sendKeys("gurcks8989") ;
			Thread.sleep(500);
			driver.findElement(By.name("password")).sendKeys("zxc123") ;
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//*[@id='loginBoxBg']/table[2]/tbody/tr/td[5]/form/table/tbody/tr[3]/td/table/tbody/tr/td[2]/input")).click() ;
			
			Thread.sleep(10000);
			try {
				if (driver.findElement(By.xpath("/html/body/div[3]/div/button")) != null){
					System.out.println("found this button") ;
					driver.findElement(By.xpath("/html/body/div[3]/div/button")).click() ;
					Alert alert_box = driver.switchTo().alert();
					Thread.sleep(700L);
					alert_box.accept();
				}
		  		else
		  			System.out.println("not found trying new button ") ;
			} catch (Exception e) {
				System.out.println("ERROR MESSAGE: NO ELEMENT FOUND") ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[Debug] End-login") ;
	}
		
	
	private void crawling() {
		// 일반 공지
		System.out.println("[Debug] Start-crawling") ;
        try {
            // 1. 수집 대상 URL
        	url = "https://hisnet.handong.edu/myboard/list.php?Board=NB0001" ;
        	driver.get(url);
            // 3. HTML 파싱.
            Document html = Jsoup.parse(driver.getPageSource()) ;
            // 4-1. Attribute 탐색
            Elements titles = html.select("body > table:nth-child(12) > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(2)") ;
            Elements nos = html.select("body > table:nth-child(12) > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1)") ;

            for(int i = 1 ; i < titles.size() ; i++) {
            	String no = nos.get(i).text().trim() ;
            	String title = titles.get(i).text().trim() ;
        		if(no.equals("공지"))
        			continue ;
                System.out.println("일반공지 " + no + "번 " + title) ;
        	}
        } catch (Exception e) {
        	e.printStackTrace();
		} finally {
			driver.close();
		}
		System.out.println("[Debug] End-crawling") ;
    }

//                    
//                Elements files = fileblock.getElementsByTag("a");
//                for( Element elm : files ) {
//                String text = elm.text();
//                String href = elm.attr("href");
//                
//                System.out.println( text+" > "+href );
//                }
//            }
//            
//            // 4-2. CSS Selector 탐색
//            System.out.println("\n[CSS Selector 탐색]");
//            Elements files = html.select(".fileblock a");
//            for( Element elm : files ) {
//                String text = elm.text();
//                String href = elm.attr("href");
//                
//                System.out.println( text+" > "+href );
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//		try {
//			notices = soup.select('')
//			// print(notices)
//			for n in notices:
//			  text = n.text
//			  #text = text.replace("\t","")
//			  #text = text.replace("\n\n","")
//			  #text = text.replace("·","")
//			  L1 = text.split("\n\n\n")
//			  i = -1
//			  for m in L1:
//			    i += 1
//			    if i == 0:
//			      continue
//			    elif i >= len(L1) - 2:
//			      break 
//			    m = m.replace("\t","")
//			    m = m.replace("\n\n","")
//			    m = m.replace("·","")
//			    L2 = m.split("\n")
//			    no = L2[0].strip()
//			    if no == '공지' :
//			      continue
//			    title = L2[1].strip()
//			    print("일반공지 " + no + "번 " + title[:-1])
//			    print('----------')
//			    '''
//			driver.find_element_by_xpath('//*[@id="td_box24"]/a').click()
}

