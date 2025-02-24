public class TableOutput extends Output {


    public abstract void display(String data){
        System.out.println("table output" + data);
    }

    public TableOutput(String data) {
        super(data);
    }
}
