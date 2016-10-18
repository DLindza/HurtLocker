import org.apache.commons.io.IOUtils;




public class Main {



    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }




    public static void main(String[] args) throws Exception{


        String output = (new Main()).readRawDataToString();
        //System.out.println(output);

        Filter filter = new Filter();

        filter.createFoodObject(output);

        for(String[] foodObject : filter.rawFoodData) {
            for(String string : foodObject) {
                System.out.println(string);
            }

        }


    }
}
