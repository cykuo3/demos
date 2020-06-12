package htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chengyuankuo
 * @date 2020/05/28
 */
public class HtmlUnitApp {

    public static void main(String[] args) throws Exception{
        Thread thread = Thread.currentThread();
        String url = "http://quotemedia.com/portal/quote?qm_symbol=dao";
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        WebClientOptions options = webClient.getOptions();
        options.setCssEnabled(false);
        options.setJavaScriptEnabled(true);
        options.setUseInsecureSSL(true);
        options.setThrowExceptionOnScriptError(false);
        options.setTimeout(30 * 1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = webClient.getPage(url);
        //先发起请求，等待js动态渲染
        int count = webClient.waitForBackgroundJavaScript(5 * 1000);
        //避免有死循环任务
        webClient.getJavaScriptEngine().shutdown();
        String res = page.asXml();
        System.out.println(res.contains("qmod-quote-element-last"));
        System.out.println(res.contains("29.50"));
    }
}
