import java.util.*;

public class Game2048 implements Game{
    //============== Поля ==============//
    GameHelper helper = new GameHelper();
    Random random = new Random();
    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);
    //==================================//


    //======= конструктор =======//
    public Game2048(Board board){ }
    public Game2048() { }
    //===========================//

    public void init(){
        List<Integer> list = new ArrayList<>(GAME_SIZE*GAME_SIZE);
        for (int i=0; i < GAME_SIZE*GAME_SIZE; i++)
        {
            list.add(null);
        }
        board.fillBoard(list);
        addItem();
        addItem();
    }
    public boolean canMove(){
        List<Key> keyListSpaces = board.availableSpace();
        return (keyListSpaces.size() != 0);
    }

    public void move(Direction direction) throws GameOverException {
        boolean moved = false;
        switch (direction)
        {
            case UP:
                for (int i=0; i<GAME_SIZE; i++)
                {
                    if (makeMove(board.getColumn(i))) moved = true;
                }
                break;

            case DOWN:
                for (int i=0; i<GAME_SIZE; i++)
                {
                    List<Key> keyList = board.getColumn(i);
                    Collections.reverse(keyList);
                    if (makeMove(keyList)) moved = true;
                }
                break;

            case LEFT:
                for (int i=0; i<GAME_SIZE; i++)
                {
                    if (makeMove(board.getRow(i))) moved = true;
                }
                break;

            case RIGHT:
                for (int i=0; i<GAME_SIZE; i++)
                {
                    List<Key> keyList = board.getRow(i);
                    Collections.reverse(keyList);
                    if (makeMove(keyList)) moved = true;
                }
                break;
        }
        if (moved)
        {
            if (board.availableSpace().size() == 0)
                throw new GameOverException("");
            else
                addItem();
        }
    }

    private boolean makeMove(List<Key> KeysInBoard)
    {
        List<Integer> pastValuesInBoard = board.getValues(KeysInBoard);
        List<Integer> listAfterMerge = helper.moveAndMergeEqual(pastValuesInBoard);
        if (listAfterMerge.equals(pastValuesInBoard))
            return false;
        else
        {
            int i = 0;
            for (Key key : KeysInBoard)
            {
                board.addItem(key, listAfterMerge.get(i));
                i++;
            }
            return true;
        }
    }

    public void addItem() {
        if (board.availableSpace().size() == 0)
        {
            try {
                throw new GameOverException("There are no empty seats on the field!");
            } catch (GameOverException e) {
                e.printStackTrace();
            }
        }
        List<Key> keyListSpaces = board.availableSpace();
        board.addItem(keyListSpaces.get(random.nextInt(keyListSpaces.size())), 2*(1+random.nextInt(1)));
    }

    public Board getGameBoard() {
        return board;
    }
    public boolean hasWin() {
        return (board.hasValue(2048));
    }
}
