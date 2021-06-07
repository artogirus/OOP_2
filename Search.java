import java.util.LinkedList;
 
public class Search {
 
	public String START = null; // START la diem khoi dau
	public String END = null; // end la diem ket thuc
	public String output = "";
	public String line;
	
	
	// constructor
	public Search(String start,String end) {
		this.START = start; 
		this.END = end; 
	} 

	void depthFirst(Graph graph, LinkedList<String> visited) {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);
                printPath(visited);  // goi method printPath
                visited.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            visited.addLast(node);
            depthFirst(graph, visited);
            visited.removeLast();
        }
    }
 
    private void printPath(LinkedList<String> visited) {
    	this.line ="";
        for (String node : visited) {
        	this.line = String.join(" => ",this.line,node);
            /* System.out.print(node); 
            System.out.print(" "); */
        }
        this.output = String.join("/",this.output,this.line);
    }
}