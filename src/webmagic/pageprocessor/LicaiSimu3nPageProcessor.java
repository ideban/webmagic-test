package webmagic.pageprocessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import webmagic.model.LicaiSimuInfo;
import webmagic.pipeline.LicaiSimuPipeline;

public class LicaiSimu3nPageProcessor implements PageProcessor {

  private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setDomain("licai.com").addCookie("safedog-flow-item", "9BA59A4DA6A444D81212BC3BF9D39997");

  @Override
  public Site getSite() {
    // TODO Auto-generated method stub
    return site;
  }

  @Override
  public void process(Page page) {
    // TODO Auto-generated method stub
    page.addTargetRequests(page.getHtml().links().regex("(/simu/\\d+-\\w+\\.html)").all());

    LicaiSimuInfo licaiSimuInfo = new LicaiSimuInfo();
    licaiSimuInfo.setTitle(page.getHtml().xpath("//div[@class='fund_title']/h2[@class='l']/text()").toString());
    licaiSimuInfo.setType(page.getHtml().xpath("//div[@class='fund_title']/div[@class='l']/text()").toString());
    licaiSimuInfo.setNav(page.getHtml().xpath("//div[@class='model_01']/ul[@class='fund_dt_big']/li[1]/span/text()").toString());
    licaiSimuInfo.setEarnings(page.getHtml().xpath("//div[@class='model_01']/ul[@class='fund_dt_big']/li[2]/span/text()").toString());
    licaiSimuInfo.setDetailTitle(page.getHtml().xpath("//div[@class='tab_zst']/table/allText()").toString());
    licaiSimuInfo.setDetailData(page.getHtml().xpath("//div[@class='tab_zst']/div/table/tidyText()").toString());
    licaiSimuInfo.setUrl(page.getHtml().xpath("//link[@rel='canonical']/text()").toString());

    if (licaiSimuInfo.getDetailData() == null) {
      // skip this page
      page.setSkip(true);
    } else {
      page.putField("repo", licaiSimuInfo);
    }

    // page.putField("title",
    // page.getHtml().xpath("//div[@class='fund_title']/h2[@class='l']/text()").toString());
    // page.putField("type",
    // page.getHtml().xpath("//div[@class='fund_title']/div[@class='l']/text()").toString());
    // page.putField("nav",
    // page.getHtml().xpath("//div[@class='model_01']/ul[@class='fund_dt_big']/li[1]/span/text()").toString());
    // page.putField("earnings",
    // page.getHtml().xpath("//div[@class='model_01']/ul[@class='fund_dt_big']/li[2]/span/text()").toString());
    // page.putField("detailTitle",
    // page.getHtml().xpath("//div[@class='tab_zst']/table/allText()").toString());
    // page.putField("detailData",
    // page.getHtml().xpath("//div[@class='tab_zst']/div/table/tidyText()").toString());

    // if (page.getResultItems().get("detailData")==null){
    // //skip this page
    // page.setSkip(true);
    // }
  }

  public static void main(String[] args) {
    Spider.create(new LicaiSimu3nPageProcessor()).addUrl("http://www.licai.com/simu/ph3n.html").addPipeline(new ConsolePipeline())
        .addPipeline(new LicaiSimuPipeline())
        // .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
        .thread(5).run();
  }

}
