package webmagic.service;

import java.util.List;

import webmagic.model.LicaiSimuInfo;

public interface LicaiSimuService {
  
  public List<LicaiSimuInfo> list();

  public LicaiSimuInfo get(String id);

  public int insert(LicaiSimuInfo u);
}
