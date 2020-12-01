import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list){
        List<Integer> filteredList = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int i=0;

        while (i<filteredList.size()){
            Integer item = filteredList.get(i);
            if (i<filteredList.size()-1 && item.equals(filteredList.get(i+1))){
                result.add(item*2);
                i+=2;
            }
            else {
                result.add(item);
                i++;
            }
        }

        if (result.size() != list.size()){
            int dif = list.size()-result.size();
            for (i=0;i < dif;i++)
                result.add(null);
        }

        return result;


    }
}
