import java.util.regex.*;
class dr {
    public static void main(String[] args) {
        String template = "Dear {name}, order {id} ships {date}.";
        String[] names = {"name", "id"};
        String[] values = {"Riya", "A07"};
        Pattern p = Pattern.compile("\\{(\\w+)\\}");
        Matcher m = p.matcher(template);
        StringBuilder result = new StringBuilder();
        int last = 0;
        while (m.find()) {
            result.append(template.substring(last, m.start()));
            String key = m.group(1);
            String value = "{?}";
            for (int i = 0; i < names.length; i++) {
                if (key.equals(names[i])) {
                    value = values[i];
                    break;
                }
            }
            result.append(value);
            last = m.end();
        }
        result.append(template.substring(last));
        System.out.println(result);
    }
}
