package com.koolss.www.matting.vo;

/**
 * @ClassName ImageVO
 * @Description:
 * @Author admin
 * @Date 2021/8/9 14:08
 * @Version 1.0.0
 * @Email koolss@koolss.com
 **/
public class ImageVO {
    private String name;
    private String size;
    private String resolvingPower;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getResolvingPower() {
        return resolvingPower;
    }

    public void setResolvingPower(String resolvingPower) {
        this.resolvingPower = resolvingPower;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageVO() {
    }

    public ImageVO(String name, String size, String resolvingPower, String url) {
        this.name = name;
        this.size = size;
        this.resolvingPower = resolvingPower;
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageVO{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", resolvingPower='" + resolvingPower + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
