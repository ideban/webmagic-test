package webmagic.pipeline;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import webmagic.model.LicaiSimuInfo;
import webmagic.service.LicaiSimuService;

public class LicaiSimuPipeline implements Pipeline {

  @Override
  public void process(ResultItems resultItems, Task task) {
    // TODO Auto-generated method stub
    LicaiSimuInfo licaiSimuInfo = (LicaiSimuInfo) resultItems.get("repo");
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
    LicaiSimuService us = (LicaiSimuService) ac.getBean("licaiSimuService");
    int result = us.insert(licaiSimuInfo);
    System.out.println(result);
  }
}
