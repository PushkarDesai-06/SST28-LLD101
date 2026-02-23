public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    // contract: n must not be null
    public void send(Notification n) {
        if (n == null)
            throw new IllegalArgumentException("Notification cannot be null");

        doSend(n);
    }

    public abstract void doSend(Notification n);
}
