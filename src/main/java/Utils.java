import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    public static List<Float> calculateTCI(List<Float> precedentValues, int n, int m){
        if (n>m){ throw new IllegalArgumentException("m doit être plus grand que n. ");}

        List<Float> listToCut = new ArrayList<>(precedentValues.subList(0, precedentValues.size()).stream().toList());
        List<Float> unorderedResult = new ArrayList<Float>();
        List<Float> result = new ArrayList<Float>();

        while (listToCut.size() > m) {

            List<Float> nList = listToCut.subList(listToCut.size() - n - 1, listToCut.size() - 1);
            System.out.println(nList);
            List<Float> mList = listToCut.subList(listToCut.size() - m - 1, listToCut.size() - 1);



            double numerator = 0;
            int denominator = 0;

            for (float fl : nList) {
                numerator += fl;
                denominator++;
            }
            float avgN = (float) (numerator / denominator);
            numerator = 0;
            denominator = 0;

            for (float fl : mList) {
                numerator += fl;
                denominator++;
            }
            float avgM = (float) (numerator / denominator);

            unorderedResult.add((avgN / avgM) * 100);
            listToCut.remove(listToCut.size() - 1);

        }

        for (int i = 0; i <= m; i++){
            result.add(0f);
        }


        for (int i = unorderedResult.size() - 1; i > 0; i--){
            result.add(unorderedResult.get(i));
        }

        return result;

    }


    public static <T> List<Integer> generateXForList(List<T> list){
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++){
            result.add(i);
        }
        return result;
    }




}
