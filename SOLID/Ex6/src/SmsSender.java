public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public void doSend(Notification n) {
        // subject not applicable for SMS channel; field is intentionally unused
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}
