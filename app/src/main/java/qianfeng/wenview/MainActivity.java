package qianfeng.wenview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private WebView web;
    private TextView text;

    private String html = "<p>【性质】平</p> <p>【五味】辛</p> <p>【热量】900.00大卡(千焦)/100克 </p> <p>【功效】抑癌抗瘤</p> <p>【棕榈油是什么】 棕榈油是从油棕树上的棕果(Elaeis Guineensis)中榨取出来的，果肉压榨出的油称为棕榈油( Palm Oil)，而果仁压榨出的油称为棕榈仁油(Palm Kernel Oil)，两种油的成分大不相同。棕榈油主要含有棕榈酸(C 16)和油酸(C 18)两种最普通的脂肪酸，棕榈油的饱和程度约为50%;棕榈仁油主要含有月桂酸(C 12)，饱和程度达80...</p";
    private BufferedReader br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = ((WebView) findViewById(R.id.webView));
        text = ((TextView) findViewById(R.id.tv));
//
////        web.loadUrl("Http://www.baidu.com");
//        web.loadUrl("file:///android_assets/jm/index.html");
//
//
//        WebSettings settings = web.getSettings();
//        settings.setJavaScriptEnabled(true);
//
//        web.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onLoadResource(WebView view, String url) {
//                view.loadUrl(url);
//            }
//        });


        web.getSettings().setJavaScriptEnabled(true);
//        text.setText(Html.fromHtml(html));
        web.loadUrl("http://www.baidu.com");
        web.loadData(getContet(),"text/html;charset=utf-8",null);
    }

    private String getContet() {
        StringBuffer result = new StringBuffer();
        try {
            br = new BufferedReader(new InputStreamReader(getAssets().open("html.txt")));
            String str;
            while ((str = br.readLine()) != null) {
                result.append(str);
            }
              return  result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
         return  null;
    }


}
