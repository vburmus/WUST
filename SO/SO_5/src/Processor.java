import java.util.ArrayList;
import java.util.List;

public class Processor {

    protected int load;
    protected List<Task> processes;

    public Processor() {
        this.load =0;
        this.processes = new ArrayList<>();
    }

    public Processor(Processor p) {
        this.load = p.load;
        this.processes = new ArrayList<>();
    }

    public int getLoad() {
        return load;
    }

    public List<Task> getProcesses() {
        return processes;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public void setProcesses(List<Task> processes) {
        this.processes = processes;
    }

    @Override
    public String toString() {
        return "Procesor{" +
                "obciazenie=" + load +
                ", procesy=" + processes +
                '}';
    }
}
