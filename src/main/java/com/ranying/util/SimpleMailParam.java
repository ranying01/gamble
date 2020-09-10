package com.ranying.util;

/**
 *
 */
public class SimpleMailParam {

    private String toEmail;

    private String title;

    private String content;

    public SimpleMailParam(String toEmail, String title, String content) {
        this.toEmail = toEmail;
        this.title = title;
        this.content = content;
    }

    public SimpleMailParam(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
