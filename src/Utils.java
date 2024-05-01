import java.util.ArrayList;
import java.util.List;

public class Utils {






    public void Utils(){









    }


    public static List<Float> calculateMomentum(List<Float> precedentValues, int n){

        List<Float> listWithoutFirstValues = precedentValues.subList(n, precedentValues.size());
        List<Float> momentumList = new ArrayList<Float>();

        for (int i = 0; i < n; i++) {
            momentumList.add(0f);
        }

        for (int i = n; i <= listWithoutFirstValues.size(); i++){

            momentumList.add(100 * (precedentValues.get(i) / precedentValues.get(i - 1)));

        }

        return momentumList;
    }

    public static <T> List<Integer> generateXForList(List<T> list){
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++){
            result.add(i);
        }
        return result;
    }




}
