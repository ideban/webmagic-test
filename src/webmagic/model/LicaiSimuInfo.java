package webmagic.model;

public class LicaiSimuInfo {

  private String id;
  private String title;
  private String type;
  private String nav;
  private String earnings;
  private String detailTitle;
  private String detailData;
  private String url;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getNav() {
    return nav;
  }

  public void setNav(String nav) {
    this.nav = nav;
  }

  public String getEarnings() {
    return earnings;
  }

  public void setEarnings(String earnings) {
    this.earnings = earnings;
  }

  public String getDetailTitle() {
    return detailTitle;
  }

  public void setDetailTitle(String detailTitle) {
    this.detailTitle = detailTitle;
  }

  public String getDetailData() {
    return detailData;
  }

  public void setDetailData(String detailData) {
    this.detailData = detailData;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String toString() {
    return "SimuInfo {" + 
        "title='" + title + '\'' + 
        ", type='" + type + '\'' + 
        ", nav='" + nav + '\'' + 
        ", earnings='" + earnings + '\'' + 
        ", detailTitle='" + detailTitle + '\'' + 
        ", detailData='" + detailData + '\'' + 
        ", url='" + getUrl() + '\'' + 
    '}';
  }

}
