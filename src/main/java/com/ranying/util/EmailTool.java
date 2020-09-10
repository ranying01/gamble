package com.ranying.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component("emailTool")
public class EmailTool {

    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;


    @Value("${email.api.warning.default.to}")
    private String defaultToEmail;


    private Logger logger = LoggerFactory.getLogger(EmailTool.class);

    /**
     * 发送简单邮件
     *
     * @param simpleMail 邮件实体
     */
    public MimeMessage sendSimpleMail(SimpleMailParam simpleMail) {
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromEmail);
            if (StringUtils.isBlank(simpleMail.getToEmail())) {
                helper.setTo(defaultToEmail);
            } else {
                helper.setTo(simpleMail.getToEmail());
            }
            helper.setSubject(simpleMail.getTitle());
            helper.setText(simpleMail.getContent(), true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            logger.error("===========发送邮件失败============{}", e.getMessage());
            e.printStackTrace();
        }
        return message;
    }

}
