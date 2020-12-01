import java.util.*;


public class SquareBoard<T> extends Board<Key,T>{
    private int size;
    public SquareBoard(int size) {
        this.size=size;
    }

    @Override
    void fillBoard(List<T> list) {
           if (list.size()!=size*size) {
               throw new RuntimeException();
           }
           board.clear();
           for (int i=0;i<size;i++){
               for (int j=0;j<size;j++){
//                 addItem(new Key(i,j),list.get(i*size+j));
                   board.put(new Key(i,j),list.get(i*size+j));
               }
           }
    }


    @Override
    List<Key> availableSpace() {
//        return super.board.entrySet().stream()
//                .filter(x -> x.getValue() == null)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
        List<Key> keyList = new ArrayList<>();
        for (Map.Entry<Key, T> entry : board.entrySet())
        {
            if (entry.getValue() == null)
            {
                keyList.add(entry.getKey());
            }
        }
        return keyList;
    }

    @Override
    void addItem(Key key, T value) {
        super.board.put(key,value);
    }

    @Override
    public Key getKey(int i, int j) {

        return board
                .keySet()
                .stream()
                .filter(key -> key.geti() == i && key.getj()==j)
                .findFirst()
                .orElseGet(()->null);
    }

    @Override
    T getValue(Key key) {
        return board.get(key);
    }

    @Override
    List<Key> getColumn(int j) {
        ArrayList<Key> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(getKey(i, j));
        return list;
    }
    @Override
    List<Key> getRow(int i) {
        ArrayList<Key> row = new ArrayList<>();
        for (int j = 0; j < size; j++)
            row.add(getKey(i, j));
        return row;
    }

    @Override
    boolean hasValue(T value) {
        if (board.containsValue(value))
            return true;
        else
            return false;
    }

    @Override
    List<T> getValues(List<Key> keys) {
        List<T> values = new ArrayList<>();
        for (int i=0; i<keys.size(); i++)
        {
            if (keys.get(i) != null)
            {
                values.add(getValue(keys.get(i)));
            }
        }
        return values;
    }
}
