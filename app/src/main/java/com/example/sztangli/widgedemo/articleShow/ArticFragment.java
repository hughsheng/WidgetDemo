package com.example.sztangli.widgedemo.articleShow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.example.sztangli.widgedemo.R;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;

import butterknife.BindView;

/**
 * Created by sztangli on 2017/9/15.
 */

public class ArticFragment extends BaseFragment {

    @BindView(R.id.article_tv)
    TextView article_tv;
    public static final String TAG = "ArticFragment";

    public static ArticFragment newInstance() {

        Bundle args = new Bundle();

        ArticFragment fragment = new ArticFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initialization() {
        article_tv.setMovementMethod(ScrollingMovementMethod.getInstance());
     article_tv.setText(Html.fromHtml("<head>\n" +
             "  <meta charset=\"utf-8\">\n" +
             "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\n" +
             "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0,user-scalable=no\">\n" +
             "\n" +
             "  <!-- Start of Baidu Transcode -->\n" +
             "  <meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n" +
             "  <meta http-equiv=\"Cache-Control\" content=\"no-transform\" />\n" +
             "  <meta name=\"applicable-device\" content=\"pc,mobile\">\n" +
             "  <meta name=\"MobileOptimized\" content=\"width\"/>\n" +
             "  <meta name=\"HandheldFriendly\" content=\"true\"/>\n" +
             "  <meta name=\"mobile-agent\" content=\"format=html5;url=http://www.jianshu.com/p/150cdb0a13c2\">\n" +
             "  <!-- End of Baidu Transcode -->\n" +
             "\n" +
             "    <meta name=\"description\"  content=\"最近项目中有个富文本编辑的需求，需要能编辑文字字号、颜色，插入图片等，最后要转成html格式然后base64转码后上传服务端，这样看来还挺复杂的。 想想像富文本这样的功能应该有人实现过了，顺手Google了下，明确一下思路。 主要是两种方法 EditText + Span 的实现方式 WebView + JavaScript 的实现方式 去GitHub搜了下，貌似已经有人实现了这个功能was...\">\n" +
             "\n" +
             "  <meta name=\"360-site-verification\" content=\"604a14b53c6b871206001285921e81d8\" />\n" +
             "  <meta property=\"wb:webmaster\" content=\"294ec9de89e7fadb\" />\n" +
             "  <meta property=\"qc:admins\" content=\"104102651453316562112116375\" />\n" +
             "  <meta property=\"qc:admins\" content=\"11635613706305617\" />\n" +
             "  <meta property=\"qc:admins\" content=\"1163561616621163056375\" />\n" +
             "  <meta name=\"google-site-verification\" content=\"cV4-qkUJZR6gmFeajx_UyPe47GW9vY6cnCrYtCHYNh4\" />\n" +
             "  <meta name=\"google-site-verification\" content=\"HF7lfF8YEGs1qtCE-kPml8Z469e2RHhGajy6JPVy5XI\" />\n" +
             "  <meta http-equiv=\"mobile-agent\" content=\"format=html5; url=http://www.jianshu.com/p/150cdb0a13c2\">\n" +
             "\n" +
             "  <!-- Apple -->\n" +
             "  <meta name=\"apple-mobile-web-app-title\" content=\"简书\">\n" +
             "\n" +
             "    <!--  Meta for Smart App Banner -->\n" +
             "  <meta name=\"apple-itunes-app\" content=\"app-id=888237539, app-argument=jianshu://notes/7198450\">\n" +
             "  <!-- End -->\n" +
             "\n" +
             "  <!--  Meta for Twitter Card -->\n" +
             "  <meta content=\"summary\" property=\"twitter:card\">\n" +
             "  <meta content=\"@jianshucom\" property=\"twitter:site\">\n" +
             "  <meta content=\"Android端富文本编辑和显示\" property=\"twitter:title\">\n" +
             "  <meta content=\"最近项目中有个富文本编辑的需求，需要能编辑文字字号、颜色，插入图片等，最后要转成html格式然后base64转码后上传服务端，这样看来还挺复杂的。 想想像富文本这样的功能应该有人实现过了，顺手Google了下，明确一下思路。 主要是两种方法 EditText + Span 的实现方式 WebView + JavaScript 的实现方式 去GitHub搜了下，貌似已经有人实现了这个功能wasabeef/richeditor-android这个库是用第二种方式实现的，通过insertImage(url)可以直接插入图片，getHtml()即可得到html的字符串，然后用base64转码即可...\" property=\"twitter:description\">\n" +
             "  <meta content=\"http://www.jianshu.com/p/150cdb0a13c2\" property=\"twitter:url\">\n" +
             "  <!-- End -->\n" +
             "\n" +
             "  <!--  Meta for OpenGraph -->\n" +
             "  <meta property=\"fb:app_id\" content=\"865829053512461\">\n" +
             "  <meta property=\"og:site_name\" content=\"简书\">\n" +
             "  <meta property=\"og:title\" content=\"Android端富文本编辑和显示\">\n" +
             "  <meta property=\"og:type\" content=\"article\">\n" +
             "  <meta property=\"og:url\" content=\"http://www.jianshu.com/p/150cdb0a13c2\">\n" +
             "  <meta property=\"og:description\" content=\"最近项目中有个富文本编辑的需求，需要能编辑文字字号、颜色，插入图片等，最后要转成html格式然后base64转码后上传服务端，这样看来还挺复杂的。 想想像富文本这样的功能应该有人实现过了，顺手G...\">\n" +
             "  <!-- End -->\n" +
             "\n" +
             "  <!--  Meta for Facebook Applinks -->\n" +
             "  <meta property=\"al:ios:url\" content=\"jianshu://notes/7198450\" />\n" +
             "  <meta property=\"al:ios:app_store_id\" content=\"888237539\" />\n" +
             "  <meta property=\"al:ios:app_name\" content=\"简书\" />\n" +
             "\n" +
             "  <meta property=\"al:android:url\" content=\"jianshu://notes/7198450\" />\n" +
             "  <meta property=\"al:android:package\" content=\"com.jianshu.haruki\" />\n" +
             "  <meta property=\"al:android:app_name\" content=\"简书\" />\n" +
             "  <!-- End -->\n" +
             "\n" +
             "\n" +
             "    <title>Android端富文本编辑和显示 - 简书</title>\n" +
             "\n" +
             "  <meta name=\"csrf-param\" content=\"authenticity_token\" />\n" +
             "<meta name=\"csrf-token\" content=\"bwdrqpoFB7U5pP8GMmPALile05c8QvoAFXZuDVhUKFvCd8Z8YiqQtdebi+VGk5LvNhdiqc9ON4+l/7bm+kkYQw==\" />\n" +
             "\n" +
             "  <link rel=\"stylesheet\" media=\"all\" href=\"//cdn2.jianshu.io/assets/web-e7e403d2843dd1edd8db.css\" />\n" +
             "  \n" +
             "  <link rel=\"stylesheet\" media=\"all\" href=\"//cdn2.jianshu.io/assets/web/pages/notes/show/entry-0a03cade4dfc10c5a79b.css\" />\n" +
             "\n" +
             "  <link href=\"//cdn2.jianshu.io/assets/favicons/favicon-03411b154a430b85d807b4366489c21122fb983a38f3d7ca926f882e6367b13e.ico\" rel=\"icon\">\n" +
             "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/57-a6f1f1ee62ace44f6dc2f6a08575abd3c3b163288881c78dd8d75247682a4b27.png\" sizes=\"57x57\" />\n" +
             "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/72-fb9834bcfce738fd7b9c5e31363e79443e09a81a8e931170b58bc815387c1562.png\" sizes=\"72x72\" />\n" +
             "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/76-49d88e539ff2489475d603994988d871219141ecaa0b1a7a9a1914f4fe3182d6.png\" sizes=\"76x76\" />\n" +
             "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/114-24252fe693524ed3a9d0905e49bff3cbd0228f25a320aa09053c2ebb4955de97.png\" sizes=\"114x114\" />\n" +
             "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/120-1bb7371f5e87f93ce780a5f1a05ff1b176828ee0d1d130e768575918a2e05834.png\" sizes=\"120x120\" />\n" +
             "      <link rel=\"apple-touch-icon-precomposed\" href=\"//cdn2.jianshu.io/assets/apple-touch-icons/152-bf209460fc1c17bfd3e2b84c8e758bc11ca3e570fd411c3bbd84149b97453b99.png\" sizes=\"152x152\" />\n" +
             "\n" +
             "  <!-- Start of 访问统计 -->\n" +
             "  <script>\n" +
             "  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" +
             "  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" +
             "  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" +
             "  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');\n" +
             "\n" +
             "  ga('create', 'UA-35169517-1', 'auto');\n" +
             "  ga('send', 'pageview');\n" +
             "</script>\n" +
             "\n" +
             "<script>\n" +
             "  var _hmt = _hmt || [];\n" +
             "  (function() {\n" +
             "    var hm = document.createElement(\"script\");\n" +
             "    hm.src = \"//hm.baidu.com/hm.js?0c0e9d9b1e7d617b3e6842e85b9fb068\";\n" +
             "    var s = document.getElementsByTagName(\"script\")[0];\n" +
             "    s.parentNode.insertBefore(hm, s);\n" +
             "  })();\n" +
             "</script>\n" +
             "\n" +
             "  <!-- End of 访问统计 -->\n" +
             "</head>\n" +
             "\n" +
             "  <body lang=\"zh-CN\" class=\"reader-black-font\">\n" +
             "    <!-- 全局顶部导航栏 -->\n" +
             "<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n" +
             "  <div class=\"width-limit\">\n" +
             "    <!-- 左上方 Logo -->\n" +
             "    <a class=\"logo\" href=\"/\"><img src=\"//cdn2.jianshu.io/assets/web/logo-58fd04f6f0de908401aa561cda6a0688.png\" alt=\"Logo\" /></a>\n" +
             "\n" +
             "    <!-- 右上角 -->\n" +
             "      <!-- 未登录显示登录/注册/写文章 -->\n" +
             "      <a class=\"btn write-btn\" target=\"_blank\" href=\"/writer#/\">\n" +
             "        <i class=\"iconfont ic-write\"></i>写文章\n" +
             "</a>      <a class=\"btn sign-up\" href=\"/sign_up\">注册</a>\n" +
             "      <a class=\"btn log-in\" href=\"/sign_in\">登录</a>\n" +
             "\n" +
             "    <!-- 如果用户登录，显示下拉菜单 -->\n" +
             "\n" +
             "    <div id=\"view-mode-ctrl\">\n" +
             "    </div>\n" +
             "    <div class=\"container\">\n" +
             "      <div class=\"navbar-header\">\n" +
             "        <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#menu\" aria-expanded=\"false\">\n" +
             "          <span class=\"icon-bar\"></span>\n" +
             "          <span class=\"icon-bar\"></span>\n" +
             "          <span class=\"icon-bar\"></span>\n" +
             "        </button>\n" +
             "      </div>\n" +
             "      <div class=\"collapse navbar-collapse\" id=\"menu\">\n" +
             "        <ul class=\"nav navbar-nav\">\n" +
             "            <li class=\"\">\n" +
             "              <a href=\"/\">\n" +
             "                <span class=\"menu-text\">首页</span><i class=\"iconfont ic-navigation-discover menu-icon\"></i>\n" +
             "</a>            </li>\n" +
             "            <li class=\"\">\n" +
             "              <a class=\"app-download-btn\" href=\"/apps\"><span class=\"menu-text\">下载App</span><i class=\"iconfont ic-navigation-download menu-icon\"></i></a>\n" +
             "            </li>\n" +
             "          <li class=\"search\">\n" +
             "            <form target=\"_blank\" action=\"/search\" accept-charset=\"UTF-8\" method=\"get\"><input name=\"utf8\" type=\"hidden\" value=\"&#x2713;\" />\n" +
             "              <input type=\"text\" name=\"q\" id=\"q\" value=\"\" autocomplete=\"off\" placeholder=\"搜索\" class=\"search-input\" />\n" +
             "              <a class=\"search-btn\" href=\"javascript:void(null)\"><i class=\"iconfont ic-search\"></i></a>\n" +
             "</form>          </li>\n" +
             "        </ul>\n" +
             "      </div>\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</nav>\n" +
             "\n" +
             "    \n" +
             "<div class=\"note\">\n" +
             "  <div class=\"post\">\n" +
             "    <div class=\"article\">\n" +
             "        <h1 class=\"title\">Android端富文本编辑和显示</h1>\n" +
             "\n" +
             "        <!-- 作者区域 -->\n" +
             "        <div class=\"author\">\n" +
             "          <a class=\"avatar\" href=\"/u/cc89e6af04c8\">\n" +
             "            <img src=\"//upload.jianshu.io/users/upload_avatars/2381335/b0e23965dab9?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96\" alt=\"96\" />\n" +
             "</a>          <div class=\"info\">\n" +
             "            <span class=\"tag\">作者</span>\n" +
             "            <span class=\"name\"><a href=\"/u/cc89e6af04c8\">linceln</a></span>\n" +
             "            <!-- 关注用户按钮 -->\n" +
             "            <div props-data-classes=\"user-follow-button-header\" data-author-follow-button></div>\n" +
             "            <!-- 文章数据信息 -->\n" +
             "            <div class=\"meta\">\n" +
             "              <!-- 如果文章更新时间大于发布时间，那么使用 tooltip 显示更新时间 -->\n" +
             "                <span class=\"publish-time\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"最后编辑于 2016.12.15 10:41\">2016.11.25 23:22*</span>\n" +
             "              <span class=\"wordage\">字数 867</span>\n" +
             "            </div>\n" +
             "          </div>\n" +
             "          <!-- 如果是当前作者，加入编辑按钮 -->\n" +
             "        </div>\n" +
             "        <!-- -->\n" +
             "\n" +
             "        <!-- 文章内容 -->\n" +
             "        <div data-note-content class=\"show-content\">\n" +
             "          <p>最近项目中有个富文本编辑的需求，需要能编辑文字字号、颜色，插入图片等，最后要转成html格式然后base64转码后上传服务端，这样看来还挺复杂的。</p>\n" +
             "<p>想想像富文本这样的功能应该有人实现过了，顺手Google了下，明确一下思路。</p>\n" +
             "<p>主要是两种方法</p>\n" +
             "<ol>\n" +
             "<li>EditText + Span 的实现方式</li>\n" +
             "<li>WebView + JavaScript 的实现方式</li>\n" +
             "</ol>\n" +
             "<p>去GitHub搜了下，貌似已经有人实现了这个功能<br><a href=\"https://github.com/wasabeef/richeditor-android\" target=\"_blank\">wasabeef/richeditor-android</a><br>这个库是用第二种方式实现的，通过<code>insertImage(url)</code>可以直接插入图片，<code>getHtml()</code>即可得到html的字符串，然后用base64转码即可。<br>试用了几天，bug还是有一些，最大的问题是显示图片没有适配屏幕宽度，显示图片的时候是按原图大小显示的，拖了几下我就晕头转向了，另外还有诸如离开界面键盘未收起，窗口泄漏等问题(leaked window)。总之用得不是很顺畅，只能寻找替代品了。</p>\n" +
             "<p>继续搜索<br><a href=\"https://github.com/mr5/icarus-android\" target=\"_blank\">mr5/icarus-android</a><br>这个库也是用第二种方式实现的，看了一点源码被绕得晕头转向，不过总算有点收获。<br><code>icarus.insertHtml(\"&lt;img src=\\\"xxx\\\" /&gt;\");</code>插入图片标签，实际上可以插入任何标签。<br><code>icarus.getContent()</code>得到html格式的字符串。实际上得到的是一串Json字符串，解析一下即可。</p>\n" +
             "<p>这个<code>Demo</code>里面点击图片默认插入的是一张默认图，看源码发现是调用<code>TextViewButton</code>的<code>command()</code>方法，然后再调用JS代码实现的。如果要自己实现点击图片的逻辑，比如图库选图和拍照等，就需要定义一个子类继承<code>TextViewButton</code>，重写<code>command()</code>方法实现自己的逻辑。</p>\n" +
             "<p>总体来说这个库用得还算顺畅，我的需求都实现了，可以插入图片，编辑字体，最后可以得到html格式的片段。<br><strong>只有一个问题还待解决，就是和上一个库一样的窗口泄漏问题。</strong><br>20161215更新<br><strong><em>窗口泄漏已解决，调用<code>Webview.destroy()</code>即可</em></strong></p>\n" +
             "<p>以上都是用WebView实现的方法<br>接下来会尝试下用EditText + Span 实现</p>\n" +
             "<blockquote>\n" +
             "<h3>富文本的图片上传策略问题</h3>\n" +
             "<p>原先需求的想法是先在编辑器里显示本地图片，等待用户编辑完成再上传全部图片，然后用上传返回的url替换之前html中显示本地图片的位置。<br>这样的问题是，如果图片很多，上传的数据量会很大，手机的网络状态经常不稳定，很容易上传失败。另外等待时间会很长，体验很差。<br>另一种策略是选图完成即上传，得到url之后直接插入，上传是耗时操作，再加上图片压缩的时间，这样编辑器显示图片会有可观的延迟时间，实际项目中可以加一个loading占位图，另外加一个标记提醒用户是否上传完成，避免没有上传成功用户即提交的问题。<br>感谢上述开源库作者mr5的指教</p>\n" +
             "</blockquote>\n" +
             "\n" +
             "        </div>\n" +
             "        <!--  -->\n" +
             "\n" +
             "        <div class=\"show-foot\">\n" +
             "          <a class=\"notebook\" href=\"/nb/6524810\">\n" +
             "            <i class=\"iconfont ic-search-notebook\"></i> <span>Android</span>\n" +
             "</a>          <div class=\"copyright\" data-toggle=\"tooltip\" data-html=\"true\" data-original-title=\"转载请联系作者获得授权，并标注“简书作者”。\">\n" +
             "            © 著作权归作者所有\n" +
             "          </div>\n" +
             "          <div class=\"modal-wrap\" data-report-note>\n" +
             "            <a id=\"report-modal\">举报文章</a>\n" +
             "          </div>\n" +
             "        </div>\n" +
             "    </div>\n" +
             "\n" +
             "    <!-- 文章底部作者信息 -->\n" +
             "      <div class=\"follow-detail\">\n" +
             "        <div class=\"info\">\n" +
             "          <a class=\"avatar\" href=\"/u/cc89e6af04c8\">\n" +
             "            <img src=\"//upload.jianshu.io/users/upload_avatars/2381335/b0e23965dab9?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96\" alt=\"96\" />\n" +
             "</a>          <div props-data-classes=\"user-follow-button-footer\" data-author-follow-button></div>\n" +
             "          <a class=\"title\" href=\"/u/cc89e6af04c8\">linceln</a>\n" +
             "            <i class=\"iconfont ic-man\"></i>\n" +
             "        </div>\n" +
             "      </div>\n" +
             "\n" +
             "      <div class=\"support-author\"></div>\n" +
             "\n" +
             "    <div class=\"meta-bottom\">\n" +
             "      <div class=\"btn like-group\"></div>\n" +
             "      <div class=\"share-group\">\n" +
             "        <a class=\"share-circle\" data-action=\"weixin-share\" data-toggle=\"tooltip\" data-original-title=\"分享到微信\">\n" +
             "          <i class=\"iconfont ic-wechat\"></i>\n" +
             "        </a>\n" +
             "        <a class=\"share-circle\" data-action=\"weibo-share\" data-toggle=\"tooltip\" href=\"javascript:void((function(s,d,e,r,l,p,t,z,c){var%20f=&#39;http://v.t.sina.com.cn/share/share.php?appkey=1881139527&#39;,u=z||d.location,p=[&#39;&amp;url=&#39;,e(u),&#39;&amp;title=&#39;,e(t||d.title),&#39;&amp;source=&#39;,e(r),&#39;&amp;sourceUrl=&#39;,e(l),&#39;&amp;content=&#39;,c||&#39;gb2312&#39;,&#39;&amp;pic=&#39;,e(p||&#39;&#39;)].join(&#39;&#39;);function%20a(){if(!window.open([f,p].join(&#39;&#39;),&#39;mb&#39;,[&#39;toolbar=0,status=0,resizable=1,width=440,height=430,left=&#39;,(s.width-440)/2,&#39;,top=&#39;,(s.height-430)/2].join(&#39;&#39;)))u.href=[f,p].join(&#39;&#39;);};if(/Firefox/.test(navigator.userAgent))setTimeout(a,0);else%20a();})(screen,document,encodeURIComponent,&#39;&#39;,&#39;&#39;,&#39;http://cwb.assets.jianshu.io/notes/images/7198450/weibo/image_805d71380442.jpg&#39;, &#39;推荐 linceln 的文章《Android端富文本编辑和显示》（ 分享自 @简书 ）&#39;,&#39;http://www.jianshu.com/p/150cdb0a13c2?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=weibo&#39;,&#39;页面编码gb2312|utf-8默认gb2312&#39;));\" data-original-title=\"分享到微博\">\n" +
             "          <i class=\"iconfont ic-weibo\"></i>\n" +
             "        </a>\n" +
             "          <a class=\"share-circle\" data-toggle=\"tooltip\" href=\"http://cwb.assets.jianshu.io/notes/images/7198450/weibo/image_805d71380442.jpg\" target=\"_blank\" data-original-title=\"下载长微博图片\">\n" +
             "            <i class=\"iconfont ic-picture\"></i>\n" +
             "          </a>\n" +
             "        <a class=\"share-circle more-share\" tabindex=\"0\" data-toggle=\"popover\" data-placement=\"top\" data-html=\"true\" data-trigger=\"focus\" href=\"javascript:void(0);\" data-content='\n" +
             "          <ul class=\"share-list\">\n" +
             "            <li><a href=\"javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=&#39;+e(&#39;http://www.jianshu.com/p/150cdb0a13c2?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=qzone&#39;)+&#39;&amp;title=&#39;+e(&#39;推荐 linceln 的文章《Android端富文本编辑和显示》&#39;),x=function(){if(!window.open(r,&#39;qzone&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=600,height=600&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();\"><i class=\"social-icon-sprite social-icon-zone\"></i><span>分享到QQ空间</span></a></li>\n" +
             "            <li><a href=\"javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;https://twitter.com/share?url=&#39;+e(&#39;http://www.jianshu.com/p/150cdb0a13c2?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=twitter&#39;)+&#39;&amp;text=&#39;+e(&#39;推荐 linceln 的文章《Android端富文本编辑和显示》（ 分享自 @jianshucom ）&#39;)+&#39;&amp;related=&#39;+e(&#39;jianshucom&#39;),x=function(){if(!window.open(r,&#39;twitter&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=600,height=600&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();\"><i class=\"social-icon-sprite social-icon-twitter\"></i><span>分享到Twitter</span></a></li>\n" +
             "            <li><a href=\"javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;https://www.facebook.com/dialog/share?app_id=483126645039390&amp;display=popup&amp;href=http://www.jianshu.com/p/150cdb0a13c2?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=facebook&#39;,x=function(){if(!window.open(r,&#39;facebook&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();\"><i class=\"social-icon-sprite social-icon-facebook\"></i><span>分享到Facebook</span></a></li>\n" +
             "            <li><a href=\"javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;https://plus.google.com/share?url=&#39;+e(&#39;http://www.jianshu.com/p/150cdb0a13c2?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=google_plus&#39;),x=function(){if(!window.open(r,&#39;google_plus&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();\"><i class=\"social-icon-sprite social-icon-google\"></i><span>分享到Google+</span></a></li>\n" +
             "            <li><a href=\"javascript:void(function(){var d=document,e=encodeURIComponent,s1=window.getSelection,s2=d.getSelection,s3=d.selection,s=s1?s1():s2?s2():s3?s3.createRange().text:&#39;&#39;,r=&#39;http://www.douban.com/recommend/?url=&#39;+e(&#39;http://www.jianshu.com/p/150cdb0a13c2?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=douban&#39;)+&#39;&amp;title=&#39;+e(&#39;Android端富文本编辑和显示&#39;)+&#39;&amp;sel=&#39;+e(s)+&#39;&amp;v=1&#39;,x=function(){if(!window.open(r,&#39;douban&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330&#39;))location.href=r+&#39;&amp;r=1&#39;};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})()\"><i class=\"social-icon-sprite social-icon-douban\"></i><span>分享到豆瓣</span></a></li>\n" +
             "          </ul>\n" +
             "        '>更多分享</a>\n" +
             "      </div>\n" +
             "    </div>\n" +
             "    <div id=\"vue_comment\"></div>\n" +
             "  </div>\n" +
             "\n" +
             "  <div class=\"vue-side-tool\"></div>\n" +
             "</div>\n" +
             "<div class=\"note-bottom\">\n" +
             "  <div class=\"js-included-collections\"></div>\n" +
             "  <div data-vcomp=\"recommended-notes\" data-lazy=\"1.5\" data-note-id=\"7198450\"></div>\n" +
             "</div>\n" +
             "\n" +
             "    <script type=\"application/json\" data-name=\"page-data\">{\"user_signed_in\":false,\"locale\":\"zh-CN\",\"os\":\"windows\",\"read_mode\":\"day\",\"read_font\":\"font2\",\"note_show\":{\"is_author\":false,\"is_following_author\":false,\"is_liked_note\":false,\"follow_state\":0,\"uuid\":\"6bcfd6ca-5eef-4196-bd1e-3666b621d88a\"},\"note\":{\"id\":7198450,\"slug\":\"150cdb0a13c2\",\"user_id\":2381335,\"notebook_id\":6524810,\"commentable\":true,\"likes_count\":7,\"views_count\":1110,\"public_wordage\":867,\"comments_count\":2,\"total_rewards_count\":0,\"is_author\":false,\"author\":{\"nickname\":\"linceln\",\"total_wordage\":6207,\"followers_count\":2,\"total_likes_count\":16}}}</script>\n" +
             "    \n" +
             "    <script src=\"//cdn2.jianshu.io/assets/babel-polyfill-8053f0c4c81c27b7aff2.js\"></script>\n" +
             "    <script src=\"//cdn2.jianshu.io/assets/web-base-71ebae3b132d7b91f6cd.js\"></script>\n" +
             "<script src=\"//cdn2.jianshu.io/assets/web-1002f4c5d335b328ce01.js\"></script>\n" +
             "    \n" +
             "    <script src=\"//cdn2.jianshu.io/assets/web/pages/notes/show/entry-1580415eff416b70aba0.js\"></script>\n" +
             "    <script>\n" +
             "  (function(){\n" +
             "      var bp = document.createElement('script');\n" +
             "      var curProtocol = window.location.protocol.split(':')[0];\n" +
             "      if (curProtocol === 'https') {\n" +
             "          bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';\n" +
             "      }\n" +
             "      else {\n" +
             "          bp.src = 'http://push.zhanzhang.baidu.com/push.js';\n" +
             "      }\n" +
             "      var s = document.getElementsByTagName(\"script\")[0];\n" +
             "      s.parentNode.insertBefore(bp, s);\n" +
             "  })();\n" +
             "</script>\n" +
             "\n" +
             "  </body>\n" +
             "</html>\n",new MImageGetter(article_tv,getContext()),null));
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_artivcleshow;
    }


    public class MImageGetter implements Html.ImageGetter {
        Context c;
        TextView container;

        public MImageGetter(TextView text,Context c) {
            this.c = c;
            this.container = text;
        }
        public Drawable getDrawable(String source) {
            final LevelListDrawable drawable = new LevelListDrawable();
//            Glide.with(c).load(source).into(new SimpleTarget<Bitmap>() {
//                @Override
//                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                    if(resource != null) {
//                        BitmapDrawable bitmapDrawable = new BitmapDrawable(resource);
//                        drawable.addLevel(1, 1, bitmapDrawable);
//                        drawable.setBounds(0, 0, resource.getWidth(),resource.getHeight());
//                        drawable.setLevel(1);
//                        container.invalidate();
//                        container.setText(container.getText());
//                    }
//                }
//            });


            return drawable;
        }

    }
}
