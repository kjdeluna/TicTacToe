public class ActionValue {
    private int action;
    private int value;
    public int alpha = Constants.NEGATIVE_INFINITY;
    public int beta = Constants.POSITIVE_INFINITY;
    public ActionValue(int action, int value) {
        this.action = action;
        this.value = value;
    }

    public int getAction() {
        return this.action;
    }
    public int getValue() {
        return this.value;
    }
    public void setAction(int action) {
        this.action = action;   
    }
    public void setValue(int value) {
        this.value = value;
    }
}