public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public void doSend(Notification n) {
        // email channel has a 40-char body limit; truncate rather than reject
        String body = n.body;
        if (body != null && body.length() > 40)
            body = body.substring(0, 40);
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        audit.add("email sent");
    }
}
