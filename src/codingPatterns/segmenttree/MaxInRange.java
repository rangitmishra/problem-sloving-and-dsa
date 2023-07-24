package codingPatterns.segmenttree;

/*
idx    0 1 2 3 4 5 6 7
arr = [3,7,5,4,1,8,3,6]
Given n queries, find max for each range
Q1: 0,3
Q2: 2,5
Q3: 0,4
Output:
7
8
7

 */
public class MaxInRange {

    int[] arr = {3,7,5,4,1,8,3,6};
    int tree[];

    public MaxInRange(){
        tree = new int[arr.length*4+1];
    }

    private void build(int node, int l, int r){
        if(l==r){
            tree[node] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        build(2*node, l, mid);
        build(2*node+1, mid+1, r);
        tree[node] = Math.max(tree[node*2], tree[node*2+1]);

    }

    private int query(int node, int start, int end, int left, int right){
        if(end < start || start > right){
            return Integer.MIN_VALUE;
        }
        if(start==end){
            return  tree[node];
        } else if(end <= left && right <= end){
            return tree[node];
        } else {
            int mid = (start+end)/2;
            int lMax = query(node*2, start, mid, left, right);
            int rMax = query(node*2+1, mid+1, end, left, right);
            return Math.max(lMax, rMax);
        }

    }

    private int query(int left, int right){
        return query(1,0, arr.length-1,left,right);

    }

    public static void main(String[] args) {

        MaxInRange maxInRange = new MaxInRange();
        maxInRange.build(1,0,maxInRange.arr.length-1);
        int ans = maxInRange.query(0,3);
        System.out.println(ans);
        ans = maxInRange.query(2,5);
        System.out.println(ans);
        ans = maxInRange.query(3,6);
        System.out.println(ans);

    }
}
