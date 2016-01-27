package webmagic.service;

import java.util.List;

import webmagic.dao.LicaiSimuDAO;
import webmagic.model.LicaiSimuInfo;

public class LicaiSimuServiceImpl implements LicaiSimuService {

  private LicaiSimuDAO licaiSimuDAO;

  public LicaiSimuDAO getLicaiSimuDAO() {
    return licaiSimuDAO;
  }

  public void setLicaiSimuDAO(LicaiSimuDAO licaiSimuDAO) {
    this.licaiSimuDAO = licaiSimuDAO;
  }

  @Override
  public List<LicaiSimuInfo> list() {
    // TODO Auto-generated method stub
    return getLicaiSimuDAO().list();
  }

  @Override
  public LicaiSimuInfo get(String id) {
    // TODO Auto-generated method stub
    return getLicaiSimuDAO().get(id);
  }

  @Override
  public int insert(LicaiSimuInfo u) {
    // TODO Auto-generated method stub
    return getLicaiSimuDAO().insert(u);
  }

}
