class Cashier {
    int n;
    int discount;
    HashMap<Integer,Integer> map;

    int count = 1;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        map = new HashMap<>();

        for(int i = 0;i<products.length;i++) {
            map.put(products[i],prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        double bill =0;
        for(int i = 0;i<product.length;i++) {
            bill += map.get(product[i]) * amount[i];
        }

        if(count == n) {
            bill = bill * ((100.0-discount)/100.0);
            count =1;
        } else {
            count++;
        }

        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */