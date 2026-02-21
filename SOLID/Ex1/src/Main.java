public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        FakeDb db = new FakeDb();
        Parser parser = new Parser();
        Validator validator = new Validator();
        OnboardingService svc = new OnboardingService(db, parser, validator);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);
        raw = "name=Pushkar;email=pushkar@sst.edu;phone=9876543210;program=AI";
        svc.registerFromRawInput(raw);
        raw = "name=Riya;email=riyasst.edu;phone=9876a43210;program=ABC";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
