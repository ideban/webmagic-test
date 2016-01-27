package webmagic.pageprocessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {
  
  private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
  
  @Override
  public Site getSite() {
    // TODO Auto-generated method stub
    return site;
  }

  @Override
  public void process(Page page) {
    // TODO Auto-generated method stub
    page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
    page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
    page.putField("name", page.getHtml().xpath("//h1[@class='entry-title']/strong/a/text()").toString());
    if (page.getResultItems().get("name")==null){
        //skip this page
        page.setSkip(true);
    }
    page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
  }
  
  public static void main(String[] args) {
    Spider.create(new GithubRepoPageProcessor())
      .addUrl("https://github.com/ideban")
      .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
      .thread(5)
      .run();
  }

}
