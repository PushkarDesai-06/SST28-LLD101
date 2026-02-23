public class WhatsAppSender extends PhoneNotificationSender {
    public WhatsAppSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public void doPhoneSend(Notification n) {
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}
