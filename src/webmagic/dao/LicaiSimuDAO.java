package webmagic.dao;

import java.util.List;

import webmagic.model.LicaiSimuInfo;

public interface LicaiSimuDAO {

  public List<LicaiSimuInfo> list();

  public LicaiSimuInfo get(String id);

  public int insert(LicaiSimuInfo u);
}
