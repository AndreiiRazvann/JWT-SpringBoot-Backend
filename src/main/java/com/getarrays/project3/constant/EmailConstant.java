package com.getarrays.project3.constant;

public class EmailConstant {
    public static final String SIMPLE_MAIL_TRANSFER_PROTOCOL = "smtps"; //represents the protocol used for sending emails
    public static final String USERNAME = "andreii.razvann@gmail.com";
    public static final String PASSWORD = "vmfa zqxi tvdl skrd";
    public static final String FROM_EMAIL = "andreii.razvann@gmail.com";
    public static final String CC_EMAIL = "";
    public static final String EMAIL_SUBJECT = "Andrei Was Here, Inc - New Password";
    public static final String GMAIL_SMTP_SERVER = "smtp.gmail.com"; //SMTP server address provided by Gmail for sending emails through their service.
    public static final String SMTP_HOST = "mail.smtp.host"; //property key used to specify the hostname of the SMTP
    //used when configuring the properties of an email session to indicate the SMTP server's hostname that should be used for sending emails.
    public static final String SMTP_AUTH = "mail.smtp.auth";//used when configuring the properties of an email session to enable or disable SMTP server authentication
    public static final String SMTP_PORT = "mail.smtp.port"; //used when configuring the properties of an email session to set the port number on which the SMTP server is listening for incoming connections
    public static final int DEFAULT_PORT = 465;
    public static final String SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable"; // is a way to upgrade a plain text connection to a secure (TLS or SSL) connection.
    public static final String SMTP_STARTTLS_REQUIRED = "mail.smtp.starttls.required"; //property key used to indicate whether the use of the STARTTLS extension is required for the SMTP protocol.
}
