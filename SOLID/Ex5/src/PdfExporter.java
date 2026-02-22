import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public ExportResult doExport(ExportRequest req) {
        // maybe we can truncate output to still accept more than 20 chars...

        // if not then we have to remove the Exporter as parent of PdfExporter and make
        // it a standalone class

        String body = req.body;
        String title = req.title;

        if (body.length() > 20)
            body = body.substring(0, 20); // truncates output

        String fakePdf = "PDF(" + title + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
