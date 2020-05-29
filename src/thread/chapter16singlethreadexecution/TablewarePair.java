package thread.chapter16singlethreadexecution;

/**
 * TablewarePair
 *
 * @author 李弘昊
 * @since 2020/5/28
 */
public class TablewarePair {
    private final Tableware leftTool;

    private final Tableware rightTool;

    public TablewarePair(Tableware leftTool, Tableware rightTool)
    {
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    public Tableware getLeftTool()
    {
        return leftTool;
    }

    public Tableware getRightTool()
    {
        return rightTool;
    }

}
