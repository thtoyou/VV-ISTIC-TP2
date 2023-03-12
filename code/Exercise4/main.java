public class Main {
    public static void main(String[] args) throws IOException {
        String packageName = "";
        String className = "";
        boolean hasGetter = false;
        CompilationUnit compilationUnit = StaticJavaParser
                .parse(new File("E:\\VV\\TP2\\src\\main\\java\\tp2_q4\\Person.java"));
        if (compilationUnit.getClassByName("Person").isPresent()) {
            className = compilationUnit.getClassByName("Person").get().getNameAsString();
        }
        try (PrintWriter writer = new PrintWriter("report.txt")) {
            writer.println("Package: " + Person.class.getPackage() + "\n" + "Classe : " + className);
            List<FieldDeclaration> privateFields = compilationUnit.findAll(FieldDeclaration.class,
                    fd -> fd.getModifiers().contains(Modifier.privateModifier()));
            for (FieldDeclaration field : privateFields) {
                Type fieldType = field.getElementType();
                String fieldName = field.getVariable(0).getNameAsString();
                writer.println("Private field: " + fieldType + " " + fieldName);
                List<MethodDeclaration> methods = compilationUnit.findAll(MethodDeclaration.class,
                        md -> md.getModifiers().contains(Modifier.publicModifier()) && md.getType().equals(fieldType)
                                && md.getNameAsString().equals(
                                        "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1)));
                if (methods.size() > 0) {
                    hasGetter = true;
                    writer.println(" has a getter");
                } else {
                    writer.println(" does not have a getter");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to create report file: " + e.getMessage());
        }
    }
}