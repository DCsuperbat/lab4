package Lab1;

import java.util.*;

public class EdgeWeightDiGraph
{
	public static List<DirectedEdge>[] adj; // �ڽӱ����  
    private int V; // �����Ŀ  
    private int E; // �ߵ���Ŀ
	Main main = new Main();

    public DirectedEdge ContainEdge(DirectedEdge e)   //���ڱ�
    {
    	String source = e.getSource();
    	String target = e.getTarget();
    	int i = main.aq.indexOf(source);
    	List<DirectedEdge> edges=adj[i];
		for(int j=0;j<edges.size();j++)
		{
			if(edges.get(j).getTarget().equals(target))
			{
				return edges.get(j);
			}
		}
		return null;
    }
    
    public void CreateGraph(ArrayList<String> al,ArrayList<String> aq)    //���ɼ�Ȩ����ͼ
    {   	
    	for(int i=0;i<al.size()-1;i++)
        	{
        		DirectedEdge e = new DirectedEdge(al.get(i),al.get(i+1),1);
        		if(ContainEdge(e)!=null)
            	{
            		double w = ContainEdge(e).weight();
            		w += 1;      		     		
            		ContainEdge(e).setWeight(w);
            	}
            	else
            	{
            		if(!al.get(i).equals(al.get(i+1)))
            		{
            			addEdge(e);
            		}
            	}
        	}
    }
    
    public EdgeWeightDiGraph(int V) 
    {  
        this.V = V;  
        E = 0;  
        adj = (List<DirectedEdge>[]) new List[V];  
        for (int i = 0; i < V; i++)
        {  
            adj[i] = new ArrayList<>();  
        }  
    }  
	      
    public void addEdge(DirectedEdge e) {  
    	int i = main.aq.indexOf(e.getSource());
        adj[i].add(e);  
        E++;  
    }  
      
    public int V() {  
        return V;  
    }  
      
    public int E() {  
        return E;  
    }  
      
    public Iterable<DirectedEdge> adj(int v) {  
        return adj[v];  
    }  
      
    public Iterable<DirectedEdge> edges() {  
        List<DirectedEdge> edges = new ArrayList<>();  
        for (int i = 0; i < V; i++) {  
            for (DirectedEdge e : adj[i]) {  
                edges.add(e);  
            }  
        }  
        return edges;  
    }  
      
    public String showDirectedGraph() {  
        String s = V + " ������, " + E + " ����\n";  
        for (int i = 0; i < main.aq.size(); i++) {  
            s += main.aq.get(i) + ": ";  
            for (DirectedEdge e : adj(i))
            {  
                s += e.getTarget() + " [" + e.weight() + "], ";  
            }  
            s += "\n";  
        }  
        return s;  
    } 

}
