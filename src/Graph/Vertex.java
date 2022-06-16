package Graph;

public class Vertex {
    private int id;

    public Vertex() {
    }

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return "Vertex: " + this.getId();
    }
}
