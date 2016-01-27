package webmagic.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import webmagic.model.LicaiSimuInfo;

public class LicaiSimuDaoImpl extends SqlSessionDaoSupport implements LicaiSimuDAO {

  @Override
  public List<LicaiSimuInfo> list() {
    // TODO Auto-generated method stub
    return this.getSqlSession().selectList("webmagic.model.LicaiSimuInfo.listAll");
  }

  @Override
  public LicaiSimuInfo get(String id) {
    // TODO Auto-generated method stub
    return (LicaiSimuInfo) this.getSqlSession().selectOne("webmagic.model.LicaiSimuInfo.get", id);
  }

  @Override
  public int insert(LicaiSimuInfo u) {
    // TODO Auto-generated method stub
    return this.getSqlSession().insert("webmagic.model.LicaiSimuInfo.create", u);
  }

}
