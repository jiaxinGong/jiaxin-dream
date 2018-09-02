package model;

//import org.hibernate.validator.constraints.NotBlank;
//import org.springframework.data.annotation.Id;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: bufoon
 * @Email: song.anling@zyxr.com
 * @Datetime: Created In 2018/1/30 10:57
 * @Desc: as follows.
 * api公共请求参数
 */
public class OpenApiParams {

//    @Id
    private String id; //appId+nonceId 用于保存mongoDB的ID

//    @NotBlank(message = "appId 不能为空")
    private String appId; // 分配给接入方应用ID
    private String method; // 接口方法
//    @NotBlank(message = "sign 不能为空")
    private String sign; // 签名
//    @NotBlank(message = "signType 不能为空")
    private String signType; //签名类型，支持RSA, HmacMD5
    private Integer bizEnc; // bizData加密方式（0不加密，1加密）
    private String encKey; // 加密的key
//    @NotBlank(message = "version 不能为空")
    private String version; // 接口版本号
    private String format; // 返回数据格式，暂支持json
//    @NotBlank(message = "timestamp 不能为空")
    private String timestamp; // 请求时间戳，精确到秒，格式 yyyy-MM-dd HH:mm:ss
//    @NotBlank(message = "nonceId 不能为空")
    private String nonceId; // 请求唯一ID
    private String callbackUrl; // 回调地址，业务指定需要回调则在这里传，非必须
//    @NotBlank(message = "bizData 不能为空")
    private String bizData; // Json业务数据

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public Integer getBizEnc() {
        return bizEnc;
    }

    public void setBizEnc(Integer bizEnc) {
        this.bizEnc = bizEnc;
    }

    public String getEncKey() {
        return encKey;
    }

    public void setEncKey(String encKey) {
        this.encKey = encKey;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBizData() {
        return bizData;
    }

    public void setBizData(String bizData) {
        this.bizData = bizData;
    }

    public String getNonceId() {
        return nonceId;
    }

    public void setNonceId(String nonceId) {
        this.nonceId = nonceId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String toString() {
        return "RequestParam{" +
                "appId='" + appId + '\'' +
                ", method='" + method + '\'' +
                ", sign='" + sign + '\'' +
                ", signType=" + signType +
                ", bizEnc='" + bizEnc + '\'' +
                ", encKey='" + encKey + '\'' +
                ", version='" + version + '\'' +
                ", format='" + format + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", bizData=" + bizData +
                '}';
    }

    /**
     * true 都为空， false 不都为空
     * @return
     */
    public boolean isAllValueNull(){
        return (StringUtils.isEmpty(this.appId)
                && StringUtils.isEmpty(this.method)
                && StringUtils.isEmpty(this.sign)
                && StringUtils.isEmpty(this.signType)
                && StringUtils.isEmpty(this.bizEnc+"")
                && StringUtils.isEmpty(this.encKey)
                && StringUtils.isEmpty(this.version)
                && StringUtils.isEmpty(this.format)
                && StringUtils.isEmpty(this.timestamp)
                && StringUtils.isEmpty(this.nonceId)
                && StringUtils.isEmpty(this.callbackUrl)
                && StringUtils.isEmpty(this.bizData));
    }

}
