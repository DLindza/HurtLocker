import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by devon on 10/17/16.
 */
public class Filter {
    int exceptions = 0;

    public CharSequence[] splitByObject(String output) {
        return output.split("##");
    }

    public void keyPattern(CharSequence[] objects) {

        for (CharSequence object : objects) {
            Pattern pattern = Pattern.compile("\\W+");
            Matcher m = pattern.matcher(object);
            m.replaceAll("name");
        }
        //this won't work because I won't know all of the possible combinations of Name
        // also it isn't reusable for each of the known key values
    }

}
