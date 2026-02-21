import java.util.*;

public class OnboardingService {
    private final Database db;
    Parser parser;
    Validator validator;

    public OnboardingService(Database db, Parser parser, Validator validator) {
        this.parser = parser;
        this.validator = validator;
        this.db = db;
    }

    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        Map<String, String> kv = parser.parseString(raw);
        boolean isValid = validator.validateStudentRecord(kv);

        if(!isValid) return;

        String id = IdUtil.nextStudentId(db.count());

        StudentRecord rec = new StudentRecord(id, kv.get("name"), kv.get("email"), kv.get("phone"), kv.get("program"));

        db.save(rec);

        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
