import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class Graph {

    HashMap<GraphNode, List<GraphNode>> adjacentcyList = new HashMap<>();

    public void addNode(GraphNode Node){
        GraphNode newNode = Node;
        adjacentcyList.put(newNode, new ArrayList<>());
    }

    public void addEdge(GraphNode user1, GraphNode user2){
        adjacentcyList.get(user1).add(user2);
    }

    public List<GraphNode> adjacentcies(GraphNode user){
        return adjacentcyList.get(user);
    }

    public boolean depthFirstSearch(GraphNode start, GraphNode end){
        Stack<GraphNode> stack = new Stack<>();
        start.state = State.Visiting;
        stack.push(start);
        GraphNode u;
        while(!stack.isEmpty()){
            u = stack.pop();
            if(u != null){
                for(GraphNode v: adjacentcies(u)){
                    if(v.state == State.Unvisited){
                        if(v == end){
                            return true;
                        }else {
                            v.state = State.Visiting;
                            stack.push(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    public String toString(){
        String graph = "";
        for (GraphNode key: adjacentcyList.keySet()){
            graph = graph + key.toString() + " is friends with";
            for(int i = 0; i < adjacentcyList.get(key).size(); i++){
                graph = graph + " " + adjacentcyList.get(key).get(i) + ", ";
            }
            graph = graph.substring(0, graph.length()-2) + "\n";
        }
        return graph;
    }

    public static void main(String[] args){
        Graph graph = new Graph();

        GraphNode tom = new GraphNode("Tom", "Mathew", 21);
        GraphNode abby = new GraphNode("Abby", "Miller", 22);
        GraphNode roger = new GraphNode("Roger", "David", 22);
        GraphNode zelda = new GraphNode("Zelda", "Mathew", 23);
        GraphNode sam = new GraphNode("Sam", "Que", 29);
        GraphNode sunny = new GraphNode("Sunny", "Kooper", 22);
        GraphNode ruby = new GraphNode("Ruby", "Zack", 22);
        GraphNode zorra = new GraphNode("Zorra", "Abignale", 22);

        graph.addNode(tom);
        graph.addNode(abby);
        graph.addNode(roger);
        graph.addNode(zelda);
        graph.addNode(sam);
        graph.addNode(sunny);
        graph.addNode(ruby);
        graph.addNode(zorra);

        graph.addEdge(tom, abby);
        graph.addEdge(zelda, sam);
        graph.addEdge(sam, zelda);
        graph.addEdge(abby, tom);
        graph.addEdge(tom, roger);
        graph.addEdge(tom, sunny);
        graph.addEdge(roger, sunny);
        graph.addEdge(sunny, roger);
        graph.addEdge(ruby, zorra);
        graph.addEdge(zorra, ruby);
        graph.addEdge(sunny, ruby);
        graph.addEdge(sunny, zorra);
        graph.addEdge(roger, ruby);
        graph.addEdge(roger, zorra);

        System.out.println("Graph: \n" +graph.toString());
        System.out.println(graph.depthFirstSearch(roger,abby));
    }
}
class GraphNode{
    User user;
    State state = State.Unvisited;

    public GraphNode(String fName, String lName, int age){
        user = new User(fName, lName, age);
    }

    @Override
    public String toString(){
        return user.toString();
    }
}
class User{
    String firstName;
    String lastName;
    int age;

    public User(String fName, String lName, int Age){
        firstName = fName;
        lastName = lName;
        age = Age;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + age;
    }
}

enum State{
    Unvisited, Visited, Visiting;
}
