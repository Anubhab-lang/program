package cn.edu.pku.zhangqixun.bean;

public class TodayWeather {
    private String city;
    private String updatetime;
    private String wendu;
    private String shidu;
    private String pm25;
    private String quality;
    private String fengxiang;
    private String fengli;
    private String date;
    private String high;
    private String low;
    private String type;
    public String getCity(){
        return city;
    }
    public String setShidu(){
        return shidu;
    }
    public String setUpdatetime(){
        return updatetime;
    }
    public String setWendu(){
        return wendu;
    }
    public String setPm25(){
        return pm25;
    }
    public String setQuality(){
        return quality;
    }
    public String setFengxiang(){
        return fengxiang;
    }
    public String setFengli(){
        return fengli;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setHigh(String high){
        this.high = high;
    }
    public void setLow(String low){
        this.low = low;
    }
    public void setType(String type){
        this.type = type;
    }
    public String toString()
    {
        return "TodayWeather{"+"city='"+city+'\''+",wendu="+wendu+'\''+",shidu="+shidu+'\''+",pm2.5="+pm25+'\''+",quality="+quality+'\''
                +",fengxiang="+fengxiang+'\''+",fengli="+fengli+'\''+",date="+date+'\''+",high="+high+'\''+",low="+low+'\''+",type="+type+'\''+'}';
    }
}
