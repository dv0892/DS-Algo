package test.app.unionfind;

public class UF {
    private int[] parents;
    private boolean[] blacklist;
    private int[] sizes;
    int components;
    public UF(int n) {
        blacklist = new boolean[n];
        parents = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
        components = n;
    }
    
    public int parent(int a) {
        while(a != parents[a]) {
            parents[a] = parents[parents[a]];
            a = parents[a];
        }
        return a;
    }
    
    public void connectTo(int a,int b) {
        sizes[b] += sizes[a];
        parents[a] = b;
        if (!blacklist[b] || !blacklist[a]) 
            components--;
        if (blacklist[a]) {
            blacklist[b] = true;
        }
        
    }
    
    public void connect(int a, int b) {
        a = parent(a);
        b = parent(b);
        if (a == b) return;
        if (sizes[a] < sizes[b]) {
            connectTo(a, b);
        } else {
            connectTo(b, a);
        }
    }
    
    public void blacklistComponent(int a) {
        a = parent(a);
        if (!blacklist[a]) 
            components--;
        blacklist[a] = true;
    }
    
    public int size(int a) {
        return sizes[a];
    }
}


