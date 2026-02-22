public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public ExportResult export(ExportRequest req) {
        if (req == null)
            throw new IllegalArgumentException("Requst cannot be null");

        return doExport(req);
    }

    public abstract ExportResult doExport(ExportRequest req);
}
