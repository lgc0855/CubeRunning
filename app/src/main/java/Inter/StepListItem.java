package Inter;

/**
 * Created by Administrator on 2016/5/18 0018.
 */
public class StepListItem {
    private int rank;
    private int headImageId;
    private int step;
    private String name;

    public StepListItem(int rank, int headImageId, int step, String name) {
        this.rank = rank;
        this.headImageId = headImageId;
        this.step = step;
        this.name = name;
    }

    public String getRank() {
        return Integer.toString(rank);
    }

    public int getHeadImageId() {
        return headImageId;
    }

    public String getStep() {
        return Integer.toString(step);
    }

    public String getName() {
        return name;
    }

}
